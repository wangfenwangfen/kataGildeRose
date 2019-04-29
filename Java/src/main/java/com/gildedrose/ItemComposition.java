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

    private boolean isSellInPassed() {
        return item.sellIn < 0;
    }

    private void decreaseQualityByOne() {
        item.quality = item.quality - 1;
    }

    void updateQuality() {
        decreaseSellInByOne();
        increaseQualityAgedBrie();
        increaseQualityBackstage();

        if (!isItemOf(ItemType.AGED_BRIE) && !isItemOf(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            decreaseQualityAccordingToQuality();
        }

        if (isSellInPassed()) {
            increaseQualityAgedBrie();

            if (!isItemOf(ItemType.AGED_BRIE)) {
                decreaseQualityBackstage();
            }
        }
    }

    private void increaseQualityAgedBrie() {
        if (isItemOf(ItemType.AGED_BRIE)) {
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

    private void decreaseSellInByOne() {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQualityAccordingToQuality() {
        if (item.quality > QUALITY_MIN) {
            if (isItemOf(ItemType.SULFURAS_HAND_OF_RAGNAROS)) {
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