package me.guigarciazinho.guerra.manager;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

import me.guigarciazinho.guerra.status.Status;

public class Manager {
	
	private Status status;
	private ArrayList<UUID> participantes;
	
	public Manager(){
		status = Status.FECHADO;
		this.participantes = new ArrayList<>();
	}
	
	public Status getStatus(){
		return this.status;
	}
	
	public void setStatus(Status status){
		this.status = status;
	}
	
	public ArrayList<UUID> getParticipantes(){
		return this.participantes;
	}
	
	public void addPlayer(Player p){
		this.participantes.add(p.getUniqueId());
		
	}
	

}
