package brcomkassin.bankingsystem.cache;

import brcomkassin.bankingsystem.bankaccount.BankAccount;
import org.bukkit.entity.Player;

public interface BankAccountCache {

    BankAccount getAccount(String owner);

    boolean hasAccount(Player player);

    void addAccount(String owner, BankAccount bankAccount);

    void removeAccount(String owner);

}
