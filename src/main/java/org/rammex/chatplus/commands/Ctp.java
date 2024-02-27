package org.rammex.chatplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.ui.SettingsPanel;

public class Ctp implements CommandExecutor {
    private final Chatplus plugin;

    public Ctp(Chatplus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String arg, @NotNull String[] args) {
        Player player = (Player) sender;
        SettingsPanel.getSettingsPanel(player);
        return false;
    }
}