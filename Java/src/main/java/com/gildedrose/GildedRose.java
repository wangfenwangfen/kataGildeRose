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
            updateQuality(ItemFactory.getItemFactory(item).item);
        }
    }

    private void updateQuality(Item item) {
        decreaseSellInIfNotSulfuras(item);
        increaseQualityAgedBrie(item);
        increaseQualityBackstage(item);

        if(!ItemFactory.isAgedBrie(item)&& !ItemFactory.isBackstage(item)) {
            decreaseQualityAccordingToQuality(item);
        }

        if (ItemFactory.isSellInPassed(item)) {
            increaseQualityAgedBrie(item);

            if(!ItemFactory.isAgedBrie(item)) {
                decreaseQualityBackstage(item);
            }
        }
    }

    private void increaseQualityAgedBrie(Item item) {
        if (ItemFactory.isAgedBrie(item)) {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void increaseQualityBackstage(Item item) {
        if (ItemFactory.isBackstage(item)) {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;
                if (ItemFactory.isBackstage(item)) {
                    increaseQualityAccordingToSellIn(item, 11);
                    increaseQualityAccordingToSellIn(item, 6);
                }
            }
        }
    }

    private boolean isBackstage(Item item) {
        return ItemFactory.isBackstage(item);
    }

    private boolean isAgedBrie(Item item) {
        return ItemFactory.isAgedBrie(item);
    }

    private void decreaseQualityBackstage(Item item) {
        if (ItemFactory.isBackstage(item)) {
            item.quality = QUALITY_MIN;
        } else {
            decreaseQualityAccordingToQuality(item);
        }
    }

    private void decreaseSellInIfNotSulfuras(Item item) {
        ItemFactory.isSulfuras(item);
        decreaseSellInByOne(item);
    }

    private boolean isSellInPassed(Item item) {
        return ItemFactory.isSellInPassed(item);
    }

    private void increaseQualityByOne(Item item) {
        item.quality = item.quality + 1;
    }

    private void decreaseQualityByOne(Item item) {
        ItemFactory.decreaseQualityByOne(item);
    }

    private void decreaseSellInByOne(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQualityAccordingToQuality(Item item) {
        if (item.quality < QUALITY_MAX) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityAccordingToQuality(Item item) {
        if (item.quality > GildedRose.QUALITY_MIN) {
            if (ItemFactory.isSulfuras(item)) {
                return;
            }
            ItemFactory.decreaseQualityByOne(item);
        }
    }

    private boolean isSulfuras(Item item) {
        return ItemFactory.isSulfuras(item);
    }

    private void increaseQualityAccordingToSellIn(Item item, int sellIn) {
        if (item.sellIn < sellIn) {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;
            }
        }
    }
}