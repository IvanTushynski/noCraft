package nocraft.nocraft;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().clearRecipes();
        Bukkit.getPluginManager().registerEvents(new fallDamage(), this);
        Bukkit.getPluginManager().registerEvents(new AirLevel(), this);
        Bukkit.getPluginManager().registerEvents(new FoodLevel(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        getCommand("teaderonlottery").setExecutor(new Lottery());
        Lottery.init();
    }

    @Override
    public void onDisable() {
    }
}
