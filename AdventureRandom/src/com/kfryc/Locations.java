package com.kfryc;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        //can be used when the class (and classes that are also being used) implements Serializable
        try (RandomAccessFile raFile = new RandomAccessFile("locations_rand.dat", "rwd")){
            raFile.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;   //times 3 as we will store 3 arguments in total
            int locationStart = (int) (indexSize + raFile.getFilePointer() + Integer.BYTES);    // FilePointer is a long value,
                                                                                                // I do not have that much data so I will use Integer
                                                                                                // Generally for larger projects Long is preferable
            raFile.writeInt(locationStart);
            long indexStart = raFile.getFilePointer();
            int startPointer = locationStart;
            raFile.seek(startPointer);

            for (Location location : locations.values()){
                raFile.writeInt(location.getLocationID());;
                raFile.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for(String direction : location.getExists().keySet()){
                    if(!direction.equalsIgnoreCase("q")){
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExists().get(direction));
                        builder.append(",");
                    }
                }
                raFile.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (raFile.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) raFile.getFilePointer();
            }
        }
    }

    // 1. This first four byte will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long. It will start at byte 8 and end at byte 1699)
    // 4. The final section of the file will contain the location records(the data). It will start at byte 1700

    static {
        //Now reading locations and directions from location.dat using ObjectInputStream (classes need to implement Serializable)
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
            boolean eof = false;        //handling end of file exception, better mechanism to end the while loop
            while (!eof){
                try {
                    Location location = (Location) locFile.readObject(); //need to cast it as compiler does not know what we might read
                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + (location.getExists().size()-1) + " exits");

                    locations.put(location.getLocationID(), location);
                } catch (IOException e){
                    eof = true;
                }
            }
        } catch (IOException e){
            System.out.println("IO exception");
        } catch (ClassNotFoundException e){ //needed to catch for readObject() method
            System.out.println("class not found exception" + e.getMessage());
        }

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
