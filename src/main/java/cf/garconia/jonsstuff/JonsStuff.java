package cf.garconia.jonsstuff;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import cf.garconia.jonsstuff.commands.Commands;
import cf.garconia.jonsstuff.events.Events;

public class JonsStuff extends JavaPlugin implements Listener {

	private static JonsStuff instance;

	@Override
	public void onLoad() {
		instance = this;
	}

	@Override
	public void onEnable() {
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new Events(), this);

		for (String cmd : Arrays.asList("heal", "feed", "farmtime", "givewand", "rld")) {
			getCommand(cmd).setExecutor(new Commands());
		}

		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Jons-Stuff] Plugin Is Enabled!");
	}

	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Jons-Stuff] Plugin Is Disabled!");
	}

	public static JonsStuff getInstance() {
		return instance;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		if (getConfig().getBoolean("youAreAwesome")) {
			player.sendMessage("You are awesome!");

			getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[Jons-Stuff] Awsome!");
		} else {
			player.sendMessage("You are not awesome...");
		}
		
	}
}
