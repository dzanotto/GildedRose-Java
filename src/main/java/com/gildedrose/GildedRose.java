package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        InventoryUpdater inventoryUpdater;
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros" -> {
                inventoryUpdater = new SulfurasInventoryUpdater();
            }
            case "Aged Brie" -> {
                inventoryUpdater = new AgedBrieInventoryUpdater();
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
                inventoryUpdater = new BackstageInventoryUpdater();
            }
            default -> {
                inventoryUpdater = new DefaultInventoryUpdater();
            }
        }
        inventoryUpdater.updateItem(item);

    }

}