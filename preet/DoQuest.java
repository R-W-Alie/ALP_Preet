import java.util.*;

public class DoQuest {
    private static final List<String> veryEasyQuests = Arrays.asList(
        "Drink a glass of water 💧",
        "Take 3 deep breaths 🌬️",
        "Stretch your arms for 10 seconds 🙆‍♂️",
        "Open a window and take a fresh breath 🌤️",
        "Smile at yourself in the mirror 😊"
        // add more if you want
    );

    private static final List<String> easyQuests = Arrays.asList(
        "Write a one-sentence journal entry 📓",
        "Do 5 jumping jacks or squats 🏃‍♀️",
        "Set a 2-minute timer and breathe ⏱️",
        "Clean your desk or a small area 🪑",
        "Write one thing you’re grateful for 🙏"
    );

    private static final List<String> harderQuests = Arrays.asList(
        "Journal for 5+ minutes 📘",
        "Exercise or move for 10 minutes 💪",
        "Meditate for 5 minutes 🧘‍♂️",
        "Make a healthy meal or snack 🥗",
        "Write down 3 things you're grateful for 🙌"
    );

    public static void run(User user, Scanner scanner) {
        System.out.println("\n--- Daily Quests ---");
        List<String> quests = get5QuestsByLevel(user.getLevel());

        for (int i = 0; i < quests.size(); i++) {
            System.out.println((i + 1) + ". " + quests.get(i));
        }

        System.out.println("\nPress Enter after completing all quests...");
        scanner.nextLine();

        user.levelUp();
        System.out.println("Great job! You've leveled up to level " + user.getLevel() + "!");

        // Add pet every 3 levels
        if (user.getLevel() % 3 == 0) {
            String newPet = getNewPet(user);
            if (newPet != null) {
                if (user.addPet(newPet)) {
                    System.out.println("You got a new pet! " + newPet);
                }
            } else {
                System.out.println("You already have all pets!");
            }
        }
    }

    private static List<String> get5QuestsByLevel(int level) {
        List<String> pool;
        if (level <= 3) {
            pool = new ArrayList<>(veryEasyQuests);
        } else if (level <= 6) {
            pool = new ArrayList<>(easyQuests);
        } else {
            pool = new ArrayList<>(harderQuests);
        }
        Collections.shuffle(pool);
        return pool.subList(0, Math.min(5, pool.size()));
    }

    private static String getNewPet(User user) {
        List<String> allPets = Arrays.asList(
            "🐜", "🐨", "🐵", "🐿️", "🦉", "🐸", "🐝", "🐛", "🐍", "🕷️", "🦎", "🦜", "🦥"
        );
        for (String pet : allPets) {
            if (!user.getPets().contains(pet)) {
                return pet;
            }
        }
        return null;
    }
}
