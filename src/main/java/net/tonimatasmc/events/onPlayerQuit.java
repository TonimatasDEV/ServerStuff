package net.tonimatasmc.events;

import main.serverstuff.yml.Players;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onPlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        Players.getPlayers().set(player.getName() + ".lastLocation", "\"" +
                player.getLocation().getWorld().getName() + "-" +
                player.getLocation().getBlockX() + "-" +
                player.getLocation().getBlockY() + "-" +
                player.getLocation().getBlockZ() + "-" +"\"");
        Players.savePlayers();
        Players.reloadPlayers();
    }
}
