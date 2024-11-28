package brcomkassin.bankingsystem.cache;

import java.util.UUID;

public interface LoanCache {
    double getValue(UUID uuid);

    void addLoan(UUID uuid, double value);

}
