package com.gildedrose;

import com.gildedrose.updatable.*;

public class UpdatableItemFactory {

  public UpdatableItem buildUpdatable(Item item) {
    switch (item.name) {
      case "Sulfuras, Hand of Ragnaros":
        return new Sulfuras(item);
      case "Aged Brie":
        return new AgedBrie(item);
      case "Backstage passes to a TAFKAL80ETC concert":
        return new ConcertPass(item);
      default:
        return new PlainItem(item);
    }
  }
}
