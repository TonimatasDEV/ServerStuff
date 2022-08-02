package net.tonimatasmc.commands;

import main.serverstuff.ServerStuff;
import net.tonimatasmc.util.UsedMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorkbenchCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("workbench") || command.getName().equalsIgnoreCase("wb")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("[&4Error&f]: You not a player.");
            } else {
                Player player = (Player) sender;

                if (player.hasPermission("serverstuff.workbench")) {
                    if (args.length == 1) {
                        if (player.hasPermission("serverstuff.workbench.other")) {
                            Player target = ServerStuff.getInstance().getServer().getPlayer(args[0]);

                            if (target.isOnline()) {
                                target.openWorkbench(player.getLocation(), true);
                            } else {
                                UsedMessages.targetNotOnline(target);
                            }
                        } else {
                            UsedMessages.nonPermission(player);
                        }
                    } else {
                        player.openWorkbench(player.getLocation(), true);
                    }
                } else {
                    UsedMessages.nonPermission(player);
                }
            }
        }

        return false;
    }
}
