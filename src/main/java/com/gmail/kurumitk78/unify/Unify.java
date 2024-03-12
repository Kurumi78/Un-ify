package com.gmail.kurumitk78.unify;

import com.gmail.kurumitk78.unify.commands.ToggleStatus;
import com.gmail.kurumitk78.unify.events.OnAxeUse;
import com.gmail.kurumitk78.unify.events.OnHoeUse;
import com.gmail.kurumitk78.unify.events.OnShovelUse;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class Unify extends JavaPlugin {

    private final List<UUID> enabledPeople = new ArrayList<>();

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        FileConfiguration configuration = getConfig();

        if (configuration.getBoolean("Unpathing")) { // Enables unpathing if enabled via config
            getServer().getPluginManager().registerEvents(new OnShovelUse(), this);
            OnShovelUse.durabilityUse = this.getConfig().getInt("UnpathingDurability");
        }

        if (configuration.getBoolean("Untilling")) { // Enables untilling if enabled via config
            getServer().getPluginManager().registerEvents(new OnHoeUse(), this);

            OnHoeUse.durabilityUse = this.getConfig().getInt("UntillingDurability");
        }

        if (configuration.getBoolean("Unstripping")) { // Enables untilling if enabled via config
            getServer().getPluginManager().registerEvents(new OnAxeUse(), this);

            OnAxeUse.durabilityUse = this.getConfig().getInt("UnstrippingDurability");
        }

        configuration.getStringList("EnabledUsers").forEach(line -> this.enabledPeople.add(UUID.fromString(line)));

        registerCommand(getCommand("undotoggle"), null, new ToggleStatus());

        new Metrics(this, 10628);
    }

    @Override
    public void onDisable(){
        getConfig().set("EnabledUsers", this.enabledPeople); // Saves the list on plugin unload.

        saveConfig();
    }

    private void registerCommand(PluginCommand pluginCommand, TabCompleter tabCompleter, CommandExecutor commandExecutor) {
        if (pluginCommand != null) {
            pluginCommand.setExecutor(commandExecutor);

            if (tabCompleter != null) pluginCommand.setTabCompleter(tabCompleter);
        }
    }

    public void addPerson(UUID uuid) {
        this.enabledPeople.add(uuid);
    }

    public void removePerson(UUID uuid) {
        this.enabledPeople.remove(uuid);
    }

    public List<UUID> getEnabledPeople() {
        return Collections.unmodifiableList(this.enabledPeople);
    }
}