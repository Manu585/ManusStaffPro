package me.manu.manusstaffpro.staffchat;

import me.manu.manusstaffpro.config.ConfigManager;
import me.manu.manusstaffpro.staffplayer.StaffPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class StaffChatHandler {
    private Player player;
    private StaffPlayer staffPlayer;

    public StaffChatHandler(Player player) {
        this.player = player;
        this.staffPlayer = StaffPlayer.getStaffPlayer(player.getUniqueId());
    }

    public void sendMessage(String message, Player playerToSendTo) {
        String messageFormat = ConfigManager.languageConfig.get().getString("StaffPro.StaffChat.Format");
        if (messageFormat != null) {
            String playerFormat = messageFormat.replace("%player%", player.getDisplayName());
            String msgFormat = messageFormat.replace("%message%", message);
            staffPlayer.getPLAYERS().values().forEach(staffPlayer -> staffPlayer.getPlayer().sendMessage
                    (playerFormat + ChatColor.RESET + msgFormat.substring(1)));
        } else {
            playerToSendTo.sendMessage(ChatColor.RED + "ConfigError! StaffPro.StaffChat.Format may be null!" +
                    "Ask your server administrator to take a look into the language.yml file!");
        }

    }

}
