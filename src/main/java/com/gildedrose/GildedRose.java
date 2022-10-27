package com.gildedrose;

import com.gildedrose.updatable.UpdatableItem;

import java.util.Arrays;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    UpdatableItemFactory factory = new UpdatableItemFactory();
    items =
        Arrays.stream(items)
            .map(factory::buildUpdatable)
            .map(UpdatableItem::update)
            .toArray(Item[]::new);
  }
}
