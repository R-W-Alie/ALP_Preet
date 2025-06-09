import java.util.*;

public class User {
    private String username;
    private String password;
    private int level;
    private List<String> pets;

    public User(String username, String password, int level, List<String> pets) {
        this.username = username;
        this.password = password;
        this.level = level;
        this.pets = new ArrayList<>(pets);
    }

    public User(String username, String password) {
        this(username, password, 1, new ArrayList<>());
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        if (level < 30) {
            level++;
        }
    }

    public List<String> getPets() {
        return Collections.unmodifiableList(pets);
    }

    public boolean addPet(String pet) {
        if (pets.size() >= 13 || pets.contains(pet)) {
            return false;
        }
        pets.add(pet);
        return true;
    }

    public String serialize() {
        // Format: username|password|level|pet1,pet2,...
        String petsStr = String.join(",", pets);
        return username + "|" + password + "|" + level + "|" + petsStr;
    }

    public static User deserialize(String data) {
        try {
            String[] parts = data.split("\\|");
            if (parts.length < 4) return null;
            String username = parts[0];
            String password = parts[1];
            int level = Integer.parseInt(parts[2]);
            List<String> pets = new ArrayList<>();
            if (!parts[3].isEmpty()) {
                pets = new ArrayList<>(Arrays.asList(parts[3].split(",")));
            }
            return new User(username, password, level, pets);
        } catch (Exception e) {
            return null;
        }
    }
}
