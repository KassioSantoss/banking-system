package brcomkassin.bankingsystem;

import brcomkassin.bankingsystem.bankaccount.BankAccountService;
import brcomkassin.bankingsystem.bankaccount.DefaultBankAccountService;
import brcomkassin.bankingsystem.cache.BankAccountCache;
import brcomkassin.bankingsystem.cache.DefaultBankAccountCache;
import brcomkassin.bankingsystem.commands.BankAccountCommand;
import brcomkassin.bankingsystem.commands.BankAccountCommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class BankingSystemPlugin extends JavaPlugin {

    @Getter
    private static BankingSystemPlugin instance;
    private final BankAccountCommandManager bankAccountCommandManager = new BankAccountCommandManager(this);

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        bankAccountCommandManager.loadAllCommands();
    }

    @Override
    public void onDisable() {

    }

}
