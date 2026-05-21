package cours.ecole221.models;

import cours.ecole221.record.Money;
import cours.ecole221.record.SKU;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

//public class Product {
//    private final UUID id;
//    private final SKU sku;
//    private final String name;
//    private Money price;
//    private int quantityInStock;
//
//    private int reorderThreshold;
//
//    public Product(SKU sku, String name, Money price) {
//        this.id = UUID.randomUUID();
//        this.sku = Objects.requireNonNull(sku, "SKU cannot be null");
//        if (name == null || name.isBlank()) {
//            throw new IllegalArgumentException("Name cannot be empty");
//        }
//        this.name = name;
//        this.price = Objects.requireNonNull(price, "Price cannot be null");
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public SKU getSku() {
//        return sku;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Money getPrice() {
//        return price;
//    }
//
//    public void applyDiscount(BigDecimal percentage) {
//        Objects.requireNonNull(percentage, "Percentage cannot be null");
//
//        if (percentage.compareTo(BigDecimal.valueOf(0.1)) < 0 ||
//                percentage.compareTo(BigDecimal.valueOf(100)) > 0) {
//            throw new IllegalArgumentException("Percentage must be between 0.1 and 100");
//        }
//
//        BigDecimal discount = price.amount()
//                .multiply(percentage)
//                .divide(BigDecimal.valueOf(100));
//
//        BigDecimal newAmount = price.amount().subtract(discount);
//
//        this.price = new Money(newAmount, price.currency());
//    }
//
//
//        public Product(
//                SKU sku,
//                String name,
//                String description,
//                Money price,
//                int reorderThreshold
//        ) {
//
//            if(name == null || name.isBlank()) {
//                throw new IllegalArgumentException(
//                        "Nom obligatoire"
//                );
//            }
//
//            this.sku = sku;
//            this.name = name;
//            this.description = description;
//            this.price = price;
//            this.reorderThreshold = reorderThreshold;
//
//            this.quantityInStock = 0;
//        }
//
//        // Ajouter stock
//        public void addStock(int quantity) {
//
//            if(quantity <= 0) {
//                throw new IllegalArgumentException(
//                        "Quantité invalide"
//                );
//            }
//
//            quantityInStock += quantity;
//        }
//
//        // Retirer stock
//        public void removeStock(int quantity) {
//
//            if(quantity <= 0) {
//                throw new IllegalArgumentException(
//                        "Quantité invalide"
//                );
//            }
//
//            // Invariance métier DDD
//            if(quantityInStock - quantity < 0) {
//
//                throw new IllegalStateException(
//                        "Stock insuffisant"
//                );
//            }
//
//            quantityInStock -= quantity;
//        }
//
//        public boolean needsRestock() {
//
//            return quantityInStock <= reorderThreshold;
//        }
//
//        public int getQuantityInStock() {
//            return quantityInStock;
//        }
//    }
//}

public class Product {

    private SKU sku;
    private String name;
    private String description;
    private Money price;

    private int quantityInStock;

    private int reorderThreshold;

        public String getName() {
        return name;
    }



    public Product(
            SKU sku,
            String name,
            String description,
            Money price,
            int reorderThreshold
    ) {

        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Nom obligatoire"
            );
        }

        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.reorderThreshold = reorderThreshold;

        this.quantityInStock = 0;
    }

    // Ajouter stock
    public void addStock(int quantity) {

        if(quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantité invalide"
            );
        }

        quantityInStock += quantity;
    }

    // Retirer stock
    public void removeStock(int quantity) {

        if(quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantité invalide"
            );
        }

        // Invariance métier DDD
        if(quantityInStock - quantity < 0) {

            throw new IllegalStateException(
                    "Stock insuffisant"
            );
        }

        quantityInStock -= quantity;
    }

    public boolean needsRestock() {

        return quantityInStock <= reorderThreshold;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }
}
