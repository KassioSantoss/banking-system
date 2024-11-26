package brcomkassin.bankingsystem;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class BankingSystemPlugin extends JavaPlugin {

    private BankingSystemPlugin instance;
    private final BankAccountService bankAccountService = new BankAccountService();

    @Override
    public void onLoad() {
        this.instance = this;
    }

    @Override
    public void onEnable() {
        getCommand("account").setExecutor(new BankAccountCommand(bankAccountService));
    }

    @Override
    public void onDisable() {

    }
}
