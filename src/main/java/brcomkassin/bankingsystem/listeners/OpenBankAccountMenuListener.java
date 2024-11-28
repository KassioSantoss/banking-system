package brcomkassin.bankingsystem.listeners;

import brcomkassin.bankingsystem.BankingSystemPlugin;
import brcomkassin.bankingsystem.Config;
import brcomkassin.bankingsystem.inventory.BankInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class OpenBankAccountMenuListener implements Listener {

    private final Config config = BankingSystemPlugin.getInstance().getConfig();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        String itemInHandName = event.getItem().getItemMeta().getDisplayName();
        String itemHandle = config.getString("item.display_name.");
        Player player = event.getPlayer();

        if (!itemInHandName.equals(itemHandle)) return;

        player.openInventory(BankInventory.INITIAL_PAGE);

    }

}
