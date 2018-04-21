package de.castle.pck.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EventCommand implements CommandExecutor  {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	
		if(args.length != 1) {
			
			sender.sendMessage(ChatColor.RED + "please use /event <event action>");
			
		}
		if (!sender.hasPermission("minecraft.command.op")) {
			
			sender.sendMessage(ChatColor.RED + "you do not have the permission to start or stop events");
			
		}
		
		if(args[0].equals("start")) {
			
			sender.sendMessage("event has started");
			
		}else if (args[0].equals("stop")) {
			

			sender.sendMessage("event has stoped");
			
		}else
			sender.sendMessage(ChatColor.RED + "you can only start or stop events");
		
		return false;
	}

	
	
	
}
