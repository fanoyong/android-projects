
package com.fanoyong.aboutphone;

import com.fanoyong.aboutphone.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Content {

    public static List<Item> ITEMS = new ArrayList<Item>();
    public static Map<Integer, Item> ITEM_MAP = new HashMap<Integer, Item>();

    static {
        addItem(new Item(Constants.INFO_CPU, "CPU/Hardware"));
        addItem(new Item(Constants.INFO_KERNEL, "Kernel"));
        addItem(new Item(Constants.INFO_DISPLAY, "Display"));
        addItem(new Item(Constants.INFO_SENSORS, "Sensors"));
        addItem(new Item(Constants.INFO_CONNECTIVITY, "Connectivity"));
        addItem(new Item(Constants.INFO_TELEPHONY, "Telephony"));
        addItem(new Item(Constants.SHOW_GPS, "GPS / Location"));
    }

    private static void addItem(Item item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class Item {
        public int id;
        public String content;

        public Item(int id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
