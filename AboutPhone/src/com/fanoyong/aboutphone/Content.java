
package com.fanoyong.aboutphone;

import android.view.View;

import java.util.ArrayList;

public class Content {

    public static ArrayList<Item> ITEM_ARRAY = new ArrayList<Item>();

    private static void addItem(Item item) {
        ITEM_ARRAY.add(item);
    }

    static {
        addItem(new Item(Constants.INFO_CPU));
        addItem(new Item(Constants.INFO_KERNEL));
        addItem(new Item(Constants.INFO_MEMORY));
        addItem(new Item(Constants.INFO_DISPLAY));
        addItem(new Item(Constants.INFO_SENSORS));
        addItem(new Item(Constants.INFO_CONNECTIVITY));
        addItem(new Item(Constants.INFO_TELEPHONY));
        addItem(new Item(Constants.SHOW_GPS));
    }

    public static class Item {
        private int type;

        public Item(int id) {
            this.setType(id);
        }

        @Override
        public String toString() {
            return "Type: " + getType();
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
