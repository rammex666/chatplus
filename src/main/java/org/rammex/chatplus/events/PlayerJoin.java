package org.rammex.chatplus.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.utils.ScoreHelper;

import java.util.List;

import static org.bukkit.Bukkit.getServer;
import static org.rammex.chatplus.utils.ColorUtil.hex;

public class PlayerJoin implements Listener {

    private static Chatplus plugin;

    public PlayerJoin(Chatplus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(plugin.getConfig().getBoolean("scoreboard.enable")){
            createScoreboard(player);
        }
        if(plugin.getConfig().getBoolean("join.enable")){
            getServer().broadcastMessage(hex(plugin.getConfig().getString("join.message")
                    .replace("\\","")
                    .replace("{player}", event.getPlayer().getName())
                    .replace("{world}", event.getPlayer().getWorld().getName())));
            event.setJoinMessage("");
        }
    }

    public static void updateScoreboard(Player player) {
        if(ScoreHelper.hasScore(player)) {
            int counter = 0;
            ScoreHelper helper = ScoreHelper.createScore(player);
            List<String> lines = plugin.getConfig().getStringList("scoreboard.content");
            helper.setTitle(plugin.getConfig().getString("scoreboard.title"));
            for (String line : lines) {
                counter = counter + 1;
                helper.setSlot(counter, line);
            }
        }
    }

    private void createScoreboard(Player player) {
        int counter = 0;
        ScoreHelper helper = ScoreHelper.createScore(player);
        List<String> lines = plugin.getConfig().getStringList("scoreboard.content");
        helper.setTitle(plugin.getConfig().getString("scoreboard.title"));
        for (String line : lines) {
            counter = counter + 1;
            helper.setSlot(counter, hex(line));
        }
    }
}