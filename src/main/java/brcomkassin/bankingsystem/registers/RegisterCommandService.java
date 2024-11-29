package brcomkassin.bankingsystem.registers;

import brcomkassin.bankingsystem.BankingSystemPlugin;
import brcomkassin.bankingsystem.bankaccount.BankAccountService;
import brcomkassin.bankingsystem.bankaccount.DefaultBankAccountService;
import brcomkassin.bankingsystem.cache.BankAccountCache;
import brcomkassin.bankingsystem.cache.DefaultBankAccountCache;
import brcomkassin.bankingsystem.commands.BankAccountCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class RegisterCommandService implements Register {

    private final BankAccountService bankAccountService;
    private final BankingSystemPlugin plugin;

    public RegisterCommandService(BankingSystemPlugin plugin, BankAccountService bankAccountService) {
        this.plugin = plugin;
        this.bankAccountService = bankAccountService;
    }

    @Override
    public void load() {
        plugin.getCommand("account").setExecutor(new BankAccountCommand(bankAccountService));
    }

}
