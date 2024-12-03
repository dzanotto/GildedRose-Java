package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(DiffReporter.class)
public class GildedRoseApprovalTest {

    @Test
    public void testWithApprovals() {
        Item[] items = new Item[]{
                new Item("Foo", 10, 50),
                new Item("Bar", 5, 25),
                new Item("Aged Brie", 10, 30),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5),
                new Item("test", 5, 0),
                new Item("Norma", 7, 60),
                new Item("Aged Brie", 10, 60),
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 49)
        };
        GildedRose gildedRose = new GildedRose(items);
        String output = "";
        for (int j = 0; j < 30; j++) {
            gildedRose.updateQuality();
            for (int i = 0; i < gildedRose.items.length; i++) {
                output += gildedRose.items[i].toString() + "\n";
            }
        }

        CombinationApprovals.verifyAllCombinations();

        Approvals.verify(output);
    }
}
