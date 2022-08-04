package net.tonimatasmc.commands;

import main.serverstuff.ServerStuff;
import main.serverstuff.yml.Messages;
import main.serverstuff.yml.Players;
import net.tonimatasmc.util.MessageVariables;
import net.tonimatasmc.util.UsedMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodModeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("god")) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                Player target = ServerStuff.getInstance().getServer().getPlayer(args[0]);

                if (player.hasPermission("serverstuff.god.other")) {
                    if (Players.getPlayers().getBoolean(target.getName() + ".god")) {
                        Players.getPlayers().set(target.getName() + ".god", false);

                        if (!player.getName().equalsIgnoreCase(target.getName())) {
                            MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.godCommand.godDisableOther"));
                        }

                        MessageVariables.sendToPlayer(null, target, Messages.getMessages().getString("Messages.godCommand.godDisable"));

                    } else {
                        Players.getPlayers().set(target.getName() + ".god", true);

                        if (!player.getName().equalsIgnoreCase(target.getName())) {
                            MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.godCommand.godEnableOther"));
                        }

                        MessageVariables.sendToPlayer(null, target, Messages.getMessages().getString("Messages.godCommand.godEnable"));
                    }
                } else {
                    UsedMessages.nonPermission(player);
                }
            } else {
                if (player.hasPermission("serverstuff.god")) {
                    if (Players.getPlayers().getBoolean(player.getName() + ".god")) {
                        Players.getPlayers().set(player.getName() + ".god", false);
                        MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.godCommand.godDisable"));
                    } else {
                        Players.getPlayers().set(player.getName() + ".god", true);
                        MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.godCommand.godEnable"));
                    }
                } else {
                    UsedMessages.nonPermission(player);
                }
            }

            Players.savePlayers();
            Players.reloadPlayers();
        }
        return false;
    }
}
