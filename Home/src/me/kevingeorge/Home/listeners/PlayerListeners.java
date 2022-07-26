package me.kevingeorge.Home.listeners;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.kevingeorge.Home.Home;

public class PlayerListeners implements Listener{
	private final Home plugin;
	
	public PlayerListeners(Home plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(!e.getFrom().getBlock().equals(e.getTo().getBlock())) {
			Player p = e.getPlayer();
			UUID id = p.getUniqueId();
			if(plugin.isQued(id)) plugin.cancelQue(id);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			UUID id = p.getUniqueId();
			if(plugin.isQued(id)) {
				plugin.cancelQue(id);
			}
		}
	}
}
