package com.gus.edificial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.regions.RegionSelector;
import com.sk89q.worldedit.spout.selections.Selection;

public class EdificialPlugin extends JavaPlugin{
	
	public static PluginLogger logger;
	EdificialListener listener;
	ConnectionManager cm;
	public static WorldEditPlugin we;
	
	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		super.onEnable();
		
		listener = new EdificialListener(this);
		this.getServer().getPluginManager().registerEvents(listener, this);
		
		logger = new PluginLogger(this);
		
		cm = new ConnectionManager(this);
		
		we = (WorldEditPlugin) this.getServer().getPluginManager().getPlugin("WorldEdit");
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = null;
		
		try{
			 player = (Player) sender;
		}catch(Exception e){
			logger.info("Console called command...");
		}
		
		
		//the base Edificial command
		if(command.getName().equalsIgnoreCase("ed")){
			
			if(args.length == 0){
				
			}
			
			else if(args.length == 1){
				
				//the command for a selection
				if(args[0].equalsIgnoreCase("select")){
					
					if(!(sender instanceof Player)){
						logger.info("Expected player!");
						return false;
					}			
	
					try {
						new EdificialSelection(player, this);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.info(player.getName() + ": no WorldEdit selection made.");
						player.sendMessage("Please make a selection with WorldEdit first.");
					}
					
					return true;
					
				}
				
				if(args[0].equalsIgnoreCase("build")){
					
					new Building(EdificialInfo.selections.get(player));
					return true;
					
				}
				
			}
			
		}
		
		return super.onCommand(sender, command, label, args);
		
	}
	
	

}
