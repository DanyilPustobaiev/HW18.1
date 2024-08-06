package app;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    List<User> userList = Arrays.asList(
            new User(102, "Marilyn", "monroe50s@mail.com"),
            new User(199, "Morgan", "freemorgan7@mail.com"),
            new User(201, "Denzel", "equalizer@mail.com"),
            new User(298, "Anthony", "hopheyanthony19@mail.com"));



    public Optional<User> findUserById(int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public Optional<User> findUserByName(String name) {
        return userList.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public Optional<List<User>> findAllUsers() {
        return userList.isEmpty() ? Optional.empty() : Optional.of(userList);
    }

}