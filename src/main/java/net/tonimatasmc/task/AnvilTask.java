package net.tonimatasmc.task;

import main.serverstuff.ServerStuff;
import net.tonimatasmc.listener.RepairListener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class AnvilTask extends BukkitRunnable {
    private static final HashMap<AnvilInventory, AnvilTask> anvilTasks = new HashMap<>();
    private final AnvilInventory inv;
    private final Player player;

    public AnvilTask(AnvilInventory inv, Player player) {
        this.inv = inv;
        this.player = player;
        anvilTasks.put(inv, this);
        this.runTaskTimer(ServerStuff.getInstance(), 1L, 3L);
    }

    public static AnvilTask getTask(AnvilInventory inv) {
        return anvilTasks.get(inv);
    }

    public static boolean hasPermission(Player p) {
        return p.hasPermission("serverstuff.anvilcolors");
    }

    public static ItemStack getTranslatedItem(Player p, AnvilInventory inv) {
        ItemStack outputItem = inv.getItem(2);

        if (outputItem != null && outputItem.hasItemMeta()) {
            ItemMeta outputItemMeta = outputItem.getItemMeta();

            if (outputItemMeta.hasDisplayName()) {
                ItemStack inputItem = inv.getItem(0);

                if (inputItem != null && inputItem.hasItemMeta()) {
                    ItemMeta inputItemMeta = inputItem.getItemMeta();

                    if (inputItemMeta.hasDisplayName() && outputItemMeta.getDisplayName().replaceAll("&", "").replaceAll("§", "").equals(inputItemMeta.getDisplayName().replaceAll("§", ""))) {
                        outputItemMeta.setDisplayName(inputItemMeta.getDisplayName());
                        outputItem.setItemMeta(outputItemMeta);

                        return outputItem;
                    }
                }

                colorItemWithPermissions(outputItem, p);
            }
        }
        return outputItem;
    }

    public static void colorItemWithPermissions(ItemStack item, Player p) {
        ItemMeta itemMeta = item.getItemMeta();
        String coloredName = ChatColor.translateAlternateColorCodes('&', itemMeta.getDisplayName());

        for (int i = 0; i < coloredName.length(); ++i) {
            if (coloredName.charAt(i) == 167) {
                char c = coloredName.charAt(i + 1);

                if (!hasPermission(p)) {
                    coloredName = coloredName.replaceAll("§" + c, "&" + c);
                }
            }
        }

        itemMeta.setDisplayName(coloredName);
        item.setItemMeta(itemMeta);
    }

    public static void register() {
        ServerStuff.getInstance().getServer().getPluginManager().registerEvents(new RepairListener(), ServerStuff.getInstance());
        ServerStuff.getInstance().saveDefaultConfig();
    }

    public void run() {
        if (this.inv.getViewers().size() == 0) {
            this.cancel();
        }

        getTranslatedItem(this.player, this.inv);
    }
}