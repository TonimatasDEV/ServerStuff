package net.tonimatasdev.commands;

import main.serverstuff.yml.Messages;
import net.tonimatasdev.util.MessageVariables;
import net.tonimatasdev.util.Simplifier;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand extends Simplifier {

    public SpeedCommand(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;

        if (args[0].equals("fly")) {
            assert playerHasPermission("serverstuff.speed.fly", player);
            assert argsNumberChecker(args.length, 2, 3, player);

            if (args.length == 3) speedType(args, player, args[1].equals("normal"), true);
            if (args.length == 2) speedType(args, player, args[1].equals("normal"), false);
        }

        if (args[0].equals("walk")) {
            assert playerHasPermission("serverstuff.speed.walk", player);
            assert argsNumberChecker(args.length, 2, 3, player);

            if (args.length == 3) speedType(args, player, args[1].equals("normal"), true);
            if (args.length == 2) speedType(args, player, args[1].equals("normal"), false);

        }

        if (args[0].equals("both")) {
            assert playerHasPermission("serverstuff.speed.both", player);
            assert argsNumberChecker(args.length, 2, 3, player);

            if (args.length == 3) speedType(args, player, args[1].equals("normal"), true);
            if (args.length == 2) speedType(args, player, args[1].equals("normal"), false);
        }
    }


    private static void speedType(String[] args, Player player, boolean normal, boolean other) {
        float speed = Float.parseFloat(args[1]);

        switch (args[0]) {
            case "fly" -> {
                Player target;

                if (other) {
                    target = getPlayer(args[2]);
                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.speedCommand.flySpeedOther"));
                } else {
                    target = player;
                }

                if (!normal) target.setFlySpeed(speed);
                if (normal) target.setFlySpeed(0.1F);

                MessageVariables.sendToPlayer(player, null, Messages.getMessages().getString("Messages.speedCommand.flySpeed"));
            }

            case "walk" -> {
                Player target;

                if (other) {
                    target = getPlayer(args[2]);
                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.speedCommand.walkSpeedOther"));
                } else {
                    target = player;
                }

                if (!normal) target.setWalkSpeed(speed);
                if (normal) target.setWalkSpeed(0.2F);

                MessageVariables.sendToPlayer(target, null, Messages.getMessages().getString("Messages.speedCommand.walkSpeed"));
            }

            case "both" -> {
                Player target;

                if (other) {
                    target = getPlayer(args[2]);
                    MessageVariables.sendToPlayer(player, target, Messages.getMessages().getString("Messages.speedCommand.bothSpeedOther"));
                } else {
                    target = player;
                }

                if (normal) {
                    target.setWalkSpeed(speed);
                    target.setFlySpeed(speed);
                } else {
                    target.setWalkSpeed(0.2F);
                    target.setFlySpeed(0.1F);
                }

                MessageVariables.sendToPlayer(target, null, Messages.getMessages().getString("Messages.speedCommand.bothSpeed"));
            }
        }
    }
}
