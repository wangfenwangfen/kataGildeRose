package com.gildedrose;

import static org.junit.Assert.*;
import org.junit.Test;

public class GildedRoseTest {

    private void verifyItem(Item item, String expectedName, int expectedSellIn, int expectedQuality) {
        assertEquals(expectedName, item.name);
        assertEquals(expectedSellIn, item.sellIn);
        assertEquals(expectedQuality, item.quality);
    }
    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    public void  decrease_quality_sellIn_if_is_elixir_when_sellIn_not_passed() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        verifyItem(app.items[0], "Elixir of the Mongoose", 4, 6);
    }
    @Test
    public void  decrease_sellIn_and_increase_quality_backstage_passes() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 7)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        verifyItem(app.items[0], "Backstage passes to a TAFKAL80ETC concert", 4, 10);
    }

    @Test
    public void decrease_sellIn_and_quality_if_item_is_dexterity_vest_when_quality_superior_max_sellIn_passed() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 80)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        verifyItem(app.items[0], "+5 Dexterity Vest", -2, 78);
    }

    @Test
    public void decrease_sellIn_and_quality_dexterity_vest_sellIn_inferior_max() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 2, 30)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        verifyItem(app.items[0], "+5 Dexterity Vest", 1, 29);
    }

    @Test
    public void decrease_sellIn_increase_quality_aged_brie_when_quality_inferior_max_sellIn_passed() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 40)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        verifyItem(app.items[0], "Aged Brie", -2, 42);
    }

    @Test
    public void decrease_sellIn_and_quality_equals_zero_backstage_when_quality_equalse_max_sellIn_passed() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        verifyItem(app.items[0], "Backstage passes to a TAFKAL80ETC concert", -2, 0);
    }
}
