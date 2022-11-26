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
                if (check >= 0 && check <= 44) {
                    player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
                    player.sendTitle(ChatColor.RED + "Не Повезло....", ChatColor.RED + "Попробуйте Ещё", 2, 30, 2);
                } else if (check >= 45 && check <= 67) {
                    executeCommand(player, true, "mi give MISCELLANEOUS SILVER_COIN %player% 1");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    player.sendTitle(ChatColor.GOLD + "Ваш Выигрыш - Серебрянная Монета!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
                    //------------------------------
                    Firework firework = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BURST).withFlicker().build());
                    data.setPower(0);
                    firework.setFireworkMeta(data);
                } else if (check >= 68 && check <= 74) {
                    executeCommand(player, true, "mi give CONSUMABLE XP_DROP_LOTTERY %player% 1");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    player.sendTitle(ChatColor.GOLD + "Ваш Выигрыш - Капсула на 1600 Очков Опыта!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
                    //------------------------------
                    Firework firework = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BURST).withFlicker().build());
                    data.setPower(0);
                    firework.setFireworkMeta(data);
                } else if (check >= 75 && check <= 82) {
                    executeCommand(player, true, "mi give MISCELLANEOUS TAVERNCOIN %player% 1");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    player.sendTitle(ChatColor.GOLD + "Ваш Выигрыш - Монета Фреавеллской Таверны!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
                    //------------------------------
                    Firework firework = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BURST).withFlicker().build());
                    data.setPower(0);
                    firework.setFireworkMeta(data);

                } else if (check >= 83 && check <= 88) {
                    executeCommand(player, true, "mi give MISCELLANEOUS TEADERONCOIN %player% 1");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    player.sendTitle(ChatColor.GOLD + "Ваш Выигрыш - Бадж Теадерона!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
                    //------------------------------
                    Firework firework = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BURST).withFlicker().build());
                    data.setPower(0);
                    firework.setFireworkMeta(data);
                } else if (check >= 89 && check <= 94) {
                    executeCommand(player, true, "mi give CONSUMABLE XP_DROP_LOTTERY_TWO %player% 1");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    player.sendTitle(ChatColor.GOLD + "Ваш Выигрыш - Капсула на 3800 Очков Опыта!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
                    //------------------------------
                    Firework firework = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BURST).withFlicker().build());
                    data.setPower(0);
                    firework.setFireworkMeta(data);
                } else if (check >= 95 && check <= 96) {
                    executeCommand(player, true, "mi give MISCELLANEOUS GOLD_COIN1 %player% 1");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    player.sendTitle(ChatColor.GOLD + "Ваш Выигрыш - Золотая Монета!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
                    //------------------------------
                    Firework firework = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BURST).withFlicker().build());
                    data.setPower(0);
                    firework.setFireworkMeta(data);
                } else if (check >= 97 && check <= 98) {
                    executeCommand(player, true, "mi give MATERIAL SUMMONCAT1 %player% 1");
                    player.playSound(player.getLocation(), Sound.MUSIC_DRAGON, 1, 1);
                    player.sendTitle(ChatColor.DARK_RED + "!!!Джекпот - Питомец!!!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
                    //------------------------------
                    Firework firework = player.getPlayer().getWorld().spawn(player.getPlayer().getLocation(), Firework.class);
                    FireworkMeta data = (FireworkMeta) firework.getFireworkMeta();
                    data.addEffects(FireworkEffect.builder().withColor(Color.RED).withColor(Color.ORANGE).with(FireworkEffect.Type.BURST).withFlicker().build());
                    data.setPower(0);
                    firework.setFireworkMeta(data);
                } else if (check >= 99 && check <= 100) {
                    executeCommand(player, true, "give %player% diamond 64");
                    player.playSound(player.getLocation(), Sound.MUSIC_DRAGON, 1, 1);
                    player.sendTitle(ChatColor.DARK_RED + "!!!Джекпот - 64 Алмазов!!!", ChatColor.GOLD + "Поздравляем", 2, 30, 2);
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
///mi give MATERIAL SUMMONCAT1 admin 1