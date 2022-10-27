package com.gildedrose.updatable;

import com.gildedrose.Item;

public class ConcertPass extends UpdatableItem {
  public ConcertPass(Item i) {
    super(i);
  }

  @Override
  public UpdatableItem update() {
    updateSellIn(this);
    updateQuality(this);
    return this;
  }

  private void updateQuality(Item item) {
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
  private void updateSellIn(Item item) {
    item.sellIn = item.sellIn - 1;
  }
}
