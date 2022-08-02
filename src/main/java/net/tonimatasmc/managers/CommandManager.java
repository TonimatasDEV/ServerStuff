package net.tonimatasmc.managers;

import net.tonimatasmc.commands.EnableDisablePluginsCommand;
import net.tonimatasmc.commands.SpeedCommand;
import net.tonimatasmc.commands.TPOfflinePlayerCommand;
import net.tonimatasmc.commands.WorkbenchCommand;
import net.tonimatasmc.tabCompleter.TabCompleter;
import org.bukkit.Bukkit;

public class CommandManager {
    public static void register() {
        Bukkit.getServer().getPluginCommand("plugin").setExecutor(new EnableDisablePluginsCommand());
        Bukkit.getServer().getPluginCommand("plugin").setTabCompleter(new TabCompleter());

        Bukkit.getServer().getPluginCommand("speed").setExecutor(new SpeedCommand());
        Bukkit.getServer().getPluginCommand("speed").setTabCompleter(new TabCompleter());

        Bukkit.getServer().getPluginCommand("tpoffline").setExecutor(new TPOfflinePlayerCommand());
        Bukkit.getServer().getPluginCommand("tpoffline").setTabCompleter(new TabCompleter());

        Bukkit.getServer().getPluginCommand("workbench").setExecutor(new WorkbenchCommand());
    }
}
