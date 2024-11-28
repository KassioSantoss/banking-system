package brcomkassin.bankingsystem.cache;

import brcomkassin.bankingsystem.bankaccount.BankAccount;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public final class DefaultBankAccountCache implements BankAccountCache {

    private final Map<String, BankAccount> cache;

    public DefaultBankAccountCache() {
        this.cache = new HashMap<>();
    }

    @Override
    public BankAccount getAccount(String owner) {
        return cache.get(owner);
    }

    @Override
    public boolean hasAccount(Player player) {
        return cache.containsKey(player.getName());
    }

    @Override
    public void addAccount(String owner, BankAccount bankAccount) {
        cache.put(owner, bankAccount);
    }

    @Override
    public void removeAccount(String owner) {
        cache.remove(owner);
    }

}
