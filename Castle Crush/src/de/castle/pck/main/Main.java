package de.castle.pck.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.castle.pck.commands.ClassCommand;
import de.castle.pck.commands.EventCommand;
import de.castle.pck.general.Welcome;
import de.castle.pck.tools.Backpack;
import de.castle.pck.tools.BuildTool;
import de.castle.pck.tools.MagicStick;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {

		new Backpack(this);
		new Welcome(this);
		new BuildTool(this);
		new MagicStick(this);
		
		getCommand("class").setExecutor(new ClassCommand());
		getCommand("event").setExecutor(new EventCommand());

		
		
	}
	
	

	
}
