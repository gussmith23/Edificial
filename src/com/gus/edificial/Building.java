package com.gus.edificial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;

import com.sk89q.worldedit.bukkit.selections.Selection;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class Building implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3408952671000377656L;
	
	Selection sel;
	
	//the number of blocks in an x,y,z row.
	public int xLength,yLength,zLength;
	
	public int xMin, yMin, zMin;
	
	//the list itself
	ArrayList<Integer> serializedBuilding = new ArrayList<Integer>();

	World world;
	
	public Building(EdificialSelection edSel){
		
		sel = edSel.sel;
		
		xLength = sel.getMaximumPoint().getBlockX() - sel.getMinimumPoint().getBlockX();
		yLength = sel.getMaximumPoint().getBlockY() - sel.getMinimumPoint().getBlockY();
		zLength = sel.getMaximumPoint().getBlockZ() - sel.getMinimumPoint().getBlockZ();
		
		xMin = sel.getMinimumPoint().getBlockX();
		yMin = sel.getMinimumPoint().getBlockY();
		zMin = sel.getMinimumPoint().getBlockZ();
		
		breakdown(edSel);
		
		EdificialPlugin.logger.info("Beginning building creation for " + edSel.player.getName() + "...");
		
		world = edSel.sel.getWorld();
		
	}
	
	/*
	 * breaking down a selection into a list of blocks.
	 * first three ints are x,y,z length
	 * then begins a list of ids of blocks.
	 */
	private void breakdown(EdificialSelection edSel) {
		
		serializedBuilding.add(xLength);
		serializedBuilding.add(yLength);
		serializedBuilding.add(zLength);
		
		EdificialPlugin.logger.info("bups");
		
		//iterating through x columns
		for(int x = 0; x < xLength; x++){
			
			EdificialPlugin.logger.info("cups");
			
			//y columns
			for(int y = 0; y < yLength; y++){
				
				EdificialPlugin.logger.info("grups");
				
				//z columns
				for(int z = 0; z < zLength; z++){
					
					Location loc = new Location(world, xMin + x, yMin + y, zMin + z);
					
					int id = world.getBlockTypeIdAt(loc);
					EdificialPlugin.logger.info(""+id);
					serializedBuilding.add(id);
					
				}
				
			}
			
		}
		
		
	}

}
