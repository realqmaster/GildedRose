package com.gildedrose.updatable;

import com.gildedrose.Item;

public class ConcertPass extends UpdatableItem {
  public ConcertPass(Item i) {
    super(i);
  }

  @Override
  void update() {
    updateQuality(this);
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
}
