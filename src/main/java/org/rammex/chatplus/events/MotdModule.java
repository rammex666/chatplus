package org.rammex.chatplus.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.rammex.chatplus.Chatplus;

import static org.rammex.chatplus.utils.ColorUtil.hex;

public class MotdModule implements Listener {

    private final Chatplus plugin;

    public MotdModule(Chatplus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPing(ServerListPingEvent event){
        if(this.plugin.getConfig().getBoolean("motd.enable")) {
            event.setMotd(hex(this.plugin.getConfig().getString("motd.motd")));
        }
    }
}