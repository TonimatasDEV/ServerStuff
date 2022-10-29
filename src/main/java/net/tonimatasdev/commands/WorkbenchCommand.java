package net.tonimatasdev.commands;

import net.tonimatasdev.util.Simplifier;
import net.tonimatasdev.util.UsedMessages;
import org.bukkit.entity.Player;

public class WorkbenchCommand extends Simplifier {

    public WorkbenchCommand(Player player, String label, String[] args) {
        assert playerHasPermission("serverstuff.workbench", player);

        if (args.length == 1) {
            player.openWorkbench(player.getLocation(), true);
        } else {
            assert playerHasPermission("serverstuff.workbench.other", player);

            if (getPlayer(args[0]).isOnline()) {
                getPlayer(args[0]).openWorkbench(player.getLocation(), true);
            } else {
                UsedMessages.targetNotOnline(getPlayer(args[0]));
            }
        }
    }
}
