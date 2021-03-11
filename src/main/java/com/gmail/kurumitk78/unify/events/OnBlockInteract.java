package com.gmail.kurumitk78.unify.events;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


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

        if(event.getMaterial().equals(Material.GRASS_PATH) &&  shovelArray.contains(event.getMaterial())){ //Unpathing

        }

        else if(event.getMaterial().equals(Material.FARMLAND) &&  hoeArray.contains(event.getMaterial())){

        }

    }
}
