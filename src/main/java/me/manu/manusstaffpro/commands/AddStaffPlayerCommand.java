package me.manu.manusstaffpro.commands;

import me.manu.manusstaffpro.hierarchy.Hierarchy;
import me.manu.manusstaffpro.staffplayer.StaffPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddStaffPlayerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("staffpro.addmember")) {
                if (label.equalsIgnoreCase("addmember")) {
                    Player toAdd = Bukkit.getPlayer(args[0]);
                    String rank = args[1];
                    p.sendMessage(args[0]);
                    p.sendMessage(args[1]);                                             //WORK IN PROGRESS
                        Hierarchy hierarchy = new Hierarchy(rank, 10);
                    StaffPlayer sPlayer = new StaffPlayer(toAdd.getUniqueId(), hierarchy);
                    StaffPlayer.registerStaffPlayers(sPlayer);
                    p.sendMessage("CREATED NEW STAFF PLAYER");
                }
            }
        }
        return false;
    }
}
