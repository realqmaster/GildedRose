package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class GildedRoseTest {

  @Test
  @DisplayName("Normal item sellIn and quality should decrease by 1 after an update")
  void normal_item_quality_decreases_by_one() {
    Item item = prepareSingleItem("foo", 1, 1);
    assertThat(item.quality).isEqualTo(0);
  }

  @Test
  @DisplayName("Normal item quality past sellIn should decrease by 2 after an update")
  void normal_item_quality_past_sellIn_decreases_by_two() {
    Item item = prepareSingleItem("foo", 0, 2);
    assertThat(item.quality).isEqualTo(0);
  }

  @Test
  @DisplayName("Aged Brie increases quality with time")
  void aged_brie_increases_quality() {
    Item item = prepareSingleItem("Aged Brie", 1, 1);
    assertThat(item.quality).isEqualTo(2);
  }

  @Test
  @DisplayName("The Quality of an item is never more than 50")
  void quality_never_greater_than_50() {
    Item item = prepareSingleItem("Aged Brie", 1, 50);
    assertThat(item.quality).isEqualTo(50);
  }

  @Test
  @DisplayName("Sulfuras never has to be sold or decreases in Quality")
  void sulfuras_never_decrease_sellIn_or_quality() {
    Item item = prepareSingleItem("Sulfuras, Hand of Ragnaros", 10, 10);
    assertThat(item.quality).isEqualTo(11);
    assertThat(item.sellIn).isEqualTo(10);
  }

  @Test
  @DisplayName("BP: Quality increases by 2 when there are 10 days or less")
  void backstage_passes_quality_increases_by_2_at_10_or_less() {
    Item item = prepareSingleItem("Backstage passes to a TAFKAL80ETC concert", 10, 10);
    assertThat(item.quality).isEqualTo(12);
  }

  @Test
  @DisplayName("BP: Quality increases by 3 when there are 10 days or less")
  void backstage_passes_quality_increases_by_3_at_15_or_less() {
    Item item = prepareSingleItem("Backstage passes to a TAFKAL80ETC concert", 5, 10);
    assertThat(item.quality).isEqualTo(13);
  }

  @Test
  @DisplayName("BP: Quality drops to 0 after concert")
  void backstage_passes_quality_drops_to_0() {
    Item item = prepareSingleItem("Backstage passes to a TAFKAL80ETC concert", 0, 10);
    assertThat(item.quality).isEqualTo(0);
  }

  @Test
  @Disabled
  @DisplayName("Conjured items degrade in Quality twice as fast as normal items")
  void conjured_items() {
    fail("Not implemented");
  }

  private static Item prepareSingleItem(String name, int sellIn, int quality) {
    Item[] items = new Item[] {new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
    return app.items[0];
    }

}
