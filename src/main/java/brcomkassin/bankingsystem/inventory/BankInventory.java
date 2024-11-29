package brcomkassin.bankingsystem.inventory;


import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public record BankInventory(Inventory inventory) {

    public final static Inventory HOME_PAGE_WITHOUT_ACCOUNT = createInventory("Página Incial", 45);
    public final static Inventory HOME_PAGE_WITH_ACCOUNT = createInventory("Página Incial", 45);

    private static Inventory createInventory(String name, int size) {
        return Bukkit.createInventory(null, size, name);
    }

}
