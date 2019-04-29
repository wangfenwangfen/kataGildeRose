package com.gildedrose;

class ItemComposition {

    private static final int QUALITY_MAX = 50;
    private static final int QUALITY_MIN = 0;
    private final Item item;

    ItemComposition(Item item) {
        this.item = item;
    }

    private boolean isItemOf(ItemType itemType){
        return item.name.equals(itemType.getValue());
    }

    private boolean isAgedBrie() {
        return item.name.equals(ItemType.AGED_BRIE.getValue());
    }

    private boolean isSellInPassed() {
        return item.sellIn < 0;
    }

    private void decreaseQualityByOne() {
        item.quality = item.quality - 1;
    }

    private boolean isSulfuras() {
        return item.name.equals(ItemType.SULFURAS_HAND_OF_RAGNAROS.getValue());
    }

    void updateQuality() {
        decreaseSellInIfNotSulfuras();
        increaseQualityAgedBrie();
        increaseQualityBackstage();

        if (!isAgedBrie() && !isItemOf(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            decreaseQualityAccordingToQuality();
        }

        if (isSellInPassed()) {
            increaseQualityAgedBrie();

            if (!isAgedBrie()) {
                decreaseQualityBackstage();
            }
        }
    }

    private void increaseQualityAgedBrie() {
        if (isAgedBrie()) {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void increaseQualityBackstage() {
        if (isItemOf(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;
                increaseQualityAccordingToSellIn(11);
                increaseQualityAccordingToSellIn(6);
            }
        }
    }

    private void decreaseQualityBackstage() {
        if (isItemOf(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            item.quality = QUALITY_MIN;
        } else {
            decreaseQualityAccordingToQuality();
        }
    }

    private void decreaseSellInIfNotSulfuras() {
        isSulfuras();
        decreaseSellInByOne();
    }

    private void decreaseSellInByOne() {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQualityAccordingToQuality() {
        if (item.quality > QUALITY_MIN) {
            if (isSulfuras()) {
                return;
            }
            decreaseQualityByOne();
        }
    }

    private void increaseQualityAccordingToSellIn(int sellIn) {
        if (item.sellIn < sellIn) {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;
            }
        }
    }
}