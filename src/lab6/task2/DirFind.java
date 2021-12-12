package lab6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class DirFind {
    
    public static void main(String[] args) {
        

        try (Stream<Path> files = Files.find(Path.of("."), 3, ((path, basicFileAttributes) -> basicFileAttributes.isDirectory()))){ // Add try with resources
            
            System.out.println("\n=== Find all dirs ===");
            // Print out directory list here
            files.forEach(System.out::println);
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    } 
}
