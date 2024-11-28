package brcomkassin.bankingsystem.loan;

import org.bukkit.entity.Player;

public interface LoanService {
    void setLoanAmount(Player player, double value);

    boolean hasPendingIssues(Player player);

}
