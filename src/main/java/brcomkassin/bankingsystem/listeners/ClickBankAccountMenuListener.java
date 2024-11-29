package brcomkassin.bankingsystem.listeners;

import brcomkassin.bankingsystem.bankaccount.BankAccountService;
import brcomkassin.bankingsystem.cache.BankAccountCache;
import brcomkassin.bankingsystem.inventory.BankInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;

public class ClickBankAccountMenuListener implements Listener {

    private final BankAccountService bankAccountService;
    private final BankAccountCache cache;

    public ClickBankAccountMenuListener(BankAccountCache cache, BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
        this.cache = cache;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        InventoryView view = event.getView();
        String title = BankInventory.TITLE;
        Player player = (Player) event.getWhoClicked();

        if (!view.getTitle().equals(title)) return;

        event.setCancelled(true);

        if (!cache.hasAccount(player)) {
            int slot = event.getSlot();

            switch (slot) {
                case 10:
                    bankAccountService.create(player);
                    break;
            }
        }
    }

}
