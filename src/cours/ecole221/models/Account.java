package cours.ecole221.models;

import cours.ecole221.exeptions.InsufficientBalanceException;
import cours.ecole221.record.Money;
import cours.ecole221.record.PhoneNumber;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {

    private final UUID id;
    private final PhoneNumber phoneNumber;

    private Money balance;

    public Account(
            UUID id,
            PhoneNumber phoneNumber,
            String currency
    ) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.balance = new Money(
                BigDecimal.ONE,
                currency
        );
    }

    public UUID id() {
        return id;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

    public Money balance() {
        return balance;
    }

    public void crediter(Money montant) {
        this.balance = this.balance.add(montant);
    }

    public void debiter(Money montant) {
        if (balance.isLessThan(montant)) {
            throw new InsufficientBalanceException(
                    "Solde insuffisant"
            );
        }
        this.balance = balance.subtract(montant);
    }

    public void transfererVers(
            Account destinataire,
            Money montant
    ) {
        this.debiter(montant);
        destinataire.crediter(montant);
    }
}
