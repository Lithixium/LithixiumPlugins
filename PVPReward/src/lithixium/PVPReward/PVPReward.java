package lithixium.PVPReward;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.iConomy.iConomy;

public class PVPReward extends JavaPlugin{
	public iConomy iConomy = null;
	public String enabledstartup = "Enabled on Startup";
	public boolean enabled;
	ConfigFile configFile = new ConfigFile(this);
	private final EntityListener entityListener = new PVPEntityListener(this);
	Logger log = Logger.getLogger("Minecraft");
	public static double moneyamount;
	public void onDisable() {}

	public void onEnable() {
		configFile.configCheck();
		PluginManager pm = getServer().getPluginManager();
		getServer().getPluginManager().registerEvent(Event.Type.ENTITY_DEATH, this.entityListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLUGIN_ENABLE, new iConomyHook(this), Priority.Monitor, this);
		pm.registerEvent(Event.Type.PLUGIN_DISABLE, new iConomyHook(this), Priority.Monitor, this);
		log.info(getDescription().getName() + " " + getDescription().getVersion() + " is now enabled!");
	}

}
