package org.rammex.chatplus;

import org.bukkit.Bukkit;
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
    File fr = new File(dir, "lang/fr.yml");
    File en = new File(dir, "lang/en.yml");




    @Override
    public void onEnable() {
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
        if (!fr.exists()) {
            try {
                fr.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (!en.exists()) {
            try {
                en.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public FileConfiguration getfr(){
        FileConfiguration cfr = YamlConfiguration.loadConfiguration(fr);
        return cfr;
    }

    public FileConfiguration geten(){
        FileConfiguration cen = YamlConfiguration.loadConfiguration(en);
        return cen;
    }



}
