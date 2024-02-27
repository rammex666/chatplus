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
import org.rammex.chatplus.ui.AdminPanel;
import org.rammex.chatplus.utils.PluginState;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.rammex.chatplus.utils.ColorUtil.hex;
import static org.rammex.chatplus.utils.ItemBuilder.getMaterialLoreItem;

public class UiClick implements Listener {
    private final Chatplus plugin;
    private final PluginState pluginState = new PluginState();

    public UiClick(Chatplus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onUiClick(InventoryClickEvent event){
        final Player playerWhoClicked = (Player) event.getWhoClicked();
        final String inventoryTitle = event.getView().getTitle();
        ItemStack clickedItem = event.getCurrentItem();
        if (inventoryTitle.equalsIgnoreCase("Admin Panel")){
            event.setCancelled(true);
            event.setResult(Event.Result.DENY);
            if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.RED+"Chat Format")){
                playerWhoClicked.closeInventory();
                AdminPanel.openChatFormatPanel(playerWhoClicked);
            }
            if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.RED+"ScoreBoard")){
                playerWhoClicked.closeInventory();
                AdminPanel.openScoreBoardPanel(playerWhoClicked);
            }
        }
        if (inventoryTitle.equalsIgnoreCase("Chat Format")){
            event.setCancelled(true);
            event.setResult(Event.Result.DENY);
            if(clickedItem.getItemMeta().getDisplayName().equals("Templates")){
                playerWhoClicked.closeInventory();
                createTemplate(playerWhoClicked);
            }
            if(clickedItem.getItemMeta().getDisplayName().equals("Change")){
                playerWhoClicked.closeInventory();
                playerWhoClicked.sendMessage(ChatColor.YELLOW +"Please enter the new chat format in the chat");
                pluginState.setWaitingForChat(true);
                pluginState.setPlayerWaiting(playerWhoClicked);
            }
        }
        if (inventoryTitle.equalsIgnoreCase("ScoreBoard")){
            event.setCancelled(true);
            event.setResult(Event.Result.DENY);
        }
        if (inventoryTitle.equalsIgnoreCase("Chat Format Templates")){
            event.setCancelled(true);
            event.setResult(Event.Result.DENY);
            if(clickedItem.getType() == Material.BOOK){
                ConfigurationSection templatesSection = plugin.getCtConf().getConfigurationSection("templates");
                for (String templateName : templatesSection.getKeys(false)) {
                    String title = ChatColor.stripColor(templatesSection.getString(templateName + ".title"));
                    String ctf = templatesSection.getString(templateName + ".chatformat");

                    if (title != null && title.equalsIgnoreCase(clickedItem.getItemMeta().getDisplayName())) {
                        plugin.getConfig().set("chatformat.format", ctf);
                        plugin.saveConfig();
                        plugin.reloadConfig();
                        playerWhoClicked.closeInventory();
                        playerWhoClicked.sendMessage(ChatColor.GREEN +"Chat format set to -> " + ctf);
                        break;
                    }
                }
            }
            if(clickedItem.getItemMeta().getDisplayName().equals(ChatColor.RED+"Back")){
                playerWhoClicked.closeInventory();
                AdminPanel.openChatFormatPanel(playerWhoClicked);
            }
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String lang = this.plugin.getConfig().getString("lang");
        Player player = event.getPlayer();
        if (pluginState.isWaitingForChat() && player.equals(pluginState.getPlayerWaiting())) {
            switch (lang)
            {
                case "en" -> player.sendMessage(hex(this.plugin.getEnConf().getString("succesmessage.formatchange")+ event.getMessage()));
                case "fr" -> player.sendMessage(hex(this.plugin.getFrConf().getString("succesmessage.formatchange")+ event.getMessage()));
                case "de" -> player.sendMessage(hex(this.plugin.getDeConf().getString("succesmessage.formatchange")+ event.getMessage()));
            }
            pluginState.setWaitingForChat(false);
            pluginState.setPlayerWaiting(null);
            plugin.getConfig().set("chatformat.format", event.getMessage().toString());
            plugin.saveConfig();
            plugin.reloadConfig();
            event.setCancelled(true);
        }
    }

    public void createTemplate(Player player) {
        plugin.getLogger().info("Opening Chat Format Templates inventory for player: " + player.getName());
        Inventory inv = Bukkit.createInventory(null, 54, "Chat Format Templates");

        generateItems(inv);

        // top
        inv.setItem(0, getMaterialLoreItem(Material.BARRIER, ChatColor.RED + "Back", null));
        inv.setItem(1, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(2, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(4, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(5, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(6, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(7, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));
        inv.setItem(8, getMaterialLoreItem(Material.GRAY_STAINED_GLASS_PANE, null, null));


        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(hex("#11B186&l&nActual Display Name"));
        List<String> lore = Collections.singletonList(hex(plugin.getConfig().getString("chatformat.format")).toString());
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        inv.setItem(3,itemStack);


        player.openInventory(inv);
    }


    public void generateItems(Inventory inv) {
        Integer n = 0;
        ConfigurationSection templatesSection = plugin.getCtConf().getConfigurationSection("templates");


        if (templatesSection != null) {
            plugin.getLogger().info("Number of templates: " + templatesSection.getKeys(false).size());

            for (String templateName : templatesSection.getKeys(false)) {
                n += 1;

                String title = templatesSection.getString(templateName + ".title");
                List<String> lore = templatesSection.getStringList(templateName + ".lore");

                String ctf = templatesSection.getString(templateName + ".chatformat");
                if (Objects.equals(plugin.getConfig().getString("chatformat.format"), ctf)) {
                    ItemStack itemStack = new ItemStack(Material.ENCHANTED_BOOK);
                    ItemMeta itemMeta = itemStack.getItemMeta();

                    if (title != null) {
                        itemMeta.setDisplayName(hex(title));
                    }

                    if (lore != null && !lore.isEmpty()) {
                        itemMeta.setLore(Collections.singletonList(hex(lore.toString())));
                    }

                    itemStack.setItemMeta(itemMeta);

                    inv.setItem(8 + n, itemStack);

                    plugin.getLogger().info("Item added ctf - Title: " + title + ", Lore: " + lore);
                } else{
                    ItemStack itemStack = new ItemStack(Material.BOOK);
                    ItemMeta itemMeta = itemStack.getItemMeta();

                    if (title != null) {
                        itemMeta.setDisplayName(hex(title));
                    }

                    if (lore != null && !lore.isEmpty()) {
                        itemMeta.setLore(Collections.singletonList(hex(lore.toString())));
                    }

                    itemStack.setItemMeta(itemMeta);

                    inv.setItem(8 + n, itemStack);

                    plugin.getLogger().info("Item added no ctf - Title: " + title + ", Lore: " + lore);
                }

            }
        } else{
            plugin.getLogger().info("null");
        }
    }
}