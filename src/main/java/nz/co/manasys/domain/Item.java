package nz.co.manasys.domain;

/**
 *
 */
public class Item {
    /**
     * 1. Item id
     */
    public int id;

    /**
     * 2. Length (mm)
     */
    public int length;

    /**
     * 3. Quantity
     */
    public int quantity;

    /**
     * 4. Item Weight (kg, the weight of one item)
     */
    public double weight;

    public Item(int id, int length, int quantity, double weight) {
        this.id = id;
        this.length = length;
        this.quantity = quantity;
        this.weight = weight;
    }

    public static Item initialize(String... items) {
        int id = Integer.parseInt(items[0]);
        int length = Integer.parseInt(items[1]);
        int quantity = Integer.parseInt(items[2]);
        double weight = Double.parseDouble(items[3]);
        Item item = new Item(id, length, quantity, weight);
        return item;
    }
}
