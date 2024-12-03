package com.gildedrose;

public class BackstageInventoryUpdater extends InventoryUpdater {

    @Override
    void updateItem(Item item) {
        incrementQuality(item);

        if (item.sellIn < 11) {
            incrementQuality(item);
        }

        if (item.sellIn < 6) {
            incrementQuality(item);
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
