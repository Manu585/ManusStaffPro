package me.manu.manusstaffpro.staffmode;

import me.manu.manusstaffpro.methods.StaffItemsCreator;
import me.manu.manusstaffpro.staffplayer.StaffPlayer;
import me.manu.manusstaffpro.util.message.MessageUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffMode {

    public static Map<String, ItemStack[]> items = new HashMap<>();
    public static Map<Integer, List<String>> powerItemsMap = new HashMap<>();

    public static void enableStaffMode(StaffPlayer sPlayer) {
        Player p = sPlayer.getPlayer();
        if (p.hasPermission("staffpro.enablestaffmode") && p.hasPermission("staffpro.use")) {
            if (!sPlayer.isInStaffMode()) {
                sPlayer.setInStaffMode(true);
                p.sendMessage(MessageUtil.staffModeEnabledMessage(sPlayer));
                items.put(sPlayer.getUuid().toString(), p.getInventory().getContents());
                p.getInventory().clear();

                p.getInventory().setItem(0, StaffItemsCreator.getInvseeItem().getStaffItem());
                p.getInventory().setItem(4, StaffItemsCreator.getVanishItem().getStaffItem());
            }
        }
    }


    public static void disableStaffMode(StaffPlayer sPlayer) {
        if (sPlayer.isInStaffMode()) {
            Player p = sPlayer.getPlayer();
            p.getInventory().clear();
            p.getInventory().setContents(items.get(sPlayer.getUuid().toString()));
            sPlayer.setInStaffMode(false);
        }
    }
    public static void setPowerItemsMap(Map<Integer, List<String>> map) {
        powerItemsMap = map;
    }
}
