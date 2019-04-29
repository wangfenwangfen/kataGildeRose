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
}
