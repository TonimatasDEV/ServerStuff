package net.tonimatasdev.commands;

import main.serverstuff.ServerStuff;
import net.tonimatasdev.util.MessageVariables;
import net.tonimatasdev.util.UsedMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class EnableDisablePluginsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("plugin")) {
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("enable")) {
                    if (player.hasPermission("serverstuff.plugin.enable") || player.hasPermission("serverstuff.plugin.*")) {
                        if (!args[1].isEmpty()) {
                            Plugin plugin = ServerStuff.getInstance().getServer().getPluginManager().getPlugin(args[1]);
                            if (plugin != null && !plugin.getName().equalsIgnoreCase("ServerStuff")) {
                                ServerStuff.getInstance().getServer().getPluginManager().enablePlugin(plugin);
                                MessageVariables.sendToPlayer(player, null, "&2[Success]: &7The plugin has been enabled.");
                            } else {
                                MessageVariables.sendToPlayer(player, null, "&4[Error]: &7You put a invalid plugin.");
                            }
                        } else {
                            UsedMessages.syntaxError(player);
                        }
                    } else {
                        UsedMessages.nonPermission(player);
                    }
                } else if (args[1].equalsIgnoreCase("disable")) {
                    if (player.hasPermission("serverstuff.plugin.enable") || player.hasPermission("serverstuff.plugin.*")) {
                        if (!args[1].isEmpty()) {
                            Plugin plugin = ServerStuff.getInstance().getServer().getPluginManager().getPlugin(args[1]);

                            if (plugin != null && !plugin.getName().equalsIgnoreCase("ServerStuff")) {
                                ServerStuff.getInstance().getServer().getPluginManager().disablePlugin(plugin);
                                MessageVariables.sendToPlayer(player, null, "&2[Success]: &7The plugin has been disabled.");
                            } else {
                                MessageVariables.sendToPlayer(player, null, "&4[Error]: &7You put a invalid plugin.");
                            }
                        } else {
                            UsedMessages.syntaxError(player);
                        }
                    } else {
                        UsedMessages.nonPermission(player);
                    }
                }
            } else {
                UsedMessages.syntaxError(player);
            }
        }
        return false;
    }
}

