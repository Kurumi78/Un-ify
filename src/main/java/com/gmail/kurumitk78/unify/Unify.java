package com.gmail.kurumitk78.unify;

import com.gmail.kurumitk78.unify.events.OnBlockInteract;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

public final class Unify extends JavaPlugin {

    @Override
    public void onEnable() {
        if(Bukkit.getServer().getVersion().contains("MC: 1.16")){ OnBlockInteract.addNewMaterials();}
        getServer().getPluginManager().registerEvents(new OnBlockInteract(), this);


        int pluginId = 10628;
        Metrics metrics = new Metrics(this, pluginId);

    }

}
