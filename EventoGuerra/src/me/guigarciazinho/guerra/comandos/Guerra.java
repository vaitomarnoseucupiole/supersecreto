package me.guigarciazinho.guerra.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.guigarciazinho.guerra.main.Main;
import me.guigarciazinho.guerra.status.Status;

public class Guerra implements CommandExecutor{
	
	private Main plugin;
	
	public Guerra(Main main){
		this.plugin = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
		if(command.getName().equalsIgnoreCase("guerra")){
			if(args.length >= 1){
				if("iniciar".equalsIgnoreCase(args[0])){
					if(sender.hasPermission("guerra.iniciar")){
						if(plugin.manager.getStatus() == Status.FECHADO){
							plugin.manager.setStatus(Status.ABERTO);
							Bukkit.broadcastMessage("§2Evento Guerra sendo iniciado.");
							Bukkit.broadcastMessage("§2Para entrar use /guerra entrar");
							Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
								@Override
								public void run() {
									plugin.manager.setStatus(Status.JOGANDO);
									Bukkit.broadcastMessage("§eO evento foi iniciado, não há mais como entrar.");

								}
							}, 20 * 120);
						}
						
					}
					
					if("entrar".equalsIgnoreCase(args[0])){
						if(plugin.manager.getStatus() == Status.ABERTO){
							Player p = (Player) sender;
							plugin.manager.addPlayer(p);
							
						}
					}
				}
				
				
				
				
			}
			
			
		}
		
		
		return false;
	}

}
