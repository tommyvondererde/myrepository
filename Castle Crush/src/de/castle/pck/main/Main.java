package de.castle.pck.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.castle.pck.commands.ClassCommand;
import de.castle.pck.tools.Backpack;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		new Backpack(this);
		
		getCommand("class").setExecutor(new ClassCommand());

	}
	
	

	
}
