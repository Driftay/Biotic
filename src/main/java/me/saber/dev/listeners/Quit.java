package me.saber.dev.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static me.saber.dev.Biotic.playerPermissions;

public class Quit implements Listener {

    @EventHandler
    public void leave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        playerPermissions.remove(player.getUniqueId());
    }
}
