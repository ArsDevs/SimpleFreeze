package me.arsen.misc.simplefreeze;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {
	
	@EventHandler
	public void onMove(PlayerMoveEvent e)
	{
		Player player = e.getPlayer();
		
		if(Main.frozen.contains(player))
		{
			Location from = e.getFrom();
			Location to = e.getTo();
			
			if(from.getX() != to.getX() || from.getY() != to.getY() || from.getZ() != to.getZ())
				player.teleport(from);
		}
	}
}
