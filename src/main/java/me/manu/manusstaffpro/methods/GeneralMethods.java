package me.manu.manusstaffpro.methods;

import me.manu.manusstaffpro.staffplayer.StaffPlayer;
import org.bukkit.entity.Player;

public class GeneralMethods {
    public void sendMessageToStaffChat(Player p, String message) {
        StaffPlayer sPlayer = StaffPlayer.getStaffPlayer(p.getUniqueId());

    }
}
