package com.gildedrose;

class GildedRose {

    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            ItemComposition itemComposition = convertItemToItemComposition(item);
            itemComposition.updateQualityOfItem();
        }
    }

    GildedRose() {
    }

    ItemComposition convertItemToItemComposition(Item item) {

        if(item.name.equals(ItemType.CONJURED.getValue())){
            return new Conjured(item);
        }
        if(item.name.equals(ItemType.SULFURAS_HAND_OF_RAGNAROS.getValue())){
            return new Sulfuras(item);
        }
        if(item.name.equals(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getValue())){
            return new Backstage(item);
        }
        return new AgedBrie(item);
    }
}