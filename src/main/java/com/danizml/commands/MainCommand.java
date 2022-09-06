package com.danizml.commands;

import main.serverstuff.ServerStuff;
import net.tonimatasdev.managers.YMLManager;
import net.tonimatasdev.util.MessageVariables;
import net.tonimatasdev.util.UsedMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("serverstuff")) {
            if (args.length >= 2) {
                if (args[0].equalsIgnoreCase("help")) {
                    if (sender.hasPermission("serverstuff.help")) {
                        //Help message
                        MessageVariables.sendToPlayer((Player) sender, null, "&6ServerStuff &8&l> &6Help");
                        MessageVariables.sendToPlayer((Player) sender, null, "&8&l[&5+&8&l] &5/serverstuff help");
                        MessageVariables.sendToPlayer((Player) sender, null, "&8&l[&5+&8&l] &5/serverstuff reload");

                    } else {
                        //Class "PermissionMessage"
                        UsedMessages.nonPermission((Player) sender);
                    }
                } else if (args[0].equalsIgnoreCase("reload")) {
                    if (sender.hasPermission("serverstuff.reload")) {
                        //Reload plugin
                        ServerStuff.getInstance().reloadConfig();
                        YMLManager.reload();
                        MessageVariables.sendToPlayer((Player) sender, null, "&6ServerStuff &8&l> &9Plugin Reloaded");
                    } else {
                        UsedMessages.nonPermission((Player) sender);
                    }
                }
            } else {
                UsedMessages.syntaxError((Player) sender);
            }
        }
        return false;
    }
}
