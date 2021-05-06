package net.clegames;

import net.clegames.commandexecutors.MLGCommand;
import net.clegames.listener.PlayerMoveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
		
		initialize();
    }

    private void initialize() {
        
		getCommand("mlg").setExecutor(new MLGCommand());
		
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }


    public static String getDisplayname() {
		
        return "§8٠•§3● §bVelo-Bewerbung §8| §7";
    }
}
