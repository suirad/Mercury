package vg.civcraft.mc.mercury.config;

import java.io.File;

public class MercuryConfigManager {
	public static void initialize() {
		if (MercuryConfigManager.inBukkit()) {
			config_ = new BukkitConfiguration();
		} else {
			File file = new File("mercury_cfg.json");
			if (!file.exists()) {
				JsonConfiguration c = new JsonConfiguration(file.getName());
				c.save(file);
				config_ = c;
			}
			else
				config_ = JsonConfiguration.load(file);
		}
	}

	public static String getHost(){
		return config_.getHost();
	}
	
	public static String getUserName(){
		return config_.getUserName();
	}

	public static String getPassword(){
		return config_.getPassword();
	}

	public static Integer getPort(){
		return config_.getPort();
	}

	public static String getServerName(){
		return config_.getServerName();
	}

	public static String getServiceHandler(){
		return config_.getServiceHandler();
	}

	public static boolean inBukkit() {
		if (MercuryConfigManager.inBukkit_ != null) {
			return inBukkit_.booleanValue();
		}
		try {
			Class.forName("org.bukkit.Bukkit");
			inBukkit_ = new Boolean(true);
			return true;
		} catch(ClassNotFoundException ex) {
			inBukkit_ = new Boolean(false);
			return false;
		}
	}

	private static Configuration config_ = null;
	private static Boolean inBukkit_ = null;
}
