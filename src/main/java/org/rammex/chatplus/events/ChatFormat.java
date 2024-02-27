package org.rammex.chatplus.events;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.rammex.chatplus.Chatplus;

import java.util.List;

import static org.bukkit.Bukkit.getServer;
import static org.rammex.chatplus.utils.ColorUtil.hex;

public class ChatFormat implements Listener {

    private final Chatplus plugin;

    public ChatFormat(Chatplus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String language = this.plugin.getConfig().getString("lang");
        event.setCancelled(true);
        List<String> bannedWords = plugin.getConfig().getStringList("banned-words");
        String message = event.getMessage();
        for (String bannedWord : bannedWords) {
            if (message.toLowerCase().contains(bannedWord.toLowerCase())) {
                event.setCancelled(true);
                switch (language) {
                    case "en" -> event.getPlayer().sendMessage(hex(this.plugin.getEnConf().getString("errormessage.messagebanned")));
                    case "fr" -> event.getPlayer().sendMessage(hex(this.plugin.getFrConf().getString("errormessage.messagebanned")));
                    case "de" -> event.getPlayer().sendMessage(hex(this.plugin.getDeConf().getString("errormessage.messagebanned")));
                }
                return;
            }
        }

        String playerName = event.getPlayer().getDisplayName();
        String world = event.getPlayer().getWorld().getName();
        if(event.getPlayer().hasPermission("ctp.color")){
            message = hex(message);

            message = PlaceholderAPI.setPlaceholders(event.getPlayer(), hex(message));
            String formattedMessage = hex(this.plugin.getConfig().getString("chatformat.format")
                    .replace("\\","")
                    .replace("{player}", playerName)
                    .replace("{message}", message)
                    .replace("{world}", world));

            formattedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), formattedMessage);
            this.plugin.getLogger().info(event.getPlayer().getName() + " >> " + message);
            for (Player onlinePlayer : this.plugin.getServer().getOnlinePlayers()) {
                if (!PlayerMessages.getPlayerChatList().contains(onlinePlayer)) {
                    onlinePlayer.sendMessage(formattedMessage);
                } else {
                    return;
                }
            }
        } else{
            String chatFormat = this.plugin.getConfig().getString("chatformat.format");

            String[] formatParts = chatFormat
                    .split("\\{message\\}", 2);

            if (formatParts.length == 2) {
                String messagePart = formatParts[0];
                String restPart = formatParts[1];

                String formattedMessage = hex(messagePart) + message + hex(restPart);
                formattedMessage = PlaceholderAPI.setPlaceholders(event.getPlayer(), formattedMessage
                        .replace("\\","")
                        .replace("{player}", playerName)
                        .replace("{world}", world));
                this.plugin.getLogger().info(event.getPlayer().getName() + " >> " + message);
                for (Player onlinePlayer : this.plugin.getServer().getOnlinePlayers()) {
                    if (!PlayerMessages.getPlayerChatList().contains(onlinePlayer)) {
                        onlinePlayer.sendMessage(formattedMessage);
                    } else {
                        return;
                    }
                }
            }
        }
    }
}