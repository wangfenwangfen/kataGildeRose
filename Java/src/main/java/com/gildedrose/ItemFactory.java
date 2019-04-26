package com.gildedrose;
class ItemFactory {

    final Item item;

    private ItemFactory(Item item) {
        this.item = item;
    }

    static ItemFactory getItemFactory(Item item){
        return new ItemFactory(item);
    }

    static boolean isBackstage(Item item) {
        return item.name.equals(ItemType.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT.getValue());
    }

    static boolean isAgedBrie(Item item) {
        return item.name.equals(ItemType.AGED_BRIE.getValue());
    }

    static boolean isSellInPassed(Item item) {
        return item.sellIn < 0;
    }

    static void decreaseQualityByOne(Item item) {
        item.quality = item.quality - 1;
    }

    static boolean isSulfuras(Item item) {
        return item.name.equals(ItemType.SULFURAS_HAND_OF_RAGNAROS.getValue());
    }
}