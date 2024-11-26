package brcomkassin.bankingsystem.commands;

import brcomkassin.bankingsystem.BankingSystemPlugin;
import brcomkassin.bankingsystem.bankaccount.DefaultBankAccountService;
import brcomkassin.bankingsystem.cache.BankAccountCache;
import brcomkassin.bankingsystem.cache.DefaultBankAccountCache;

public class BankAccountCommandManager {

    private final BankingSystemPlugin plugin;
    private final BankAccountCache bankAccountCache = new DefaultBankAccountCache();
    private final DefaultBankAccountService bankAccountService = new DefaultBankAccountService(bankAccountCache);

    public BankAccountCommandManager(BankingSystemPlugin plugin) {
        this.plugin = plugin;
    }

    public void loadAllCommands(){
        plugin.getCommand("account").setExecutor(new BankAccountCommand(bankAccountService));
    }


}
