package com.gus.edificial;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class EdificialInfo {
	
	/*
	 * hashmap used when constructing a selection.
	 * the integer represents the stage.
	 * current number of stages - 
	 */
	public static HashMap<Player,Integer> constructionStage = new HashMap<Player,Integer>();
	
	//what to add/subtract from selected y values, 2 by default.
	public static int yAdd = 2;
	
	//the ip and port.
	public static String ip = "70.15.90.240";
	public static int port = 2323;
	
	//the selections of different players
	public static HashMap<Player,EdificialSelection> selections = new HashMap<Player, EdificialSelection>();
	
}
