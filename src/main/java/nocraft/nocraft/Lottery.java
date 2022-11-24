package nocraft.nocraft;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.RegisteredServiceProvider;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public class Lottery implements CommandExecutor {

    private void executeCommand(Player p, boolean console, String cmd) {
        CommandSender sender = p;
        if (console) sender = getServer().getConsoleSender();
        getServer().dispatchCommand(sender, ChatColor.translateAlternateColorCodes('&', cmd.replaceAll("%player%", p.getName())));
    }

    public static Economy eco;

    public static void init() {
        RegisteredServiceProvider<Economy> reg = Bukkit.getServicesManager().getRegistration(Economy.class);
        if (reg != null) {
            eco = reg.getProvider();
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (eco == null) {
                getLogger().info(ChatColor.DARK_RED + "Connect To Vault Failed!!!");
                return true;
            }
            //Лотерея---------------------------------------
            Player player = (Player) sender;
                int[] exp = new int[100];
                int check = (int) Math.floor(Math.random() * exp.length);
                if (check >= 0 && check <= 30) {
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
                    player.sendTitle(ChatColor.RED + "Не Повезло....", ChatColor.RED + "Попробуйте Ещё", 2, 30, 2);
                } else if (check >= 31 && check <= 50) {
                    executeCommand(player, true, "eco give %player% 100");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    player.sendTitle(ChatColor.GOLD + "Ваш Выигрыш Составил 100 Золотых Монет!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
                    //------------------------------
                    Firework firework = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BURST).withFlicker().build());
                    data.setPower(0);
                    firework.setFireworkMeta(data);
                } else if (check >= 51 && check <= 70) {
                    executeCommand(player, true, "mi give CONSUMABLE XP_DROP_LOTTERY %player% 1");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    player.sendTitle(ChatColor.GOLD + "Ваш Выигрыш - Капсула на 1600 Очков Опыта!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
                    //------------------------------
                    Firework firework = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BURST).withFlicker().build());
                    data.setPower(0);
                    firework.setFireworkMeta(data);
                } else if (check >= 71 && check <= 100) {
                    executeCommand(player, true, "mi give CONSUMABLE XP_DROP_LOTTERY_TWO %player% 1");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    player.sendTitle(ChatColor.GOLD + "Ваш Выигрыш - Капсула на 3800 Очков Опыта!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
                    //------------------------------
                    Firework firework = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BURST).withFlicker().build());
                    data.setPower(0);
                    firework.setFireworkMeta(data);
                }
        }
        return true;
    }
}
