import java.util.List;

public class ViewPets {
    public static void run(User user) {
        List<String> pets = user.getPets();
        System.out.println("\n--- Your Pets ---");
        if (pets.isEmpty()) {
            System.out.println("You don't have any pets yet.");
        } else {
            for (int i = 0; i < pets.size(); i++) {
                System.out.println((i + 1) + ". " + pets.get(i));
            }
        }
    }
}
