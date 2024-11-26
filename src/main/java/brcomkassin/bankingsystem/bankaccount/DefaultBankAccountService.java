package brcomkassin.bankingsystem.bankaccount;

import brcomkassin.bankingsystem.cache.BankAccountCache;
import org.bukkit.entity.Player;

public class DefaultBankAccountService implements BankAccountService {

    private final BankAccountCache bankAccountCache;

    public DefaultBankAccountService(BankAccountCache bankAccountCache) {
        this.bankAccountCache = bankAccountCache;
    }

    @Override
    public void create(Player player) {
        BankAccount bankAccount = new BankAccount();
        bankAccountCache.addAccount(player.getName(), bankAccount);
        player.sendMessage("Voce criou uma conta!");
    }

}
