package com.gildedrose.updatable;

import com.gildedrose.Item;

public abstract class UpdatableItem extends Item {

  public UpdatableItem(Item i) {
    super(i.name, i.sellIn, i.quality);
  }

  public abstract Item update();
}
