package com.gildedrose;

class GildedRose {
    static final int QUALITY_MAX = 50;
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

        if (ItemFactory.isAgedBrie(item)
                || ItemFactory.isBackstage(item)) {
            if (item.quality < QUALITY_MAX) {
                ItemFactory.increaseQualityByOne(item);
                increaseQualityIfBackstage(item);
            }
        } else {
            decreaseQualityAccordingToQuality(item);
        }

        if (ItemFactory.isSellInPassed(item)) {
            if (ItemFactory.isAgedBrie(item)) {
                ItemFactory.increaseQualityAccordingToQuality(item);
            } else {
                decreaseQualityBackstage(item);
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

    private void increaseQualityIfBackstage(Item item) {
        if (ItemFactory.isBackstage(item)) {
            increaseQualityAccordingToSellIn(item, 11);
            increaseQualityAccordingToSellIn(item, 6);
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
        ItemFactory.increaseQualityByOne(item);
    }

    private void decreaseQualityByOne(Item item) {
        ItemFactory.decreaseQualityByOne(item);
    }

    private void decreaseSellInByOne(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQualityAccordingToQuality(Item item) {
        ItemFactory.increaseQualityAccordingToQuality(item);
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
            ItemFactory.increaseQualityAccordingToQuality(item);
        }
    }
}