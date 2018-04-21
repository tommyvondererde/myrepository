package de.castle.pck.tools;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class BuildTool implements Listener {

	public static ItemStack buildtool = new ItemStack(Material.STICK);
	private ItemMeta buildtoolmeta = buildtool.getItemMeta();
	int materialnumber = 0;

	private Material[] material = new Material[] { Material.COBBLESTONE, Material.SMOOTH_BRICK, Material.STONE,
			Material.WOOD };

	public BuildTool(Plugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		buildtoolmeta.setDisplayName("buildtool | " + material[materialnumber]);
		buildtoolmeta.setUnbreakable(true);
		buildtool.setItemMeta(buildtoolmeta);

	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent click) {

		Player player = click.getPlayer();
		Action action = click.getAction();
		ItemStack item = click.getItem();

		Location location = click.getClickedBlock().getLocation();
		if (item != null && item.equals(buildtool) && player.isSneaking()) {
			if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {

				if (materialnumber < material.length) {
					materialnumber++;

					player.sendMessage("you now selected: " + (material[materialnumber]));
				} else if (materialnumber >= material.length) {

					materialnumber = 0;
					player.sendMessage("you now selected: " + (material[materialnumber]));

				}
			}

			else if (action.equals(Action.RIGHT_CLICK_BLOCK)) {
				if (item != null && item.equals(buildtool)) {
					location.getBlock().setType((material[materialnumber]));

				}

			}
		}
	}
}
