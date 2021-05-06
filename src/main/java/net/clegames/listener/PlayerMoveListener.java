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
    public void handlePlayerMove(PlayerMoveEvent playerMoveEvent) {

        Player player = playerMoveEvent.getPlayer();

        if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WATER) {

            player.sendMessage(Main.getDisplayname() + "Du hast den MLG erfolgreich geschafft§8.");
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 10F, 10F);
            player.getLocation().getBlock().getRelative(BlockFace.DOWN).setType(Material.AIR);
        }
    }
}
