package cours.ecole221.models;

public class User {
    public boolean isActive;
    private String nom;
    private String login;
    private String password;
    private String email;
    private String role;
    private Address adresse;

    public User(String email) {
        this.email = email;
    }

    public User(String email, String role, Address adresse) {
        this.email = email;
        this.role = role;
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Address getAdresse() {
        return adresse;
    }
}








