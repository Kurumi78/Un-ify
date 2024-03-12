package com.gmail.kurumitk78.unify.commands;

import com.gmail.kurumitk78.unify.Unify;
import com.gmail.kurumitk78.unify.utils.Methods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.UUID;

public class ToggleStatus implements CommandExecutor {

    private final Unify plugin = JavaPlugin.getPlugin(Unify.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) return false;

        Player player = (Player) commandSender;

        UUID uuid = player.getUniqueId();

        if (this.plugin.getEnabledPeople().contains(uuid)) {
            this.plugin.addPerson(uuid);

            player.sendMessage(Methods.color("&7[&8Un-ify&7] Un-doing enabled!"));

            return true;
        }

        this.plugin.removePerson(uuid);

        player.sendMessage(Methods.color("&7[&8Un-ify&7] Un-doing disabled!"));

        return true;
    }
}