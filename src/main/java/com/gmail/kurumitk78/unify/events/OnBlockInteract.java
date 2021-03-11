package com.gmail.kurumitk78.unify.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnBlockInteract implements Listener {

    public static List<Material> shovelArray = new ArrayList<>(Arrays.asList(Material.IRON_SHOVEL, Material.DIAMOND_SHOVEL, Material.STONE_SHOVEL, Material.WOODEN_SHOVEL, Material.GOLDEN_SHOVEL));
    public static List<Material> hoeArray = new ArrayList<>(Arrays.asList(Material.IRON_HOE, Material.DIAMOND_HOE, Material.STONE_HOE, Material.WOODEN_HOE, Material.GOLDEN_HOE));

    public static void addNewMaterials(){ // For 1.16 Support
        hoeArray.add(Material.NETHERITE_HOE);
        shovelArray.add(Material.NETHERITE_SHOVEL);
    }

    @EventHandler
    public void OnBlockRightClick(PlayerInteractEvent event){
        //event.getPlayer().sendMessage(ChatColor.GRAY + "[Un-Ify] " + ChatColor.DARK_GRAY + event.getMaterial() + " " + shovelArray.contains(event.getPlayer().getEquipment().getItemInMainHand().getType()));
        if(event.getClickedBlock().getType().equals(Material.GRASS_PATH) &&  shovelArray.contains(event.getPlayer().getEquipment().getItemInMainHand().getType())){ //Unpathing
            Location pathLoc = event.getClickedBlock().getLocation();
            World world = event.getClickedBlock().getWorld();
            world.getBlockAt(pathLoc).setType(Material.GRASS_BLOCK);
            ItemStack shovel = event.getPlayer().getEquipment().getItemInMainHand();
            Damageable shovelMeta = (Damageable) shovel.getItemMeta();
            shovelMeta.setDamage(shovelMeta.getDamage()+1);
            shovel.setItemMeta((ItemMeta)shovelMeta);


        }

        else if(event.getClickedBlock().getType().equals(Material.FARMLAND) &&  hoeArray.contains(event.getPlayer().getEquipment().getItemInMainHand().getType())){
            Location tilledLoc = event.getClickedBlock().getLocation();
            World world = event.getClickedBlock().getWorld();
            world.getBlockAt(tilledLoc).setType(Material.DIRT);
            ItemStack hoe = event.getPlayer().getEquipment().getItemInMainHand();
            Damageable hoeMeta = (Damageable) hoe.getItemMeta();
            hoeMeta.setDamage(hoeMeta.getDamage()+1);
            hoe.setItemMeta((ItemMeta)hoeMeta);

        }

    }
}
