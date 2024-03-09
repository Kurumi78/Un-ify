package com.gmail.kurumitk78.unify.events;

import com.gmail.kurumitk78.unify.Unify;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gmail.kurumitk78.unify.Unify.modernver;

public class OnShovelUse implements Listener {
    public static List<Material> shovelArray = new ArrayList<>(Arrays.asList(Material.IRON_SHOVEL,
            Material.DIAMOND_SHOVEL, Material.STONE_SHOVEL, Material.WOODEN_SHOVEL, Material.GOLDEN_SHOVEL));

    public static int durabilityUse;


    @EventHandler
    public void OnBlockRightClick(PlayerInteractEvent event) {
        if(modernver){
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType().equals(Material.DIRT_PATH)
                    && shovelArray.contains(event.getPlayer().getEquipment().getItemInMainHand().getType())   //Unpathing
                    && event.getHand()== EquipmentSlot.HAND
                    && Unify.enabledPeople.contains(event.getPlayer().getName())){

                new BukkitRunnable() {
                    public void run() {

                        undoPathing(event.getClickedBlock().getLocation(), event.getClickedBlock().getWorld());
                        ItemStack shovel = event.getPlayer().getEquipment().getItemInMainHand();
                        Damageable shovelMeta = (Damageable) shovel.getItemMeta();
                        shovelMeta.setDamage(shovelMeta.getDamage() + durabilityUse);
                        shovel.setItemMeta(shovelMeta);

                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("Un-ify"), 1);



            }
        } else {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getType().equals(Material.LEGACY_GRASS_PATH)
                    && shovelArray.contains(event.getPlayer().getEquipment().getItemInMainHand().getType())   //Unpathing
                    && Unify.enabledPeople.contains(event.getPlayer().getName())){
                new BukkitRunnable() {
                    public void run() {

                        undoPathing(event.getClickedBlock().getLocation(), event.getClickedBlock().getWorld());
                        ItemStack shovel = event.getPlayer().getEquipment().getItemInMainHand();
                        Damageable shovelMeta = (Damageable) shovel.getItemMeta();
                        shovelMeta.setDamage(shovelMeta.getDamage() + 1);
                        shovel.setItemMeta((ItemMeta) shovelMeta);

                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("Un-ify"), 1);

            }

        }


    }

    public void undoPathing(Location blockLoc, World blockWorld){
        blockWorld.getBlockAt(blockLoc).setType(Material.GRASS_BLOCK);

    }
    public static void addNewMaterials(){ // For 1.16 Support
        shovelArray.add(Material.NETHERITE_SHOVEL);
    }

}

