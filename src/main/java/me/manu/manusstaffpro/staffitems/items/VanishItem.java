package me.manu.manusstaffpro.staffitems.items;

import de.myzelyam.api.vanish.VanishAPI;
import me.manu.manusstaffpro.staffitems.StaffItem;
import me.manu.manusstaffpro.staffplayer.StaffPlayer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class VanishItem extends StaffItem {
    public VanishItem() {
        super("Vanish", new ItemStack(Material.SLIME_BALL));
    }

    private List<String> createLore() {
        List<String> lore = new ArrayList<>();
        lore.add(getStaffItemLoreColor() + "Right-click to toggle vanish mode");
        lore.add(getStaffItemLoreColor() + "and become invisible to players");

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

    private void vanishPlayer(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        final StaffPlayer staffPlayer = StaffPlayer.getStaffPlayer(player.getUniqueId());

        if (player.hasPermission("manusstaffpro.vanish") && staffPlayer.isInStaffMode()) {
            toggleVanish(player);
        }
    }

    private void toggleVanish(Player player) {
        if (VanishAPI.isInvisible(player)) {
            VanishAPI.showPlayer(player);
            sendMessage(player, ChatColor.GREEN, "You are no longer vanished");
        } else {
            VanishAPI.hidePlayer(player);
            sendMessage(player, ChatColor.GREEN, "You are now vanished");
        }
    }

    private void sendMessage(Player player, ChatColor color, String message) {
        player.sendMessage(color + message);
    }

    @Override
    protected void initialize() {
        this.setStaffItemLore(createLore());
        this.configureItemMeta();
    }

    @Override
    public void handleEvent(Event e, StaffPlayer staffPlayer) {
        if (e instanceof PlayerInteractEvent) {
            PlayerInteractEvent event = (PlayerInteractEvent) e;
            vanishPlayer(event);
        }
    }

    @Override
    public ChatColor getStaffItemColor() {
        return ChatColor.GRAY;
    }

    @Override
    public ChatColor getStaffItemLoreColor() {
        return ChatColor.BLUE;
    }
}
