package org.rammex.chatplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.ui.AdminPanel;

public class CtpAdmin implements CommandExecutor {
    private final Chatplus plugin;

    public CtpAdmin(Chatplus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        AdminPanel.getadminpanel(player);
        return false;
    }
}