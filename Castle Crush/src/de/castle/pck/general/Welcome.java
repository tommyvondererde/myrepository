package de.castle.pck.general;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class Welcome implements Listener {

	public Welcome(Plugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent joinevent) {

		Player player = joinevent.getPlayer();

		player.sendMessage(ChatColor.AQUA + "Welcome to this server");
		player.sendMessage(ChatColor.YELLOW + "You currently have " + null + " coins");
		joinevent.setJoinMessage(ChatColor.GREEN + "Player " + player.getName() + " has joined");
		
		// hier regeln einf�gen

	}

}
