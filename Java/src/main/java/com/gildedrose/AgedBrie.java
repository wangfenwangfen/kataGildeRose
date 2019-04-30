package com.gildedrose;

class AgedBrie extends ItemComposition {
    AgedBrie(Item item) {
        super(item);
    }

    @Override
    void updateQualityOfItem() {
        decreaseSellInByOne();
        increaseQualityByOne();
        if(isSellInPassed()){
            increaseQualityByOne();
        }
    }

    private void increaseQualityByOne() {
        if (item.quality < QUALITY_MAX) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseSellInByOne() {
        item.sellIn = item.sellIn - 1;

    }
    private boolean isSellInPassed() {
        return item.sellIn < 0;
    }
}
