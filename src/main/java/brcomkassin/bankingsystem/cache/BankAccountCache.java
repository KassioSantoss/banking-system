package brcomkassin.bankingsystem.cache;

import brcomkassin.bankingsystem.bankaccount.BankAccount;

public interface BankAccountCache {

    BankAccount getAccount(String owner);

    void addAccount(String owner,BankAccount bankAccount);

}
