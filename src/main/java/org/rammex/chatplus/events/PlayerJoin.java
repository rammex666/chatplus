package org.rammex.chatplus.events;

import de.Herbystar.TTA.TTA_Methods;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.utils.ScoreHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            getServer().broadcastMessage(hex(plugin.getConfig().getString("join.message").replace("\\","").replace("{player}", e.getPlayer().getName()).replace("{world}", e.getPlayer().getWorld().getName())));
            e.setJoinMessage("");
        }
        if(plugin.getConfig().getBoolean("tablist.enable")){
            TTA_Methods.sendAnimatedTablist(player, readHeaderListFromConfig("tablist.header",player),readHeaderListFromConfig("tablist.footer",player),5);
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

    public static String hex(String message) {
        Pattern pattern = Pattern.compile("(#[a-fA-F0-9]{6})");
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            String hexCode = message.substring(matcher.start(), matcher.end());
            String replaceSharp = hexCode.replace('#', 'x');

            char[] ch = replaceSharp.toCharArray();
            StringBuilder builder = new StringBuilder("");
            for (char c : ch) {
                builder.append("&" + c);
            }

            message = message.replace(hexCode, builder.toString());
            matcher = pattern.matcher(message);
        }
        return ChatColor.translateAlternateColorCodes('&', message).replace('&', '§');
    }

    private List<String> readHeaderListFromConfig(String path,Player player) {
        FileConfiguration config = plugin.getConfig();
        List<String> headerList = new ArrayList<>();

        if (config.isList(path)) {
            List<?> headerValues = config.getList(path);
            if (headerValues != null) {
                for (Object value : headerValues) {
                    if (value instanceof String) {
                        value = PlaceholderAPI.setPlaceholders(player, (String) value);
                        headerList.add(hex((String) value));
                    }
                }
            }
        }

        return headerList;
    }
}
