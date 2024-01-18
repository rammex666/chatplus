package org.rammex.chatplus;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.rammex.chatplus.commands.*;
import org.rammex.chatplus.events.ChatFormat;
import org.rammex.chatplus.events.PlayerJoin;
import org.rammex.chatplus.events.UiClick;

import java.io.File;
import java.io.IOException;

public final class Chatplus extends JavaPlugin {
    File dir = getDataFolder();
    File fr = new File(dir+"/lang", "fr.yml");
    File en = new File(dir+"/lang", "en.yml");
    FileConfiguration frconf;
    FileConfiguration enconf;






    @Override
    public void onEnable() {
        dir.mkdirs();
        logmessage();
        this.getCommand("ctphelp").setExecutor(new ctphelp());
        this.getCommand("ctpadmin").setExecutor(new ctpadmin(this));
        this.getCommand("ctpreload").setExecutor(new ctpreload(this));
        this.getCommand("csfchat").setExecutor(new csfchat(this));
        this.getCommand("ctpgp").setExecutor(new ctpgp(this));
        Bukkit.getPluginManager().registerEvents(new UiClick(this), this);
        Bukkit.getPluginManager().registerEvents(new ChatFormat(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);
        saveDefaultConfig();
        reloadConfig();
        getConfig();
        RefreshScoarBoard();
        loadfiles();
    }

    @Override
    public void onDisable() {

    }


    void logmessage() {
        getLogger().info("-----------");
        getLogger().info("Plugin Created by .rammex");
        getLogger().info("Version 1.0");
        getLogger().info("-----------");
    }

    public void RefreshScoarBoard(){
        new BukkitRunnable() {

            @Override
            public void run() {
                if(getConfig().getBoolean("scoreboard.enable")){
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        PlayerJoin.updateScoreboard(player);
                    }
                }
            }

        }.runTaskTimer(this, 2000L, 2000L);
    }

    void loadfiles(){
        //fr
        fr = new File(getDataFolder(), "fr.yml");
        if (!fr.exists()) {
            fr.getParentFile().mkdirs();
            saveResource("fr.yml", false);
        }

        frconf = new YamlConfiguration();
        try {
            frconf.load(fr);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        // en
        en = new File(getDataFolder(), "en.yml");
        if (!en.exists()) {
            en.getParentFile().mkdirs();
            saveResource("en.yml", false);
        }

        enconf = new YamlConfiguration();
        try {
            enconf.load(en);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getfr(){
        return this.frconf;
    }

    public FileConfiguration geten(){
        return this.enconf;
    }



}
