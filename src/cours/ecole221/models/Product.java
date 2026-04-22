package cours.ecole221.models;

import cours.ecole221.record.Money;
import cours.ecole221.record.SKU;

import java.util.Objects;
import java.util.UUID;

public class Product {
    private final UUID id;
    private final SKU sku;
    private final String name;
    private Money price;

    public Product(SKU sku, String name, Money price) {
        this.id = UUID.randomUUID();
        this.sku = Objects.requireNonNull(sku, "SKU cannot be null");
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
        this.price = Objects.requireNonNull(price, "Price cannot be null");
    }
}
