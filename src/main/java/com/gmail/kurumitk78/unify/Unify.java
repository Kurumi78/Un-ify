package com.gmail.kurumitk78.unify;

import com.gmail.kurumitk78.unify.commands.ToggleStatus;
import com.gmail.kurumitk78.unify.events.OnAxeUse;
import com.gmail.kurumitk78.unify.events.OnHoeUse;
import com.gmail.kurumitk78.unify.events.OnShovelUse;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class Unify extends JavaPlugin {


    public static boolean modernver = false;
    public static List<String> enabledPeople = new ArrayList<>();




    @Override
    public void onEnable() {


        if (!(new File(this.getDataFolder(), "config.yml").exists())) { // Generates the config if missing,
            this.saveDefaultConfig();
        }
        if(Bukkit.getServer().getVersion().contains("MC: 1.16")|| Bukkit.getServer().getVersion().contains("MC: 1.17") || Bukkit.getServer().getVersion().contains("MC: 1.18") || Bukkit.getServer().getVersion().contains("MC: 1.19") || Bukkit.getServer().getVersion().contains("MC: 1.20")){
            OnHoeUse.addNewMaterials(); //adds netherite tools if 1.16 is detected
            OnShovelUse.addNewMaterials();
            OnAxeUse.addNewMaterials();
            modernver = true;
        }
        if(this.getConfig().getBoolean("Unpathing")) { //Enables unpathing if enabled via config
            getServer().getPluginManager().registerEvents(new OnShovelUse(), this);
            OnShovelUse.durabilityUse = this.getConfig().getInt("UnpathingDurability");
        }

        if(this.getConfig().getBoolean("Untilling")) { //Enables untilling if enabled via config
            getServer().getPluginManager().registerEvents(new OnHoeUse(), this);
            OnHoeUse.durabilityUse = this.getConfig().getInt("UntillingDurability");
        }

        if(this.getConfig().getBoolean("Unstripping")) { //Enables untilling if enabled via config
            getServer().getPluginManager().registerEvents(new OnAxeUse(), this);
            OnAxeUse.durabilityUse = this.getConfig().getInt("UnstrippingDurability");
        }

        enabledPeople = this.getConfig().getStringList("EnabledUsers");    //Sets up the list of valid people on startup from config

        this.getCommand("undotoggle").setExecutor(new ToggleStatus()); //Registers the command to toggle if the plugin is active with a said user


        int pluginId = 10628; //BStats metrics
        Metrics metrics = new Metrics(this, pluginId);

    }

    public void onDisable(){
        this.getConfig().set("EnabledUsers", enabledPeople); //Saves the list on plugin unload.
        this.saveConfig();
    }

}
