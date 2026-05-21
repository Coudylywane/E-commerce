package cours.ecole221;

import cours.ecole221.interfaces.Validator;
import cours.ecole221.models.*;
import cours.ecole221.record.Money;
import cours.ecole221.record.PhoneNumber;
import cours.ecole221.record.SKU;

import java.util.*;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println();

        List<Product> products = new ArrayList<>();

        Product nike = new Product(
                new SKU("NK-001"),
                "Nike Air",
                "Chaussure Nike",
                new Money(
                        new BigDecimal("45000"),
                        "XOF"
                ),
                5
        );

        Product iphone = new Product(
                new SKU("APL-001"),
                "iPhone 13",
                "Téléphone Apple",
                new Money(
                        new BigDecimal("650000"),
                        "XOF"
                ),
                5
        );

        Product casque = new Product(
                new SKU("CSQ-001"),
                "Casque Bluetooth",
                "Sony",
                new Money(
                        new BigDecimal("25000"),
                        "XOF"
                ),
                5
        );

        products.add(nike);
        products.add(iphone);
        products.add(casque);

        // Ajouter du stock
        nike.addStock(20);
        iphone.addStock(2);
        casque.addStock(4);

        System.out.println("===== STOCK ACTUEL APRES AJOUT =====");

        for(Product product : products) {

            System.out.println(
                    product.getName()
                            + " -> "
                            + product.getQuantityInStock()
            );
        }

        // Vente
        nike.removeStock(7);

        System.out.println("===== STOCK ACTUEL APRES VENTE =====");

        for(Product product : products) {

            System.out.println(
                    product.getName()
                            + " -> "
                            + product.getQuantityInStock()
            );
        }

        // ===================================
        // TEST INVARIANCE STOCK
        // ===================================

        System.out.println("\n===== TEST  =====");

        try {

            casque.removeStock(10);

        } catch (IllegalStateException e) {

            System.out.println(
                    "Erreur : " + e.getMessage()
            );
        }

        // ===================================
        // ALERTES REAPPROVISIONNEMENT
        // ===================================

        System.out.println(
                "\n===== PRODUITS A REAPPROVISIONNER ====="
        );

        for(Product product : products) {

            if(product.needsRestock()) {

                System.out.println(
                        product.getName()
                                + " stock faible : "
                                + product.getQuantityInStock()
                );
            }
        }
    }


//                Product tshirt = new Product(
//                        new SKU("TSHIRT-001"),
//                        "T-Shirt Nike",
//                        "T-shirt noir",
//                        new Money(new BigDecimal("15000"), "XOF"),
//                        5
//                );
//
//                // Ajout de stock
//                tshirt.addStock(10);
//
//                System.out.println("Stock actuel : "
//                        + tshirt.getQuantityInStock());
//
//                // Vente
//                tshirt.removeStock(3);
//
//                System.out.println("Stock après vente : "
//                        + tshirt.getQuantityInStock());
//
//                // Vérification réapprovisionnement
//                System.out.println(
//                        "Besoin de réapprovisionnement ? "
//                                + tshirt.needsRestock()
//                );
//
//                // Cas invalide
//                tshirt.removeStock(20);
//            }


//        Account compte1 = new Account(
//                UUID.randomUUID(),
//                new PhoneNumber("771234567"),
//                "XOF"
//        );
//
//        Account compte2 = new Account(
//                UUID.randomUUID(),
//                new PhoneNumber("+221781112233"),
//                "XOF"
//        );
//
//        compte1.crediter(
//                new Money(
//                        new BigDecimal("5000"),
//                        "XOF"
//                )
//        );
//
//        System.out.println(
//                "Solde compte1 : "
//                        + compte1.balance()
//        );
//
//        // ---------------------------
//        // Transfert valide
//        // ---------------------------
//
//        System.out.println("################### TEST VALIDE #########################");
//
//        compte1.transfererVers(
//                compte2,
//                new Money(
//                        new BigDecimal("2000"),
//                        "XOF"
//                )
//        );
//
//        System.out.println(
//                "Solde compte1 après transfert : "
//                        + compte1.balance()
//        );
//
//        System.out.println(
//                "Solde compte2 après transfert : "
//                        + compte2.balance()
//        );
//
//        // ---------------------------
//        // TEST 1 : montant negatif
//        // ---------------------------
//        System.out.println("################### TEST INVALIDE #########################");
//
//        try {
//
//            Money negatif = new Money(
//                    new BigDecimal("-1000"),
//                    "XOF"
//            );
//
//        } catch (Exception e) {
//            System.out.println(
//                    "Erreur montant négatif : "
//                            + e.getMessage()
//            );
//        }
//
//        // ---------------------------
//        // TEST 2 : devises différentes
//        // ---------------------------
//
//        try {
//            compte1.crediter(
//                    new Money(
//                            new BigDecimal("100"),
//                            "EUR"
//                    )
//            );
//
//        } catch (Exception e) {
//            System.out.println(
//                    "Erreur devise : "
//                            + e.getMessage()
//            );
//        }
//
//        // ---------------------------
//        // TEST 3 : dépassement du solde
//        // ---------------------------
//
//        try {
//
//            compte1.debiter(
//                    new Money(
//                            new BigDecimal("999999"),
//                            "XOF"
//                    )
//            );
//
//        } catch (Exception e) {
//
//            System.out.println(
//                    "Erreur solde : "
//                            + e.getMessage()
//            );
//        }
//    }






