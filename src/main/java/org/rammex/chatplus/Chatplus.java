package org.rammex.chatplus;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.rammex.chatplus.commands.*;
import org.rammex.chatplus.events.*;
import org.rammex.chatplus.utils.Metrics;

import java.io.File;
import java.io.IOException;

public final class Chatplus extends JavaPlugin {
    private File dir = getDataFolder();

    @Getter
    private FileConfiguration frConf;
    @Getter
    private FileConfiguration enConf;
    @Getter
    private FileConfiguration deConf;
    @Getter
    private FileConfiguration ctConf;

    @Override
    public void onEnable() {
        dir.mkdirs();
        logMessage();
        this.getCommand("ctphelp").setExecutor(new CtpHelp(this));
        this.getCommand("ctpadmin").setExecutor(new CtpAdmin(this));
        this.getCommand("ctpreload").setExecutor(new CtpReload(this));
        this.getCommand("csfchat").setExecutor(new CsfChat(this));
        this.getCommand("ctpgp").setExecutor(new CtpGp(this));
        this.getCommand("ctp").setExecutor(new Ctp(this));
        Bukkit.getPluginManager().registerEvents(new UiClick(this), this);
        Bukkit.getPluginManager().registerEvents(new ChatFormat(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);
        Bukkit.getPluginManager().registerEvents(new MotdModule(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMessages(this), this);
        saveDefaultConfig();
        reloadConfig();
        getConfig();
        refreshScoreBoard();
        loadFiles();
        int pluginId = 21110;
        Metrics metrics = new Metrics(this, pluginId);

        metrics.getPluginData();
    }

    @Override
    public void onDisable() {
        // No action needed on disable
    }

    private void logMessage() {
        getLogger().info("-----------");
        getLogger().info("Plugin Created by .rammex");
        getLogger().info("Version 1.3.1");
        getLogger().info("-----------");
    }

    public void refreshScoreBoard() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if(getConfig().getBoolean("scoreboard.enable")) {
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        PlayerJoin.updateScoreboard(player);
                    }
                }
            }
        }.runTaskTimer(this, 2000L, 2000L);
    }

    private void loadFiles() {
        loadFile("fr");
        loadFile("en");
        loadFile("de");
        loadFile("chatformat");
    }

    private void loadFile(String fileName) {
        File file = new File(getDataFolder() + "/lang", fileName + ".yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            saveResource("lang/" + fileName + ".yml", false);
        }

        FileConfiguration fileConf = new YamlConfiguration();
        try {
            fileConf.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        switch (fileName) {
            case "fr":
                frConf = fileConf;
                break;
            case "en":
                enConf = fileConf;
                break;
            case "de":
                deConf = fileConf;
                break;
            case "chatformat":
                ctConf = fileConf;
                break;
        }
    }
}