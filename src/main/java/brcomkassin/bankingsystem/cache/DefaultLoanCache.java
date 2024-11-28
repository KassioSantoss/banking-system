package brcomkassin.bankingsystem.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DefaultLoanCache implements LoanCache {

    private final Map<UUID, Double> cache;

    public DefaultLoanCache() {
        this.cache = new HashMap<>();
    }

    @Override
    public double getValue(UUID uuid) {
        return cache.getOrDefault(uuid, 0.0);
    }

    @Override
    public void addLoan(UUID uuid, double value) {
        cache.put(uuid, value);
    }

}
