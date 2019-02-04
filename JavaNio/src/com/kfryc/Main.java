package com.kfryc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {
            // Writing Binary files using NIO
            byte[] outputBytes = "Hello World!".getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);   //resets the position of the buffer - needed to write new data
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was: " + numBytes);

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);  //passing the size of the buffer to be for Integer
            intBuffer.putInt(345);
            intBuffer.flip();   //resets the buffer position to zero in the ByteBuffer, this enables us to write to file
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip();   //resets the buffer position to zero in the ByteBuffer, this enables us to write to file
            intBuffer.putInt(-98765);
            intBuffer.flip();   //resets the buffer position to zero in the ByteBuffer, this enables us to write to file
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();  //this will only enable us to read the file (because of FileInputStream)

//            Path dataPath = FileSystems.getDefault().getPath("data.txt");
//            //Files.write sends bytes (not string), so we need to convert the string to Bytes
//            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
//            List<String> lines = Files.readAllLines(dataPath);
//            for(String line : lines){
//                System.out.println(line);
//            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
