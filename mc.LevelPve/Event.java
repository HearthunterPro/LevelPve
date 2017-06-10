package mc.LevelPve;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event implements Listener {

	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void players(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		File file = new File("plugins//LevelPve//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		File file2 = new File("plugins//LevelPve//Player.yml");
		YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
		int lvl = cfg2.getInt(p.getName() + ".Level");
		String text = cfg.getString("Format").replaceAll("(%lvl%)", lvl + "").replaceAll("(&([a-f0-9]))", "\u00A7$2");
		e.setFormat(text + "<" + e.getFormat());
		
	}
	@EventHandler
	public void Players(EntityDeathEvent e){
		if(e.getEntity().getKiller() instanceof Player){
			Player p = (Player) e.getEntity().getKiller();
			if(e.getEntity() instanceof Zombie){
				File file = new File("plugins//LevelPve//config.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				File file2 = new File("plugins//LevelPve//Player.yml");
				YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
				int ax = cfg.getInt("Entity.Zombie.min");
				int as = cfg.getInt("Entity.Zombie.max");
				int random = getRandom(ax , as);
				
				int lvl = cfg2.getInt(p.getName() + ".Exp");
				int a = lvl + random; 
				cfg2.set(p.getName() + ".Exp", a);
				Boolean show = cfg.getBoolean("ShowMessage");
				if(show == true){
					String texts = cfg.getString("MessageKill").replaceAll("(&([a-f0-9]))", "\u00A7$2").replaceAll("(%mob%)", e.getEntity().getName()).replaceAll("(%exp%)", random + "");
					p.sendMessage(texts);
				}
				try {
					cfg2.save(file2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else if(e.getEntity() instanceof Skeleton){
				File file = new File("plugins//LevelPve//config.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				File file2 = new File("plugins//LevelPve//Player.yml");
				YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
				int ax = cfg.getInt("Entity.Skeleton.min");
				int as = cfg.getInt("Entity.Skeleton.max");
				int random = getRandom(ax , as);
				
				int lvl = cfg2.getInt(p.getName() + ".Exp");
				int a = lvl + random; 
				cfg2.set(p.getName() + ".Exp", a);
				try {
					cfg2.save(file2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Boolean show = cfg.getBoolean("ShowMessage");
				if(show == true){
					String texts = cfg.getString("MessageKill").replaceAll("(&([a-f0-9]))", "\u00A7$2").replaceAll("(%mob%)", e.getEntity().getName()).replaceAll("(%exp%)", random + "");
					p.sendMessage(texts);
				}
			} else if(e.getEntity() instanceof Enderman){
				File file = new File("plugins//LevelPve//config.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				File file2 = new File("plugins//LevelPve//Player.yml");
				YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
				int ax = cfg.getInt("Entity.Enderman.min");
				int as = cfg.getInt("Entity.Enderman.max");
				int random = getRandom(ax , as);
				
				int lvl = cfg2.getInt(p.getName() + ".Exp");
				int a = lvl + random; 
				cfg2.set(p.getName() + ".Exp", a);
				try {
					cfg2.save(file2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Boolean show = cfg.getBoolean("ShowMessage");
				if(show == true){
					String texts = cfg.getString("MessageKill").replaceAll("(&([a-f0-9]))", "\u00A7$2").replaceAll("(%mob%)", e.getEntity().getName()).replaceAll("(%exp%)", random + "");
					p.sendMessage(texts);
				}
			} else if(e.getEntity() instanceof Spider){
				File file = new File("plugins//LevelPve//config.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				File file2 = new File("plugins//LevelPve//Player.yml");
				YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
				int ax = cfg.getInt("Entity.Spider.min");
				int as = cfg.getInt("Entity.Spider.max");
				int random = getRandom(ax , as);
				
				int lvl = cfg2.getInt(p.getName() + ".Exp");
				int a = lvl + random; 
				cfg2.set(p.getName() + ".Exp", a);
				try {
					cfg2.save(file2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Boolean show = cfg.getBoolean("ShowMessage");
				if(show == true){
					String texts = cfg.getString("MessageKill").replaceAll("(&([a-f0-9]))", "\u00A7$2").replaceAll("(%mob%)", e.getEntity().getName()).replaceAll("(%exp%)", random + "");
					p.sendMessage(texts);
				}
			} else if(e.getEntity() instanceof Player){
				File file = new File("plugins//LevelPve//config.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				File file2 = new File("plugins//LevelPve//Player.yml");
				YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
				int ax = cfg.getInt("Entity.Player.min");
				int as = cfg.getInt("Entity.Player.max");
				int random = getRandom(ax , as);
				
				int lvl = cfg2.getInt(p.getName() + ".Exp");
				int a = lvl + random; 
				cfg2.set(p.getName() + ".exp", a);
				try {
					cfg2.save(file2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Boolean show = cfg.getBoolean("ShowMessage");
				if(show == true){
					String texts = cfg.getString("MessageKill").replaceAll("(&([a-f0-9]))", "\u00A7$2").replaceAll("(%mob%)", e.getEntity().getName()).replaceAll("(%exp%)", lvl + "");
					p.sendMessage(texts);
				}
			}
			
			
		}
	}
	
	@EventHandler
	public void Players(PlayerJoinEvent e){
		Player p = e.getPlayer();
		File file2 = new File("plugins//LevelPve//Player.yml");
		YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
		String a = cfg2.getString(p.getName() + ".Level");
		if(a == null){
			cfg2.set(p.getName() + ".Level", 0);
			cfg2.set(p.getName() + ".Exp", 0);
			try {
				cfg2.save(file2);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	
	@EventHandler
	public void players2(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		String text = e.getMessage();
		if(text.equalsIgnoreCase("level")){
			e.setCancelled(true);
			File file2 = new File("plugins//LevelPve//Player.yml");
			YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
			int lvl = cfg2.getInt(p.getName() + ".Level");
			int exp = cfg2.getInt(p.getName() + ".Exp");
			p.sendMessage(ChatColor.GREEN + "You Have Status " + "\n"
					+ ChatColor.GREEN + "Lvl : " + lvl + "\n"
					+ ChatColor.GREEN + "Exp : " + exp + "\n"
							+ "============================");
		}
	}
	
	
	
	
	public int getRandom(int lower, int upper) {
        Random random = new Random();
        return random.nextInt((upper - lower) + 1) + lower;
    }
}
