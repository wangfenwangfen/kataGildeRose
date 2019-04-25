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

            if (!item.name.equals(ItemName_aged_brie)
                    && !item.name.equals(ItemName_Backstage)) {
                quality = 0;
                if (item.quality > quality) {
                    if (!item.name.equals(ItemName_Sulfuras)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                quality = 50;
                if (item.quality < quality) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(ItemName_Backstage)) {
                        sellIn = 11;
                        quality = 50;
                        if (item.sellIn < sellIn) {
                            if (item.quality < quality) {
                                item.quality = item.quality + 1;
                            }
                        }
                        sellIn = 6;

                        if (item.sellIn < sellIn) {
                            quality = 50;
                            if (item.quality < quality) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(ItemName_Sulfuras)) {
                item.sellIn = item.sellIn - 1;
            }

            sellIn = 0;
            if (item.sellIn < sellIn) {
                if (!item.name.equals(ItemName_aged_brie)) {
                    if (!item.name.equals(ItemName_Backstage)) {
                        quality = 0;
                        if (item.quality > quality) {
                            if (!item.name.equals(ItemName_Sulfuras)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    quality = 50;
                    if (item.quality < quality) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}