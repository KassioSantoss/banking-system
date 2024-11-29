package brcomkassin.bankingsystem;

import brcomkassin.bankingsystem.registers.RegisterServiceManager;
import brcomkassin.bankingsystem.utils.Config;
import lombok.Getter;
import lombok.SneakyThrows;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class BankingSystemPlugin extends JavaPlugin {

    @Getter private static BankingSystemPlugin instance;
    @Getter  private static Economy economy;
    @Getter private final Config config = new Config(this, "config.yml");
    private final RegisterServiceManager registerServiceManager = new RegisterServiceManager(this);

    @Override
    public void onLoad() {
        instance = this;
    }

    @SneakyThrows
    @Override
    public void onEnable() {
        if (!setupEconomy()) return;

        config.saveAndReloadDefaultConfig();
        registerServiceManager.createCommandService().load();
        registerServiceManager.createListenerService().load();
    }

    @SneakyThrows
    @Override
    public void onDisable() {
        config.saveConfig();
    }

    public boolean setupEconomy() {
        RegisteredServiceProvider<Economy> provider = getServer().getServicesManager().getRegistration(Economy.class);
        if (provider == null) {
            getLogger().severe("Vault não encontrado ou não há um plugin de economia ativo!");
            getServer().getPluginManager().disablePlugin(this);
            return false;
        }
        economy = provider.getProvider();
        getLogger().info("Vault integrado com sucesso!");
        return true;
    }

}
