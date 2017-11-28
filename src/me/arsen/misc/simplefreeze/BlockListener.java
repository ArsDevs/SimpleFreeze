package me.arsen.misc.simplefreeze;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {
	@EventHandler
	public void onBreak(BlockBreakEvent e)
	{
		Player player = e.getPlayer();
		
		if(Main.frozen.contains(player))
		{
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e)
	{
		Player player = e.getPlayer();
		
		if(Main.frozen.contains(player))
		{
			e.setCancelled(true);
		}		
	}
}
