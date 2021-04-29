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

public class MLGCommand implements CommandExecutor {
    @Override
    public boolean onCommand(final CommandSender commandSender, Command command, String string, String[] args) {
        if (commandSender instanceof Player) {
            final Player commandPlayer = (Player) commandSender;

            if(args.length == 1){

                final double commandCordinateY = Double.parseDouble(args[0]);
                final double playerCordinateY = commandPlayer.getLocation().getY();

                try {
                    commandPlayer.teleport(new Location(commandPlayer.getWorld(), commandPlayer.getLocation().getX(),
                            playerCordinateY + commandCordinateY, commandPlayer.getLocation().getZ()));

                    commandPlayer.getInventory().setItem(0, new ItemBuilder(Material.WATER_BUCKET).setDisplayName("§8٠•§3● §bWasser").build());
                    commandPlayer.getInventory().setItem(1, new ItemBuilder(Material.BUCKET).setDisplayName("§8٠•§3● §bEimer").build());
                    commandPlayer.playSound(commandPlayer.getLocation(), Sound.EXPLODE, 10F, 10F);

                } catch (NumberFormatException exception) {
                    commandPlayer.sendMessage(Main.getDisplayname() + "Bitte nutzte §8/§7mlg §8[§ahöhe§8]§7.");
                }
            }

        }

        return false;
    }
}
