package com.gildedrose;

class GildedRose {
    private static final int QUALITY_MAX = 50;
    private static final int QUALITY_MIN = 0;
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";


    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                decreaseSellinByOne(item, 1);
            }

            if (item.name.equals(AGED_BRIE)
                    || item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                if (item.quality < QUALITY_MAX) {
                    increaseQualityByOne(item, 1);

                    if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        increaseQualityAccordingToSellIn(item, QUALITY_MAX, 11, 1);
                        increaseQualityAccordingToSellIn(item, QUALITY_MAX, 6, 1);
                    }
                }
            } else {
                decreaseQualityAccordingToQuality(item, SULFURAS_HAND_OF_RAGNAROS, QUALITY_MIN, 1);
            }

            if (isSellInPassed(item)) {
                if (item.name.equals(AGED_BRIE)) {
                    increaseQualityAccordingToQuality(item, QUALITY_MAX, 1);
                } else {
                    if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        item.quality = QUALITY_MIN;
                    } else {
                        decreaseQualityAccordingToQuality(item, SULFURAS_HAND_OF_RAGNAROS, QUALITY_MIN, 1);
                    }
                }
            }
        }
    }

    private boolean isSellInPassed(Item item) {
        return item.sellIn < 0;
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