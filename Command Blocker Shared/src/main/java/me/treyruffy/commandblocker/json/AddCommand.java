package me.treyruffy.commandblocker.json;

public class AddCommand {

	private final String command;
	private final String permission;
	private final String message;
	private final String worlds;
	private final String playercommands;
	private final String consolecommands;
	private final Boolean confirmation;
	
	private AddCommand(String command, String permission, String message,
			String worlds, String playercommands, String consolecommands, Boolean confirmation) {
		this.command = command;
		this.permission = permission;
		this.message = message;
		this.worlds = worlds;
		this.playercommands = playercommands;
		this.consolecommands = consolecommands;
		this.confirmation = confirmation;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getPermission() {
		return permission;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getWorlds() {
		return worlds;
	}
	
	public String getPlayerCommands() {
		return playercommands;
	}
	
	public String getConsoleCommands() {
		return consolecommands;
	}
	
	public Boolean getConfirmation() {
		return confirmation;
	}
}
