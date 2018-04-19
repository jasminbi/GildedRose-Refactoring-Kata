package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseShould {

    @Test
    public void decrease_quality_daily() {
        //arrange (given)
        Item[] items = new Item[] { new Item("foo", 10, 5) };
        GildedRose app = new GildedRose(items);

        //act (when)
        app.updateQuality();

        //assert (then we expect)
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void decrease_sellin_daily() {
        Item[] items = new Item[] { new Item("foo", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    public void decrease_quality_faster_after_sellin() {
        Item[] items = new Item[] { new Item("foo", 0, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void limit_quality_decrease_to_0() {
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void increase_quality_if_item_is_brie() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void limit_item_quality_to_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }






}
