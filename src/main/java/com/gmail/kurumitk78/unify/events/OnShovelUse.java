package com.gmail.kurumitk78.unify.events;

import com.gmail.kurumitk78.unify.Unify;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnShovelUse implements Listener {
    public static List<Material> shovelArray = new ArrayList<>(Arrays.asList(Material.IRON_SHOVEL,
            Material.DIAMOND_SHOVEL, Material.STONE_SHOVEL, Material.WOODEN_SHOVEL, Material.GOLDEN_SHOVEL));


    @EventHandler
    public void OnBlockRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType().equals(Material.GRASS_PATH)
                && shovelArray.contains(event.getPlayer().getEquipment().getItemInMainHand().getType())   //Unpathing
               && Unify.enabledPeople.contains(event.getPlayer().getName())){

            Location pathLoc = event.getClickedBlock().getLocation();
            World world = event.getClickedBlock().getWorld();
            world.getBlockAt(pathLoc).setType(Material.GRASS_BLOCK);
            ItemStack shovel = event.getPlayer().getEquipment().getItemInMainHand();
            Damageable shovelMeta = (Damageable) shovel.getItemMeta();
            shovelMeta.setDamage(shovelMeta.getDamage() + 1);
            shovel.setItemMeta((ItemMeta) shovelMeta);


        }

    }
    public static void addNewMaterials(){ // For 1.16 Support
        shovelArray.add(Material.NETHERITE_SHOVEL);
    }
}

