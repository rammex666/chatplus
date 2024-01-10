package org.rammex.chatplus.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.utils.ScoreHelper;

import java.util.List;

import static org.bukkit.Bukkit.getServer;

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
            getServer().broadcastMessage(plugin.getConfig().getString("join.message").replace("{player}", player.getName()).replace("&e", ChatColor.YELLOW.toString()).replace("&0", ChatColor.BLACK.toString()).replace("&1", ChatColor.DARK_BLUE.toString()).replace("&2", ChatColor.DARK_GREEN.toString()).replace("&3", ChatColor.DARK_AQUA.toString()).replace("&4", ChatColor.DARK_RED.toString()).replace("&5", ChatColor.DARK_PURPLE.toString()).replace("&6", ChatColor.GOLD.toString()).replace("&7", ChatColor.GRAY.toString()).replace("&8", ChatColor.DARK_GRAY.toString()).replace("&9", ChatColor.BLUE.toString()).replace("&a", ChatColor.GREEN.toString()).replace("&b", ChatColor.AQUA.toString()).replace("&c", ChatColor.RED.toString()).replace("&d", ChatColor.LIGHT_PURPLE.toString()).replace("&f", ChatColor.WHITE.toString()).replace("&l", ChatColor.BOLD.toString()).replace("&k", ChatColor.MAGIC.toString()).replace("&n", ChatColor.UNDERLINE.toString()).replace("&o", ChatColor.ITALIC.toString()).replace("&m", ChatColor.STRIKETHROUGH.toString()).replace("&r", ChatColor.RESET.toString()));
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
            helper.setSlot(c, line);
        }
    }
}
