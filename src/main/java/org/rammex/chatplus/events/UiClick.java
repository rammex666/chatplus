package org.rammex.chatplus.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.ui.TemplatesChatFormat;
import org.rammex.chatplus.ui.adminpanel;

public class UiClick implements Listener {
    Chatplus plugin;
    public UiClick(Chatplus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void Uiclick(InventoryClickEvent e){
        final Inventory inventory = e.getInventory();
        final Player whoClicked = (Player) e.getWhoClicked();
        final String title = e.getView().getTitle();
        ItemStack current = e.getCurrentItem();
        if (title.equalsIgnoreCase("Admin Panel")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
            if(current.getType() == Material.PAPER){
                whoClicked.closeInventory();
                adminpanel.chatformatpanel(whoClicked);
            }
            if(current.getType() == Material.BOOK){
                whoClicked.closeInventory();
                adminpanel.scoreboardpanel(whoClicked);
            }
        }
        if (title.equalsIgnoreCase("Chat Format")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
            if(current.getType() == Material.ANVIL){
                whoClicked.closeInventory();
                TemplatesChatFormat.tmpltctft(whoClicked);
            }
        }
        if (title.equalsIgnoreCase("Chat Format Templates")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
            if(current.getType() == Material.BOOK){
                String name = current.getItemMeta().getDisplayName();
                plugin.getConfig().set("chatformat.format",name);
                plugin.reloadConfig();
                whoClicked.closeInventory();
                whoClicked.sendMessage(ChatColor.GREEN +"Chat format set to -> " + name);
            }
        }
    }
}
