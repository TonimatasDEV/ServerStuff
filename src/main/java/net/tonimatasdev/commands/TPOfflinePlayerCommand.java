package net.tonimatasdev.commands;

import main.serverstuff.yml.Players;
import net.tonimatasdev.util.MessageVariables;
import net.tonimatasdev.util.Simplifier;
import net.tonimatasdev.util.UsedMessages;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TPOfflinePlayerCommand extends Simplifier {

    public TPOfflinePlayerCommand(Player player, String label, String[] args) {
        if (args.length == 1) {
            assert playerHasPermission("serverstuff.tpoffline", player);
            assert Players.getPlayers().getConfigurationSection(args[0]) != null;

            player.teleport((Location) Players.getPlayers().get(args[0] + ".lastLocation"));
            MessageVariables.sendToPlayer(player, null, "&2[Successfully]: &fTeleported to " + Players.getPlayers().get(args[0] + ".lastLocation").toString().replaceAll("-", " "));
        } else {
            UsedMessages.syntaxError(player);
        }
    }
}
