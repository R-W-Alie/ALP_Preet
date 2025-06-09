import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Menu {
    private static final String USER_DATA_DIR = "user_data/";
    private Scanner s = new Scanner(System.in);
    private String currentUser = null;

    public void welcome() {
        System.out.println("""
                Welcome to Preet
                \033[1m"I was once a seed — small, still, and buried.
                But something inside me wanted the light."\033[0m

                You are not planting a tree.
                \033[1mYou are the tree.\033[0m

                Each day, your actions water, movement, rest are sunlight and rain.

                You stretch a little taller.
                Your roots grow deeper.
                Your leaves grow stronger.

                A gentle companion watches over you,
                cheering when you rise,
                comforting when you fall.

                There is no final stage.
                Only seasons.
                Some fast, some slow.
                All part of your becoming.

                \033[0;37m\033[01You are the tree.
                And you are still growing.\033[m
                """);
        System.out.print("Press Enter to continue...");
        s.nextLine();
        LogReg();
    }

    public void LogReg() {
        while (currentUser == null) {
            System.out.println("\n\033[1mRoots and Branches\033[0m");
            System.out.println("1. \033[3mTake root\033[0m (Register)");
            System.out.println("2. \033[3mReturn to your grove\033[0m (Login)");
            System.out.println("3. \033[3mLet the wind carry you away\033[0m (Exit)");
            System.out.print("\nChoose your path: ");

            String choice = s.nextLine().trim();

            switch (choice) {
                case "1":
                    register();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    System.out.println("\nMay your roots find nourishment elsewhere.");
                    System.exit(0);
                default:
                    System.out.println("\nThe wind whispers of unclear choices...");
            }
        }
        showSanctuary();
    }
    //while() {
            //pertanyaa
            //jwban

            // switch() {
            //     case "1":
            //         break;
            //     case "2":
            //         break;
            //     case "3":
            //         System.out.println("\nMay your roots find nourishment elsewhere.");
            //         System.exit(0);
            //     default:
            //         System.out.println("\nThe wind whispers of unclear choices...");
            // }
        //}

    private void register() {
        System.out.println("\n\033[1mTake Root in This Soil\033[0m");

        String username;
        while (true) {
            System.out.print("\nChoose your name (3-12 characters): ");
            username = s.nextLine().trim();

            if (username.length() < 3 || username.length() > 12) {
                System.out.println("A name must be strong enough to hold but light enough to grow.");
                continue;
            }

            if (userExists(username)) {
                System.out.println("This name already grows in our grove.");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.print("Choose your secret (min 8 characters): ");
            password = s.nextLine();

            if (password.length() < 8) {
                System.out.println("Your secret must be deep enough to protect your roots.");
                continue;
            }

            System.out.print("Whisper your secret once more: ");
            String confirm = s.nextLine();

            if (!password.equals(confirm)) {
                System.out.println("The whispers don't match...");
            } else {
                break;
            }
        }

        try {
            createUserFile(username, password);
            System.out.println("\n\033[1mYou have taken root.\033[0m");
            System.out.println("Welcome, " + username + ", to this sacred grove.");
            currentUser = username;
        } catch (IOException e) {
            System.out.println("The earth trembles... your roots couldn't settle. Try again.");
        }
    }

    private void login() {
        System.out.println("\n\033[1mReturn to Your Grove\033[0m");

        System.out.print("\nYour name: ");
        String username = s.nextLine().trim();

        if (!userExists(username)) {
            System.out.println("No tree by that name grows here...");
            return;
        }

        System.out.print("Your secret: ");
        String password = s.nextLine();

        try {
            if (verifyPassword(username, password)) {
                System.out.println("\n\033[1mThe leaves rustle in welcome.\033[0m");
                System.out.println("Your branches remember this place, " + username + ".");
                currentUser = username;
            } else {
                System.out.println("The secret doesn't match our records...");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("The wind carries away your words... try again.");
        }
    }

    private void showSanctuary() {
        System.out.println("\n\033[1mYour Sacred Grove\033[0m");
        System.out.println("Here, " + currentUser + ", you may grow in peace.");
        System.out.println("\nThe gentle wind carries options to you...");
        System.out.println("1. Meditate on your growth");
        System.out.println("2. Record a new memory");
        System.out.println("3. Let your roots wander (Logout)");
    }

    private boolean userExists(String username) {
        return Files.exists(Paths.get(USER_DATA_DIR + username + ".tree"));
    }

    private void createUserFile(String username, String password) throws IOException {
        new File(USER_DATA_DIR).mkdirs();
        
        Map<String, String> userData = new HashMap<>();
        userData.put("password", hashPassword(password));
        userData.put("created", new Date().toString());
        
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(USER_DATA_DIR + username + ".tree"))) {
            oos.writeObject(userData);
        }
    }

    private boolean verifyPassword(String username, String password) 
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(USER_DATA_DIR + username + ".tree"))) {
            @SuppressWarnings("unchecked")
            Map<String, String> userData = (Map<String, String>) ois.readObject();
            return userData.get("password").equals(hashPassword(password));
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to hash password", e);
        }
    }
}

// public void menu(){
// System.out.println("""
// ==========================
// 🌳Preet🌳
// ==========================
// Welcome to Preet! This is a place where you can grow and learn.
// You can choose to start your journey or log in if you already have an
// account.
// 1. Start
// 2. Log in
// 3. Exit
// """);
// int pilih = s.nextInt();
// switch (pilih) {
// case 1 -> start();
// case 2 -> login();
// case 3 -> {
// System.out.println("Exiting the program...");
// System.exit(0);
// }
// default -> System.out.println("Invalid choice. Please try again.");
// }
// }

// public void start(){
// System.out.println("Hi! Welcome to Preet. Let's get started.");
// System.out.println("Please enter your username:");
// String username = s.next();
// System.out.println("Please enter your password:");
// String password = scan.next();
// //pake hashmap?
// }

// public void login(){
// System.out.println("Please enter your username:");
// String username = s.next();
// System.out.println("Please enter your password:");
// String password = s.next();
// // Here you would typically check the username and password against a
// database or a list of users
// // For now, we'll just print them out
// System.out.println("Username: " + username);
// System.out.println("Password: " + password);
// }
