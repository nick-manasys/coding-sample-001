package nz.co.manasys.domain;

public class Configuration {
    public SortOrder sortOrder;

    public int maxPiecesPerPack;

    public double maxWeightPerPack;

    public Configuration(SortOrder sortOrder, int maxPiecesPerPack, double maxWeightPerPack) {
        this.sortOrder = sortOrder;
        this.maxPiecesPerPack = maxPiecesPerPack;
        this.maxWeightPerPack = maxWeightPerPack;
    }

    public static Configuration initialize(String... items) {
        SortOrder sortOrder = SortOrder.valueOf(items[0]);
        int maxPiecesPerPack = Integer.parseInt(items[1]);
        double maxWeightPerPack = Double.parseDouble(items[2]);

        return new Configuration(sortOrder, maxPiecesPerPack, maxWeightPerPack);
    }    
}
