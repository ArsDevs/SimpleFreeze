package me.arsen.misc.simplefreeze;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HitListener implements Listener {
	
	@EventHandler
	public void onHit(EntityDamageByEntityEvent e)
	{
		if(e.getEntity() instanceof Player)
		{
			Player player = (Player) e.getEntity();
			if(Main.frozen.contains(player))
			{
				e.setCancelled(true);
			}
		}

		if(e.getDamager() instanceof Player)
		{
			Player player = (Player) e.getDamager();
			if(Main.frozen.contains(player))
			{
				e.setCancelled(true);
			}			
		}
	}
}
