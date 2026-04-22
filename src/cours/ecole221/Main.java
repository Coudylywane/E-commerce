package cours.ecole221;

import cours.ecole221.models.Product;
import cours.ecole221.record.Money;
import cours.ecole221.record.SKU;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        try {
            SKU sku = new SKU("TEC-43256");
            Money price = new Money(new BigDecimal("150000"), "FCFA");

            Product product = new Product(sku, "TV", price);
            String message = "Produit créé : "
                    + product.getName()
                    + " | Prix : " + product.getPrice().amount()
                    + " " + product.getPrice().currency();
            System.out.println(message);

            // réduction
            product.applyDiscount(new BigDecimal("15"));
            System.out.println("Prix après réduction : " + product.getPrice());

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
