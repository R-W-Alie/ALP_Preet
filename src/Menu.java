
import java.time.LocalDate;
import java.util.*;

public class Menu {
    private Scanner s = new Scanner(System.in);
    private String currentUser = null;

    public void welcome() {
        System.out.println(
                "\u001b[32m" +
                        "             U _____ u  _        ____   U  ___ u  __  __  U _____ u \r\n" +
                        " __        __\\| ___\"|/ |\"|    U /\"___|   \\/\"_ \\/U|' \\/ '|u\\| ___\"|/ \r\n" +
                        " \\\"\\      /\"/ |  _|\" U | | u  \\| | u     | | | |\\| |\\/| |/ |  _|\"   \r\n" +
                        " /\\ \\ /\\ / /\\ | |___  \\| |/__  | |/__.-,_| |_| | | |  | |  | |___   \r\n" +
                        "U  \\ V  V /  U|_____|  |_____|  \\____|\\_)-\\___/  |_|  |_|  |_____|  \r\n" +
                        "\u001b[33m" +
                        ".-,_\\ /\\ /_,-.<<   >>  //  \\\\  _// \\\\      \\\\   <<,-,,-.   <<   >>  \r\n" +
                        " \\_)-'  '-(_/(__) (__)(_\")(\"_)(__)(__)    (__)   (./  \\.) (__) (__) \r\n" +
                        "\u001b[32m" +
                        "  _____   U  ___ u     ____      ____    U _____ uU _____ u  _____  \r\n" +
                        " |_ \" _|   \\/\"_ \\/   U|  _\"\\ uU |  _\"\\ u \\| ___\"|/\\| ___\"|/ |_ \" _| \r\n" +
                        "   | |     | | | |   \\| |_) |/ \\| |_) |/  |  _|\"   |  _|\"     | |   \r\n" +
                        "  /| |\\.-,_| |_| |    |  __/    |  _ <    | |___   | |___    /| |\\  \r\n" +
                        " u |_|U \\_)-\\___/     |_|       |_| \\_\\   |_____|  |_____|  u |_|U  \r\n" +
                        "\u001b[33m" +
                        " _// \\\\_     \\\\       ||>>_     //   \\\\_  <<   >>  <<   >>  _// \\\\_ \r\n" +
                        "(__) (__)   (__)     (__)__)   (__)  (__)(__) (__)(__) (__)(__) (__)\r\n" +
                        "\u001b[0m");

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

        int level = 1;
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
        System.out.println("1. Do Quest\n2. View Tree\n3. View Animals\n4. Play Memory Game\n5. Create Pet\n0. Exit");
        int choice = -1;
        while (choice != 0) {
            do {
                System.out.print("Choose an option: ");
                try {
                    choice = s.nextInt();
                    s.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    s.next();
                    choice = -1;
                }
            } while (choice < 0 || choice > 5);
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
                case 5:
                    choosePet(user);
                    break;
                case 0:
                    System.out.println("\nMay your roots find nourishment elsewhere.");
                    System.exit(0);
                default:
                    System.out.println("\nThe wind whispers of unclear choices...");
            }
        }
    }

    public void doQuest(User user) {
        LocalDate today = LocalDate.now();

        if (user.getLastQuestDate() == null || !user.getLastQuestDate().equals(today)) {
            int playerLevel = user.getLevel();
            List<String> dailyQuests = DoQuest.get5QuestsByLevel(playerLevel);

            user.setTodayQuests(dailyQuests);
            user.setCompletedQuestIndices(new HashSet<>());
            user.setLastQuestDate(today);
            UserManager.saveToFile(user);
        }

        List<String> dailyQuests = user.getTodayQuests();
        Set<Integer> completed = user.getCompletedQuestIndices();

        System.out.println("\n🌿 Your 5 quests for today:");

        while (completed.size() < dailyQuests.size()) {
            System.out.println("\nAvailable quests:");
            for (int i = 0; i < dailyQuests.size(); i++) {
                if (!completed.contains(i)) {
                    System.out.println((i + 1) + ". " + dailyQuests.get(i));
                }
            }

            System.out.print("Choose a quest number to complete (or 0 to quit): ");
            String input = s.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 0) {
                System.out.println("🌙 Quitting quests for today.");
                UserManager.saveToFile(user);
                mainmenu(user);
                return;
            }

            if (choice < 1 || choice > dailyQuests.size()) {
                System.out.println("❌ Please choose a number between 1 and " + dailyQuests.size());
                continue;
            }

            int questIndex = choice - 1;

            if (completed.contains(questIndex)) {
                System.out.println("❌ You already completed that quest today. Choose another.");
                continue;
            }

            completed.add(questIndex);
            System.out.println("✅ Quest completed: " + dailyQuests.get(questIndex));

            int reward = 1;
            user.addPoint(reward);
            System.out.println("🌟 Growth achieved! +" + reward + " point. Current level: " + user.getLevel());
            if (user.getPoint() >= 10) {
                user.increaseLevel(1);
                user.addPoint(-10); // Reset points after level up
                System.out.println("🎉 Congratulations! You leveled up to level " + user.getLevel() + "!");
            }
            UserManager.saveToFile(user);
        }

        System.out.println("\n🎉 You completed all quests for today! Great job!");
        mainmenu(user);
    }

    public void choosePet(User user) {
        System.out.println("\nChoose an animal to add to your grove:");

        int level = user.getLevel();
        int maxPets = level / 2;

        if (level < 2) {
            System.out.println("You need to be at least level 2 to adopt a pet.");
            return;
        }

        if (user.getPets().size() >= maxPets) {
            System.out.println("You can only have " + maxPets + " animal(s) at your current level (" + level
                    + "). Level up to adopt more!");
            return;
        }

        // Filter available pets (not already owned)
        List<Pet> availablePets = new ArrayList<>();
        for (Pet pet : PetData.allPets) {
            boolean owned = false;
            for (Pet ownedPet : user.getPets()) {
                if (pet.getName().equals(ownedPet.getName()) && pet.getIcon().equals(ownedPet.getIcon())) {
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

        int remainingSlots = maxPets - user.getPets().size();
        System.out.println("You can adopt " + remainingSlots + " more animal(s).");

        for (int i = 0; i < availablePets.size(); i++) {
            Pet petsy = availablePets.get(i);
            System.out.printf("%d. %s %s%n", i + 1, petsy.getIcon(), petsy.getName());
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
        user.addPet(chosenPet);
        System.out.println("You have adopted " + chosenPet.getName() + " " + chosenPet.getIcon() + "!");
        UserManager.saveToFile(user);
        mainmenu(user);
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
            System.out.printf("%d. %s %s\n", i + 1, pet.getIcon(), pet.getName());
        }

        int level = user.getLevel();
        int maxPets = level / 2;
        if (user.pets.size() < maxPets) {
            mainmenu(user);
        } else {
            System.out.println("\nYou have reached the maximum number of animals for your current level.");
            mainmenu(user);
        }
    }

    public static final StringBuilder[] tree1;
    public static final StringBuilder[] tree2;
    public static final StringBuilder[] tree3;
    public static final StringBuilder[] tree4;
    static {
        String[] tree1_str_temp = {
                "               ..-=--+=:.    ",
                "             .=##%#%#%###:    ",
                "             :#%%#%%#%%%#*=.  ",
                "            .==++#**#+=+###:  ",
                "                   :+         "
        };

        String[] tree2_str_temp = {
                "                  ..:....",
                "            ..--==+=:.-**+=:..",
                "          ...++***##****++*#*####++-..",
                "         ..:+***#%%#*#####%%#***#%##*+:. ",
                "        .-**##*#####%%%#%##%%%####%%%#=.",
                "        .-#%%%%%%%%%%%##*##%*###%*#**#*:. ",
                "      .:=++####%%###%%%@%%%%%%%########*=. ",
                "     ..=*##%%%#%####%%%%%##%%%%%%%%###***+-..",
                "    -+**####%%%%%@%%%%###%%####%%##%%##%%#*+:. ",
                "    =**#%*#%%##%%%%%%%%#***%%%%%%##%#####**#=. ",
                "      .-==-=*==+=#*#%#+=#=%##*+*=--=#*#####*-. ",
                "            ..:-....-#%=-:... .-=**:==:-:.. ",
                "                      -#+.",
                "                      :#+.",
                "                  .....:=*+:..... "
        };

        String[] tree3_str_temp = {
                "                                     .....    .:-==---=-..",
                "                                   .:-:---=++=:....=*#*+*#**+-...",
                "                                 ..-+*#++*#***++++++******+++***++-:...",
                "                               .....+*****####***###**+++*#######%%#***+=:",
                "                             ..:+++*#*####%%#+***#%%###%#*+***++######***+-.",
                "                           ..-***##***%%%@%***###%####%%%%%##*****%%#**#**+:",
                "                         .-+****##*****%%%#*#%%%%#%%%####%%%%%%%%*##%@%%%#*+:",
                "                         .=**##%%###%%%%####%%%%#*#*###%%%###%##**##*%%@%##+.",
                "                         .-#%%%%%%%@@%@%#%%%%%%#####*#*%%%#*####%%#*#**+*##*+:. ",
                "                         .-*##%%**##%@%%#%%%#%####%@@%#%%##%#%%%%**+#####%%%#+-. ",
                "                       .-*+*+*%%##%###%###%%##%%%%%@%%%%%%%@%%%%#*%%%%%#####%##*+:. ",
                "                       .+**#####%#%#%%#%#**###%%%@%%%%%%%##%%@%##%%%%#%####%##***=:...",
                "                   ....+#####%%%@%%%#*#%@%#%%%%%%##%%*####%%%%%%%@%%###*#*********+-.",
                "                 .=++*****######%@%%%@%%@@@%%%@%%######@%##%####%%%%#%#%#%###%%%###*==-. ",
                "                 .=*%###%%%#*%%#*#%###%%@%%%@%%%%%%###%%%*#**##%%%%%#*####%##%%%%#**##=.",
                "                 .:*++*##%%*#%%#%%##%%%%%%%#%%%%%%%#****#%%%%%%%%%%%##%%%#%######***#%+- ",
                "                 ....+###****%#+-######%#%%%%%%=##***##%%%%#**#%%####@%###%%%%%##%##+=..",
                "                   ..:::+=:-#+:=*=.-*%%##%%###=:*%+=@%%+*+*##=...:-::######*#%%#**+.",
                "                         ... ...  ..-===+:.-..:=*%%%%+..*:....  ..-==*%#+=**+==**=:. ",
                "                                    ...    ..*%#:**.          .-*+*=-. ..=.   ...",
                "                                             -##*..",
                "                                             :##+",
                "                                             -##*.",
                "                                             .-*#*:",
                "                                         ....:::-+****+---:..... "
        };

        String[] tree4_str_temp = {
                "                                                                       ..      ...",
                "                                                                 ...:---:.....:--:.",
                "                                                        ... .......           .:-+++++*+++=+++*+::...",
                "                                                 ........-...:--=-:.....   .....=*****+*#*****+++===:.",
                "                                             ...:--========+++++#*+++--:...-==-=+*##**++++++###****=:--:....",
                "                                            ..-=++***+=++*+**#**#**###*====+++++*#*++++++++*+=++++++***++=-.....",
                "                                          .:-=++**##*++*+*###*****+++++++++*++++*****#*##**********##***+*+++=-.  ..",
                "                                        ..-+*++++++**+***********+++*+**+***++++++++*#####****####***#%##***+++++++=:....",
                "                                   ...:...=++*##*****#%##%%#%%%#++*##%%#%%*%##+++++++**#%#*%##*###%%%##%####**+++*+*+:..",
                "                                 ..-=+=--++**#****#*#%%##%%##++++****%%#%%%*******#**+**+#%*++++++*%%##%##%#%#*##*+=+=:...",
                "                             .:.:.=+**+++#####*#%%##*##%@@%%#+*+#*#***#%#%#*#%%#%%%#%#**+++***+**+++=+%%#########**+***+-:.",
                "                           ...-+=+***###*##*+*#%%%%%@@@@%*++++**%#**%%####%%##%%%##%%%%*#*####*#+****#*%%%%%%#**%%%****+-=:.",
                "                         ...:+**+**#**##*++++**#%@%%@@@@#***+*##%%%%%%%%%#%%%#%%%%%%%@%%@%##**##*++*+**%%%%#####***#**+**:.",
                "                      ...:=+*+**##%#**###*++*+**#%@@@@@#****##%##%@%#%%%%%%%%%#***##*#@@@%##*#***#**##***#%%#**#%**%%###*+=..",
                "                      :=+***###****####*#***##*#*%#%###*#**##%%%%@%%#%##@%%%#####%%%#*%%@@%##%%#%%%%##**%##%@@@%%%%@%##****+:. ",
                "                     .:=+*#*##**#%##%@#****###%%######*#%%%#%@%%@@%%#**###########*%%%##@%#%%%#%@%%%#*###****%%%%%@@@%%%#*+...",
                "                     .:+****#%#%%##%%###%##%%%%%%###*###*#%%%%%%%%%#****#**####%#%%%%%%#*##%##%#**#*+***####*#%%@%@%%###***=..",
                "                      -=+*%#%##%@@%%#*#%@@@@@@@@@%%%#####%%@%#%%%@@**%%%#***##*##%@@%####**####**###%%***%%*#%#*#%#%##****++:.",
                "                    ...:+##%%%%%%%%%%@%%@@@%%%@@%%%##%@@%%@###%%@#*#######**#*##*#%%%%##***#%%*#%%##@@%%%****##++++**#%#***++-:...",
                "                    .-=*##%%%%%%%#@@@###%@@%%%%%%*@%@@@@@@@@*%###*#*##%%%%#%%%%%%@@@@%%###%+=#*##%#%###*++*******#***#%#*#*##+==-..",
                "                    ...--**##%%%%%#***##%##%@@@%%%%###%%%####%%###%###%%%@@@@@%###%%%%###%%%#%%@%#@@#****++*###%%%###%%%%#%%#**+-:.",
                "               ....=+=+=-=+**#%%@%*###*#####%@#%##**#*###**%#%%%@@%%%%%@@@%%%%%%%%%###%@%@%%%%%%@%%#**#%%#***####%####%####%#**+*--...",
                "               .:=+**++*+***#%#%*#*#%%%#*####%%%*#*#%%%%%#%%####%%%%%%%@@%%%%%#%%%%%%%%%@%%%#%@@%%#***%@@@%%%%%##%%############***+=-: ",
                "              .:=*#*++****###%%%%#%%%%######%%%####*****##%%###%%%%%@@@@%%%#%%%#%%%@%%%%@%%@@@%#%###%%%%%%###%%####*#*##%%%@%*##*+-...",
                "              ..=+#**#*#*#%##*###%%##%%%%%@%%%*%******##*#%%%%%%%%%%%@%%%%%%%%##@%%*#+%%%%@%@@%##%##%%%%%#%%#%%%%*####*%##%##**+*#*+=-:..",
                "              ..+*#**#%@***%%%%%%%##%@%**##%%%#***#%#%#*#####%%#%%%%%%%%%#%%%%*#*#####%%#%%%%%#%%#%@%%#%%%#%%%%*##%%#%**###**#**%%##***++=-:..",
                "         .......-**#%%%#*###%%@%%%%@@##%%@%%#*##*%#%%%%#*%##%@@%%@@#######%%#***##*###%%%%%%%%%%#%%%%%@@%%%#*####*+###****+*****+#**+*****-...",
                "      .:::--==-=+++****###%%%%%%%%@%%%##%#%%##*%#%@@@%@@%%%%%%%@@%%#############%%%####%%%%####%%@@%%%%%%%#%%%######*******###**#**++++*+::.",
                "    ..=+++++*++*#*+**#%%#*#*##*##%@@@%@@@@@@@%%@@@@@@@%@@@@%@@%%%%%###%####%##%@@%%%#*#%%%####*##%%%%%%%###*%%%#%##%%%##%##%%%%%%%%###*#*+++++=..",
                "   ..:+*+*#*++**%%%#%%%#*#****####%@%#%%%%%%%%%@@@%%@%%@%%%@@@@%%%#*#%##%##%%%%%%*##****#**##%%#%#%%%%#%%%#%%###%#%%%%###%%%%%%%#%%%##%%*#**#++:.",
                "   .:++*#%%##**##%%%%%%##*#%%%#**#**#%########%%%@@%%%%%%@%%%%%%%%%%%%#%#####%%%%%%**##****##*#%%%%%%@@#%%#**###%##*#%%%#**#%%%%%%%%%#*+*#####+:. ",
                "   .:+##%######%#%%%%%%@%%##%%%%#####*%#*#*#*%%@%##%%#%%%%%%##%%%%%%%%%##%%#*+*****#%#####**#**#*%%%%%@%%%#####*%%##***###***##%@%###***+*#*#+:-..",
                "    .-*#**+#*+#%##%%%##-=##%%%%##%%#%####%%%#%%%%%%%@@@%#%%%%%%%%%%%%%%#%#***+++**###%%%%%#%%%%%%%%%%%%@%#**##%%%%%########*####**#%####+*#%%#++-. ",
                "    .====...=*####%#%###*#%+%%%#=%%@@%#*#*#%%%%%%%%@@%#*##%##%%%%%%%#%#***+*####%%%#%@@%%%%%**+#@%%%%%%#@%%%@%%%%%%%#%#%%***#%#*##*%%*##%%%@%%#+=:.",
                "    ...... .:*####%##*+#****#%##%+--+#%%%##*%%#%+%%%%%%%%%%%@@%@*+-#%%****###*##*%%%%%%%#%%#***#%@%@%###%%%%%@@@@%###%#%##%#%#@%%####%%######++=...",
                "           .:*#****=+==-::=*#%%%%+:*=+*#*===*+*#%%%*+%%@@%%%%%%%*-.=+%%%%=-:=#%%#%%%%#%#*+*===##%%%*-..=-====+%%%%*+##########%#%%#%*##%#=*+..",
                "           ..:-:::-:=#-.:-..*#%*+-+*++++=:..+*#@%%##*#%%%%%%%%##+-.:-+%%%*::+%@%%@%*+###**######+:... ..:=-::.-*%######*%%*######%%##%*##**=..",
                "              .....=++:.....-:-: .....-***+*#%%%%%###+=+%%%===*####=.:#%%%##%@%+-*=*=#=-...+**:.      .:.-+:.:.-##%@###*%##**++*%#####*+=**=:.",
                "                   .....   .....       ...:-=**#=#-+-:...==-....-*#%%%%%%%%%%%+....=#=... ...=.       ....+==-*=#%%#%#*+*+*=#+:+=-+*###**+-:..",
                "                                             ....:*-..    .      ...=*#%%%%##*. ..=#+.      ..           ..-*=-#*#%%*:.:.=+####+:..:=-===:.",
                "                                                ...-..               ..-##%###-.-##*:..                   :++**+##*=*-........=*=-. .. .....",
                "                                                                      .:###%##*#-.",
                "                                                                       .*###%#*-",
                "                                                                       .*#####-.",
                "                                                                       .+#####-",
                "                                                                       .+#####-",
                "                                                                       .+*##%#=.",
                "                                                                       .**##%#+.",
                "                                                                       .=**###*:",
                "                                                                   ....-***#%#*-..",
                "                                                     ...............:=+*#######*-................",
                "                                                    ..::----================================---::.. "
        };

        tree1 = new StringBuilder[tree1_str_temp.length];
        for (int i = 0; i < tree1_str_temp.length; i++) {
            tree1[i] = new StringBuilder(tree1_str_temp[i]);
        }

        tree2 = new StringBuilder[tree2_str_temp.length];
        for (int i = 0; i < tree2_str_temp.length; i++) {
            tree2[i] = new StringBuilder(tree2_str_temp[i]);
        }

        tree3 = new StringBuilder[tree3_str_temp.length];
        for (int i = 0; i < tree3_str_temp.length; i++) {
            tree3[i] = new StringBuilder(tree3_str_temp[i]);
        }

        tree4 = new StringBuilder[tree4_str_temp.length];
        for (int i = 0; i < tree4_str_temp.length; i++) {
            tree4[i] = new StringBuilder(tree4_str_temp[i]);
        }
    }

    public void viewTree(User user) {
        System.out.println("\n=== YOUR TREE : ===");
        StringBuilder[] tree = null;

        if (user.getLevel() < 6) {
            tree = tree1;
        } else if (user.getLevel() < 11) {
            tree = tree2;
        } else if (user.getLevel() < 16) {
            tree = tree3;
        } else {
            System.out.println("Your tree is fully grown! 🌳");
            for (StringBuilder line : tree4) {
                System.out.println(line.toString());
            }
            return;
        }

        List<Pet> pets = user.getPets();
        Random random = new Random();

        List<String> petSymbols = new ArrayList<>();
        for (Pet pet : pets) {
            petSymbols.add(pet.getIcon());
        }

        for (String symbol : petSymbols) {
            int attempts = 0;
            boolean placed = false;

            while (!placed && attempts < 10) {
                if (tree == null || tree.length == 0) {
                    System.err.println("Warning: Tree array is null or empty. Cannot place pets.");
                    break;
                }
                int row = random.nextInt(tree.length);

                if (tree[row] == null || tree[row].length() == 0) {
                    attempts++;
                    continue;
                }
                int col = random.nextInt(tree[row].length());

                if (tree[row].charAt(col) != ' ') {
                    tree[row].setCharAt(col, symbol.charAt(0));
                    placed = true;
                }

                attempts++;
            }
        }

        for (StringBuilder line : tree) {
            System.out.println(line.toString());
        }
        mainmenu(user);
    }

    public void playMemoryGame(User user) {
        for (int i = 0; i < 99; i++) {
            System.out.println();
        }
        if (user.getPets().size() < 5) {
            System.out.println("You need at least 5 pets to play the Memory Card Game.");
            mainmenu(user);
        } else {
            System.out.println("You have " + user.getPets().size() + " pets. Let's play!");
            System.out.println("\n=== Memory Card Game ===");
            MemoryCardGame.run(user, s);
        }
        mainmenu(user);
    }
}