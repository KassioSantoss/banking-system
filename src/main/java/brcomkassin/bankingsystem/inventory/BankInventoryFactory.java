package brcomkassin.bankingsystem.inventory;

import brcomkassin.bankingsystem.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BankInventoryFactory {

    public Inventory createHomePageWithoutAccount() {
        Inventory inventory = Bukkit.createInventory(null, 45, "Página Inicial");

        ItemStack createAccountItem = ItemBuilder.of(Material.ANVIL)
                .setName("&aCriar Conta")
                .setLore("&fAperte aqui para criar a sua conta!")
                .build();

        inventory.setItem(22, createAccountItem);
        return inventory;
    }

    public Inventory createHomePageWithAccount(double balance) {
        Inventory inventory = Bukkit.createInventory(null, 45, "Página Inicial");

        ItemStack balanceItem = ItemBuilder.of(Material.ANVIL)
                .setName("&aInformações da conta:")
                .setLore("&fsaldo atual: " + balance)
                .build();

        inventory.setItem(22, balanceItem);
        return inventory;
    }

}
