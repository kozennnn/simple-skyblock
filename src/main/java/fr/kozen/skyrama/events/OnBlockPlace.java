package fr.kozen.skyrama.events;

import fr.kozen.skyrama.Skyrama;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class OnBlockPlace implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        if(Skyrama.getGridManager().isInPlayerIsland(event.getPlayer(), event.getPlayer().getLocation()) == 1) {
            if(event.getPlayer().hasPermission("skyrama.event.place")){
                event.setCancelled(false);
            }else{
                event.getPlayer().sendMessage(Skyrama.getLocaleManager().getString("player-place"));
                event.setCancelled(true);
            }
        }
    }
}