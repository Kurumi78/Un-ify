package com.gmail.kurumitk78.unify.events;

import com.gmail.kurumitk78.unify.Unify;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
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

public class OnAxeUse implements Listener {     //TO-DO: Organize and re-format this class.
    public static List<Material> axeArray = new ArrayList<>(Arrays.asList(Material.IRON_AXE, Material.DIAMOND_AXE, Material.STONE_AXE, Material.WOODEN_AXE, Material.GOLDEN_AXE));
    public static int durabilityUse;


    @EventHandler
    public void OnBlockRightClick(PlayerInteractEvent event) {

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK
                && axeArray.contains(event.getPlayer().getEquipment().getItemInMainHand().getType())   //UnStripping
                && event.getHand() == EquipmentSlot.HAND
                && Unify.enabledPeople.contains(event.getPlayer().getName())) {

            //May the coffee lord forgive me for what I'm about to do
            if (event.getClickedBlock().getType() == Material.STRIPPED_ACACIA_LOG || event.getClickedBlock().getType() == Material.STRIPPED_ACACIA_WOOD ||
                    event.getClickedBlock().getType() == Material.STRIPPED_SPRUCE_LOG || event.getClickedBlock().getType() == Material.STRIPPED_SPRUCE_WOOD ||
                    event.getClickedBlock().getType() == Material.STRIPPED_OAK_LOG || event.getClickedBlock().getType() == Material.STRIPPED_OAK_WOOD ||
                    event.getClickedBlock().getType() == Material.STRIPPED_BIRCH_LOG || event.getClickedBlock().getType() == Material.STRIPPED_BIRCH_WOOD ||
                    event.getClickedBlock().getType() == Material.STRIPPED_DARK_OAK_LOG || event.getClickedBlock().getType() == Material.STRIPPED_DARK_OAK_WOOD ||
                    event.getClickedBlock().getType() == Material.STRIPPED_JUNGLE_LOG || event.getClickedBlock().getType() == Material.STRIPPED_JUNGLE_WOOD ||
                    event.getClickedBlock().getType() == Material.STRIPPED_CRIMSON_HYPHAE || event.getClickedBlock().getType() == Material.STRIPPED_CRIMSON_STEM ||
                    event.getClickedBlock().getType() == Material.STRIPPED_WARPED_HYPHAE || event.getClickedBlock().getType() == Material.STRIPPED_WARPED_STEM ||
                    event.getClickedBlock().getType() == Material.STRIPPED_MANGROVE_LOG || event.getClickedBlock().getType() == Material.STRIPPED_MANGROVE_WOOD ||
                    event.getClickedBlock().getType() == Material.STRIPPED_CHERRY_LOG || event.getClickedBlock().getType() == Material.STRIPPED_CHERRY_WOOD ||
                    event.getClickedBlock().getType() == Material.STRIPPED_BAMBOO_BLOCK) {


                new BukkitRunnable() {
                    public void run() {
                        Location strippedLoc = event.getClickedBlock().getLocation();
                        World world = event.getClickedBlock().getWorld();
                        boolean doStuff = false;
                        switch (event.getClickedBlock().getType()) {

                            case STRIPPED_ACACIA_LOG:
                                world.getBlockAt(strippedLoc).setType(Material.ACACIA_LOG);
                                doStuff = true;
                                break;
                            case STRIPPED_SPRUCE_LOG:
                                world.getBlockAt(strippedLoc).setType(Material.SPRUCE_LOG);
                                doStuff = true;
                                break;
                            case STRIPPED_OAK_LOG:
                                world.getBlockAt(strippedLoc).setType(Material.OAK_LOG);
                                doStuff = true;
                                break;
                            case STRIPPED_BIRCH_LOG:
                                world.getBlockAt(strippedLoc).setType(Material.BIRCH_LOG);
                                doStuff = true;
                                break;
                            case STRIPPED_DARK_OAK_LOG:
                                world.getBlockAt(strippedLoc).setType(Material.DARK_OAK_LOG);
                                doStuff = true;
                                break;
                            case STRIPPED_JUNGLE_LOG:
                                world.getBlockAt(strippedLoc).setType(Material.JUNGLE_LOG);
                                doStuff = true;
                                break;
                            case STRIPPED_CRIMSON_STEM:
                                world.getBlockAt(strippedLoc).setType(Material.CRIMSON_STEM);
                                doStuff = true;
                                break;
                            case STRIPPED_CRIMSON_HYPHAE:
                                world.getBlockAt(strippedLoc).setType(Material.CRIMSON_HYPHAE);
                                doStuff = true;
                                break;
                            case STRIPPED_WARPED_STEM:
                                world.getBlockAt(strippedLoc).setType(Material.WARPED_STEM);
                                doStuff = true;
                                break;
                            case STRIPPED_WARPED_HYPHAE:
                                world.getBlockAt(strippedLoc).setType(Material.WARPED_HYPHAE);
                                doStuff = true;
                                break;
                            case STRIPPED_MANGROVE_LOG:
                                world.getBlockAt(strippedLoc).setType(Material.MANGROVE_LOG);
                                doStuff = true;
                                break;
                            case STRIPPED_CHERRY_LOG:
                                world.getBlockAt(strippedLoc).setType(Material.CHERRY_LOG);
                                doStuff = true;
                                break;
                            case STRIPPED_ACACIA_WOOD:
                                world.getBlockAt(strippedLoc).setType(Material.ACACIA_WOOD);
                                doStuff = true;
                                break;
                            case STRIPPED_SPRUCE_WOOD:
                                world.getBlockAt(strippedLoc).setType(Material.SPRUCE_WOOD);
                                doStuff = true;
                                break;
                            case STRIPPED_OAK_WOOD:
                                world.getBlockAt(strippedLoc).setType(Material.OAK_WOOD);
                                doStuff = true;
                                break;
                            case STRIPPED_BIRCH_WOOD:
                                world.getBlockAt(strippedLoc).setType(Material.BIRCH_WOOD);
                                doStuff = true;
                                break;
                            case STRIPPED_DARK_OAK_WOOD:
                                world.getBlockAt(strippedLoc).setType(Material.DARK_OAK_WOOD);
                                doStuff = true;
                                break;
                            case STRIPPED_JUNGLE_WOOD:
                                world.getBlockAt(strippedLoc).setType(Material.JUNGLE_WOOD);
                                doStuff = true;
                                break;
                            case STRIPPED_CHERRY_WOOD:
                                world.getBlockAt(strippedLoc).setType(Material.CHERRY_WOOD);
                                doStuff = true;
                                break;
                            case STRIPPED_MANGROVE_WOOD:
                                world.getBlockAt(strippedLoc).setType(Material.MANGROVE_WOOD);
                                doStuff = true;
                                break;
                            case STRIPPED_BAMBOO_BLOCK:
                                world.getBlockAt(strippedLoc).setType(Material.BAMBOO_BLOCK);
                                doStuff = true;
                                break;
                        }
                        if (doStuff) {
                            ItemStack axe = event.getPlayer().getEquipment().getItemInMainHand();
                            Damageable axeMeta = (Damageable) axe.getItemMeta();
                            axeMeta.setDamage(axeMeta.getDamage() + durabilityUse);
                            axe.setItemMeta((ItemMeta) axeMeta);
                        }
                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("Un-ify"), 1);
            }

        }
    }
            public static void addNewMaterials() { // For 1.16 Support
                axeArray.add(Material.NETHERITE_AXE);
            }
        }






