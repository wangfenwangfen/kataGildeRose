package com.gildedrose;

class Conjured extends ItemComposition {
    Conjured(Item item) {
        super(item);
    }

    @Override
    void updateQualityOfItem() {
        decreaseSellInByOne();
        decreaseQualityConjured();
        decreaseQualityAccordingToQuality();
    }

    private void decreaseSellInByOne() {
        item.sellIn = item.sellIn - 1;
    }
    private void decreaseQualityConjured() {
        if (item.quality > QUALITY_MIN && item.quality < QUALITY_MAX) {
                decreaseQualityByOne();
        }
    }

    private void decreaseQualityByOne() {
        item.quality = item.quality - 1;
    }

    private void decreaseQualityAccordingToQuality() {
        if (item.quality > QUALITY_MIN) {
            decreaseQualityByOne();
        }
    }
}
