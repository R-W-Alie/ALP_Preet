import java.util.*;

public class Menu {
    private Scanner s = new Scanner(System.in);
    private String currentUser = null;
    public class PetData {
        public static final List<Pet> allPets = Arrays.asList(
        new Pet("ants", 10, new String[] { // Sentences array defined explicitly here
            "The ants are marching.",
            "An ant scurries across the floor."
        }, "🐜") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Pet("koala", 10, new String[] { // Sentences array defined explicitly here
            "The koala is munching eucalyptus.",
            "The koala looks very sleepy."
        }, "🐨") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Pet("monkey", 10, new String[] { // Sentences array defined explicitly here
            "The monkey swings through the trees.",
            "A monkey chatters playfully."
        }, "🐵") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Pet("squirrel", 10, new String[] { // Sentences array defined explicitly here
            "The squirrel buries a nut.",
            "A squirrel climbs swiftly up the tree."
        }, "🐿️") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Pet("owl", 10, new String[] { // Sentences array defined explicitly here
            "The owl hoots softly.",
            "An owl gazes with wise eyes."
        }, "🦉") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Pet("frog", 10, new String[] { // Sentences array defined explicitly here
            "The frog croaks by the pond.",
            "A frog leaps into the water."
        }, "🐸") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Pet("bee", 10, new String[] { // Sentences array defined explicitly here
            "The bee buzzes around a flower.",
            "A bee collects nectar."
        }, "🐝") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Caterpillar("caterpillar", 10), // Caterpillar already handles its own sentences internally
        new Pet("snake", 10, new String[] { // Sentences array defined explicitly here
            "The snake slithers through the grass.",
            "A snake basks in the sun."
        }, "🐍") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Pet("spider", 10, new String[] { // Sentences array defined explicitly here
            "The spider weaves a web.",
            "A spider hangs patiently from a thread."
        }, "🕷️") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Pet("lizard", 10, new String[] { // Sentences array defined explicitly here
            "The lizard basks in the sun.",
            "A lizard scurries across a rock."
        }, "🦎") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Pet("bird", 10, new String[] { // Sentences array defined explicitly here
            "The bird chirps a happy tune.",
            "A bird soars high in the sky."
        }, "🦜") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        },
        new Pet("sloth", 10, new String[] { // Sentences array defined explicitly here
            "The sloth moves very slowly.",
            "A sloth hangs upside down."
        }, "🦥") {
            @Override public void interact() { System.out.println(getIcon() + " " + getSentences()[new Random().nextInt(getSentences().length)]); }
        }
    );
}

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

            String choice = s.nextLine();

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
    }

    private void register() {
        System.out.println("\n\033[1mTake Root in This Soil\033[0m");
        String username;

        while (true) {
            System.out.print("\nChoose your name (3-12 characters): ");
            username = s.nextLine().trim();

            if (username.length() < 3 || username.length() > 12) {
                System.out.println("⚠️ A name must be strong enough to hold, but light enough to grow.");
                continue;
            }

            if (UserManager.loadFromFile(username) != null) {
                System.out.println("🌳 This name already grows in our grove. Choose another.");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.print("Choose a password (min 4 characters): ");
            password = s.nextLine().trim();
            if (password.length() < 4) {
                System.out.println("Your roots need a bit more strength.");
            } else {
                break;
            }
        }

        int level;
        level = 1;
        int point = 0;

        User newUser = new User(username, password, level, point);
        UserManager.saveToFile(newUser);
        System.out.println("\nAccount created! Welcome, " + username + "!");
    }

    private void login() {
        System.out.print("Username: ");
        String username = s.nextLine().trim();

        System.out.print("Password: ");
        String password = s.nextLine().trim();

        User user = UserManager.loadFromFile(username);

        if (user == null) {
            System.out.println("User not found or file corrupted.");
        } else if (!user.getPassword().equals(password)) {
            System.out.println("Incorrect password.");
        } else {
            System.out.println("Login successful! Welcome back, " + user.getUsername() + "!");
            mainmenu(user);
        }
    }

    public void mainmenu(User user) {
        System.out.println();
        System.out.println("=== Main Menu ===");
        System.out.println("1. Do Quest\n2. View Tree\n3. View Animals\n4. Play Memory Game\n0. Exit");
        int choice = -1;
        while (choice != 0) {
            do {
                System.out.print("Choose an option: ");
                try {
                    choice = s.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    s.next();
                    choice = -1;
                }
            } while (choice < 0 || choice > 4);
            switch (choice) {
                case 1:
                    doQuest(user);
                    break;
                case 2:
                    viewTree(user);
                    break;
                case 3:
                    viewAnimals(user);
                case 4:
                    playMemoryGame(user);
                    break;
                case 0:
                    System.out.println("\nMay your roots find nourishment elsewhere.");
                    System.exit(0);
                default:
                    System.out.println("\nThe wind whispers of unclear choices...");
            }
        }
    }

    public void playMemoryGame(User user) {
        for (int i = 0; i < 99; i++) {
            System.out.println();
        }
    }

    public void choosePet(User user) {
        System.out.println("\nChoose an animal to add to your grove:");

        // Filter pets yang BELUM dimiliki user
        List<Pet> availablePets = new ArrayList<>();
        for (Pet pet : PetData.allPets) {
            boolean owned = false;
            for (Pet p : user.pets) {
                if (p.getId() == pet.getId()) {
                    owned = true;
                    break;
                }
            }
            if (!owned) {
                availablePets.add(pet);
            }
        }

        if (availablePets.isEmpty()) {
            System.out.println("You already have all animals in your grove!");
            return;
        }

        // Tampilkan hewan yang belum dimiliki
        for (int i = 0; i < availablePets.size(); i++) {
            Pet pet = availablePets.get(i);
            System.out.printf("%d. %s %s (HP: %d)%n", i + 1, pet.getIcon(), pet.getName(), pet.getHp());
        }

        System.out.print("Enter the number of the animal you want to adopt (or 0 to cancel): ");
        String input = s.nextLine().trim();
        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        if (choice == 0) {
            System.out.println("No animal adopted.");
            return;
        }

        if (choice < 1 || choice > availablePets.size()) {
            System.out.println("Choice out of range.");
            return;
        }

        Pet chosenPet = availablePets.get(choice - 1);
        user.pets.add(chosenPet);
        System.out.println("You have adopted " + chosenPet.getName() + " " + chosenPet.getIcon() + "!");
        UserManager.saveToFile(user);  // Simpan perubahan user
    }

    public void viewAnimals(User user) {
        System.out.println("\n=== My Animals ===");
        if (user.pets.isEmpty()) {
            System.out.println("You feel a presence missing beside you...");
            choosePet(user);
            return;
        }
        for (int i = 0; i < user.pets.size(); i++) {
            Pet pet = user.pets.get(i);
            System.out.printf("%d. %s %s (HP: %d)%n", i + 1, pet.getIcon(), pet.getName(), pet.getHp());
        }
    }

        public void viewTree(User user) {
            // Display treenya i still need to draw
        }

        public void doQuest(User user) {
            int playerLevel = user.getLevel();
            List<String> dailyQuests = DoQuest.get5QuestsByLevel(playerLevel); // Make sure this exists
            Set<Integer> completedIndices = new HashSet<>();
            System.out.println("\n🌿 Your 5 quests for today:");

            while (completedIndices.size() < dailyQuests.size()) {
                System.out.println("\nAvailable quests:");
                for (int i = 0; i < dailyQuests.size(); i++) {
                    if (!completedIndices.contains(i)) {
                        System.out.println((i + 1) + ". " + dailyQuests.get(i));
                    }
                }

                System.out.print("Choose a quest number to complete (or 0 to quit): ");
                String input = s.nextLine().trim(); // use the class-level Scanner `s`
                int choice;
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    continue;
                }

                if (choice == 0) {
                    System.out.println("🌙 Quitting quests for today.");
                    mainmenu(user);
                    break;
                }

                if (choice < 1 || choice > dailyQuests.size()) {
                    System.out.println("❌ Please choose a number between 1 and " + dailyQuests.size());
                    continue;
                }

                int questIndex = choice - 1;

                if (completedIndices.contains(questIndex)) {
                    System.out.println("❌ You already completed that quest today. Choose another.");
                    continue;
                }

                completedIndices.add(questIndex);
                System.out.println("✅ Quest completed: " + dailyQuests.get(questIndex));

                int reward = 1;
                user.increaseLevel(reward);
                System.out.println("🌟 Growth achieved! +" + reward + " level(s). Current level: " + user.getLevel());

                UserManager.saveToFile(user);
            }

            if (completedIndices.size() == dailyQuests.size()) {
                System.out.println("\n🎉 You completed all quests for today! Great job!");
            }
        }

    }
