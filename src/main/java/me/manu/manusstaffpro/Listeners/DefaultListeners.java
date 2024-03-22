package me.manu.manusstaffpro.Listeners;

import me.manu.manusstaffpro.ManusStaffPro;
import me.manu.manusstaffpro.hierarchy.Hierarchy;
import me.manu.manusstaffpro.staffitems.items.InvseeItem;
import me.manu.manusstaffpro.staffitems.items.VanishItem;
import me.manu.manusstaffpro.staffmode.StaffMode;
import me.manu.manusstaffpro.staffplayer.StaffPlayer;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class DefaultListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("staffpro.use")) {
            User user = ManusStaffPro.luckPerms.getUserManager().getUser(p.getUniqueId());              assert user != null;
            Group group = ManusStaffPro.luckPerms.getGroupManager().getGroup(user.getPrimaryGroup());   assert group != null;

            if (group.getWeight().isPresent()) {
                Hierarchy hierarchy = new Hierarchy(user.getPrimaryGroup(), group.getWeight().getAsInt());
                StaffPlayer sPlayer = new StaffPlayer(p.getUniqueId(), hierarchy);
                StaffPlayer.registerStaffPlayers(sPlayer);
                p.sendMessage("Created new StaffPlayer with the rank: " + hierarchy.getRank());
                p.sendMessage("Created new StaffPlayer with the hierachy: " + hierarchy.getPower());
            }
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        StaffPlayer sPlayer = StaffPlayer.getStaffPlayer(p.getUniqueId());
        StaffMode.disableStaffMode(sPlayer);
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        StaffPlayer staffPlayer = StaffPlayer.getStaffPlayer(e.getPlayer().getUniqueId());
        if (staffPlayer != null) {
            InvseeItem invseeItem = new InvseeItem();
            invseeItem.handleEvent(e, staffPlayer);

            VanishItem vanishItem = new VanishItem();
            vanishItem.handleEvent(e, staffPlayer);
        }
    }
}
