package lithixium.PVPReward;

import java.io.File;
import java.util.List;

import org.bukkit.util.config.Configuration;
@SuppressWarnings("unused")
public class ConfigFile {
	private static PVPReward plugin;
	public ConfigFile(PVPReward instance) {
		plugin = instance;
	}
	public String dir = "plugins" + File.separator + "PVPReward";
	File configFile = new File(dir + File.separator + "config.yml");
	
	public void configCheck() {
		new File(dir).mkdir();
		if(!configFile.exists()) {
			try {
				configFile.createNewFile();
				addDefaults();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			} else {
				loadKeys();
			}
		}
	private void write(String root, Object x) {
		Configuration configF = load();
		configF.setProperty(root, x);
		configF.save();
	}
	private Boolean readBoolean(String root) {
		Configuration configF = load();
		return configF.getBoolean(root, true);
	}
	private Double readDouble(String root) {
		Configuration configF = load();
		return configF.getDouble(root, 0);
	}
	private List<String> readStringList (String root) {
		Configuration configF = load();
		return configF.getKeys(root);
	}
	private String readString(String root) {
		Configuration configF = load();
		return configF.getString(root);
	}
	private Configuration load() {
		try{
			Configuration configF = new Configuration(configFile);
			configF.load();
			return configF;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private void addDefaults() {
		plugin.log.info("[PVPReward] Generating default configuration file....");
		write("money-amount", 5);
		loadKeys();
}

	private void loadKeys() {
		plugin.log.info("[PVPReward] Loading config file...");
		PVPReward.moneyamount = readDouble("money-amount");
	}
}