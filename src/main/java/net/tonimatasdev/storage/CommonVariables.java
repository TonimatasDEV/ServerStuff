package net.tonimatasdev.storage;

import org.bukkit.ChatColor;

public class CommonVariables {
    public static String chatTranslator(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
