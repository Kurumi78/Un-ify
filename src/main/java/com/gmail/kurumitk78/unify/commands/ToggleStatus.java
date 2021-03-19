package com.gmail.kurumitk78.unify.commands;

import com.gmail.kurumitk78.unify.Unify;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleStatus implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!Unify.enabledPeople.contains(sender.getName())){
            Unify.enabledPeople.add(sender.getName());
        } else { Unify.enabledPeople.remove(sender.getName());}
        return false;
    }
}
