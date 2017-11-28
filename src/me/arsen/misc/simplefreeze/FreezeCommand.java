package me.arsen.misc.simplefreeze;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String a, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission(Permissions.ADMIN.name()))
		{
			if(args.length > 0)
			{
				Player target = Bukkit.getPlayerExact(args[0]);
				if(target != null)
				{
					String msg = Main.config.getString("froze");
					msg = msg.replaceAll("%player%", target.getName());
					
					if(Main.frozen.contains(target))
					{
						Main.frozen.remove(target);
						Main.sendMsg(target, Main.config.getString("prefix"), Main.config.getString("unfrozen"));
					}
					else
					{
						Main.frozen.add(target);
						Main.sendMsg(target, Main.config.getString("prefix"), Main.config.getString("frozen"));
					}
					Main.sendMsg(player, Main.config.getString("prefix"), msg);
						
				}
				else
					Main.sendMsg(player, Main.config.getString("prefix"), Main.config.getString("offline"));
			}
			else
				Main.sendMsg(player, Main.config.getString("prefix"), Main.config.getString("usage"));
		}
		else
		{
			Main.sendMsg(player, Main.config.getString("prefix"), Main.config.getString("permission"));
		}
		return false;
	}

}
