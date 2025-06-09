import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Welcome to the Self-Improvement Quest Game ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    register(userManager, scanner);
                    break;
                case "2":
                    User user = login(userManager, scanner);
                    if (user != null) {
                        Menu menu = new Menu(user, userManager, scanner);
                        menu.run();
                    }
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please select 1, 2, or 3.");
            }
        }
    }

    private static void register(UserManager userManager, Scanner scanner) {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine().trim();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return;
        }

        if (userManager.registerUser(username, password)) {
            System.out.println("Registration successful! You can now log in.");
        } else {
            System.out.println("Username already exists. Try a different username.");
        }
    }

    private static User login(UserManager userManager, Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        User user = userManager.loginUser(username, password);
        if (user == null) {
            System.out.println("Invalid username or password.");
        } else {
            System.out.println("Login successful! Welcome " + user.getUsername());
        }
        return user;
    }
}
