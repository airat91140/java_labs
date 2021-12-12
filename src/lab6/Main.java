package lab6;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void labTask1(String[] args) {
        int counter = 0;
        if (args.length != 1) {
            System.out.println("You should put 1 filename as an argument");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Write string for search");
        String str = sc.nextLine();
        try (BufferedReader buf = new BufferedReader(new FileReader(args[0]))) {
            String line = "";
            while ((line = buf.readLine()) != null) {
                if (line.contains(str))
                    ++counter;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("File contains " + counter + " of " + str);
        sc.close();
    }

    public static void testLab2() {
        ShoppingCart cart = new ShoppingCart(2), newCart;
        cart.addItems(new Item(1, "as", 12),
                new Item(45, "bb", 10),
                new Item(12, "ee", 20),
                new Item(56, "as", 15));
        try
        {
            FileOutputStream fileOut = new FileOutputStream("Cart.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(cart);
            out.close();
            fileOut.close();

            FileInputStream fileIn = new FileInputStream("Cart.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            newCart = (ShoppingCart) in.readObject();
            in.close();
            fileIn.close();

            System.out.println(cart);
            System.out.println(newCart);
        }
        catch (Exception i)
        {
            i.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testLab2();
        labTask1(args);

    }
}
