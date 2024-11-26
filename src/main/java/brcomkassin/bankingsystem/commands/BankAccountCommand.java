package brcomkassin.bankingsystem.commands;

import brcomkassin.bankingsystem.bankaccount.BankAccount;
import brcomkassin.bankingsystem.bankaccount.BankAccountService;
import brcomkassin.bankingsystem.bankaccount.DefaultBankAccountService;
import brcomkassin.bankingsystem.cache.BankAccountCache;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BankAccountCommand implements CommandExecutor {

    private final BankAccountService bankAccountService;

    public BankAccountCommand(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return true;

        switch (args[0]) {
            case "create":
                bankAccountService.create(player);
                break;
        }

        return false;
    }

}