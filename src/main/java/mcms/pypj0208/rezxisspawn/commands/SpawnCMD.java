package mcms.pypj0208.rezxisspawn.commands;

import mcms.pypj0208.rezxisspawn.RezxisSpawn;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {
    private RezxisSpawn plugin;

    public SpawnCMD(RezxisSpawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
            if ((sender instanceof Player)) {
                if (args.length == 0) {
                    Location location = (Location) plugin.getConfig().get("Spawn.Location");
                    player.teleport(location);
                    player.sendMessage(ChatColor.GREEN + "Spawn地点へテレポートしました");
                } else {
                    player.sendMessage(ChatColor.GOLD + "使用方法: " + ChatColor.GREEN + "/spawn");
                }
            } else {
                sender.sendMessage("コンソールからは使用できません");
            }
        return false;
    }
}