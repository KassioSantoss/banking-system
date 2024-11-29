package brcomkassin.bankingsystem.registers;

import brcomkassin.bankingsystem.BankingSystemPlugin;
import brcomkassin.bankingsystem.bankaccount.BankAccountService;
import brcomkassin.bankingsystem.bankaccount.DefaultBankAccountService;
import brcomkassin.bankingsystem.cache.BankAccountCache;
import brcomkassin.bankingsystem.cache.DefaultBankAccountCache;
import brcomkassin.bankingsystem.inventory.BankInventoryFactory;
import brcomkassin.bankingsystem.inventory.BankInventoryManager;
import lombok.Getter;

@Getter
public class RegisterServiceManager {

    private final BankingSystemPlugin plugin;
    private final BankAccountCache bankAccountCache;
    private final BankAccountService bankAccountService;
    private final BankInventoryManager manager;

    public RegisterServiceManager(BankingSystemPlugin plugin) {
        this.plugin = plugin;
        this.manager = new BankInventoryManager(new BankInventoryFactory());
        this.bankAccountCache = new DefaultBankAccountCache();
        this.bankAccountService = new DefaultBankAccountService(bankAccountCache);
    }

    public RegisterCommandService createCommandService() {
        return new RegisterCommandService(plugin, bankAccountService);
    }

    public RegisterListenerService createListenerService() {
        return new RegisterListenerService(plugin, manager, bankAccountCache, bankAccountService);
    }

}
