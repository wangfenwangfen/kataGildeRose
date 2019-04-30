package com.gildedrose;

class Backstage extends ItemComposition {
    Backstage(Item item) {
        super(item);
    }

    @Override
    void updateQualityOfItem() {
        decreaseSellInByOne();
        increaseQualityBackstage();
    }
    private void decreaseSellInByOne() {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQualityBackstage() {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;
                increaseQualityAccordingToSellIn(11);
                increaseQualityAccordingToSellIn(6);
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
