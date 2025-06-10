package FOlder;
// 🐝
public class Bee extends Pet {
    private static final String[] bee_sentences = {
        "The bee buzzes happily.",
        "The bee dances to show the way.",
        "The bee collects pollen.",
        "The bee guards the hive bravely."
    };

    public Bee(String name) {
        super(name, bee_sentences, "🐝");
    }

    @Override
    public void interact() {
        System.out.print("🐝 ");
        super.interact();
    }
}
