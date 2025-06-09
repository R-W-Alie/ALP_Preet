import java.util.*;

public class User {
    private String username;
    private String pass;
    private int level;
    private int point; // Atribut point baru
    ArrayList<Pet> pets = new ArrayList<>();

    public User(String username, String pass, int level, int point) {
        this.username = username;
        this.pass = pass;
        this.level = level; // Diperbaiki: Menggunakan parameter level yang diteruskan
        this.point = point;
        this.pets = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return pass;
    }

    public int getLevel() {
        return level;
    }

    public int getPoint() { // Metode getter baru untuk point
        return point;
    }

    public void increaseLevel(int amount) {
        this.level += amount;
    }

    public void addPoint(int amount) { // Contoh metode untuk menambahkan point
        this.point += amount;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", level=" + level +
                ", point=" + point + // Ditambahkan: point di toString
                ", pets=" + pets +
                '}';
    }
}