import java.util.*;

public class ViewTree {
    public static void run(User user) {
        int level = user.getLevel();
        List<String> pets = user.getPets();

        System.out.println("\n--- Your Tree ---");
        // Simple ASCII tree grows by level (max 10 lines)
        int treeHeight = Math.min(level / 3 + 1, 10);

        for (int i = 1; i <= treeHeight; i++) {
            printSpaces(treeHeight - i);
            printStars(i * 2 - 1);
            System.out.println();
        }
        printSpaces(treeHeight - 1);
        System.out.println("| |");

        // Display pet emojis randomly on the tree
        if (!pets.isEmpty()) {
            System.out.println("\nPets decorating your tree:");
            Collections.shuffle(pets);
            for (String pet : pets) {
                System.out.print(pet + " ");
            }
            System.out.println();
        }
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) System.out.print(" ");
    }

    private static void printStars(int count) {
        for (int i = 0; i < count; i++) System.out.print("*");
    }
}
