package com.gildedrose;

public class AgedBrieInventoryUpdater extends InventoryUpdater {

    @Override
    void updateItem(Item item) {
        incrementQuality(item);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            incrementQuality(item);
        }
    }
}
