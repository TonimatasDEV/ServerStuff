package com.danizml.tabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabCompleter implements org.bukkit.command.TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (cmd.getName().equalsIgnoreCase("serverstuff")) {
            List<String> argList = new ArrayList<>();

            if (args.length == 1) {
                argList.add("help");
                argList.add("reload");
                return argList.stream().filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
            }
        }
        return null;
    }
}
