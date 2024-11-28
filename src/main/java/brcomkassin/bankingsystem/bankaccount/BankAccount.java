package brcomkassin.bankingsystem.bankaccount;

import brcomkassin.bankingsystem.BankingSystemPlugin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class BankAccount {

    private BankingSystemPlugin plugin;
    private String owner;
    private double value;

}
