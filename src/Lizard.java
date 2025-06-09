// 🦎
public class Lizard extends Pet {
    private static final String[] lizard_sentences = {
        "The lizard basks in the sun.",
        "The lizard darts across a rock.",
        "The lizard's tail twitches.",
        "The lizard blinks slowly."
    };

    public Lizard(String name, int hp) {
        super(name, hp, lizard_sentences, "🦎");
    }

    @Override
    public void interact() {
        System.out.print("🦎 ");
        super.interact();
    }
}
