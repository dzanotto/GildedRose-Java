package com.gildedrose;

public class DefaultInventoryUpdater extends InventoryUpdater {
    @Override
    void updateItem(Item item) {
        decreaseQuality(item);

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }
}
