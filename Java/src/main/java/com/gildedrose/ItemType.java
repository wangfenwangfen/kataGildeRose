package com.gildedrose;

public enum ItemType {

    BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS_HAND_OF_RAGNAROS("Sulfuras, Hand of Ragnaros"), CONJURED("Conjured"),
    AGED_BRIE("Aged Brie");

    private String value;

    public String getValue() {
        return value;
    }

    ItemType(String value) {
        this.value = value;
    }
}