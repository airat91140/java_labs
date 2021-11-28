package lab5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void modelExceptions() {
        try {
            int[] array = {1, 2, 3};
            array[3] = 4;
        }catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        try {
            FileInputStream inp = new FileInputStream("non-existing_file.txt");
        }catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        }
        try {
            String a = null;
            a.length();
        }catch (NullPointerException ex) {
            System.out.println("NullPointerException");}
        try {
            String hostname = "http://locaihost";
            URL url = new URL(hostname);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.getResponseCode();

        }catch (IOException ex) {
            System.out.println("IOException");
        }
        try {
            Integer a = 3;
            Object obj = a;
            String b = (String) obj;
        }catch (ClassCastException ex) {
            System.out.println("ClassCastException");
        }
        try {
            int a = 5 / 0;
        }catch (ArithmeticException ex) {
            System.out.println("ArithmeticException");
        }
    }

    public static void outOfMemory() {
        int []array = new int[1000000000];
    }

    public static void stackOverFlow() {
        stackOverFlow();
    }

    public static void main(String[] args) {
        modelExceptions();
        stackOverFlow();
    }
}
