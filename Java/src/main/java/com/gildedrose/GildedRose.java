package com.gildedrose;

class GildedRose {

    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            ItemComposition itemComposition = new ItemComposition(item);
            itemComposition.updateQuality();
        }
    }
}