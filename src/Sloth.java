// 🦥
public class Sloth extends Pet {
    private static final String[] sloth_sentences = {
        "The sloth slowly blinks at you.",
        "The sloth hangs upside down.",
        "The sloth takes its sweet time.",
        "The sloth scratches lazily."
    };

    public Sloth(String name, int fun) {
        super(name, fun, sloth_sentences, "🦥");
    }

    @Override
    public void interact() {
        System.out.print("🦥 ");
        super.interact();
    }
}
