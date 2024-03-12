package com.gmail.kurumitk78.unify.events;

import com.gmail.kurumitk78.unify.Unify;
import com.gmail.kurumitk78.unify.utils.ServerProtocol;
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

public class OnShovelUse implements Listener {

    private final Unify plugin = JavaPlugin.getPlugin(Unify.class);

    public static int durabilityUse;

    @EventHandler(ignoreCancelled = true)
    public void onBlockRightClick(PlayerInteractEvent event) {
        // If action is not block, return early.
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Player player = event.getPlayer();

        Block block = event.getClickedBlock();

        // If block is null return early.
        if (block == null) return;

        // If protocol is at least blah blah. do your thing then return
        if (ServerProtocol.isAtLeast(ServerProtocol.v1_16_R1)) {
            // If not block return
            if (!block.getType().equals(Material.DIRT_PATH)) return;

            ItemStack itemStack = player.getInventory().getItemInMainHand();

            // If it doesn't end in _SHOVEL, return.
            if (!itemStack.getType().toString().endsWith("_SHOVEL")) return;

            if (event.getHand() == EquipmentSlot.HAND && this.plugin.getEnabledPeople().contains(player.getUniqueId())) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        undoPathing(block.getLocation(), block.getWorld());
                        ItemStack shovel = player.getInventory().getItemInMainHand();

                        if (shovel instanceof Damageable) {
                            Damageable damageable = (Damageable) shovel.getItemMeta();

                            if (damageable != null) {
                                damageable.setDamage(damageable.getDamage() + durabilityUse);
                            }

                            shovel.setItemMeta(damageable);
                        }

                    }
                }.runTaskLater(this.plugin, 1);
            }

            return;
        }

        // If type isn't what you want, return.
        if (!block.getType().equals(Material.LEGACY_GRASS_PATH)) return;

        ItemStack itemStack = player.getInventory().getItemInMainHand();

        // If it doesn't end in _SHOVEL, return.
        if (!itemStack.getType().toString().endsWith("_SHOVEL")) return;

        if (this.plugin.getEnabledPeople().contains(player.getUniqueId())) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    undoPathing(block.getLocation(), event.getClickedBlock().getWorld());
                    ItemStack shovel = player.getInventory().getItemInMainHand();

                    Damageable shovelMeta = (Damageable) shovel.getItemMeta();

                    if (shovelMeta != null) {
                        shovelMeta.setDamage(shovelMeta.getDamage() + 1);
                    }

                    shovel.setItemMeta(shovelMeta);
                }
            }.runTaskLater(this.plugin, 1);
        }
    }

    private void undoPathing(Location blockLoc, World blockWorld){
        blockWorld.getBlockAt(blockLoc).setType(Material.GRASS_BLOCK);
    }
}