package FOlder;
// 🐜 Ant.java
public class Ant extends Pet {
    private static final String[] ant_sentences = {
        "The ant marches diligently!",
        "The ant is carrying a crumb.",
        "The ant waves its antennae.",
        "The ant forms a line with others."
    };

    public Ant(String name) {
        super(name, ant_sentences, "🐜");
    }

    @Override
    public void interact() {
        System.out.print("🐜 ");
        super.interact();
    }
}
