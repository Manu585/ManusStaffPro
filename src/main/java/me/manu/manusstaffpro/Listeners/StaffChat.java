package me.manu.manusstaffpro.Listeners;

import me.manu.manusstaffpro.staffchat.StaffChatHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        StaffChatHandler chatHandler = new StaffChatHandler(e.getPlayer());
        if (e.getMessage().startsWith("@")) {
            e.setCancelled(true);
            for (Player all : Bukkit.getOnlinePlayers()) {
                chatHandler.sendMessage(e.getMessage(), all);
            }
        }
    }
}
