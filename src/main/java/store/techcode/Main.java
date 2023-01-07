package store.techcode;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.Lightable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
    getServer().getPluginManager().registerEvents(this, this);

    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        Material mat = e.getBlock().getType();
        if(mat.equals(Material.REDSTONE_TORCH)) {
//            e.getBlock().setType(Material.REDSTONE_TORCH_OFF);
            Lightable data = (Lightable) e.getBlock().getBlockData();
            data.setLit(false);
            e.getBlock().setBlockData(data);
        }
        if(mat.equals(Material.REDSTONE_WIRE) || mat.equals(Material.OAK_BUTTON) || mat.equals(Material.STONE_BUTTON) || mat.equals(Material.BIRCH_BUTTON) || mat.equals(Material.ACACIA_BUTTON) || mat.equals(Material.DARK_OAK_BUTTON) || mat.equals(Material.CRIMSON_BUTTON) || mat.equals(Material.JUNGLE_BUTTON) || mat.equals(Material.WARPED_BUTTON) || mat.equals(Material.ACACIA_BUTTON) || mat.equals(Material.POLISHED_BLACKSTONE_BUTTON) || mat.equals(Material.SPRUCE_BUTTON) || mat.equals(Material.MANGROVE_BUTTON)) {
            p.sendMessage("§7Redstone jest wylaczony");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockRedstone(BlockRedstoneEvent e) {
        e.setNewCurrent(0);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
