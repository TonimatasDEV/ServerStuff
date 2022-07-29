package net.tonimatasmc.tabCompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> argList = new ArrayList<>();

        if (command.getName().equalsIgnoreCase("plugin")) {
            if (args.length == 1) {
                argList.add("enable");
                argList.add("disable");
                return argList.stream().filter((a) -> a.startsWith(args[0])).collect(Collectors.toList());
            } else if (args.length == 2 && args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("disable")) {
                Plugin[] var6 = Bukkit.getPluginManager().getPlugins();

                for (Plugin plugins : var6) {
                    argList.add(plugins.getName());
                }

                return argList;
            }
        }return null;
    }
}
