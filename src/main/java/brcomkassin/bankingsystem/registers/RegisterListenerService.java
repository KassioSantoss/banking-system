package brcomkassin.bankingsystem.registers;

import brcomkassin.bankingsystem.BankingSystemPlugin;
import brcomkassin.bankingsystem.bankaccount.BankAccountService;
import brcomkassin.bankingsystem.cache.BankAccountCache;
import brcomkassin.bankingsystem.inventory.BankInventoryManager;
import brcomkassin.bankingsystem.listeners.ClickBankAccountMenuListener;
import brcomkassin.bankingsystem.listeners.OpenBankAccountMenuListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class RegisterListenerService implements Register {

    private final BankingSystemPlugin plugin;
    private final Listener clickMenuListener;
    private final Listener openMenuListener;

    public RegisterListenerService(BankingSystemPlugin plugin, BankInventoryManager inventoryManager, BankAccountCache bankAccountCache, BankAccountService bankAccountService) {
        this.plugin = plugin;
        this.clickMenuListener = new ClickBankAccountMenuListener(bankAccountService);
        this.openMenuListener = new OpenBankAccountMenuListener(bankAccountCache, inventoryManager);
    }

    @Override
    public void load() {
        Bukkit.getPluginManager().registerEvents(clickMenuListener, plugin);
        Bukkit.getPluginManager().registerEvents(openMenuListener, plugin);
    }

}
