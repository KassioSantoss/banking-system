package brcomkassin.bankingsystem.listeners;

import brcomkassin.bankingsystem.BankingSystemPlugin;
import brcomkassin.bankingsystem.bankaccount.BankAccountService;
import brcomkassin.bankingsystem.bankaccount.DefaultBankAccountService;
import brcomkassin.bankingsystem.cache.BankAccountCache;
import brcomkassin.bankingsystem.inventory.BankInventoryFactory;
import brcomkassin.bankingsystem.inventory.BankInventoryManager;
import brcomkassin.bankingsystem.utils.Config;
import brcomkassin.bankingsystem.inventory.BankInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.map.MapView;

public class OpenBankAccountMenuListener implements Listener {

    private final Config config = BankingSystemPlugin.getInstance().getConfig();
    private final BankAccountCache bankAccountCache;
    private final BankInventoryManager bankInventoryManager;

    public OpenBankAccountMenuListener(BankAccountCache bankAccountCache, BankInventoryManager bankInventoryManager) {
        this.bankInventoryManager = bankInventoryManager;
        this.bankAccountCache = bankAccountCache;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

        if (itemInMainHand == null || itemInMainHand.getType() == Material.AIR) return;

        String itemInMainHandName = itemInMainHand.getType().name();
        String itemID = config.getString("item.ID");
        player.sendMessage("itemId: " + itemInMainHandName);

        if (!itemInMainHandName.equals(itemID)) return;

        if (bankAccountCache.hasAccount(player)) {
            bankInventoryManager.openBankMenu(player, true);
            return;
        }
        bankInventoryManager.openBankMenu(player, false);
    }

}
