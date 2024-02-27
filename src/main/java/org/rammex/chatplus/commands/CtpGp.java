package org.rammex.chatplus.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.chatplus.Chatplus;

import static org.rammex.chatplus.utils.ColorUtil.hex;

public class CtpGp implements CommandExecutor {
    private final Chatplus plugin;

    public CtpGp(Chatplus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String language = this.plugin.getConfig().getString("lang");
        if (!(sender instanceof Player)) {
            switch (language) {
                case "en" -> sender.sendMessage(hex(this.plugin.getEnConf().getString("errormessage.notplayer")));
                case "fr" -> sender.sendMessage(hex(this.plugin.getFrConf().getString("errormessage.notplayer")));
                case "de" -> sender.sendMessage(hex(this.plugin.getDeConf().getString("errormessage.notplayer")));
            }
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            switch(language) {
                case "en" -> player.sendMessage(hex(this.plugin.getEnConf().getString("commandsusage.ctpgp")));
                case "fr" -> player.sendMessage(hex(this.plugin.getFrConf().getString("commandsusage.ctpgp")));
                case "de" -> player.sendMessage(hex(this.plugin.getDeConf().getString("commandsusage.ctpgp")));
            }
            return true;
        }

        String group = args[0].toLowerCase();

        if (!this.plugin.getConfig().contains("groupschat." + group)) {
            switch (language) {
                case "en" -> player.sendMessage(hex(this.plugin.getEnConf().getString("errormessage.groupnotexist")));
                case "fr" -> player.sendMessage(hex(this.plugin.getFrConf().getString("errormessage.groupnotexist")));
                case "de" -> player.sendMessage(hex(this.plugin.getDeConf().getString("errormessage.groupnotexist")));
            }
            return true;
        }

        String permission = this.plugin.getConfig().getString("groupschat." + group + ".permission");

        if (!player.hasPermission(permission)) {
            switch (language) {
                case "en" -> player.sendMessage(hex(this.plugin.getEnConf().getString("errormessage.noperm")));
                case "fr" -> player.sendMessage(hex(this.plugin.getFrConf().getString("errormessage.noperm")));
                case "de" -> player.sendMessage(hex(this.plugin.getDeConf().getString("errormessage.noperm")));
            }
            return true;
        }
        String playerName = player.getName();
        String groupMessage = String.join(" ", args).substring(args[0].length());

        String title = hex(this.plugin.getConfig().getString("groupschat." + group + ".title"));
        if (title == null) {
            title = hex("#98FFF1[GROUPCHAT]");
        }

        String formattedMessage = hex(this.plugin.getConfig().getString("chatformat.format")
                .replace("\\", "")
                .replace("{player}", playerName)
                .replace("{message}", groupMessage)
                .replace("{world}", player.getWorld().getName()));

        formattedMessage = PlaceholderAPI.setPlaceholders(player, formattedMessage);

        String message = String.format("%s %s", title, formattedMessage);
        for (Player onlinePlayer : this.plugin.getServer().getOnlinePlayers()) {
            if (onlinePlayer.hasPermission(permission)) {
                onlinePlayer.sendMessage(hex(message));
            }
        }

        return true;
    }
}