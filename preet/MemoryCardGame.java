import java.util.*;

public class MemoryCardGame {
    private static final List<String> ALL_ANIMALS = Arrays.asList(
        "🐜", "🐨", "🐵", "🐿️", "🦉", "🐸", "🐝", "🐛", "🐍", "🕷️", "🦎", "🦜", "🦥"
    );

    public static void run(User user, Scanner scanner) {
        if (user.getPets().size() < 5) {
            System.out.println("You need at least 5 pets to play the Memory Card Game.");
            return;
        }

        // Select 6 cards (3 pairs) from user's pets
        List<String> playablePets = new ArrayList<>(user.getPets());
        Collections.shuffle(playablePets);
        List<String> gameCards = new ArrayList<>();

        for (int i = 0; i < Math.min(3, playablePets.size()); i++) {
            gameCards.add(playablePets.get(i));
            gameCards.add(playablePets.get(i));
        }

        Collections.shuffle(gameCards);

        boolean[] matched = new boolean[gameCards.size()];
        int tries = 0;
        Scanner sc = scanner;

        System.out.println("\n--- Memory Card Game ---");
        while (!allTrue(matched)) {
            printBoard(gameCards, matched);

            int first = getValidIndexInput(sc, "Pick first card (1-" + gameCards.size() + "): ", matched);
            int second = getValidIndexInput(sc, "Pick second card (1-" + gameCards.size() + "): ", matched, first);

            tries++;

            if (gameCards.get(first).equals(gameCards.get(second))) {
                System.out.println("Match found! " + gameCards.get(first));
                matched[first] = true;
                matched[second] = true;
            } else {
                System.out.println("Not a match.");
            }
        }
        System.out.println("Congratulations! You completed the game in " + tries + " tries.");
    }

    private static void printBoard(List<String> cards, boolean[] matched) {
        System.out.println("\nBoard:");
        for (int i = 0; i < cards.size(); i++) {
            if (matched[i]) {
                System.out.print("[" + cards.get(i) + "] ");
            } else {
                System.out.print("[" + (i + 1) + "] ");
            }
        }
        System.out.println();
    }

    private static int getValidIndexInput(Scanner sc, String prompt, boolean[] matched) {
        return getValidIndexInput(sc, prompt, matched, -1);
    }

    private static int getValidIndexInput(Scanner sc, String prompt, boolean[] matched, int exclude) {
        int idx = -1;
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                idx = Integer.parseInt(input) - 1;
                if (idx < 0 || idx >= matched.length) {
                    System.out.println("Invalid number, try again.");
                    continue;
                }
                if (matched[idx]) {
                    System.out.println("Card already matched, pick another.");
                    continue;
                }
                if (idx == exclude) {
                    System.out.println("Cannot pick the same card twice.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return idx;
    }

    private static boolean allTrue(boolean[] arr) {
        for (boolean b : arr) {
            if (!b) return false;
        }
        return true;
    }
}
