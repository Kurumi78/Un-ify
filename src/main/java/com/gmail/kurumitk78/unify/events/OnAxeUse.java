package com.gmail.kurumitk78.unify.events;

import com.gmail.kurumitk78.unify.Unify;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class OnAxeUse implements Listener {

    private final Unify plugin = JavaPlugin.getPlugin(Unify.class);

    public static int durabilityUse;

    @EventHandler(ignoreCancelled = true)
    public void onBlockRightClick(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Player player = event.getPlayer();

        Block block = event.getClickedBlock();

        if (block == null) return;

        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if (!itemStack.getType().toString().endsWith("_AXE")) return;

        if (event.getHand() != EquipmentSlot.HAND && !this.plugin.getEnabledPeople().contains(player.getUniqueId())) return;

        String type = block.getType().toString();

        if (!type.endsWith("_LOG") || !type.endsWith("_WOOD") || !type.endsWith("_STEM") || block.getType() != Material.BAMBOO_BLOCK || !type.endsWith("_HYPHAE")) return;

        new BukkitRunnable() {
            public void run() {
                Location strippedLoc = block.getLocation();
                World world = block.getWorld();
                boolean doStuff = false;

                switch (block.getType()) {
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
                    ItemStack axe = player.getInventory().getItemInMainHand();

                    if (axe.hasItemMeta()) {
                        Damageable axeMeta = (Damageable) axe.getItemMeta();

                        if (axeMeta != null) {
                            axeMeta.setDamage(axeMeta.getDamage() + durabilityUse);
                        }

                        axe.setItemMeta(axeMeta);
                    }
                }

            }
        }.runTaskLater(this.plugin, 1);
    }
}