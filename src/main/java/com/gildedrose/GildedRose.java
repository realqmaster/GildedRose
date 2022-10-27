package com.gildedrose;

import java.util.Arrays;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    Arrays.asList(items).forEach(this::process);
  }

  private void process(Item item) {
    if (isNotSulfuras(item)) {
      sellInDecrease(item);
    }
    if (item.quality > 0) {
      applyUpdateQualityLogic(item);
    }
  }

  private void applyUpdateQualityLogic(Item item) {
    if (hasNormalQualityUpdate(item)) {
      updateQuality(item);
    } else {
      if (isConcertPass(item)) {
        updateConcertPassQuality(item);
      } else {
        qualityIncreases(item);
      }
    }
  }

  private void updateQuality(Item item) {
    if (item.sellIn >= 0) {
      qualityDecrease(item);
    } else {
      doubleQualityDecrease(item);
    }
  }

  private static void sellInDecrease(Item item) {
    item.sellIn = item.sellIn - 1;
  }

  private static void qualityIncreases(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }

  private static void updateConcertPassQuality(Item item) {
    if (item.quality < 50) {
      if (item.sellIn < 0) {
        item.quality = 0;
      } else if (item.sellIn < 6) {
        item.quality = item.quality + 3;
      } else if (item.sellIn < 11) {
        item.quality = item.quality + 2;
      }
    }
  }

  private static void qualityDecrease(Item item) {
    item.quality = item.quality - 1;
  }

  private void doubleQualityDecrease(Item item) {
    qualityDecrease(item);
    qualityDecrease(item);
  }

  private static boolean isNotSulfuras(Item item) {
    return !item.name.equals("Sulfuras, Hand of Ragnaros");
  }

  private static boolean isConcertPass(Item item) {
    return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  private static boolean isNotAgedBrie(Item item) {
    return !item.name.equals("Aged Brie");
  }

  private static boolean hasNormalQualityUpdate(Item item) {
    return !isConcertPass(item) && isNotAgedBrie(item) && isNotSulfuras(item);
  }
}
