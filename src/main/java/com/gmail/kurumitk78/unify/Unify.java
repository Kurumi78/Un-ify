package com.gmail.kurumitk78.unify;

import com.gmail.kurumitk78.unify.events.OnHoeUse;
import com.gmail.kurumitk78.unify.events.OnShovelUse;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

import java.io.File;

public final class Unify extends JavaPlugin {


    @Override
    public void onEnable() {

        if (!(new File(this.getDataFolder(), "config.yml").exists())) { // Generates the config if missing,
            this.saveDefaultConfig();
        }
        if(Bukkit.getServer().getVersion().contains("MC: 1.16")){ OnHoeUse.addNewMaterials();
            OnShovelUse.addNewMaterials();}

        if(this.getConfig().getBoolean("Unpathing")) {
            getServer().getPluginManager().registerEvents(new OnShovelUse(), this);
        }

        if(this.getConfig().getBoolean("Untilling")) {
            getServer().getPluginManager().registerEvents(new OnHoeUse(), this);
        }

        int pluginId = 10628;
        Metrics metrics = new Metrics(this, pluginId);

    }

}
