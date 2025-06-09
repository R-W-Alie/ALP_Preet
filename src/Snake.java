// 🐍
public class Snake extends Pet {
    private static final String[] snake_sentences = {
        "The snake slithers quietly.",
        "The snake flicks its tongue.",
        "The snake coils up to rest.",
        "The snake watches everything around."
    };

    public Snake(String name, int hp) {
        super(name, hp, snake_sentences, "🐍");
    }

    @Override
    public void interact() {
        System.out.print("🐍 ");
        super.interact();
    }
}
