package me.manu.manusstaffpro.commands;

import me.manu.manusstaffpro.staffmode.StaffMode;
import me.manu.manusstaffpro.staffplayer.StaffPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffModeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (label.equalsIgnoreCase("staffmode")) {
                StaffPlayer sPlayer = StaffPlayer.getStaffPlayer(p.getUniqueId());
                if (!sPlayer.isInStaffMode()) {
                    StaffMode.enableStaffMode(sPlayer);
                } else {
                    StaffMode.disableStaffMode(sPlayer);
                }
                return true;
            }
        }
        return false;
    }
}
