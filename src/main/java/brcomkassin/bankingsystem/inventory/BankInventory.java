package brcomkassin.bankingsystem.inventory;


import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public record BankInventory(Inventory inventory) {

    public static String TITLE = "Página Incial";
    public final static Inventory HOME_PAGE_WITHOUT_ACCOUNT = createInventory(TITLE, 45);
    public final static Inventory HOME_PAGE_WITH_ACCOUNT = createInventory(TITLE, 45);

    private static Inventory createInventory(String name, int size) {
        return Bukkit.createInventory(null, size, name);
    }

}
