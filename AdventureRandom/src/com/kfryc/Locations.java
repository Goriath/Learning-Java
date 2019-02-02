package com.kfryc;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

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
            int startPointer = locationStart;   //calculate location's record length after written to a file
            raFile.seek(startPointer);          //move file pointer to the first location offset (only for first location)

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
                        //direction, locationID, direction, locationID
                        // N,1,U,2...
                    }
                }
                raFile.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer, (int) (raFile.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) raFile.getFilePointer();
            }

            raFile.seek(indexStart);
            for(Integer locationID: index.keySet()){
                raFile.writeInt(locationID);
                raFile.writeInt(index.get(locationID).getStartByte());
                raFile.writeInt(index.get(locationID).getLength());
            }
        }
    }

    // 1. This first four byte will contain the number of locations (bytes 0-3)
    // 2. The next four bytes will contain the start offset of the locations section (bytes 4-7)
    // 3. The next section of the file will contain the index (the index is 1692 bytes long. It will start at byte 8 and end at byte 1699)
    // 4. The final section of the file will contain the location records(the data). It will start at byte 1700

    static {
        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = ra.readInt();    // good practise to write the number of location in the beginning of the file
            long locationStartPoint = ra.readInt();

            while(ra.getFilePointer() < locationStartPoint){
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }
        }catch (IOException e){
            System.out.println("IOException in static initializer: " + e.getMessage());
        }
    }

    public Location getLocation(int locationId) throws IOException{
        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location location = new Location(locationId, description, null);    //null will avoid adding a new LinkedHashMap (in constructor)
        if(locationId != 0){
            for(int i =0; i<exitPart.length;i++){
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[i] = " + exitPart[i+1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
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

    public void close() throws IOException{
        ra.close();
    }
}
