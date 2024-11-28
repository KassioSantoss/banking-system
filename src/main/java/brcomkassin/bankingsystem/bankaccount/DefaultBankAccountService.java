package brcomkassin.bankingsystem.bankaccount;

import brcomkassin.bankingsystem.cache.BankAccountCache;
import org.bukkit.entity.Player;

public final class DefaultBankAccountService implements BankAccountService {

    private final BankAccountCache bankAccountCache;

    public DefaultBankAccountService(BankAccountCache bankAccountCache) {
        this.bankAccountCache = bankAccountCache;
    }

    @Override
    public void create(Player player) {
        if (bankAccountCache.hasAccount(player)) {
            player.sendMessage("Voce já possui uma conta!");
            return;
        }

        BankAccount bankAccount = new BankAccount();
        String owner = player.getName();
        bankAccountCache.addAccount(owner, bankAccount);
        bankAccount.setOwner(owner);
        bankAccount.setValue(0);
        player.sendMessage("Voce criou uma conta!");
    }

    @Override
    public void remove(Player player) {
        bankAccountCache.removeAccount(player.getName());
    }

}
