package me.guigarciazinho.guerra.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.guigarciazinho.guerra.comandos.Guerra;
import me.guigarciazinho.guerra.manager.Manager;

public class Main extends JavaPlugin{
	public Manager manager;
	public Guerra guerra;
	
	public void onEnable(){
		manager = new Manager();
		guerra = new Guerra(this);
		
		
	}

	public void onDisable(){
		
	}
}
