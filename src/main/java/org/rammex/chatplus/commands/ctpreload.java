package org.rammex.chatplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.chatplus.Chatplus;


import static org.rammex.chatplus.utils.ColorUtil.hex;

public class ctpreload implements CommandExecutor {
    Chatplus plugin;
    public ctpreload(Chatplus plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        String lang= this.plugin.getConfig().getString("lang");
        Player player = (Player) sender;

        this.plugin.reloadConfig();

        if(lang.equals("en")){
            player.sendMessage(hex(this.plugin.geten().getString("succesmessage.reload")));
        }
        if(lang.equals("fr")){
            player.sendMessage(hex(this.plugin.getfr().getString("succesmessage.reload")));
        }
        if(lang.equals("de")){
            player.sendMessage(hex(this.plugin.getde().getString("succesmessage.reload")));
        }
        return false;
    }


}
