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
            if (name.equals(AGED_BRIE)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (name.equals(BACKSTAGE_PASSES)) {
                        if (item.sellIn < 11) {
                            increaseQuality(item);
                        }

                        if (item.sellIn < 6) {
                            increaseQuality(item);
                        }
                    }
                }
            } else if (name.equals(BACKSTAGE_PASSES)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (name.equals(BACKSTAGE_PASSES)) {
                        if (item.sellIn < 11) {
                            increaseQuality(item);
                        }

                        if (item.sellIn < 6) {
                            increaseQuality(item);
                        }
                    }
                }
            } else {
                if (item.quality > 0) {
                    decreaseQuality(item);
                }
            }

            if (!name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (name.equals(AGED_BRIE)) {
                    increaseQuality(item);
                } else {
                    if (name.equals(BACKSTAGE_PASSES)) {
                        item.quality = 0;
                    } else {
                        if (item.quality > 0) {
                            decreaseQuality(item);
                        }
                    }
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}