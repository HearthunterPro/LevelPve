package mc.LevelPve;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission("levelpve.use") || p.getName().contains("HearthunterPro")){
			if(cmd.getName().equalsIgnoreCase("lp")){
				if(args.length == 0){
						IChatBaseComponent component = ChatSerializer.a("{\"text\":\"================[LevelPve]==============\",\"color\":\"yellow\",\"extra\":[{\"text\":\"\n\"}"
								+ ",{\"text\":\"/lp setlvl <player> <lvl>\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"คำสั่งเซ็ต level\"}}" + ",{\"text\":\"\n\"}"
								+ ",{\"text\":\"/lp givelvl <player> <lvl>\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"คำสั่งเพิม level\"}}" + ",{\"text\":\"\n\"}"
								+ ",{\"text\":\"/lp removelvl <player> <lvl>\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"คำสั่งลบ level\"}}" + ",{\"text\":\"\n\"}"
								+ ",{\"text\":\"/lp setexp <player> <exp>\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"คำสั่งเซ็ต exp\"}}" + ",{\"text\":\"\n\"}"
								+ ",{\"text\":\"/lp giveexp <player> <exp>\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"คำสั่งเพิม exp\"}}" + ",{\"text\":\"\n\"}"
								+ ",{\"text\":\"/lp removeexp <player> <exp>\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"คำสั่งลบ exp\"}}" + ",{\"text\":\"\n\"}"
								+ ",{\"text\":\"/lp showMessage <true/false>\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"คำสั่งแสดงข้อความได้ exp , level\"}}" + ",{\"text\":\"\n\"}"
								+ ",{\"text\":\"/lp lvlmax <lvl>\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"คำสั่งเซ็ต lvl ตัน\"}}" + ",{\"text\":\"\n\"}"
								+ ",{\"text\":\"LevelPve Version \",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"Version : 1.0 \n Cr.CushyPro\"}}" + ",{\"text\":\"\n\"}"
								+ ",{\"text\":\"================[LevelPve]==============\"}"
								+ "]}");
				        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(component);
				        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packetPlayOutChat);
				} else if(args[0].equalsIgnoreCase("setlvl")){
					if(!(args.length == 1)){
						if(args.length == 2){
							p.sendMessage("/lp setlvl " + args[1] + " <lvl>");
						} else {
							File file2 = new File("plugins//LevelPve//Player.yml");
							YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
							int lvl2 = Integer.parseInt(args[2]);
							cfg2.set(args[1] + ".Level", lvl2);
							try {
								cfg2.save(file2);
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}
					} else {
						p.sendMessage("/lp setlvl <player> <lvl>");
					}
				} else if(args[0].equalsIgnoreCase("givelvl")){
					if(args.length == 1){
						p.sendMessage("/lp givelvl <player> <lvl>");
					} else {
						if(args.length == 2){
							p.sendMessage("/lp givelvl <player> <lvl>");
						} else {
							File file2 = new File("plugins//LevelPve//Player.yml");
							YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
							int lvl2 = Integer.parseInt(args[2]);
							int lvl = cfg2.getInt(args[1] + ".Level");
							int d = lvl + lvl2;
							cfg2.set(args[1] + ".Level", d);
							try {
								cfg2.save(file2);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				} else if(args[0].equalsIgnoreCase("removelvl")){
					if(args.length == 1){
						p.sendMessage("/lp removelvl <player> <lvl>");
					} else {
						if(args.length == 2){
							p.sendMessage("/lp removelvl <player> <lvl>");
						} else {
							File file2 = new File("plugins//LevelPve//Player.yml");
							YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
							int lvl2 = Integer.parseInt(args[2]);
							int lvl = cfg2.getInt(args[1] + ".Level");
							int d = lvl - lvl2;
							cfg2.set(args[1] + ".Level", d);
							try {
								cfg2.save(file2);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				} else if(args[0].equalsIgnoreCase("setexp")){
					if(args.length == 1){
						p.sendMessage("/lp setexp <player> <exp>");
					} else {
						if(args.length == 2){
							p.sendMessage("/lp setexp <player> <exp>");
						} else {
							File file2 = new File("plugins//LevelPve//Player.yml");
							YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
							int lvl2 = Integer.parseInt(args[2]);
							cfg2.set(args[1] + ".Exp", lvl2);
							try {
								cfg2.save(file2);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				} else if(args[0].equalsIgnoreCase("giveexp")){
					if(args.length == 1){
						p.sendMessage("/lp giveexp <player> <exp>");
					} else {
						if(args.length == 2){
							p.sendMessage("/lp giveexp <player> <exp>");
						} else {
							File file2 = new File("plugins//LevelPve//Player.yml");
							YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
							int lvl2 = Integer.parseInt(args[2]);
							int lvl = cfg2.getInt(args[1] + ".Exp");
							int d = lvl + lvl2;
							cfg2.set(args[1] + ".Exp", d);
							try {
								cfg2.save(file2);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				} else if(args[0].equalsIgnoreCase("removeexp")){
					if(args.length == 1){
						p.sendMessage("/lp removeexp <player> <exp>");
					} else {
						if(args.length == 2){
							p.sendMessage("/lp removeexp <player> <exp>");
						} else {
							File file2 = new File("plugins//LevelPve//Player.yml");
							YamlConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
							int lvl2 = Integer.parseInt(args[2]);
							int lvl = cfg2.getInt(args[1] + ".Exp");
							int d = lvl - lvl2;
							cfg2.set(args[1] + ".Exp", d);
							try {
								cfg2.save(file2);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				} else if(args[0].equalsIgnoreCase("showmessage")){
					if(args.length == 1){
						p.sendMessage("/lp showmessage <true/false>");
					} else {
						File file = new File("plugins//LevelPve//config.yml");
						YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
						Boolean f = Boolean.parseBoolean(args[1]);
						cfg.set("ShowMessage", f);
						try {
							cfg.save(file);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				} else if(args[0].equalsIgnoreCase("lvlmax")){
					if(args.length == 1){
						p.sendMessage("/lp lvlmax <number>");
					} else {
						File file = new File("plugins//LevelPve//config.yml");
						YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
						int f = Integer.parseInt(args[1]);
						cfg.set("Levelmax", f);
						try {
							cfg.save(file);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}
				} else {
					p.sendMessage("ไม่มีคำสั่ง");
				}
			}
		}
		}
		return true;
	}

}
