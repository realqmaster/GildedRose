package com.gildedrose.updatable;

import com.gildedrose.Item;

public class PlainItem extends UpdatableItem {

  public PlainItem(Item i) {
    super(i);
  }

  @Override
  void update() {
    updateQuality(this);
    updateSellIn(this);
  }

  private void updateQuality(PlainItem item) {
    if (item.sellIn >= 0) {
      item.quality = item.quality - 1;
    } else {
      item.quality = item.quality - 2;
    }
  }

  private void updateSellIn(PlainItem item) {
    item.sellIn = item.sellIn - 1;
  }
}
