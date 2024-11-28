package brcomkassin.bankingsystem.commands;

import brcomkassin.bankingsystem.BankingSystemPlugin;
import brcomkassin.bankingsystem.bankaccount.DefaultBankAccountService;
import brcomkassin.bankingsystem.cache.BankAccountCache;
import brcomkassin.bankingsystem.cache.DefaultBankAccountCache;

public final class RegisterCommandManager {

    private final BankingSystemPlugin plugin;
    private static RegisterCommandManager instance;
    private final BankAccountCache bankAccountCache = new DefaultBankAccountCache();
    private final DefaultBankAccountService bankAccountService = new DefaultBankAccountService(bankAccountCache);

    public RegisterCommandManager(BankingSystemPlugin plugin) {
        this.plugin = plugin;
    }

    public void loadAllCommands() {
        plugin.getCommand("account").setExecutor(new BankAccountCommand(bankAccountService));
    }

}
