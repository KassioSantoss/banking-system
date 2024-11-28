package brcomkassin.bankingsystem;

import brcomkassin.bankingsystem.commands.RegisterCommandManager;
import lombok.Getter;
import lombok.SneakyThrows;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class BankingSystemPlugin extends JavaPlugin {

    @Getter
    private static BankingSystemPlugin instance;
    @Getter
    private static Economy economy;
    private final RegisterCommandManager bankAccountCommandManager = new RegisterCommandManager(this);
    @Getter
    private final Config config = new Config(this, "config");

    @Override
    public void onLoad() {
        instance = this;
    }

    @SneakyThrows
    @Override
    public void onEnable() {
        if (!setupEconomy()) {
            getLogger().severe("Vault não encontrado ou não há um plugin de economia ativo!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getLogger().info("Vault integrado com sucesso!");
        config.saveAndReloadDefaultConfig();
        bankAccountCommandManager.loadAllCommands();
    }

    @SneakyThrows
    @Override
    public void onDisable() {
        config.saveConfig();
    }

    public boolean setupEconomy() {
        RegisteredServiceProvider<Economy> provider = getServer().getServicesManager().getRegistration(Economy.class);
        if (provider == null) {
            return false;
        }
        economy = provider.getProvider();
        return true;
    }

}
