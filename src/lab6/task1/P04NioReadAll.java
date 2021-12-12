package lab6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class P04NioReadAll {
  public static void main(String[] args) {
        
    Path file =  Paths.get("hamlet.txt");
    List<String> fileArr;
    Pattern lord = Pattern.compile(".*(L|l)ord.*");
    Pattern prison = Pattern.compile(".*(P|p)rison.*");

    try{
        // Read fileinto array here
        List<String> lines = Files.readAllLines(file);
        System.out.println("\n=== Lord Count ===");
        long wordCount = 0; // Replace with your pipeline
        wordCount = lines.stream().flatMap(s -> lord.matcher(s).results()).count();
        System.out.println("Word count: " + wordCount);

        System.out.println("\n=== Prison Count ===");
        wordCount = 0; // Replace with your pipeline
        wordCount = lines.stream().flatMap(s -> prison.matcher(s).results()).count();

        System.out.println("Word count: " + wordCount);            

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }
  } 
}
