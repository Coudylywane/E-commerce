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

        System.out.println("----------- TESTS INVALIDES -----------");

        //  SKU invalide
        try {
            new SKU("rtguyg");
        } catch (Exception e) {
            System.out.println("SKU invalide bloqué ✔️");
        }

        //  Devise invalide
        try {
            new Money(new BigDecimal("100"), "USD");
        } catch (Exception e) {
            System.out.println("Devise invalide bloquée ✔️");
        }

        //  Montant négatif
        try {
            new Money(new BigDecimal("-50"), "FCFA");
        } catch (Exception e) {
            System.out.println("Montant négatif bloqué ✔️");
        }

        //  Nom vide
        try {
            new Product(new SKU("TEC-1234"), "", new Money(new BigDecimal("100"), "FCFA"));
        } catch (Exception e) {
            System.out.println("Nom vide bloqué ✔️");
        }

        // Addition de devises différentes
        try {
            Money m1 = new Money(new BigDecimal("100"), "EUR");
            Money m2 = new Money(new BigDecimal("50"), "FCFA");
            m1.add(m2);
        } catch (Exception e) {
            System.out.println("Addition devises bloquée ✔️");
        }
    }
}
