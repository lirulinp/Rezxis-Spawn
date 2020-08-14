package mcms.pypj0208.rezxisspawn.commands;

import mcms.pypj0208.rezxisspawn.RezxisSpawn;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCMD implements CommandExecutor{

    private RezxisSpawn plugin;

    public SetSpawnCMD(RezxisSpawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("rezxis.setspawn.use") || player.isOp()) {
            if ((sender instanceof Player)) {
                if (args.length == 0) {
                    plugin.getConfig().addDefault("Spawn.Location", player.getLocation());
                    plugin.getConfig().set("Spawn.Location", player.getLocation());
                    plugin.saveConfig();
                    plugin.loadconfig();
                    player.sendMessage(ChatColor.GREEN + "Spawn地点を設定しました");
                } else {
                    player.sendMessage(ChatColor.GOLD +  "使用方法: §a/setspawn");
                }
            } else {
                sender.sendMessage("コンソールからは使用できません");
            }
        } else {
            player.sendMessage(ChatColor.RED + "このコマンドを使用する権限がありません");
        }
        return false;
    }
}
