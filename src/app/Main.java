package app;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        Scanner sc = new Scanner(System.in);

        Optional<List<User>> userOptionalListId = userRepository.findAllUsers();
        if (userOptionalListId.isPresent()) {
            List<User> userListId = userOptionalListId.get();
            System.out.println("List of all users id:");
            int count = 0;
            for (User user : userListId) {
                count++;
                System.out.println(count + ") " + user.getId());
            }

            System.out.print("Type user id: ");
            int userId = sc.nextInt();
            Optional<User> userById = userRepository.findUserById(userId);
            userById.ifPresentOrElse(
                    user -> System.out.println("User found by id: " + user),
                    () -> System.out.println("Unknown id!\n-------------------\nTry search by name!")
            );
        }

        sc.nextLine();

        Optional<List<User>> userOptionalListName = userRepository.findAllUsers();
        if (userOptionalListName.isPresent()) {
            List<User> userListName = userOptionalListName.get();
            System.out.println("\nList of all users names:");
            int countNames = 0;
            for (User user : userListName) {
                countNames++;
                System.out.println(countNames + ") " + user.getName());
            }

            System.out.print("Type user name: ");
            String searchName = sc.nextLine();
            Optional<User> userByName = userRepository.findUserByName(searchName);
            userByName.ifPresentOrElse(
                    user -> System.out.println("User found by name: " + user),
                    () -> System.out.println("Unknown name!\n-------------------\nTry search by email!")
            );
        }


        Optional<List<User>> userOptionalListEmail = userRepository.findAllUsers();
        if (userOptionalListEmail.isPresent()) {
            List<User> userListEmail = userOptionalListEmail.get();
            System.out.println("\nList of all users email:");
            int countEmail = 0;
            for (User user : userListEmail) {
                countEmail++;
                System.out.println(countEmail + ") " + user.getEmail());
            }

            System.out.print("Type user email: ");
            String userEmail = sc.nextLine();
            Optional<User> userByEmail = userRepository.findUserByEmail(userEmail);
            userByEmail.ifPresentOrElse(
                    user -> System.out.println("User found by email: " + user),
                    () -> System.out.println("Unknown email!\n-------------------\nAll searches have failed :(")
            );

        }

        sc.close();

        Optional<List<User>> userOptionFullList = userRepository.findAllUsers();
        if (userOptionFullList.isPresent()) {
            List<User> userFullList = userOptionFullList.get();
            System.out.println("\nList of all users :");
            int countUsers = 0;
            for (User user : userFullList) {
                countUsers++;
                System.out.println(countUsers + ") " + user);
            }
        }

        Optional<List<User>> allQntUser = userRepository.findAllUsers();
        allQntUser.ifPresentOrElse(
                user -> System.out.println("\nNumber of users: " + user.size()),
                () -> System.out.println("No users!")
        );

    }
}
