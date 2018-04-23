package de.castle.pck.tools;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class Backpack implements Listener {

	private ItemStack backpack = new ItemStack(Material.LEATHER);
	private ItemMeta backpackmeta = backpack.getItemMeta();
	private Plugin plugin;

	public Backpack(Plugin plugin) { 
		this.plugin = plugin;
		registerRecipes();
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	public boolean registerRecipes() {
		backpackmeta.setDisplayName("񘬍backpack");
		backpack.setItemMeta(backpackmeta);

		// Plugin plugin = Bukkit.getPluginManager().getPlugin("CastleCrush");

		NamespacedKey key = new NamespacedKey(plugin, "backpack");
		ShapedRecipe backpackrecipe = new ShapedRecipe(key, backpack);
		backpackrecipe.shape("LGL", "SWS", "LLL");
		backpackrecipe.setIngredient('L', Material.LEATHER);
		backpackrecipe.setIngredient('G', Material.GOLD_INGOT);
		backpackrecipe.setIngredient('W', Material.WOOL);
		backpackrecipe.setIngredient('S', Material.STRING);

		Bukkit.addRecipe(backpackrecipe);

		return false;

	}

	@EventHandler
	public void onPlayerClicks(PlayerInteractEvent click) {
		
		Player player = click.getPlayer();
		ItemStack item = click.getItem();

		Action action = click.getAction();

		if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {


			if (item != null && item.equals(backpack)) {

				Inventory inv =	Bukkit.createInventory(player, 9*4, "backpack");
				player.openInventory(inv);	
				//lol
				
				
			}

		}

	}
}
