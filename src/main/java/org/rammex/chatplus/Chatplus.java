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
import org.rammex.chatplus.events.MotdModule;
import org.rammex.chatplus.events.PlayerJoin;
import org.rammex.chatplus.events.UiClick;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public final class Chatplus extends JavaPlugin {
    File dir = getDataFolder();
    File fr = new File(dir, "fr.yml");
    File en = new File(dir, "en.yml");
    File de = new File(dir, "de.yml");
    File ct = new File(dir, "chatformat.yml");
    FileConfiguration frconf;
    FileConfiguration enconf;
    FileConfiguration deconf;
    FileConfiguration ctconf;



    @Override
    public void onEnable() {
        dir.mkdirs();
        logmessage();
        this.getCommand("ctphelp").setExecutor(new ctphelp(this));
        this.getCommand("ctpadmin").setExecutor(new ctpadmin(this));
        this.getCommand("ctpreload").setExecutor(new ctpreload(this));
        this.getCommand("csfchat").setExecutor(new csfchat(this));
        this.getCommand("ctpgp").setExecutor(new ctpgp(this));
        Bukkit.getPluginManager().registerEvents(new UiClick(this), this);
        Bukkit.getPluginManager().registerEvents(new ChatFormat(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);
        Bukkit.getPluginManager().registerEvents(new MotdModule(this), this);
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
        getLogger().info("Version 1.3.1");
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
        fr = new File(getDataFolder()+"/lang", "fr.yml");
        if (!fr.exists()) {
            fr.getParentFile().mkdirs();
            saveResource("lang/fr.yml", false);
        }

        frconf = new YamlConfiguration();
        try {
            frconf.load(fr);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        // en
        en = new File(getDataFolder()+"/lang", "en.yml");
        if (!en.exists()) {
            en.getParentFile().mkdirs();
            saveResource("lang/en.yml", false);
        }

        enconf = new YamlConfiguration();
        try {
            enconf.load(en);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

       de = new File(getDataFolder()+"/lang", "de.yml");
        if (!de.exists()) {
            de.getParentFile().mkdirs();
            saveResource("lang/de.yml", false);
        }

        deconf = new YamlConfiguration();
        try {
            deconf.load(de);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }


        ct = new File(getDataFolder()+"/templates", "chatformat.yml");
        if (!ct.exists()) {
            ct.getParentFile().mkdirs();
            saveResource("templates/chatformat.yml", false);
        }

        ctconf = new YamlConfiguration();
        try {
            ctconf.load(ct);
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

    public FileConfiguration getde(){
        return this.deconf;
    }
    public FileConfiguration getct(){
        return this.ctconf;
    }

    

}
