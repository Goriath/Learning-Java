package com.kfryc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        try{
            // Deleting the file
            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
            Files.deleteIfExists(fileToDelete); //there will be no exceptions

            // Renaming - using .move() method
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.move(fileToMove, destination);

//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e){
            e.printStackTrace();
        }

    }
//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//        System.out.println();
//
////        Path filePath = FileSystems.getDefault().getPath("files","SubdirectoryFile.txt");
//        Path filePath = Paths.get(".","files","SubdirectoryFile.txt");
//        printFile(filePath);
//        System.out.println();
//
//        filePath = Paths.get("C:\\Programming\\Java\\OutThere.txt");
//        printFile(filePath);
//
//        filePath = Paths.get("");
//        System.out.println(filePath.toAbsolutePath());
//
//        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
//        System.out.println(path2.normalize().toAbsolutePath());
//        printFile(path2.normalize());
//        System.out.println();
//
//        Path path3 = FileSystems.getDefault().getPath("this file does not exist.txt");
//        System.out.println(path3.toAbsolutePath());
//
//        Path path4 = Paths.get("Z:\\", "abcd", "whatever.txt");
//        System.out.println(path4.toAbsolutePath());
//        System.out.println();
//
//        filePath = FileSystems.getDefault().getPath("files");
//        System.out.println("Exists = " + Files.exists(filePath));
//
//        System.out.println("Exists = " + Files.exists(path4));
//
//    }
//
//    private static void printFile(Path path){
//        try(BufferedReader fileReader = Files.newBufferedReader(path)){
//            String line;
//            while((line = fileReader.readLine()) != null){
//                System.out.println(line);
//            }
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
}
