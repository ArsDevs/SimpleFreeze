package me.arsen.misc.simplefreeze;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	
	public static FileConfiguration config;
	public static ArrayList<Player> frozen = new ArrayList<>();
	
	@Override
	public void onEnable()
	{
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
		getCommand("freeze").setExecutor(new FreezeCommand());
		Bukkit.getPluginManager().registerEvents(new MovementListener(), this);
		Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
		Bukkit.getPluginManager().registerEvents(new HitListener(), this);
		config = this.getConfig();
		System.out.println("SimpleFreeze plugin is Enabled.");
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("SimpleFreeze plugin is Disabled.");
	}
	
	public static void sendMsg(Player player,String prefix,String command)
	{
		
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix+" "+command));
	}
	
}
