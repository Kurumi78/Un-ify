package com.gmail.kurumitk78.unify;

import com.gmail.kurumitk78.unify.events.OnBlockInteract;
import org.bukkit.plugin.java.JavaPlugin;

public final class Unify extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OnBlockInteract(), this);

    }

}
