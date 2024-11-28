package brcomkassin.bankingsystem.listeners;

import brcomkassin.bankingsystem.bankaccount.BankAccountService;
import brcomkassin.bankingsystem.inventory.BankInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

public class ClickBankAccountMenuListener implements Listener {

    private final BankAccountService bankAccountService;

    public ClickBankAccountMenuListener(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        InventoryView view = event.getView();
        String title = BankInventory.INITIAL_PAGE.getTitle();
        Player player = (Player) event.getWhoClicked();

        if (!view.getTitle().equals(title)) return;
        int slot = 0;

        switch (slot) {
            case 10:
                bankAccountService.create(player);
        }

    }

}
