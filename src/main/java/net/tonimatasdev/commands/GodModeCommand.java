package net.tonimatasdev.commands;

import main.serverstuff.yml.Messages;
import main.serverstuff.yml.Players;
import net.tonimatasdev.util.MessageVariables;
import net.tonimatasdev.util.Simplifier;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodModeCommand extends Simplifier {

    public GodModeCommand(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;

        assert playerHasPermission("serverstuff.god", player);

        if (Players.getPlayers().getBoolean(player.getName() + ".god")) {
            Players.getPlayers().set(player.getName() + ".god", false);
            MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.godCommand.godDisable"));
        } else {
            Players.getPlayers().set(player.getName() + ".god", true);
            MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.godCommand.godEnable"));
        }

        if (args.length == 2) {
            Player target = getPlayer(args[0]);

            assert playerHasPermission("serverstuff.god.other", player);

            if (Players.getPlayers().getBoolean(target.getName())) {
                Players.getPlayers().set(target.getName() + ".god", true);

                if (!player.getName().equals(target.getName())) {
                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.godCommand.godEnableOther"));
                }

                MessageVariables.sendToPlayer(null, target, Messages.getMessages().getString("Messages.godCommand.godEnable"));
            } else {
                Players.getPlayers().set(target.getName() + ".god", false);

                if (!player.getName().equals(target.getName())) {
                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.godCommand.godDisableOther"));
                }

                MessageVariables.sendToPlayer(null, target, Messages.getMessages().getString("Messages.godCommand.godDisable"));
            }
        }

        Players.savePlayers();
        Players.reloadPlayers();
    }
}
