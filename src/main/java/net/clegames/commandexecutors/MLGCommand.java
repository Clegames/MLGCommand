package net.clegames.commandexecutors;

import net.clegames.main.Main;
import net.clegames.utils.ItemBuilder;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MLGCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String string, String[] strings) {
        if (commandSender instanceof Player) {

            Player player = (Player) commandSender;

            if (strings.length == 1) {

                double commandCoordinateY = Double.parseDouble(args[0]);

                try {

                    player.teleport(new Location(player.getWorld(), player.getLocation().getX(),
                            player.getLocation().getY() + commandCordinateY, player.getLocation().getZ()));

                    player.getInventory().setItem(0,
                            new ItemBuilder(Material.WATER_BUCKET).setDisplayName("§8٠•§3● §bWasser").build(););

                    player.getInventory().setItem(1,
                            new ItemBuilder(Material.BUCKET).setDisplayName("§8٠•§3● §bEimer").build());

                    player.playSound(player.getLocation(), Sound.EXPLODE, 10F, 10F);

                } catch (NumberFormatException numberFormatException) {

                    player.sendMessage(Main.getDisplayname() + "Bitte nutze §8/§7mlg §8[§aheight§8]§7.");
                }
            }
        }

        return false;
    }
}
