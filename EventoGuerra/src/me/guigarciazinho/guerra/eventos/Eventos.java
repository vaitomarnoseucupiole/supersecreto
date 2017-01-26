package me.guigarciazinho.guerra.eventos;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.guigarciazinho.guerra.main.Main;
import me.guigarciazinho.guerra.status.Status;

public class Eventos implements Listener {
	private Main plugin;

	public Eventos(Main main) {
		this.plugin = main;
	}

	@EventHandler
	private void aoMorrer(PlayerDeathEvent e) {
		if (plugin.manager.getStatus() != Status.FECHADO) {
			Player p = (Player) e.getEntity();
			if (plugin.manager.getParticipantes().contains(p.getUniqueId())) {
				plugin.manager.getParticipantes().remove(p.getUniqueId());
				for (UUID id : plugin.manager.getParticipantes()) {
					Player som = Bukkit.getPlayer(id);
					som.playSound(som.getLocation(), Sound.AMBIENCE_RAIN, 1, 1);
					som.sendMessage("§c" + p.getName() + " Saiu do jogo.");
				}
				if (plugin.manager.getStatus() == Status.JOGANDO) {
					if (plugin.manager.getParticipantes().size() == 1) {
						Player vencedor = Bukkit.getPlayer(plugin.manager.getParticipantes().get(0));
						Bukkit.broadcastMessage("§2" + vencedor.getName() + "Venceu o evento guerra".toUpperCase());
					}
				}

			}
		}
	}

	@EventHandler
	private void aoSair(PlayerQuitEvent e) {
		if (plugin.manager.getStatus() != Status.FECHADO) {
			Player p = e.getPlayer();
			if (plugin.manager.getParticipantes().contains(p.getUniqueId())) {
				plugin.manager.getParticipantes().remove(p.getUniqueId());
				for (UUID id : plugin.manager.getParticipantes()) {
					Player som = Bukkit.getPlayer(id);
					som.playSound(som.getLocation(), Sound.AMBIENCE_RAIN, 1, 1);
					som.sendMessage("§c" + p.getName() + " Saiu do jogo.");
				}
				if (plugin.manager.getStatus() == Status.JOGANDO) {
					if (plugin.manager.getParticipantes().size() == 1) {
						Player vencedor = Bukkit.getPlayer(plugin.manager.getParticipantes().get(0));
						Bukkit.broadcastMessage("§2" + vencedor.getName() + "Venceu o evento guerra".toUpperCase());
					}
				}
			}
		}

	}

	@EventHandler
	private void aoKickar(PlayerKickEvent e) {
		if (plugin.manager.getStatus() != Status.FECHADO) {
			Player p = e.getPlayer();
			if (plugin.manager.getParticipantes().contains(p.getUniqueId())) {
				plugin.manager.getParticipantes().remove(p.getUniqueId());
				for (UUID id : plugin.manager.getParticipantes()) {
					Player som = Bukkit.getPlayer(id);
					som.playSound(som.getLocation(), Sound.AMBIENCE_RAIN, 1, 1);
					som.sendMessage("§c" + p.getName() + " Saiu do jogo.");
				}
				if (plugin.manager.getStatus() == Status.JOGANDO) {
					if (plugin.manager.getParticipantes().size() == 1) {
						Player vencedor = Bukkit.getPlayer(plugin.manager.getParticipantes().get(0));
						Bukkit.broadcastMessage("§2" + vencedor.getName() + "Venceu o evento guerra".toUpperCase());
					}
				}
			}
		}
	}

}
