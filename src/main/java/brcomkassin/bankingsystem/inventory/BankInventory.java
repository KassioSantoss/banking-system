package brcomkassin.bankingsystem.inventory;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

@Getter
public record BankInventory(Inventory inventory) {

    public final static Inventory INITIAL_PAGE;

    static {
        INITIAL_PAGE = createInventory("Página Incial", 54);
    }

    private static Inventory createInventory(String name, int size) {
        return Bukkit.createInventory(null, size, name);
    }

}
