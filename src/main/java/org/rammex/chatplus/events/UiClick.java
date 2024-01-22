package org.rammex.chatplus.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.rammex.chatplus.Chatplus;
import org.rammex.chatplus.ui.adminpanel;
import org.rammex.chatplus.utils.PluginState;

import java.util.List;
import java.util.Set;

import static org.rammex.chatplus.events.ChatFormat.hex;

public class UiClick implements Listener {
    Chatplus plugin;

    public UiClick(Chatplus plugin) {
        this.plugin = plugin;
    }
    private final PluginState pluginState = new PluginState();


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
                tmpltctft(whoClicked);
            }
            if(current.getType() == Material.CRAFTING_TABLE){
                whoClicked.closeInventory();
                pluginState.setWaitingForChat(true);
                pluginState.setPlayerWaiting((Player) whoClicked);
            }
        }
        if (title.equalsIgnoreCase("ScoreBoard")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
        }
        if (title.equalsIgnoreCase("Chat Format Templates")){
            e.setCancelled(true);
            e.setResult(Event.Result.DENY);
            if(current.getType() == Material.BOOK){
                ConfigurationSection templatesSection = plugin.getct().getConfigurationSection("templates");
                for (String templateName : templatesSection.getKeys(false)) {
                    String titlee = ChatColor.stripColor(templatesSection.getString(templateName + ".title"));

                    if (titlee != null && titlee.equalsIgnoreCase(current.getItemMeta().getDisplayName())) {
                        plugin.getConfig().set("chatformat.format", current.getItemMeta().getDisplayName().toString());
                        plugin.saveConfig();
                        plugin.reloadConfig();
                        whoClicked.closeInventory();
                        whoClicked.sendMessage(ChatColor.GREEN +"Chat format set to -> " + current.getItemMeta().getDisplayName());
                        break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String lang= this.plugin.getConfig().getString("lang");
        Player player = event.getPlayer();
        if (pluginState.isWaitingForChat() && player.equals(pluginState.getPlayerWaiting())) {
            if(lang.equals("en")){
                player.sendMessage(hex(this.plugin.geten().getString("succesmessage.formatchange")+ event.getMessage()));
            }
            if(lang.equals("fr")){
                player.sendMessage(hex(this.plugin.getfr().getString("succesmessage.formatchange")+ event.getMessage()));
            }
            if(lang.equals("de")){
                player.sendMessage(hex(this.plugin.getde().getString("succesmessage.formatchange")+ event.getMessage()));
            }
            pluginState.setWaitingForChat(false);
            pluginState.setPlayerWaiting(null);
            plugin.getConfig().set("chatformat.format", event.getMessage().toString());
            plugin.saveConfig();
            plugin.reloadConfig();
            event.setCancelled(true);
        }
    }

    public void tmpltctft(Player player) {
        plugin.getLogger().info("Opening Chat Format Templates inventory for player: " + player.getName());
        Inventory inv = Bukkit.createInventory(null, 54, "Chat Format Templates");

        generateItems(inv);

        // top
        inv.setItem(0, getItem(Material.BARRIER, ChatColor.RED + "Back", null));
        inv.setItem(1, getItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(2, getItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(3, getItem(Material.PAPER, ChatColor.RED + "Soon", null));
        inv.setItem(4, getItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(5, getItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(6, getItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(7, getItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(8, getItem(Material.GRAY_STAINED_GLASS_PANE, null, null));

        player.openInventory(inv);
    }

    public ItemStack getItem(Material material, String customName, List<String> lore) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        if (lore != null) customM.setLore(lore);
        it.setItemMeta(customM);
        return it;
    }

    public void generateItems(Inventory inv) {
        Integer n = 0;
        ConfigurationSection templatesSection = plugin.getct().getConfigurationSection("templates");


        if (templatesSection != null) {
            plugin.getLogger().info("Number of templates: " + templatesSection.getKeys(false).size());

            for (String templateName : templatesSection.getKeys(false)) {
                n += 1;

                String title = templatesSection.getString(templateName + ".title");
                List<String> lore = templatesSection.getStringList(templateName + ".lore");

                ItemStack itemStack = new ItemStack(Material.BOOK);

                ItemMeta itemMeta = itemStack.getItemMeta();

                if (title != null) {
                    itemMeta.setDisplayName(hex(title));
                }

                if (lore != null && !lore.isEmpty()) {
                    itemMeta.setLore(lore);
                }

                itemStack.setItemMeta(itemMeta);

                inv.setItem(8 + n, itemStack);

                plugin.getLogger().info("Item added - Title: " + title + ", Lore: " + lore);
            }
        } else{
            plugin.getLogger().info("null");
        }
    }
}
