import java.util.*;

public class AuthManager {
    private Scanner s = new Scanner(System.in);

    public User start() {
        System.out.println("Welcome to the Quest Game!");
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.print("Choose option: ");
            String choice = s.nextLine();

            if (choice.equals("1")) {
                return UserManager.login(s);
            } else if (choice.equals("2")) {
                return UserManager.register(s);
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }
}