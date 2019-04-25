package com.gildedrose;

class GildedRose {
    private static final int QUALITY_MAX = 50;
    private static final int QUALITY_MIN = 0;

    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals(ItemType.SULFURAS_HAND_OF_RAGNAROS.getValue())) {
                decreaseSellinByOne(item, 1);
            }

            if (item.name.equals(ItemType.AGED_BRIE.getValue())
                    || item.name.equals(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getValue())) {
                if (item.quality < QUALITY_MAX) {
                    increaseQualityByOne(item, 1);

                    if (item.name.equals(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getValue())) {
                        increaseQualityAccordingToSellIn(item, QUALITY_MAX, 11, 1);
                        increaseQualityAccordingToSellIn(item, QUALITY_MAX, 6, 1);
                    }
                }
            } else {
                decreaseQualityAccordingToQuality(item, ItemType.SULFURAS_HAND_OF_RAGNAROS, QUALITY_MIN, 1);
            }

            if (isSellInPassed(item)) {
                if (!item.name.equals(ItemType.AGED_BRIE.getValue())) {
                    if (item.name.equals(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getValue())) {
                        item.quality = QUALITY_MIN;
                    } else {
                        decreaseQualityAccordingToQuality(item, ItemType.SULFURAS_HAND_OF_RAGNAROS, QUALITY_MIN, 1);
                    }
                } else {
                    increaseQualityAccordingToQuality(item, QUALITY_MAX, 1);
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

    private void decreaseQualityAccordingToQuality(Item item, ItemType itemName_Sulfuras, int quality, int unitOne) {
        if (item.quality > quality) {
            if (!item.name.equals(itemName_Sulfuras.getValue())) {
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