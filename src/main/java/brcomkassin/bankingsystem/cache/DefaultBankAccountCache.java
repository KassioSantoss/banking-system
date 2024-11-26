package brcomkassin.bankingsystem.cache;

import brcomkassin.bankingsystem.bankaccount.BankAccount;

import java.util.HashMap;
import java.util.Map;

public class DefaultBankAccountCache implements BankAccountCache {

    private final Map<String, BankAccount> cache = new HashMap<>();

    @Override
    public BankAccount getAccount(String owner) {
        return cache.get(owner);
    }

    @Override
    public void addAccount(String owner, BankAccount bankAccount) {
        cache.put(owner, bankAccount);
    }

}
