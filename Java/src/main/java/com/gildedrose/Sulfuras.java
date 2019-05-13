package com.gildedrose;

class Sulfuras extends ItemComposition {
    Sulfuras(Item item) {
        super(item);
    }

    @Override
    void updateQualityOfItem() {
        decreaseSellInByOne();
    }

    private void decreaseSellInByOne() {
        item.sellIn = item.sellIn - 1;
    }

}
