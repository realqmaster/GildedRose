package com.gildedrose;

import com.gildedrose.updatable.*;

import java.util.Objects;

public class UpdatableItemFactory {

  public UpdatableItem buildUpdatable(Item item) {
    ItemType type = evaluateType(item);
    switch (type) {
      case SULFURAS:
        return new Sulfuras(item);
      case AGED_BRIE:
        return new AgedBrie(item);
      case CONCERT_PASS:
        return new ConcertPass(item);
      case CONJURED:
        return new ConjuredItem(item);
      default:
        return new PlainItem(item);
    }
  }

  private ItemType evaluateType(Item item) {
    if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
      return ItemType.SULFURAS;
    } else if ("Aged Brie".equals(item.name)) {
      return ItemType.AGED_BRIE;
    } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
      return ItemType.CONCERT_PASS;
    } else if (Objects.nonNull(item.name) && item.name.startsWith("Conjured")) {
      return ItemType.CONJURED;
    } else return ItemType.PLAIN;
  }

  private enum ItemType {
    SULFURAS,
    AGED_BRIE,
    CONCERT_PASS,
    PLAIN,
    CONJURED,
  }
}
