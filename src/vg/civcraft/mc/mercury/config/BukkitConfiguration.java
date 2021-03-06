package vg.civcraft.mc.mercury.config;

import vg.civcraft.mc.mercury.MercuryPlugin;
import org.bukkit.configuration.ConfigurationSection;

public class BukkitConfiguration implements Configuration {
	public BukkitConfiguration(){}

	@Override
	public String getHost(){
		return config().getString("host", null);
	}

	@Override
	public String getPassword(){
		return config().getString("password", null);
	}

	@Override
	public Integer getPort(){
		int val = config().getInt("port", -1);
		if (val < 0) {
			return null;
		}
		return new Integer(val);
	}
	
	@Override
	public String getUserName() {
		return config().getString("username", "");
	}

	@Override
	public String getServerName(){
		return config().getString("server-name", null);
	}

	@Override
	public String getServiceHandler(){
		return config().getString("service", null);
	}

	private ConfigurationSection config(){
		return MercuryPlugin.instance.getConfig();
	}
}
