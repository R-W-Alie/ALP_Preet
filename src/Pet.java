import java.util.Random;

public abstract class Pet {
    private int id;
    protected String name;
    protected int hp;
    protected String[] sentences;
    private String icon;
    private static final Random rand = new Random();

    public Pet(String name, int hp, String[] sentences, String icon) {
        this.name = name;
        this.hp = hp;
        this.sentences = sentences;
        this.icon = icon;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public String[] getSentences() {
        return this.sentences;
    }

    public String getIcon() {
        return this.icon;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp); // prevent negative HP
    }

    public void setSentences(String[] sentences) {
        this.sentences = sentences;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    // New: species name (based on class name)
    public String getSpecies() {
        return this.getClass().getSimpleName(); // e.g., "Ant", "Butterfly"
    }

    // New: check if pet is alive
    public boolean isAlive() {
        return this.hp > 0;
    }

    // New: display full info (for viewAnimals)
    public String getDisplayInfo() {
        return icon + " " + name + " the " + getSpecies() + " (HP: " + hp + ")";
    }

    // Interaction behavior
    public void interact() {
        if (sentences != null && sentences.length > 0) {
            int index = rand.nextInt(sentences.length);
            System.out.println(sentences[index]);
        } else {
            System.out.println("...");
        }
    }
}