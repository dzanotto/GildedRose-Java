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
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros" -> {
            }
            case "Aged Brie" -> {
                incrementQuality(item);

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    incrementQuality(item);
                }
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
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
            default -> {
                decreaseQuality(item);

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    decreaseQuality(item);
                }
            }
        }

    }

    private static void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private static void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}