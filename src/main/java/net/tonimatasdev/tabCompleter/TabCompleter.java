package net.tonimatasdev.tabCompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> argList = new ArrayList<>();

        if (command.getName().equalsIgnoreCase("tpoffline")) {
            if (args.length == 1) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    argList.add(p.getName());
                }

                return argList.stream().filter((a) -> a.startsWith(args[0])).collect(Collectors.toList());
            }
        }

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
        } else if (command.getName().equalsIgnoreCase("speed")) {
            if (args.length == 1) {
                argList.add("fly");
                argList.add("walk");
                argList.add("both");
                return argList.stream().filter((a) -> a.startsWith(args[0])).collect(Collectors.toList());
            } else if (args.length == 2) {
                argList.add("normal");
                argList.add("-1");
                argList.add("-0.9");
                argList.add("-0.8");
                argList.add("-0.7");
                argList.add("-0.6");
                argList.add("-0.5");
                argList.add("-0.4");
                argList.add("-0.3");
                argList.add("-0.2");
                argList.add("-0.1");
                argList.add("0");
                argList.add("0.1");
                argList.add("0.2");
                argList.add("0.3");
                argList.add("0.4");
                argList.add("0.5");
                argList.add("0.6");
                argList.add("0.7");
                argList.add("0.8");
                argList.add("0.9");
                argList.add("1");
                return argList;
            } else if (args.length == 3 && args[0].equalsIgnoreCase("fly")) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    argList.add(p.getName());
                }

                return argList;
            }
        }

        return null;
    }
}
