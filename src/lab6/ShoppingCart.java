package lab6;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {
    int cartID;
    ArrayList<Item> items;
    int itemCount;
    transient double cartTotal;

    public ShoppingCart(int cartID) {
        this.cartID = cartID;
        items = new ArrayList<>();
        itemCount = 0;
        cartTotal = 0;
    }

    public void addItems(Item ... its) {
        itemCount += its.length;
        for (var i : its) {
            items.add(i);
            cartTotal += i.cost;
        }
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.writeInt(cartID);
        out.writeObject(items);
        out.writeInt(itemCount);
        out.writeUTF(LocalDateTime.now().toString());
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        cartID = in.readInt();
        items = (ArrayList<Item>) in.readObject();
        itemCount = in.readInt();
        System.out.println("Serialized on " + in.readUTF());
        cartTotal = 0;
        for (var i : items)
            cartTotal += i.cost;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartID=" + cartID +
                ", items=" + items +
                ", itemCount=" + itemCount +
                ", cartTotal=" + cartTotal +
                '}';
    }
}
