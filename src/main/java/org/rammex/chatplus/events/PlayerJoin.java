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

    static Chatplus plugin;

    public PlayerJoin(Chatplus plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    void PlayerJoinE(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if(plugin.getConfig().getBoolean("scoreboard.enable")){
            createScoreboard(player);
        }
        if(plugin.getConfig().getBoolean("join.enable")){
            getServer().broadcastMessage(hex(plugin.getConfig().getString("join.message").replace("\\","").replace("{player}", e.getPlayer().getName()).replace("{world}", e.getPlayer().getWorld().getName())));
            e.setJoinMessage("");
        }
    }

    public static void updateScoreboard(Player player) {
        if(ScoreHelper.hasScore(player)) {
            Integer c = 0;
            ScoreHelper helper = ScoreHelper.createScore(player);
            List<String> lines = plugin.getConfig().getStringList("scoreboard.content");
            helper.setTitle(plugin.getConfig().getString("scoreboard.title"));
            for (String line : lines) {
                c = c + 1;
                helper.setSlot(c, line);
            }
        }
    }

    private void createScoreboard(Player player) {
        Integer c = 0;
        ScoreHelper helper = ScoreHelper.createScore(player);
        List<String> lines = plugin.getConfig().getStringList("scoreboard.content");
        helper.setTitle(plugin.getConfig().getString("scoreboard.title"));
        for (String line : lines) {
            c = c + 1;
            helper.setSlot(c, hex(line));
        }
    }


}
