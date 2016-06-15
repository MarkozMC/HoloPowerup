package CZ.MarkoCZ.Holo;
import java.util.Random;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.gmail.filoghost.holographicdisplays.api.handler.PickupHandler;
import com.gmail.filoghost.holographicdisplays.api.line.ItemLine;

import de.slikey.effectlib.EffectManager;



public class A extends JavaPlugin implements Listener{

	public EffectManager manager;
	public static Random rm;	
	int randomm;
	public static Random randoom;
	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		this.manager = new EffectManager(this);
		saveDefaultConfig();
		randoom = new Random();
		this.randomm = getConfig().getInt("powerup-chance");
		if(Bukkit.getServer().getPluginManager().isPluginEnabled("HolographicDisplays")){
			Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "HolographicDisplays Has been hooked");
		}else{
			Bukkit.getServer().getPluginManager().disablePlugin(this);
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "HolographicDisplays can not hooked.. Disabled");
		}
	
	}
	
	@EventHandler
	public void PlayerDeath(PlayerDeathEvent e){
		Player p = e.getEntity().getPlayer();
		final Location loc = p.getLocation();
		if (getConfig().getStringList("BlackList").contains(p.getWorld().getName())) {
		      return;
		    }
		if ((this.randoom.nextInt(100) < this.randomm)){
		       Item drop = p.getWorld().dropItemNaturally(loc.add(0,1,0), new ItemStack(Material.SKULL));
		       C c = new C(manager);
               c.setEntity(drop);
               c.start();
               drop.remove();
               
			    Random r = new Random();
			    for (int rr = 1; rr <= 1; rr++)
			    {
			      rr = 1 + r.nextInt(10);
			      if (rr == 1)
			      {
				String text = ChatColor.GOLD  + "" + ChatColor.BOLD + "Fire Resistance";
				ItemStack icon = new ItemStack(Material.BLAZE_POWDER);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 2)
			      {
				String text = ChatColor.AQUA  + "" + ChatColor.BOLD + "Swiftness";
				ItemStack icon = new ItemStack(Material.PACKED_ICE);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 3)
			      {
				String text = ChatColor.DARK_BLUE  + "" + ChatColor.BOLD + "Water Breathing";
				ItemStack icon = new ItemStack(Material.DIAMOND_HELMET);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 4)
			      {
				String text = ChatColor.BLUE  + "" + ChatColor.BOLD + "Jump";
				ItemStack icon = new ItemStack(Material.LAPIS_BLOCK);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 5)
			      {
				String text = ChatColor.RED + "" + ChatColor.BOLD + "Regeneration";
				ItemStack icon = new ItemStack(Material.APPLE);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 6)
			      {
				String text = ChatColor.DARK_GREEN  + "" + ChatColor.BOLD + "Poison";
				ItemStack icon = new ItemStack(Material.POISONOUS_POTATO);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 7)
			      {
				String text = ChatColor.DARK_GRAY  + "" + ChatColor.BOLD + "???";
				ItemStack icon = new ItemStack(Material.WEB);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 8)
			      {
				String text = ChatColor.GRAY  + "" + ChatColor.BOLD + "INVISIBILITY";
				ItemStack icon = new ItemStack(Material.CARPET);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 9)
			      {
				String text = ChatColor.DARK_RED  + "" + ChatColor.BOLD + "Harm";
				ItemStack icon = new ItemStack(Material.SPIDER_EYE);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.HARM, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 10)
			      {
				String text = ChatColor.DARK_GRAY  + "" + ChatColor.BOLD + "Weakness";
				ItemStack icon = new ItemStack(Material.STONE);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 11)
			      {
				String text = ChatColor.RED  + "" + ChatColor.BOLD + "???";
				ItemStack icon = new ItemStack(Material.REDSTONE);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 12)
			      {
				String text = ChatColor.RED  + "" + ChatColor.BOLD + "???";
				ItemStack icon = new ItemStack(Material.REDSTONE);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, getConfig().getInt("effect-time") * 20, 0));
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 13)
			      {
				String text = ChatColor.RED  + "" + ChatColor.BOLD + "???";
				ItemStack icon = new ItemStack(Material.REDSTONE);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.setHealth(22);
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 14)
			      {
				String text = ChatColor.RED  + "" + ChatColor.BOLD + "???";
				ItemStack icon = new ItemStack(Material.REDSTONE);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.setHealth(25);
				        hologram.delete();

				    }
				});
		  }
			      if (rr == 13)
			      {
				String text = ChatColor.RED  + "" + ChatColor.BOLD + "???";
				ItemStack icon = new ItemStack(Material.REDSTONE);

				final Hologram hologram = (Hologram) HologramsAPI.createHologram(this, loc.add(0.0, 0.6, 0.0));
				hologram.appendTextLine(text);
				ItemLine itemLine = hologram.appendItemLine(icon);

				itemLine.setPickupHandler(new PickupHandler() { 

				    @Override
				    public void onPickup(Player p) {

				        
				        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, null);
				        p.setMaxHealth(2);
				        hologram.delete();
				        

				    }
				});
		  }
			             
			    }
		  
			    
		}
	}
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent e){
		e.getPlayer().setMaxHealth(20);
	}
	@EventHandler
	public void PlayerRespawn(PlayerRespawnEvent e){
		e.getPlayer().setMaxHealth(20);
	}
	@EventHandler
	public void PlayerHeartDeath(PlayerDeathEvent e){
		e.getEntity().getPlayer().setMaxHealth(20);
	}
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
		     Player p = (Player)sender;
	    if ((cmd.getName().equalsIgnoreCase("hp")) && 
	    	(args.length == 0) || (cmd.getName().equalsIgnoreCase("HolographicPower") && (args.length == 0)))
	        {
	    	p.sendMessage("&8&m                                   ".replace("&", "§"));
	    	p.sendMessage("&c@MarkoCZ".replace("&", "§"));
	    	p.sendMessage("&c@Version : &e1.0.7".replace("&", "§"));
	    	p.sendMessage("&8&m                                   ".replace("&", "§"));
	          return true;
	        }
	    else if (args[0].equalsIgnoreCase("reload") && p.isOp()){
	    	reloadConfig();
	    	p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a[Holographic-Powerup] Config Loaded!"));
	  }else{
		 
	  }
			
		  
		  
	  
     return true;
}
}
