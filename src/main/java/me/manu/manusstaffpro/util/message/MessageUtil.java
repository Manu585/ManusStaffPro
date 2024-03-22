package me.manu.manusstaffpro.util.message;

import me.manu.manusstaffpro.staffplayer.StaffPlayer;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageUtil {
    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
    public static String format(String msg) {
        Matcher match = pattern.matcher(msg);
        while (match.find()) {
            String color = msg.substring(match.start(), match.end());
            msg = msg.replace(color, ChatColor.of(color) + "");
            match = pattern.matcher(msg);
        }
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String serverStartMessage() {
        return format("&2Starting " + Bukkit.getName() + " v1.0.0 !");
    }

    public static String serverStopMessage() {
        return format("&2Stopping " + Bukkit.getName() + " v1.0.0 !");
    }

    public static String staffModeEnabledMessage(StaffPlayer sPlayer) {
        return format("&6Activated Staffmode power: " + sPlayer.getHierarchy().getPower());
    }
}
