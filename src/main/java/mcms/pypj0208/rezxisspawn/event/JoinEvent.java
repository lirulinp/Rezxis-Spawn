package mcms.pypj0208.rezxisspawn.event;

import mcms.pypj0208.rezxisspawn.RezxisSpawn;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinEvent implements Listener {
    private RezxisSpawn plugin;

    public JoinEvent(RezxisSpawn plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location location = (Location) plugin.getConfig().get("Spawn.Location");
        player.teleport(location);
    }
}