package com.gus.edificial;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.regions.RegionSelector;


/*
 * an object to represent a group of selected blocks. can be transformed into the serializable EdificialClipboardObject,
 * in a way "finalizing" it as an object, "exporting" it, but can also be transformed and manipulated before its exportation.
 * let it be known that i am uncomfortable writing this up while the worldedit api is out there, but at the same time it
 * seems to be on its last legs. correct me if i'm wrong.
 */
public class EdificialSelection {
	
	private EdificialPlugin plugin;
	Selection sel;
	Player player;
	Region reg;
	
	//the coordinates bounding the regions.
	//convention will be that 1<=2
	public Integer x1,x2,y1,y2,z1,z2 =  (Integer) null;
	
	
	public EdificialSelection(Player player, EdificialPlugin plugin) throws Exception{
				
		this.player = player;
		this.plugin = plugin;
		
		sel = EdificialPlugin.we.getSelection(player);
		
		x1 = sel.getMinimumPoint().getBlockX();
		y1 = sel.getMinimumPoint().getBlockY();
		z1 = sel.getMinimumPoint().getBlockZ();
	
		x2 = sel.getMaximumPoint().getBlockX();
		y2 = sel.getMaximumPoint().getBlockY();
		z2 = sel.getMaximumPoint().getBlockZ();
		
		informPlayer();
		
		EdificialPlugin.logger.info(player.getName() + " created new selection: " + x1 + ", " + y1 + ", " + z1 + "; " + x2 + ", " + y2 + ", " + z2 + ".");
		EdificialPlugin.logger.info("Total blocks selected: " + sel.getArea() + ".");
	
		EdificialInfo.selections.put(player, this);
		
	}


	public void informPlayer() {
		// TODO Auto-generated method stub
		
		player.sendMessage("The coordinates of your selection are " + x1 + ", " + y1 + ", " + z1 + "; " + x2 + ", " + y2 + ", " + z2 + ".");
		player.sendMessage("Total blocks selected: " + sel.getArea() + ".");
		
	}
	
	

	
}
