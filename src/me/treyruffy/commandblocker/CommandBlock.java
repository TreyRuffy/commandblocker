package me.treyruffy.commandblocker;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandBlock implements Listener{
	@SuppressWarnings("unused")
	private final CommandBlocker plugin;
	
	public CommandBlock(CommandBlocker plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommand(PlayerCommandPreprocessEvent event){
		Player sender = event.getPlayer();
		String[] args = event.getMessage().split(" ");
		for (String command : ConfigManager.getDisabled().getConfigurationSection("DisabledCommands").getKeys(false)){
			String commands = command.replace("%colon%", ":");
			String permission = command.replace("%colon%", "").replace(" ", "");
			if (args[0].equalsIgnoreCase("/" + commands)){
				if (ConfigManager.getDisabled().getString("DisabledCommands." + command + ".Permission") == null){
					if (!(sender.hasPermission(ConfigManager.getConfig().getString("Default.Permission").replace("%command%", permission)))){
						event.setCancelled(true);
						if (ConfigManager.getDisabled().getString("DisabledCommands." + command + ".Message") == null){
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getConfig().getString("Default.Message")));
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getDisabled().getString("DisabledCommands." + command + ".Message")));
						}
						return;
					}
				} else {
					if(!(sender.hasPermission(ConfigManager.getDisabled().getString("DisabledCommands." + command + ".Permission")))){
						event.setCancelled(true);
						if (ConfigManager.getDisabled().getString("DisabledCommands." + command + ".Message") == null){
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getConfig().getString("Default.Message")));
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigManager.getDisabled().getString("DisabledCommands." + command + ".Message")));
						}
						return;
					}
				}
			}
		}
	}
}