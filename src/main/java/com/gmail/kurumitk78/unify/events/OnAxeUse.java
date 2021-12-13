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

public class OnAxeUse implements Listener {
    public static List<Material> axeArray = new ArrayList<>(Arrays.asList(Material.IRON_AXE, Material.DIAMOND_AXE, Material.STONE_AXE, Material.WOODEN_AXE, Material.GOLDEN_AXE));

    @EventHandler
    public void OnBlockRightClick(PlayerInteractEvent event) {

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK
                && axeArray.contains(event.getPlayer().getEquipment().getItemInMainHand().getType())   //UnStripping
                && Unify.enabledPeople.contains(event.getPlayer().getName())) {

            Location strippedLoc = event.getClickedBlock().getLocation();
            World world = event.getClickedBlock().getWorld();
            switch (event.getClickedBlock().getType()) {

                case STRIPPED_ACACIA_LOG:
                    world.getBlockAt(strippedLoc).setType(Material.ACACIA_LOG);
                    break;
                case STRIPPED_SPRUCE_LOG:
                    world.getBlockAt(strippedLoc).setType(Material.SPRUCE_LOG);
                    break;
                case STRIPPED_OAK_LOG:
                    world.getBlockAt(strippedLoc).setType(Material.OAK_LOG);
                    break;
                case STRIPPED_BIRCH_LOG:
                    world.getBlockAt(strippedLoc).setType(Material.BIRCH_LOG);
                    break;
                case STRIPPED_DARK_OAK_LOG:
                    world.getBlockAt(strippedLoc).setType(Material.DARK_OAK_LOG);
                    break;
                case STRIPPED_JUNGLE_LOG:
                    world.getBlockAt(strippedLoc).setType(Material.JUNGLE_LOG);
                    break;
                case STRIPPED_ACACIA_WOOD:
                    world.getBlockAt(strippedLoc).setType(Material.ACACIA_WOOD);
                    break;
                case STRIPPED_SPRUCE_WOOD:
                    world.getBlockAt(strippedLoc).setType(Material.SPRUCE_WOOD);
                    break;
                case STRIPPED_OAK_WOOD:
                    world.getBlockAt(strippedLoc).setType(Material.OAK_WOOD);
                    break;
                case STRIPPED_BIRCH_WOOD:
                    world.getBlockAt(strippedLoc).setType(Material.BIRCH_WOOD);
                    break;
                case STRIPPED_DARK_OAK_WOOD:
                    world.getBlockAt(strippedLoc).setType(Material.DARK_OAK_WOOD);
                    break;
                case STRIPPED_JUNGLE_WOOD:
                    world.getBlockAt(strippedLoc).setType(Material.JUNGLE_WOOD);
                    break;
            }

                ItemStack axe = event.getPlayer().getEquipment().getItemInMainHand();
                Damageable axeMeta = (Damageable) axe.getItemMeta();
                axeMeta.setDamage(axeMeta.getDamage() + 1);
                axe.setItemMeta((ItemMeta) axeMeta);

            }

        }
        public static void addNewMaterials () { // For 1.16 Support
            axeArray.add(Material.NETHERITE_AXE);
        }
    }

