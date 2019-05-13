package com.gildedrose;

class Elixir extends ItemComposition {

    Elixir(Item item) {
        super(item);
    }

    @Override
    void updateQualityOfItem() {
        decreaseSellInByOne();
        decreaseQualityAccordingToQuality();
        if (isSellInPassed()) {
            decreaseQualityAccordingToQuality();
        }
    }

    private void decreaseSellInByOne() {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQualityAccordingToQuality() {
        if (item.quality > QUALITY_MIN) {
            decreaseQualityByOne();
        }
    }

    private void decreaseQualityByOne() {
        item.quality = item.quality - 1;
    }

    private boolean isSellInPassed() {
        return item.sellIn < 0;
    }

}
