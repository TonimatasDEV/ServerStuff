package net.tonimatasdev.managers;

import net.tonimatasdev.constructor.ServerStuffCommandExecutor;
import net.tonimatasdev.tabCompleter.TabCompleter;
import org.bukkit.Bukkit;

public class CommandManager {
    public static void register() {
        Bukkit.getServer().getPluginCommand("plugin").setExecutor(new ServerStuffCommandExecutor().getExecutor());
        Bukkit.getServer().getPluginCommand("plugin").setTabCompleter(new TabCompleter());

        Bukkit.getServer().getPluginCommand("speed").setExecutor(new ServerStuffCommandExecutor().getExecutor());
        Bukkit.getServer().getPluginCommand("speed").setTabCompleter(new TabCompleter());

        Bukkit.getServer().getPluginCommand("tpoffline").setExecutor(new ServerStuffCommandExecutor().getExecutor());
        Bukkit.getServer().getPluginCommand("tpoffline").setTabCompleter(new TabCompleter());

        Bukkit.getServer().getPluginCommand("workbench").setExecutor(new ServerStuffCommandExecutor().getExecutor());
        Bukkit.getServer().getPluginCommand("god").setExecutor(new ServerStuffCommandExecutor().getExecutor());
    }
}
