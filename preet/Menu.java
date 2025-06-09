import java.util.Scanner;

public class Menu {
    private User user;
    private UserManager userManager;
    private Scanner scanner;

    public Menu(User user, UserManager userManager, Scanner scanner) {
        this.user = user;
        this.userManager = userManager;
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Do Quests");
            System.out.println("2. View Pets");
            System.out.println("3. Memory Card Game");
            System.out.println("4. View Tree");
            System.out.println("5. Logout");
            System.out.print("Select an option (1-5): ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    DoQuest.run(user, scanner);
                    userManager.updateUser(user);
                    break;
                case "2":
                    ViewPets.run(user);
                    break;
                case "3":
                    MemoryCardGame.run(user, scanner);
                    break;
                case "4":
                    ViewTree.run(user);
                    break;
                case "5":
                    System.out.println("Logging out...");
                    userManager.updateUser(user);
                    return;
                default:
                    System.out.println("Invalid input. Please select a number between 1-5.");
            }
        }
    }
}
