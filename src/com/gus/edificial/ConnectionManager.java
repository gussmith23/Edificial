package com.gus.edificial;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionManager{
	
	public static Socket socket = null;
	public EdificialPlugin plugin;
	
	public ConnectionManager(EdificialPlugin plugin){
		
		this.plugin = plugin;
		
		
		plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try{
				
				EdificialPlugin.logger.info("Connecting to " + EdificialInfo.ip + ":" + EdificialInfo.port + ".");
				socket = new Socket(EdificialInfo.ip, EdificialInfo.port);
				EdificialPlugin.logger.info("Connected to " + EdificialInfo.ip + ":" + EdificialInfo.port + ".");
				
				}catch(ConnectException e){
					EdificialPlugin.logger.warning("Connection to " + EdificialInfo.ip + ":" + EdificialInfo.port + " timed out; Edificial is disconnected.");
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
	}
	
	
	
}
