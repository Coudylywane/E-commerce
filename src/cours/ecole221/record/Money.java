package cours.ecole221.record;
import cours.ecole221.exeptions.CurrencyMismatchException;
import cours.ecole221.exeptions.InvalidCurrencyException;

import java.math.BigDecimal;
import java.util.Objects;

public record Money(BigDecimal amount, String currency) {
    public Money {
        Objects.requireNonNull(amount, "Amount cannot be null");
        Objects.requireNonNull(currency, "Currency cannot be null");

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        if (!currency.equals("FCFA") && !currency.equals("EUR") && !currency.equals("XOF")){
            throw new InvalidCurrencyException("Currency must be FCFA or EUR or XOF ");
        }
    }
    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot add different currencies");
        }
        return new Money(this.amount.add(other.amount), this.currency);
    }

    public boolean isLessThan(Money other) {
        verifierMemeDevise(other);
        return this.amount.compareTo(other.amount) < 0;
    }

    private void verifierMemeDevise(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new CurrencyMismatchException(
                    "Les devises sont différentes"
            );
        }
    }

    public Money subtract(Money other) {
        verifierMemeDevise(other);
        return new Money(
                this.amount.subtract(other.amount),
                this.currency
        );
    }
}
