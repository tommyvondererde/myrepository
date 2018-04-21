package de.castle.pck.commands;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import de.castle.pck.tools.BuildTool;

public class ClassCommand implements CommandExecutor,Listener {

	public static Player target = null;
public static String arg;


dddd
	@Ovearride
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			
		
		
		if (args.length != 2) {
			sender.sendMessage(ChatColor.RED + "Please use /class <class name> <player>");
			return false;
		}

		if (!sender.hasPermission("minecraft.command.op")) {
			sender.sendMessage(ChatColor.RED + "You do not have the permission to set the class");
			return false;
		}

		Collection<? extends Player> players = Bukkit.getOnlinePlayers();
		for (Player player : players) {
			if (player.getName().equals(args[1])) {
				target = player;
				break;
			}
		}

		if (target == null) {
			sender.sendMessage(ChatColor.RED + "Player " + args[1] + " not found");
			return false;
		}

		if (args[0].equals("mage")) {

		} else if (args[0].equals("knight")) {

		} else if (args[0].equals("archer")) {

		} else if (args[0].equals("builder")) {
			
			
			Inventory inv = target.getInventory();
			inv.addItem(BuildTool.buildtool);

			

		}

		sender.sendMessage(ChatColor.GREEN + "Player " + target.getName() + " set to " + args[0]);
		arg = args[0];

		return true;
	}
//	@EventHandler
//	public void onItemDrop (PlayerDropItemEvent dropevent) {
//
//		
//		Item item = dropevent.getItemDrop();
//		Player player = dropevent.getPlayer();
//		
//		player.sendMessage("lol");
//		if (arg == "mage") {
//
//		} else if (arg == "knight") {
//
//		} else if (arg == ("archer")) {
//
//		} else if (arg == ("builder")) {
//			if(item == BuildTool.buildtool) {
//				
//				item.remove();
//				player.getInventory().addItem(BuildTool.buildtool);
//				
//				
//			}
//			
//
//		}
//	
//	
//	}
}
