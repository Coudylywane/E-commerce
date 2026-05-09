package cours.ecole221.models;

public class Transaction {
    private int date;
    private String name;
    private int amount;
    private String currency;
    private String userType;

    public Transaction(int date, String name, String currency) {
        this.date = date;
        this.name = name;
        this.currency = currency;
        this.amount = 0;
        this.userType = "STANDARD";
    }

    public Transaction(int date, String name, int amount, String currency, String userType) {
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.userType = userType;
    }

    public int getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getUserType() {
        return userType;
    }
}
