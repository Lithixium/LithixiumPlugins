package lithixium.PVPReward;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;

import com.iConomy.*;
import com.iConomy.system.Holdings;

public class PVPEntityListener extends EntityListener {
	public static PVPReward plugin;
	public PVPEntityListener(PVPReward instance) {
		plugin = instance;
	}
		@SuppressWarnings("unused")
		public void onEntityDeath(EntityDeathEvent event){
			if(event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent){
			     EntityDamageByEntityEvent nEvent = (EntityDamageByEntityEvent) event.getEntity().getLastDamageCause();
			     if(nEvent.getDamager() instanceof Player && nEvent.getEntity() instanceof Player){
			          Player deadPlayer = (Player) nEvent.getEntity();
			          Player alivePlayer = (Player) nEvent.getDamager();
			          String alivePlayerString = alivePlayer.getName();
			          if(iConomy.hasAccount(alivePlayerString)) {
			        	  Holdings balance = iConomy.getAccount(alivePlayerString).getHoldings();
			        	  balance.add(PVPReward.moneyamount);
			        	  alivePlayer.sendMessage(ChatColor.RED + "You have been awarded " + PVPReward.moneyamount);
			          } else {}
			      }
			   }
			}
	}