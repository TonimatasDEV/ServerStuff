package net.tonimatasmc.managers;

import net.tonimatasmc.commands.EnableDisablePluginsCommand;
import net.tonimatasmc.commands.SpeedCommand;
import net.tonimatasmc.tabCompleter.TabCompleter;
import org.bukkit.Bukkit;

public class CommandManager {
    public static void register() {
        Bukkit.getServer().getPluginCommand("plugin").setExecutor(new EnableDisablePluginsCommand());
        Bukkit.getServer().getPluginCommand("plugin").setTabCompleter(new TabCompleter());

        Bukkit.getServer().getPluginCommand("speed").setExecutor(new SpeedCommand());
        Bukkit.getServer().getPluginCommand("speed").setTabCompleter(new TabCompleter());
    }
}
