package me.manu.manusstaffpro.staffplayer;

import me.manu.manusstaffpro.hierarchy.Hierarchy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StaffPlayer {
    private static Map<UUID, StaffPlayer> PLAYERS = new HashMap<>();

    private final Player player;
    private final UUID uuid;
    private final Hierarchy hierarchy;
    private boolean isInStaffMode = false;

    public StaffPlayer(UUID uuid, Hierarchy hierarchy) {
        this.uuid = uuid;
        this.hierarchy = hierarchy;

        this.player = Bukkit.getPlayer(uuid);
    }

    public Player getPlayer() {
        return this.player;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public boolean isInStaffMode() {
        return isInStaffMode;
    }

    public void setInStaffMode(boolean mode) {
        this.isInStaffMode = mode;
    }

    public Map<UUID, StaffPlayer> getPLAYERS() {
        return PLAYERS;
    }

    public Hierarchy getHierarchy() {
        return this.hierarchy;
    }

    public static StaffPlayer getStaffPlayer(UUID uuid) {
        return PLAYERS.get(uuid);
    }

    public static Map<UUID, StaffPlayer> getPlayers() {
        return PLAYERS;
    }

    public static void registerStaffPlayers(StaffPlayer player) {
        PLAYERS.put(player.getUuid(), player);
    }
}
