package lithixium.PVPReward;

import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerListener;
import org.bukkit.plugin.Plugin;
import com.iConomy.*;

public class iConomyHook extends ServerListener {
	private PVPReward plugin;
	public iConomyHook(PVPReward plugin) {
		this.plugin = plugin;
	}
	public void onPluginDisable(PluginDisableEvent event) {
		if(plugin.iConomy != null) {
			if (event.getPlugin().getDescription().getName().equals("iConomy")) {
				plugin.iConomy = null;
				System.out.println("[PVPRewards] iConomy Released!");
			}
		}
	}
	public void onPluginEnable(PluginEnableEvent event) {
		if (plugin.iConomy == null) {
			Plugin iConomy = plugin.getServer().getPluginManager().getPlugin("iConomy");
			if (iConomy != null) {
				if (iConomy.isEnabled() && iConomy.getClass().getName().equals("com.iConomy.iConomy")) {
					plugin.iConomy = (iConomy)iConomy;
					System.out.println("[PVPRewards] iConomy Found!");
					
				}
			}
		}
	}
}
