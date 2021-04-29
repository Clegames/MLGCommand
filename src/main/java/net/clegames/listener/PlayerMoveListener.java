package net.clegames.listener;

import net.clegames.main.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.net.http.WebSocket;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void handlePlayerMove(final PlayerMoveEvent event) {

        Player eventPlayer = event.getPlayer();

        if (eventPlayer.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WATER) {
            eventPlayer.sendMessage(Main.getDisplayname() + "Du hasst den MLG erfolgreich geschafft§8.");
            eventPlayer.playSound(eventPlayer.getLocation(), Sound.LEVEL_UP, 10F, 10F);
            eventPlayer.getLocation().getBlock().getRelative(BlockFace.DOWN).setType(Material.AIR);


        }
    }

}
