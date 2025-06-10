import java.io.*;
import java.util.*;

public class UserManager {
    public static final String USER_FOLDER = "users";

    static {
        File folder = new File(USER_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static void saveToFile(User user) {
        File file = new File(USER_FOLDER + "/" + user.getUsername() + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(user.getUsername() + "\n");
            writer.write(user.getPassword() + "\n");
            writer.write(user.getLevel() + "\n");
            writer.write(user.getPoint() + "\n");

            for (Pet pet : user.getPets()) {
                writer.write("PET:" + pet.getSpecies() + "," + pet.getName() + "," + pet.getIcon() + "\n");
            }

        } catch (IOException e) {
            System.err.println("Failed to save user data:");
            e.printStackTrace();
        }
    }

    public static User loadFromFile(String username) {
        File file = new File(USER_FOLDER + "/" + username + ".txt");
        if (!file.exists())
            return null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String uname = reader.readLine();
            String pass = reader.readLine();
            int level = Integer.parseInt(reader.readLine());
            int point = Integer.parseInt(reader.readLine());

            User user = new User(uname, pass, level, point);

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("PET:")) {
                    String[] parts = line.substring(4).split(",");
                    if (parts.length >= 3) {
                        String species = parts[0];
                        String name = parts[1];
                        String icon = parts[2];

                        Pet pet = createPetByType(species, name);
                        if (pet != null) {
                            user.addPet(pet);
                        }
                    }
                }
            }

            return user;

        } catch (Exception e) {
            System.err.println("Error loading user:");
            e.printStackTrace();
            return null;
        }
    }

    public static Pet createPetByType(String type, String name) {
        return switch (type) {
            case "Frog" -> new Frog(name);
            case "Bird" -> new Bird(name);
            case "Snake" -> new Snake(name);
            case "Ant" -> new Ant(name);
            case "Bee" -> new Bee(name);
            case "Koala" -> new Koala(name);
            case "Lizard" -> new Lizard(name);
            case "Monkey" -> new Monkey(name);
            case "Owl" -> new Owl(name);
            case "Sloth" -> new Sloth(name);
            case "Spider" -> new Spider(name);
            case "Squirrel" -> new Squirrel(name);
            case "Caterpillar" -> new Caterpillar(name);
            default -> null;
        };
    }
}
