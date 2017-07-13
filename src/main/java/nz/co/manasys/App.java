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
        try {
            String line;
            String[] strings;
            Configuration configuration = null;
            List<Item> items = new ArrayList<Item>();
            System.out.println("Bin packer 1.0\nReady at line 10 >");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (null != (line = br.readLine().trim()) && line.startsWith("#")) {
                // do nothing
            }

            // if (null != (line = br.readLine().trim())) {
            // read first line
            strings = line.split(",");
            configuration = Configuration.initialize(strings);
            // System.out.println(configuration);
            // }

            while (null != (line = br.readLine().trim()) && !"".equals(line)) {
                if (!line.startsWith("#")) {
                    Item item;
                    strings = line.split(",");
                    item = Item.initialize(strings);
                    items.add(item);
                    // System.out.println(item);
                }
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
        } catch (Exception e) {
            System.out.println("Could not execute computation");
        }
    }

    private static List<Pack> processInputs(Configuration configuration, List<Item> items) {
        System.out.println("Processing outputs\n");
        List<Pack> packs = new ArrayList<Pack>();
        List<Item> sortedItems = sortItems(configuration.sortOrder, items);

        int packId = 1;
        Pack currentPack = new Pack(packId++);
        packs.add(currentPack);
        for (Item sortedItem : sortedItems) {
            Item currentItem = new Item(sortedItem.id, sortedItem.length, 0, sortedItem.weight);
            currentPack.items.add(currentItem);
            for (int i = 0; i < sortedItem.quantity; i++) {
                if (currentPack.quantity + 1 <= configuration.maxPiecesPerPack
                        && currentPack.weight + currentItem.weight <= configuration.maxWeightPerPack) {
                    currentItem.quantity++;
                    currentPack.quantity++;
                    currentPack.weight += currentItem.weight;
                    if (sortedItem.length > currentPack.length) {
                        currentPack.length = sortedItem.length;
                    }
                } else {
                    currentPack = new Pack(packId++);
                    packs.add(currentPack);
                    currentItem = new Item(sortedItem.id, sortedItem.length, 1, sortedItem.weight);
                    currentPack.items.add(currentItem);
                    currentPack.length = sortedItem.length;
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
