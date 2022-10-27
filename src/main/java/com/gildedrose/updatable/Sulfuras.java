package com.gildedrose.updatable;

import com.gildedrose.Item;

public class Sulfuras extends UpdatableItem {

  public Sulfuras(Item i) {
    super(i);
  }

  @Override
  void update() {
    updateQuality(this);
  }

  private void updateQuality(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }
}
