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




}
