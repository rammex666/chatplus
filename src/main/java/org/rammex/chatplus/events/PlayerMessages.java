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
import org.rammex.chatplus.ui.AdminPanel;

import java.util.ArrayList;
import java.util.List;

public class PlayerMessages implements Listener {
    private final Chatplus plugin;

    @Getter
    private static List<Player> playerChatList;

    public PlayerMessages(Chatplus plugin) {
        this.plugin = plugin;
        playerChatList = new ArrayList<>();
    }

    @EventHandler
    public void onUiClick(InventoryClickEvent event){
        final Player playerWhoClicked = (Player) event.getWhoClicked();
        final String inventoryTitle = event.getView().getTitle();
        ItemStack clickedItem = event.getCurrentItem();
        if (inventoryTitle.equalsIgnoreCase("Settings Panel")){
            event.setCancelled(true);
            event.setResult(Event.Result.DENY);
            if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.RED+"Admin Panel")){
                playerWhoClicked.closeInventory();
                AdminPanel.openChatFormatPanel(playerWhoClicked);
            }
            if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.RED+"See Player messages") && playerWhoClicked.hasPermission("ctp.SeeSetting")){
                if(playerChatList.contains(playerWhoClicked)) {
                    playerChatList.remove(playerWhoClicked);
                    playerWhoClicked.sendMessage(ChatColor.GREEN +"You will now see player messages");
                }
                playerWhoClicked.closeInventory();
            }
            if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.GREEN+"See Player messages") && playerWhoClicked.hasPermission("ctp.SeeSetting")){
                if(!playerChatList.contains(playerWhoClicked)) {
                    playerChatList.add(playerWhoClicked);
                    playerWhoClicked.sendMessage(ChatColor.RED +"You will no longer see player messages");
                }
                playerWhoClicked.closeInventory();
            }
        }
    }
}