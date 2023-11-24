package org.rammex.chatplus.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.rammex.chatplus.Chatplus;

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
        if (!(title.equalsIgnoreCase("Admin Panel"))){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
        };
    }
}
