package brcomkassin.bankingsystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BankAccountCommand implements CommandExecutor {

    private final BankAccount bankAccount;

    public BankAccountCommand(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) return true;

        switch (args[0]) {
            case "create":
                bankAccount.create();
                break;
        }

        return false;
    }
}
