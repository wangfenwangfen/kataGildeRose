package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            String ItemName_aged_brie = "Aged Brie";
            String ItemName_Backstage = "Backstage passes to a TAFKAL80ETC concert";
            String ItemName_Sulfuras = "Sulfuras, Hand of Ragnaros";
            int quality;
            int sellIn;
            int unitOne = 1;

            if (!item.name.equals(ItemName_aged_brie)
                    && !item.name.equals(ItemName_Backstage)) {
                quality = 0;
                decreaseQualityAccordingToQuality(item, ItemName_Sulfuras, quality, unitOne);
            } else {
                quality = 50;
                if (item.quality < quality) {
                    increaseQualityByOne(item, unitOne);

                    if (item.name.equals(ItemName_Backstage)) {
                        increaseQualityAccordingToSellIn(item, 50, 11, unitOne);
                        increaseQualityAccordingToSellIn(item, 50, 6, unitOne);
                    }
                }
            }

            if (!item.name.equals(ItemName_Sulfuras)) {
                decreaseSellinByOne(item, unitOne);
            }

            sellIn = 0;
            if (item.sellIn < sellIn) {
                if (!item.name.equals(ItemName_aged_brie)) {
                    if (!item.name.equals(ItemName_Backstage)) {
                        quality = 0;
                        decreaseQualityAccordingToQuality(item, ItemName_Sulfuras, quality, unitOne);
                    } else {
                        item.quality = 0;
                    }
                } else {
                    quality = 50;
                    increaseQualityAccordingToQuality(item, quality, unitOne);
                }
            }
        }
    }

    private void increaseQualityByOne(Item item, int unitOne) {
        item.quality = item.quality + unitOne;
    }

    private void decreaseQualityByOne(Item item, int unitOne) {
        item.quality = item.quality - unitOne;
    }

    private void decreaseSellinByOne(Item item, int unitOne) {
        item.sellIn = item.sellIn - unitOne;
    }

    private void increaseQualityAccordingToQuality(Item item, int quality, int unitOne) {
        if (item.quality < quality) {
            item.quality = item.quality + unitOne;
        }
    }

    private void decreaseQualityAccordingToQuality(Item item, String itemName_Sulfuras, int quality, int unitOne) {
        if (item.quality > quality) {
            if (!item.name.equals(itemName_Sulfuras)) {
                decreaseQualityByOne(item, unitOne);
            }
        }
    }

    private void increaseQualityAccordingToSellIn(Item item, int quality, int sellIn, int unitOne) {
        if (item.sellIn < sellIn) {
            increaseQualityAccordingToQuality(item, quality, unitOne);
        }
    }
}