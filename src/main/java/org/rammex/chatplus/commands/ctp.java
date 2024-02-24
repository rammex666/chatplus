package org.rammex.chatplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.ui.settingspanel;

public class ctp implements CommandExecutor {
    Chatplus plugin;
    public ctp(Chatplus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String arg, @NotNull String[] args) {
        Player player = (Player) sender;
        settingspanel.getSettingsPanel(player);
        return false;
    }
}
