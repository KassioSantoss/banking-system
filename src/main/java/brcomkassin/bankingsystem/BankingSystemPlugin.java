package brcomkassin.bankingsystem;

import brcomkassin.bankingsystem.bankaccount.BankAccountService;
import brcomkassin.bankingsystem.bankaccount.DefaultBankAccountService;
import brcomkassin.bankingsystem.cache.BankAccountCache;
import brcomkassin.bankingsystem.cache.DefaultBankAccountCache;
import brcomkassin.bankingsystem.commands.BankAccountCommand;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class BankingSystemPlugin extends JavaPlugin {

    @Getter
    private static BankingSystemPlugin instance;
    private final BankAccountCache bankAccountCache = new DefaultBankAccountCache();
    private final DefaultBankAccountService bankAccountService = new DefaultBankAccountService(bankAccountCache);

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getCommand("account").setExecutor(new BankAccountCommand(bankAccountService));
    }

    @Override
    public void onDisable() {

    }

}
