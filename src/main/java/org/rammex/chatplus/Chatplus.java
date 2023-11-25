package org.rammex.chatplus;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.rammex.chatplus.commands.ctpadmin;
import org.rammex.chatplus.commands.ctphelp;
import org.rammex.chatplus.commands.ctpreload;
import org.rammex.chatplus.events.ChatFormat;
import org.rammex.chatplus.events.UiClick;

public final class Chatplus extends JavaPlugin {

    @Override
    public void onEnable() {
        logmessage();
        this.getCommand("ctphelp").setExecutor(new ctphelp());
        this.getCommand("ctpadmin").setExecutor(new ctpadmin(this));
        this.getCommand("ctpreload").setExecutor(new ctpreload(this));
        Bukkit.getPluginManager().registerEvents(new UiClick(this), this);
        Bukkit.getPluginManager().registerEvents(new ChatFormat(this), this);
        saveDefaultConfig();
        reloadConfig();
        getConfig();
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
}
