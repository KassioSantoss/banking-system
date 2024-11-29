package brcomkassin.bankingsystem.inventory;

import brcomkassin.bankingsystem.BankingSystemPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BankInventoryManager {

    private final BankInventoryFactory factory;

    public BankInventoryManager(BankInventoryFactory factory) {
        this.factory = factory;
    }

    public void openBankMenu(Player player, boolean hasAccount) {
        if (hasAccount) {
            Economy economy = BankingSystemPlugin.getEconomy();
            Inventory homePageWithAccount = factory.createHomePageWithAccount(economy.getBalance(player));
            player.openInventory(homePageWithAccount);
            return;
        }
        Inventory homePageWithoutAccount = factory.createHomePageWithoutAccount();
        player.openInventory(homePageWithoutAccount);
    }

}
