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

public class OnHoeUse implements Listener {

    private final Unify plugin = JavaPlugin.getPlugin(Unify.class);

    public static int durabilityUse;

    @EventHandler(ignoreCancelled = true)
    public void onBlockRightClick(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        Player player = event.getPlayer();

        Block block = event.getClickedBlock();

        if (block == null) return;

        Material blockType = block.getType();

        if (blockType != Material.FARMLAND) return;

        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if (!itemStack.getType().toString().endsWith("_HOE")) return;

        if (event.getHand() != EquipmentSlot.HAND) return;

        if (!this.plugin.getEnabledPeople().contains(player.getUniqueId())) return;

        new BukkitRunnable() {
            public void run() {
                Location tilledLoc = block.getLocation();
                World world = block.getWorld();
                world.getBlockAt(tilledLoc).setType(Material.DIRT);

                Damageable hoeMeta = (Damageable) itemStack.getItemMeta();

                if (hoeMeta != null) {
                    hoeMeta.setDamage(hoeMeta.getDamage() + durabilityUse);
                }

                itemStack.setItemMeta(hoeMeta);
            }
        }.runTaskLater(this.plugin, 1);
    }
}