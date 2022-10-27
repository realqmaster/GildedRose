package com.gildedrose.updatable;

import com.gildedrose.Item;

public class AgedBrie extends UpdatableItem {

  public AgedBrie(Item i) {
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
      item.quality = item.quality + 1;
    }
  }

  private void updateSellIn(Item item) {
    item.sellIn = item.sellIn - 1;
  }
}
