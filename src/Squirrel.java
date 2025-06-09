// 🐿️
public class Squirrel extends Pet {
    private static final String[] squirrel_sentences = {
        "The squirrel nibbles on a nut.",
        "The squirrel scurries around the tree.",
        "The squirrel fluffs its tail.",
        "The squirrel hides a treasure."
    };

    public Squirrel(String name, int hp) {
        super(name, hp, squirrel_sentences, "🐿️");
    }

    @Override
    public void interact() {
        System.out.print("🐿️ ");
        super.interact();
    }
}
