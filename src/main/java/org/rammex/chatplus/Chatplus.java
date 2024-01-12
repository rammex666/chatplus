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
}
