package org.rammex.chatplus.events;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.ui.adminpanel;

import java.util.ArrayList;
import java.util.List;

public class PlayerMessages implements Listener {
    Chatplus plugin;

    @Getter
    public static List<Player> playerChatList;

    public PlayerMessages(Chatplus plugin) {
        this.plugin = plugin;
        playerChatList = new ArrayList<>();
    }

    @EventHandler
    public void Uiclick(InventoryClickEvent e){
        final Inventory inventory = e.getInventory();
        final Player whoClicked = (Player) e.getWhoClicked();
        final String title = e.getView().getTitle();
        ItemStack current = e.getCurrentItem();
        if (title.equalsIgnoreCase("Settings Panel")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
            if(current.getItemMeta().getDisplayName().equals(ChatColor.RED+"Admin Panel")){
                whoClicked.closeInventory();
                adminpanel.getadminpanel(whoClicked);
            }
            if(current.getItemMeta().getDisplayName().equals(ChatColor.RED+"See Player messages") && whoClicked.hasPermission("ctp.SeeSetting")){
                if(playerChatList.contains(whoClicked)){
                    playerChatList.remove(whoClicked);
                    whoClicked.sendMessage(ChatColor.GREEN +"You will now see player messages");
                }
                whoClicked.closeInventory();
            }
            if(current.getItemMeta().getDisplayName().equals(ChatColor.GREEN+"See Player messages") && whoClicked.hasPermission("ctp.SeeSetting")){
                if(!playerChatList.contains(whoClicked)){
                    playerChatList.add(whoClicked);
                    whoClicked.sendMessage(ChatColor.RED +"You will no longer see player messages");
                }
                whoClicked.closeInventory();
            }
        }
    }


}
