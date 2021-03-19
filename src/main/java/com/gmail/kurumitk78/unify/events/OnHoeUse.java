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

public class OnHoeUse implements Listener {
    public static List<Material> hoeArray = new ArrayList<>(Arrays.asList(Material.IRON_HOE, Material.DIAMOND_HOE, Material.STONE_HOE, Material.WOODEN_HOE, Material.GOLDEN_HOE));
    @EventHandler
    public void OnBlockRightClick(PlayerInteractEvent event){

        if(event.getAction() == Action.RIGHT_CLICK_BLOCK &&event.getClickedBlock().getType().equals(Material.FARMLAND)
                &&  hoeArray.contains(event.getPlayer().getEquipment().getItemInMainHand().getType())   //Untilling
                && Unify.enabledPeople.contains(event.getPlayer().getName())){

            Location tilledLoc = event.getClickedBlock().getLocation();
            World world = event.getClickedBlock().getWorld();
            world.getBlockAt(tilledLoc).setType(Material.DIRT);
            ItemStack hoe = event.getPlayer().getEquipment().getItemInMainHand();
            Damageable hoeMeta = (Damageable) hoe.getItemMeta();
            hoeMeta.setDamage(hoeMeta.getDamage()+1);
            hoe.setItemMeta((ItemMeta)hoeMeta);

        }

    }
    public static void addNewMaterials(){ // For 1.16 Support
        hoeArray.add(Material.NETHERITE_HOE);
    }
}
