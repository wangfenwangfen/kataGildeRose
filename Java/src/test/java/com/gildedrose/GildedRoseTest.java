package com.gildedrose;

import static org.junit.Assert.*;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    public void  update_quality_elixir() {
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Elixir of the Mongoose", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }
    @Test
    public void  update_quality_backstage_passes() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 7)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }


}
