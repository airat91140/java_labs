package lab6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class P03NioReadAll {
    
    public static void main(String[] args) {
        
        List<String> fileArr;
        Path file =  Paths.get("hamlet.txt");

        try{
            // Read file into array here
            List<String> lines = Files.readAllLines(file);
            Pattern ros = Pattern.compile("^(\\s|\t)*Ros\\..*");
            Pattern guil = Pattern.compile("^(\\s|\t)*Guil\\..*");

            System.out.println("\n=== Rosencrantz ===");
            // Filter for Ros. here
            lines.stream().filter(ros.asMatchPredicate()).forEach(System.out::println);
            
            System.out.println("\n=== Guildenstern ===");
            // Filter for Guil. here
            lines.stream().filter(guil.asMatchPredicate()).forEach(System.out::println);

            

        }catch (IOException e){
          System.out.println("Error: " + e.getMessage());
        }

    } 
}
