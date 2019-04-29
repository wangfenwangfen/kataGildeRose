package com.gildedrose;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ConvertItemTest {
    @Test
    public void should_return_a_itemComposition_with_type_aged_brie() {
        Item item = new Item("Aged Brie", 5, 7);
        ItemComposition itemComposition = new ItemComposition(item);
         itemComposition = itemComposition.convertItemToItemComposition();
        ItemComposition itemCompositionExpected = new AgedBrie(item);

        assertThat(itemComposition).isEqualTo(itemCompositionExpected);
    }

    @Test
    public void should_return_a_itemComposition_with_type_backstage() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 7);
        ItemComposition itemComposition = new ItemComposition(item);
        itemComposition = itemComposition.convertItemToItemComposition();
        ItemComposition itemCompositionExpected = new Backstage(item);

        assertThat(itemComposition).isEqualTo(itemCompositionExpected);
    }

    @Test
    public void should_return_a_itemComposition_with_type_sulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 7);
        ItemComposition itemComposition = new ItemComposition(item);
        itemComposition = itemComposition.convertItemToItemComposition();
        ItemComposition itemCompositionExpected = new Sulfurase(item);

        assertThat(itemComposition).isEqualTo(itemCompositionExpected);
    }

    @Test
    public void should_return_a_itemComposition_with_type_conjured() {
        Item item = new Item("Conjured", 5, 7);
        ItemComposition itemComposition = new ItemComposition(item);
        itemComposition = itemComposition.convertItemToItemComposition();
        ItemComposition itemCompositionExpected = new Conjured(item);

        assertThat(itemComposition).isEqualTo(itemCompositionExpected);
    }
}
