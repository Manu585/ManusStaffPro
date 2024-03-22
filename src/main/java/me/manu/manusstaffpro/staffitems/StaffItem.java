package me.manu.manusstaffpro.staffitems;

import me.manu.manusstaffpro.staffplayer.StaffPlayer;
import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class StaffItem {
    private String itemName;
    private List<String> itemLore = new ArrayList<>();
    public ItemStack staffItem;

    public StaffItem(String itemName, ItemStack staffItem) {
        this.itemName = itemName;
        this.staffItem = staffItem;
        initialize();
    }

    protected abstract void initialize();

    public String getItemName() {
        return this.itemName;
    }

    public List<String> getItemLore() {
        return this.itemLore;
    }

    public ItemStack getStaffItem() {
        return this.staffItem;
    }

    public void setStaffItemLore(List<String> itemLore) {
        this.itemLore = itemLore;
    }

    public void setStaffItemName(String itemName) {
        this.itemName = itemName;
    }

    public abstract void handleEvent(Event e, StaffPlayer staffPlayer);

    public abstract ChatColor getStaffItemColor();

    public abstract ChatColor getStaffItemLoreColor();
}
