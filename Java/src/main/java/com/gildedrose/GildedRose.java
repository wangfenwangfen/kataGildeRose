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
            updateQuality(ItemFactoryCopy.getItemFactory(item).item);
        }
    }

    private void updateQuality(Item item) {
        decreaseSellInIfNotSulfuras(item);
        increaseQualityAgedBrie(item);
        increaseQualityBackstage(item);

        if(!ItemFactoryCopy.isAgedBrie(item)&& !ItemFactoryCopy.isBackstage(item)) {
            decreaseQualityAccordingToQuality(item);
        }

        if (ItemFactoryCopy.isSellInPassed(item)) {
            increaseQualityAgedBrie(item);

            if(!ItemFactoryCopy.isAgedBrie(item)) {
                decreaseQualityBackstage(item);
            }
        }
    }

    private void increaseQualityAgedBrie(Item item) {
        if (ItemFactoryCopy.isAgedBrie(item)) {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void increaseQualityBackstage(Item item) {
        if (ItemFactoryCopy.isBackstage(item)) {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;
                if (ItemFactoryCopy.isBackstage(item)) {
                    increaseQualityAccordingToSellIn(item, 11);
                    increaseQualityAccordingToSellIn(item, 6);
                }
            }
        }
    }

    private void decreaseQualityBackstage(Item item) {
        if (ItemFactoryCopy.isBackstage(item)) {
            item.quality = QUALITY_MIN;
        } else {
            decreaseQualityAccordingToQuality(item);
        }
    }

    private void decreaseSellInIfNotSulfuras(Item item) {
        ItemFactoryCopy.isSulfuras(item);
        decreaseSellInByOne(item);
    }

    private void decreaseSellInByOne(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQualityAccordingToQuality(Item item) {
        if (item.quality > GildedRose.QUALITY_MIN) {
            if (ItemFactoryCopy.isSulfuras(item)) {
                return;
            }
            ItemFactoryCopy.decreaseQualityByOne(item);
        }
    }

    private void increaseQualityAccordingToSellIn(Item item, int sellIn) {
        if (item.sellIn < sellIn) {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;
            }
        }
    }
}