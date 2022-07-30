package com.danizml.commands;

import main.serverstuff.ServerStuff;
import main.serverstuff.yml.Config;
import main.serverstuff.yml.Messages;
import net.tonimatasmc.util.MessageColor;
import net.tonimatasmc.util.PermissionMessage;
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

                        //help message
                        MessageColor.sendToPlayer((Player) sender, "&6ServerStuff &8&l> &6Help");
                        MessageColor.sendToPlayer((Player) sender, "&8&l[&5+&8&l] &5/serverstuff help");
                        MessageColor.sendToPlayer((Player) sender, "&8&l[&5+&8&l] &5/serverstuff reload");

                    } else {
                        //Class "PermissionMessage"
                        PermissionMessage.nonPermission((Player) sender);
                    }

                } else if (args[0].equalsIgnoreCase("reload")) {
                    if (sender.hasPermission("serverstuff.reload")) {

                        //reload plugin
                        ServerStuff.getInstance().reloadConfig();
                        Messages.reloadMessages();
                        MessageColor.sendToPlayer((Player) sender, "&6ServerStuff &8&l> &9Plugin Reloaded");

                    } else {
                        PermissionMessage.nonPermission((Player) sender);
                    }
                }
            } else {
                MessageColor.sendToPlayer((Player) sender, "&4[Error]: &7Syntax error.");
            }
        }
        return false;
    }
}
