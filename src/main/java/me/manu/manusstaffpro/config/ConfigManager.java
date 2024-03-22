package me.manu.manusstaffpro.config;

import me.manu.manusstaffpro.staffmode.StaffMode;
import me.manu.manusstaffpro.util.message.MessageUtil;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigManager {
    public static Config defaultConfig;
    public static Config languageConfig;

    public ConfigManager() {
        defaultConfig = new Config(new File("config.yml"));
        languageConfig = new Config(new File("language.yml"));
        configCheck(ConfigType.DEFAULT);
        configCheck(ConfigType.LANGUAGE);
    }

    public static void configCheck(final ConfigType type) {
        FileConfiguration config;
        if (type == ConfigType.DEFAULT) {
            config = defaultConfig.get();
            config.addDefault("staffModeItems.10", Arrays.asList("freeze_item"));
            config.addDefault("staffModeItems.20", Arrays.asList("freeze_item", "vanish_item"));
            config.options().copyDefaults(true);
            defaultConfig.save();
        } else if (type == ConfigType.LANGUAGE) {
            config = languageConfig.get();
            config.addDefault("StaffPro.StaffChat.Format", MessageUtil.format("&3[&5StaffChat&3] &6%player% &4>> %message% !!!"));
            languageConfig.save();
        }
    }

    public static FileConfiguration getConfig() {
        return ConfigManager.defaultConfig.get();
    }

    public static void loadStaffModeItems() {
        FileConfiguration config = defaultConfig.get();
        ConfigurationSection section = config.getConfigurationSection("staffModeItems");
        if (section == null) return;

        Map<Integer, List<String>> powerItemsMap = new HashMap<>();
        for (String key : section.getKeys(false)) {
            int power = Integer.parseInt(key);
            List<String> items = section.getStringList(key);
            powerItemsMap.put(power, items);
        }
        StaffMode.setPowerItemsMap(powerItemsMap);
    }
}
