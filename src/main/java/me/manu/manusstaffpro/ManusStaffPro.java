package me.manu.manusstaffpro;

import me.manu.manusstaffpro.Listeners.DefaultListeners;
import me.manu.manusstaffpro.Listeners.StaffChat;
import me.manu.manusstaffpro.commands.StaffModeCommand;
import me.manu.manusstaffpro.config.ConfigManager;
import me.manu.manusstaffpro.methods.StaffItemsCreator;
import me.manu.manusstaffpro.util.message.MessageUtil;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class ManusStaffPro extends JavaPlugin {

    public static ManusStaffPro instance;
    public static LuckPerms luckPerms;

    @Override
    public void onEnable() {
        instance = this;
        luckPerms = LuckPermsProvider.get();
        MessageUtil.serverStartMessage();
        StaffItemsCreator.initStaffItems(); //Initialize items
        new ConfigManager();

        this.getCommand("staffmode").setExecutor(new StaffModeCommand());
        this.getCommand("addmember").setExecutor(new StaffModeCommand());

        registerEvents();
    }

    @Override
    public void onDisable() {
        MessageUtil.serverStopMessage();
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new DefaultListeners(), this);
        getServer().getPluginManager().registerEvents(new StaffChat(), this);
    }

    public static ManusStaffPro getInstance() {
        return instance;
    }
}
