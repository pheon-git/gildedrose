package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            String name = item.name;
            switch (name) {
                case AGED_BRIE:
                    increaseQuality(item);
                    decreaseSellIn(item);

                    if (item.sellIn < 0) increaseQuality(item);
                    break;
                case BACKSTAGE_PASSES:
                    increaseQuality(item);
                    if (item.sellIn < 11) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQuality(item);
                    }
                    decreaseSellIn(item);

                    if (item.sellIn < 0) item.quality = 0;
                    break;
                case SULFURAS:

                    break;
                default:
                    decreaseQuality(item);
                    decreaseSellIn(item);

                    if (item.sellIn < 0) decreaseQuality(item);
                    break;
            }

        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

}