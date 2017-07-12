package nz.co.manasys.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Pack {
    /**
     * 1. Pack id
     */
    public int id;

    /**
     * 2. List of Items
     */
    public List<Item> items = new ArrayList<Item>();

    public int length;

    public int quantity;

    public double weight;

    public Pack(int id) {
        this.id = id;
    }

    public String toString() {
        String result = "Pack Number: " + id + "\n";
        double packWeight = 0.0;
        for (Item item : items) {
            packWeight += item.quantity * item.weight;
            result += item.id + "," + item.length + "," + item.quantity + "," + item.weight + "\n";
        }
        result += "Pack Length: " + length + ", Pack Weight: " + String.format("%.2f", packWeight) + "\n";
        return result;
    }
}
