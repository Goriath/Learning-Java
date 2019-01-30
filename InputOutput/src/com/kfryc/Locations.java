package com.kfryc;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        //try with resources using Byte Streams and saving both locations and directions in single file "locations.dat"
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))){
            for(Location location : locations.values()){
                locFile.writeInt(location.getLocationID()); //to write Integer
                locFile.writeUTF(location.getDescription()); //to write String
                System.out.println("Saving location " + location.getLocationID() + " : " + location.getDescription());
                System.out.println("Saving " + (location.getExists().size() -1) + " exits");
                locFile.writeInt(location.getExists().size() - 1);;
                for (String direction : location.getExists().keySet()){
                    if(!direction.equalsIgnoreCase("q")){
                        System.out.println("\t\t" + direction + ", "+location.getExists().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExists().get(direction));
                    }
                }
            }
        }
        //try with resources using BufferedWriter - tidy and concise
//        try(BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
//            BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))){
//            for (Location location : locations.values()){
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String direction : location.getExists().keySet()){
//                    if(!direction.equalsIgnoreCase("q")){
//                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExists().get(direction) + "\n");
//                    }
//                }
//            }
//        }
    }

    static {
        //Now reading locations and directions from location.dat
        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
            boolean eof = false;        //handling end of file exception, better mechanism to end the while loop
            while (!eof){
                try{
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("Read location " + locID + " : " + description);
                    System.out.println("Found " + numExits + " exits");
                    for(int i=0;i<numExits;i++){
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + "," + destination);
                    }
                    locations.put(locID, new Location(locID, description, exits));
                } catch (EOFException e){
                    eof = true;
                }
            }
        } catch (IOException e){
            System.out.println("IO exception");
        }

        //Now reading locations from locations_big.txt
//        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))){
//            scanner.useDelimiter(",");
//            while (scanner.hasNextLine()){
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        //Now reading the exits from directions_big.txt without Scanner
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
//            String input;
//            while ((input = dirFile.readLine()) != null){
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
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
