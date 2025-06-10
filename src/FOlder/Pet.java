package FOlder;
import java.util.Random;

public abstract class Pet {
    private int id;
    protected String name;
    protected String[] sentences;
    private String icon;
    private static final Random rand = new Random();

    public Pet(String name, String[] sentences, String icon) {
        this.name = name;
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


    // New: display full info (for viewAnimals)
    public String getDisplayInfo() {
        return icon + " " + name + " the " + getSpecies();
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