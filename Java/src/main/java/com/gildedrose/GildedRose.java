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

            updateQuality(item);
        }
    }

    private void updateQuality(Item item) {
        decreaseSellInIfNotSulfuras(item);

        if (item.name.equals(ItemType.AGED_BRIE.getValue())
                || item.name.equals(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getValue())) {
            if (item.quality < QUALITY_MAX) {
                increaseQualityByOne(item);

                increaseQualityIfBackstage(item);
            }
        } else {
            decreaseQualityAccordingToQuality(item);
        }

        if (isSellInPassed(item)) {
            if (!item.name.equals(ItemType.AGED_BRIE.getValue())) {
                decreaseQualityBackstage(item);
            } else {
                increaseQualityAccordingToQuality(item);
            }
        }
    }

    private void decreaseQualityBackstage(Item item) {
        if (item.name.equals(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getValue())) {
            item.quality = QUALITY_MIN;
        } else {
            decreaseQualityAccordingToQuality(item);
        }
    }

    private void increaseQualityIfBackstage(Item item) {
        if (item.name.equals(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getValue())) {
            increaseQualityAccordingToSellIn(item, 11);
            increaseQualityAccordingToSellIn(item, 6);
        }
    }

    private void decreaseSellInIfNotSulfuras(Item item) {
        if (!item.name.equals(ItemType.SULFURAS_HAND_OF_RAGNAROS.getValue())) {
            decreaseSellInByOne(item);
        }
    }

    private boolean isSellInPassed(Item item) {
        return item.sellIn < 0;
    }

    private void increaseQualityByOne(Item item) {
        item.quality = item.quality + 1;
    }

    private void decreaseQualityByOne(Item item) {
        item.quality = item.quality - 1;
    }

    private void decreaseSellInByOne(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQualityAccordingToQuality(Item item) {
        if (item.quality < GildedRose.QUALITY_MAX) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityAccordingToQuality(Item item) {
        if (item.quality > GildedRose.QUALITY_MIN) {
            if (!item.name.equals(ItemType.SULFURAS_HAND_OF_RAGNAROS.getValue())) {
                decreaseQualityByOne(item);
            }
        }
    }

    private void increaseQualityAccordingToSellIn(Item item, int sellIn) {
        if (item.sellIn < sellIn) {
            increaseQualityAccordingToQuality(item);
        }
    }
}