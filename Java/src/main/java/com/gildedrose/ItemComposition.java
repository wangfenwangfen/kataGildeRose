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
        decreaseQualityConjured();

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

    private void decreaseQualityConjured() {
        if (item.quality > QUALITY_MIN && item.quality < QUALITY_MAX) {
            if (isItemOf(ItemType.CONJURED)) {
               decreaseQualityByOne();
            }
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

     ItemComposition convertItemToItemComposition() {

         if(item.name.equals(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getValue())){
             return new Backstage(item);
         }
            return new AgedBrie(item);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemComposition that = (ItemComposition) o;

        return item != null ? item.equals(that.item) : that.item == null;
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }
}