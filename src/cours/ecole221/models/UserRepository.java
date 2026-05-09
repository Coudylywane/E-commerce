package cours.ecole221.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private final Map<Integer, User> store = new HashMap<>();

    public UserRepository() {
        store.put(1, new User("alice@mail.com"));
        store.put(2, new User("bob@mail.com"));
        store.put(3, new User("charlie@mail.com"));
    }

    public Optional<User> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }
}
