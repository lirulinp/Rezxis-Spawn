package mcms.pypj0208.rezxisspawn;

import mcms.pypj0208.rezxisspawn.commands.SetSpawnCMD;
import mcms.pypj0208.rezxisspawn.commands.SpawnCMD;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class RezxisSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("RezxisSpawn has enabled!");

        getCommand("setspawn").setExecutor(new SetSpawnCMD(this));
        getCommand("spawn").setExecutor(new SpawnCMD(this));

        loadconfig();
    }

    @Override
    public void onDisable() {
        System.out.println("RezxisSpawn has disabled!");
    }

    public void loadconfig() {
        FileConfiguration cfg = this.getConfig();
        cfg.options().copyDefaults(true);

        this.saveConfig();
    }
}