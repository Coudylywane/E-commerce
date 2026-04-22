package cours.ecole221.record;
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

        if (!currency.equals("FCFA") && !currency.equals("EUR")) {
            throw new InvalidCurrencyException("Currency must be FCFA or EUR");
        }
    }
    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot add different currencies");
        }

        return new Money(this.amount.add(other.amount), this.currency);
    }
}
