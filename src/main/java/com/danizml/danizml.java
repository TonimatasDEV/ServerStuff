package com.danizml;

import com.danizml.commands.MainCommand;
import com.danizml.tabCompleter.TabCompleter;
import org.bukkit.Bukkit;

public class danizml {
    public static void enable() {
        Bukkit.getServer().getPluginCommand("serverstuff").setExecutor(new MainCommand());
        Bukkit.getServer().getPluginCommand("serverstuff").setTabCompleter(new TabCompleter());
    }

    public static void disable() {

    }
}
