package mc.LevelPve;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		getCommand("lp").setExecutor(new Commands());
		getServer().getPluginManager().registerEvents(new Event(), this);
		file();
		run();
	}
	
	@SuppressWarnings("deprecation")
	private void run() {
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				Object[] a = Bukkit.getOnlinePlayers().toArray();
				int max = a.length;
				for(int x = 0; x < max;x++){
					Player p = (Player) a[x];
					levelup(p);
					levelmax(p);
				}
				
			}

		private void levelmax(Player p) {
		File file = new File("plugins//LevelPve//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		File file2 = new File("plugins//LevelPve//Player.yml");
		YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
		int max = cfg.getInt("Levelmax");
		int lvl = cfg2.getInt(p.getName() + ".Level");
		if(lvl >= max){
			cfg2.set(p.getName() + ".Level", max);
			try {
				cfg2.save(file2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

			private void levelup(Player p) {
				File file = new File("plugins//LevelPve//config.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				File file2 = new File("plugins//LevelPve//Player.yml");
				YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
				int exp = cfg2.getInt(p.getName() + ".Exp");
				int lvl = cfg2.getInt(p.getName() + ".Level");
				int max = cfg.getInt("lvl.num");
				int x = 1;
				while(x <= max){
					int bb = cfg.getInt("lvl."+ x +".lvl");
					if(lvl <= bb){
						int be = cfg.getInt("lvl."+ x +".exp");
						if(exp >= be){
							int s = lvl + 1;
							int d = exp - be;
							cfg2.set(p.getName() + ".Level", s);
							cfg2.set(p.getName() + ".Exp", d);
							try {
								cfg2.save(file2);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.sendMessage("=====> LEVEL UP! Lvl:" + ChatColor.RED + s);
						}
					}
					x++;
				}
			}
		}, 0, 1);
	}

	private void file() {
		File file = new File("plugins//LevelPve//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Format", "&a[Lvl: &c%lvl%&a]&f");
		cfg.set("ShowMessage", true);
		cfg.set("MessageKill", "&aYou kill %mob% reward %exp% exp");
		cfg.set("Levelmax", 100);
		cfg.set("lvl.num", 4);
		cfg.set("lvl.1.lvl", 20);
		cfg.set("lvl.1.exp", 200);
		cfg.set("lvl.2.lvl", 70);
		cfg.set("lvl.2.exp", 500);
		cfg.set("lvl.3.lvl", 90);
		cfg.set("lvl.3.exp", 800);
		cfg.set("lvl.4.lvl", 100);
		cfg.set("lvl.4.exp", 1000);
		cfg.set("Entity.Zombie.min", 0);
		cfg.set("Entity.Zombie.max", 100);
		cfg.set("Entity.Skeleton.min", 0);
		cfg.set("Entity.Skeleton.max", 100);
		cfg.set("Entity.Spider.min", 0);
		cfg.set("Entity.Spider.max", 100);
		cfg.set("Entity.EnderMan.min", 0);
		cfg.set("Entity.EnderMan.max", 120);
		cfg.set("Entity.Player.min", 100);
		cfg.set("Entity.Player.max", 500);
		if(!file.exists()){
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		
		
	}

	public void onDisable(){
		
	}

}
