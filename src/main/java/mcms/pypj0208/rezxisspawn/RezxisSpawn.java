package mcms.pypj0208.rezxisspawn;

import mcms.pypj0208.rezxisspawn.commands.SetSpawnCMD;
import mcms.pypj0208.rezxisspawn.commands.SpawnCMD;
import mcms.pypj0208.rezxisspawn.event.JoinEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class RezxisSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RezxisSpawn has enabled!");

        getCommand("setspawn").setExecutor(new SetSpawnCMD(this));
        getCommand("spawn").setExecutor(new SpawnCMD(this));
        getServer().getPluginManager().registerEvents(new JoinEvent(this),this);

        loadconfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("RezxisSpawn has disabled!");
    }

    public void loadconfig() {
        FileConfiguration cfg = this.getConfig();
        cfg.options().copyDefaults(true);

        this.saveConfig();
    }
}