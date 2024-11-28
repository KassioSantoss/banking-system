package brcomkassin.bankingsystem.loan;

import brcomkassin.bankingsystem.cache.LoanCache;
import org.bukkit.entity.Player;

public class DefaultLoanService implements LoanService {

    private final LoanCache loanCache;

    public DefaultLoanService(LoanCache loanCache) {
        this.loanCache = loanCache;
    }


    @Override
    public void setLoanAmount(Player player, double value) {
        if (hasPendingIssues(player)) return;

        loanCache.addLoan(player.getUniqueId(), value);
        player.sendMessage("O emprestimo no valor de: " + value + " foi efetuado com sucesso!");
    }

    @Override
    public boolean hasPendingIssues(Player player) {
        if (loanCache.getValue(player.getUniqueId()) > 0) {
            player.sendMessage("Voce possui uma pendencia ativa!");
            return true;
        }
        return false;
    }


}
