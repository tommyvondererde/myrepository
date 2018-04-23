package de.castle.pck.tools;

import java.util.HashSet;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class MagicStick implements Listener {

	public static ItemStack magicstick = new ItemStack(Material.STICK);
	private ItemMeta magicstickmeta = magicstick.getItemMeta();

	public MagicStick(Plugin plugin) {

		magicstickmeta.setDisplayName("magicstick");
		magicstick.setItemMeta(magicstickmeta);
		plugin.getServer().getPluginManager().registerEvents(this, plugin);

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		ItemStack item = p.getInventory().getItemInOffHand(); // Item aus dem Inventar

		Block block = p.getTargetBlock((HashSet<Byte>) null, 250);

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand() != null && p.getItemInHand() == magicstick
					&& p.getInventory().getItemInOffHand() != null
					&& p.getInventory().getItemInOffHand().getType() == Material.BONE) {

				if (p.getInventory().getItemInOffHand().getAmount() == 1) {
					p.getWorld().strikeLightning(block.getLocation());

				} else {
					item.setAmount(item.getAmount() - 1);
					System.out.println("ik bin ein berliner");
					p.getWorld().strikeLightning(block.getLocation());
					return;
				}

			}
		}
	}

}
