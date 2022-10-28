package com.gildedrose.updatable;

import com.gildedrose.Item;

public class PlainItem extends UpdatableItem {

  public PlainItem(Item i) {
    super(i);
  }

  @Override
  public UpdatableItem update() {
    updateSellIn(this);
    updateQuality(this);
    return this;
  }

  private void updateQuality(PlainItem item) {
    if (item.quality > 0) {
      if (item.sellIn >= 0) {
        item.quality = item.quality - 1;
      } else {
        item.quality = item.quality - 2;
      }
    }
  }

  private void updateSellIn(Item item) {
    item.sellIn = item.sellIn - 1;
  }
}
