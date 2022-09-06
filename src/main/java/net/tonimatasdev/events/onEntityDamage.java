package net.tonimatasdev.events;

import main.serverstuff.yml.Players;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class onEntityDamage implements Listener {
    @EventHandler
    public void onDamageEvent(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            if (Players.getPlayers().getBoolean(player.getName() + ".god")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamageEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            if (Players.getPlayers().getBoolean(player.getName() + ".god")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamageEvent(EntityDamageByBlockEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            if (Players.getPlayers().getBoolean(player.getName() + ".god")) {
                event.setCancelled(true);
            }
        }
    }
}
