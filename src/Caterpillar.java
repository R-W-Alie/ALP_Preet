//🐛
public class Caterpillar extends Pet {
    private static final String[] caterpillar_sentences = {
        "The caterpillar wiggles along a branch.",
        "The caterpillar munches on a leaf.",
        "The caterpillar looks sleepy.",
        "The caterpillar dreams of becoming a butterfly."
    };

    public Caterpillar(String name, int hp) {
        super(name, hp, caterpillar_sentences, "🐛");
    }

    @Override
    public void interact() {
        System.out.print("🐛 ");
        super.interact();
    }
}
