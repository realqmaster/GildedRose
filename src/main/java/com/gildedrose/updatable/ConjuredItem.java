package com.gildedrose.updatable;

import com.gildedrose.Item;

public class ConjuredItem extends UpdatableItem {
  public ConjuredItem(Item item) {
    super(item);
  }

  @Override
  public Item update() {
    updateQuality(this);
    return this;
  }

  private void updateQuality(Item item) {
    if (item.quality > 0) {
      if (item.sellIn >= 0) {
        item.quality = item.quality - 2;
      } else {
        item.quality = item.quality - 4;
      }
    }
  }
}
