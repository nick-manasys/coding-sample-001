package nz.co.manasys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import nz.co.manasys.domain.Configuration;
import nz.co.manasys.domain.Item;
import nz.co.manasys.domain.Pack;
import nz.co.manasys.domain.SortOrder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        String line;
        String[] strings;
        Configuration configuration = null;
        List<Item> items = new ArrayList<Item>();
        System.out.println("Bin packer 1.0\nReady at line 10 >");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if (null != (line = br.readLine().trim())) {
            // read first line
            strings = line.split(",");
            configuration = Configuration.initialize(strings);
            // System.out.println(configuration);
        }
        while (null != (line = br.readLine().trim()) && !"".equals(line)) {
            Item item;
            strings = line.split(",");
            item = Item.initialize(strings);
            items.add(item);
            // System.out.println(item);
        }

        if (null != configuration) {
            // process
            List<Pack> packs = processInputs(configuration, items);
            System.out.println("Processed packs");

            for (Pack pack : packs) {
                System.out.println(pack);
            }
        }

        System.out.println("Fisnished");
    }

    private static List<Pack> processInputs(Configuration configuration, List<Item> items) {
        System.out.println("Processing outputs");
        List<Pack> packs = new ArrayList<Pack>();
        List<Item> sortedItems = sortItems(configuration.sortOrder, items);

        int packNumber = 1;
        int packLength = 0;
        Pack pack = new Pack(packNumber++);
        packs.add(pack);
        for (Item sortedItem : sortedItems) {
            Item item1 = new Item(sortedItems.get(0).id, sortedItems.get(0).length, 0, sortedItems.get(0).weight);
            pack.items.add(item1);
            for (int i = 0; i < sortedItem.quantity; i++) {
                if (item1.quantity + 1 <= configuration.maxPiecesPerPack
                        && pack.weight + item1.weight <= configuration.maxWeightPerPack) {
                    item1.quantity++;
                    pack.weight += item1.weight;
                    if (sortedItem.length > packLength) {
                        packLength = sortedItem.length;
                    }
                } else {
                    pack = new Pack(packNumber++);
                    packs.add(pack);
                    item1 = new Item(sortedItems.get(0).id, sortedItems.get(0).length, 1, sortedItems.get(0).weight);
                    pack.items.add(item1);
                    packLength = sortedItem.length;
                }
            }
        }
        return packs;
    }

    private static List<Item> sortItems(SortOrder sortOrder, List<Item> items) {
        List<Item> result = null;
        switch (sortOrder) {
        case NATURAL:
            result = items;
            break;
        case SHORT_TO_LONG:
            result = items.stream().sorted((a, b) -> ((Integer) a.length).compareTo(b.length))
                    .collect(Collectors.toList());
            break;
        case LONG_TO_SHORT:
            result = items.stream().sorted((a, b) -> ((Integer) a.length).compareTo(b.length))
                    .collect(Collectors.toList());
            break;
        }
        return result;
    }
}
