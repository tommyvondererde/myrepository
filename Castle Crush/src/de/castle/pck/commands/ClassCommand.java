package de.castle.pck.commands;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClassCommand implements CommandExecutor {

	
	public static Player target = null;
	
	@Override
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
			
		}
		
		sender.sendMessage(ChatColor.GREEN + "Player " + target.getName() + " set to " + args[0]);

		return true;
	}
}
