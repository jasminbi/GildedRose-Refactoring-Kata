package com.gildedrose;

class GildedRose {
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (item.name.equals(SULFURAS)) {
            return;
        }

        item.sellIn = item.sellIn - 1;

        switch (item.name) {
            case AGED_BRIE:
                increaseQuality(item);
                if (sellByDateHasPassedFor(item)) {
                    increaseQuality(item);
                }
                break;
            case BACKSTAGE_PASSES:
                increaseQuality(item);
                if (item.sellIn < 10) {
                    increaseQuality(item);
                }

                if (item.sellIn < 5) {
                    increaseQuality(item);
                }

                if (sellByDateHasPassedFor(item)) {
                    item.quality = MIN_QUALITY;
                }


                break;
            default:
                decreaseQuality(item);
                if (sellByDateHasPassedFor(item)) {

                    decreaseQuality(item);

                }
                break;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY && !item.name.equals(SULFURAS)) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }

    //explanatory method
    private boolean sellByDateHasPassedFor(Item item) {
        return item.sellIn < 0;
    }
}