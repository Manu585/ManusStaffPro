package me.manu.manusstaffpro.methods;

import me.manu.manusstaffpro.staffitems.StaffItem;
import me.manu.manusstaffpro.staffitems.items.InvseeItem;
import me.manu.manusstaffpro.staffitems.items.VanishItem;

public class StaffItemsCreator {
    private static StaffItem invseeItem;
    private static StaffItem vanishItem;

    public static void initStaffItems() {
        invseeItem = new InvseeItem();
        vanishItem = new VanishItem();
    }


    public static StaffItem getInvseeItem() {
        return invseeItem;
    }
    public static StaffItem getVanishItem() {
        return vanishItem;
    }

    public static void setInvseeItem(StaffItem item) {
        invseeItem = item;
    }
    public static void setVanishItem(StaffItem item) {
        vanishItem = item;
    }
}
