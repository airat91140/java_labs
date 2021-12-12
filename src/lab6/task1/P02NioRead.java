package lab6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class P02NioRead {
    
    public static void main(String[] args) {

        try{ // Create Try with Resources here
            
            System.out.println("\n=== Entire File ===");
            // print lines here
            Files.lines(Paths.get("hamlet.txt")).forEach(System.out::println);
            
        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

    } 
}
