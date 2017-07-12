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

    public double weight;

    public Pack(int id) {
        this.id = id;
    }

    public String toString() {
        String result = "Pack Number: " + id + "\n";
        int packLength = 0;
        double packWeight = 0.0;
        for (Item item : items) {
            packLength += item.length;
            packWeight += item.weight;
            result += item.id + "," + item.length + "," + item.quantity + "," + item.weight + "\n";
        }
        result += "Pack Length: " + packLength + ", Pack Weight: " + packWeight + "\n";
        return result;
    }
}