//        try {
//            SKU sku = new SKU("TEC-43256");
//            Money price = new Money(new BigDecimal("150000"), "FCFA");
//
//            Product product = new Product(sku, "TV", price);
//            String message = "Produit créé : "
//                    + product.getName()
//                    + " | Prix : " + product.getPrice().amount()
//                    + " " + product.getPrice().currency();
//            System.out.println(message);
//
//            // réduction
//            product.applyDiscount(new BigDecimal("15"));
//            System.out.println("Prix après réduction : " + product.getPrice());
//
//        } catch (Exception e) {
//            System.out.println("Erreur : " + e.getMessage());
//        }
//
//        System.out.println("----------- TESTS INVALIDES -----------");
//
//        //  SKU invalide
//        try {
//            new SKU("rtguyg");
//        } catch (Exception e) {
//            System.out.println("SKU invalide bloqué ✔️");
//        }
//
//        //  Devise invalide
//        try {
//            new Money(new BigDecimal("100"), "USD");
//        } catch (Exception e) {
//            System.out.println("Devise invalide bloquée ✔️");
//        }
//
//        //  Montant négatif
//        try {
//            new Money(new BigDecimal("-50"), "FCFA");
//        } catch (Exception e) {
//            System.out.println("Montant négatif bloqué ✔️");
//        }
//
//        //  Nom vide
//        try {
//            new Product(new SKU("TEC-1234"), "", new Money(new BigDecimal("100"), "FCFA"));
//        } catch (Exception e) {
//            System.out.println("Nom vide bloqué ✔️");
//        }
//
//        // Addition de devises différentes
//        try {
//            Money m1 = new Money(new BigDecimal("100"), "EUR");
//            Money m2 = new Money(new BigDecimal("50"), "FCFA");
//            m1.add(m2);
//        } catch (Exception e) {
//            System.out.println("Addition devises bloquée ✔️");
//        }
//
//
//        // Ex 1
//        Predicate<Integer> isPositive = n -> n > 0;
//        System.out.println(isPositive.test(5));   // true
//        System.out.println(isPositive.test(-3));  // false
//
//
//        // Ex 2
//        Consumer<String> logger = s -> System.out.println("[LOG] " + s.toUpperCase());
//        logger.accept("bonjour"); // [LOG] BONJOUR
//
//        // Ex 3 :
//        Function<String, Integer> doubleValue = s -> Integer.parseInt(s) * 2;
//        System.out.println(doubleValue.apply("10")); // 20
//
//        // Ex 4 :
//        Supplier<Double> interestRateSupplier = () -> Math.random() * 5.0;
//        System.out.println(interestRateSupplier.get()); // ex: 2.34
//
//        // Ex 5 :
//        Validator emailValidator = s -> s != null && s.contains("@");
//        System.out.println(emailValidator.validate("test@mail.com")); // true
//        System.out.println(emailValidator.validate("testmail.com"));  // false
//
//        //////Niveau 2/////
//
//        //Ex 6
//        List<String> fruits = List.of("Apple", "Banana", "Avocado");
//        List<String> result = fruits.stream()
//                .filter(f -> f.startsWith("A"))
//                .toList();
//        System.out.println(result); // [Apple, Avocado]
//
//
//        //Ex 7
//        List<User> users = List.of(new User("a@mail.com"), new User("b@mail.com"));
//        List<String> emails = users.stream()
//                .map(User::getEmail)
//                .toList();
//        users = List.of(new User("a@mail.com"), new User("b@mail.com"));
//        System.out.println(emails); // [a@mail.com, b@mail.com]
//
//        //Ex 8
//        List<Integer> prices = List.of(50, 150, 200);
//        int total = prices.stream()
//                .filter(p -> p > 100)
//                .mapToInt(Integer::intValue)
//                .sum();
//        System.out.println(total); // 350
//
//        //Ex 9
//        List<String> names = List.of("Ali", "Bob", "Ali");
//        List<String> uniqueNames = names.stream()
//                .distinct()
//                .sorted()
//                .toList();
//        System.out.println(uniqueNames); // [Ali, Bob]
//
//        // Ex 10
//        Optional<User> admin = users.stream()
//                .filter(u -> "ADMIN".equals(u.getRole()))
//                .findAny();
//
//        admin.ifPresent(u -> System.out.println(u.getEmail()));
//
//        // Ex 11 — CORRIGÉ : "15-01-2002" était une soustraction arithmétique (= -1988)
//        //          On utilise un entier au format YYYYMMDD à la place.
//        List<Transaction> transactions = List.of(
//                new Transaction(20020115, "hhhh", "EUR")
//        );
//        Map<String, List<Transaction>> byCurrency = transactions.stream()
//                .collect(Collectors.groupingBy(Transaction::getCurrency));
//        System.out.println(byCurrency.get("XOF")); // null (la transaction est en EUR)
//
//
////         // Ex 12 —
////         (Collectors.summarizingDouble nécessite une Function<Product, Double>)
////        Money price12 = new Money(new BigDecimal("150000"), "FCFA");
////        SKU sku12 = new SKU("TEC-43256");
////        List<Product> products = List.of(new Product(sku12, "TV", price12));
////        DoubleSummaryStatistics stats = products.stream()
////                .collect(Collectors.summarizingDouble(p -> p.getPrice().amount().doubleValue()));
//
//
//        // Ex 13
//        List<Student> students = List.of(
//                new Student("fatou", 10),
//                new Student("Demba", 5)
//        );
//        Map<Boolean, List<Student>> results = students.stream()
//                .collect(Collectors.partitioningBy(s -> s.getGrade() >= 10));
//        System.out.println(results.get(true));  // admis
//        System.out.println(results.get(false)); // recalés
//
//        // Ex 14
//        List<Order> orders = List.of(
//                new Order(List.of(new Item("Apple"), new Item("Banana"))),
//                new Order(List.of(new Item("Apple"), new Item("Orange")))
//        );
//        List<Item> allItems = orders.stream()
//                .flatMap(o -> o.getItems().stream())
//                .toList();
//        System.out.println(allItems.size()); // 4
//
//        // Ex 15 — CORRIGÉ : variable user déclarée avec une Address,
//        //          et User.getAdresse() retourne maintenant un objet Address
//        User user = new User("jean@mail.com", "USER", new Address("Rue Dakar", "Dakar", "Sénégal"));
//        String street = Optional.ofNullable(user)
//                .map(User::getAdresse)
//                .map(Address::getStreet)
//                .orElse("Rue inconnue");
//        System.out.println(street); // Rue Dakar
//
//        // Ex 16 — CORRIGÉ : variable transaction déclarée,
//        //          getUserType() ajouté dans Transaction
//        Transaction transaction = new Transaction(20240101, "achat", 500, "XOF", "PREMIUM");
//
//        Predicate<Transaction> isXof =
//                t -> t.getAmount() > 0 && "XOF".equals(t.getCurrency());
//
//        Predicate<Transaction> isPremium =
//                t -> "PREMIUM".equals(t.getUserType());
//
//        Predicate<Transaction> complexValidator =
//                isXof.or(isPremium);
//
//        System.out.println(complexValidator.test(transaction)); // true
//
//        // Ex 17 — CORRIGÉ : variables ids et repository déclarées
//        List<Integer> ids = List.of(1, 2, 5); // l'id 5 n'existe pas dans le repo
//        UserRepository repository = new UserRepository();
//        List<User> existingUsers = ids.stream()
//                .map(repository::findById)
//                .flatMap(Optional::stream)
//                .toList();
//        System.out.println(existingUsers.size()); // 2
//
//        // Ex 18 — CORRIGÉ : import java.util.Objects ajouté
//        List<String> csvLines = List.of(
//                "Ali;25;50000",
//                "BadLine",
//                "Awa;abc;30000"
//        );
//
//        List<Employee> employees = csvLines.stream()
//                .map(line -> {
//                    try {
//                        String[] parts = line.split(";");
//                        return new Employee(
//                                parts[0],
//                                Integer.parseInt(parts[1]),
//                                Double.parseDouble(parts[2])
//                        );
//                    } catch (Exception e) {
//                        return null;
//                    }
//                })
//                .filter(Objects::nonNull)
//                .toList();
//
//        System.out.println(employees.size()); // 1
//    }
}
