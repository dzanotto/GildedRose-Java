package com.gildedrose;

public abstract class InventoryUpdater {

    abstract void updateItem(Item item);

    public static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    public static void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
