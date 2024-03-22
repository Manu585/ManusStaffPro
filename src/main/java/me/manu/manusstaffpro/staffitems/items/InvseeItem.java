package me.manu.manusstaffpro.staffitems.items;

import me.manu.manusstaffpro.staffitems.StaffItem;
import me.manu.manusstaffpro.staffplayer.StaffPlayer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InvseeItem extends StaffItem {
    public InvseeItem() {
        super("Invsee", new ItemStack(Material.CHEST));
    }

    private List<String> createLore() {
        List<String> lore = new ArrayList<>();
        lore.add(getStaffItemLoreColor() + "Right-click on player to");
        lore.add(getStaffItemLoreColor() + "view their inventory!");

        return lore;
    }

    private void configureItemMeta() {
        ItemStack item = getStaffItem();
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(getStaffItemColor() + /*getConfig().getString("essence.airessence.essencename")*/"Vanish");
            meta.setLore(getItemLore());
            item.setItemMeta(meta);
        }
    }

    @Override
    protected void initialize() {
        this.setStaffItemLore(createLore());
        this.configureItemMeta();

    }

    @Override
    public void handleEvent(Event e, StaffPlayer staffPlayer) {

    }

    @Override
    public ChatColor getStaffItemColor() {
        return ChatColor.GOLD;
    }

    @Override
    public ChatColor getStaffItemLoreColor() {
        return ChatColor.YELLOW;
    }
}
