package net.clegames.main;

import net.clegames.commandexecutors.MLGCommand;
import net.clegames.listener.PlayerMoveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static String displayname;


    @Override
    public void onEnable() {
        displayname = "§8٠•§3● §bVelo-Berwerbung §8| §7";

        getCommand("MLG").setExecutor(new MLGCommand());

    registerEvents();


    }

    private void registerEvents() {
        final PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerMoveListener(), this);

    }


    public static String getDisplayname() {
        return displayname;
    }
}
