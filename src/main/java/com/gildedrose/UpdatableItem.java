package com.gildedrose;

public abstract class UpdatableItem extends Item {

  public UpdatableItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  abstract void update();
}
