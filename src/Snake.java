

// 🐍
public class Snake extends Pet {
    private static final String[] snake_sentences = {
        "The snake slithers quietly.",
        "The snake flicks its tongue.",
        "The snake coils up to rest.",
        "The snake watches everything around."
    };

    public Snake(String name) {
        super(name, snake_sentences, "🐍");
    }

    @Override
    public void interact() {
        System.out.print("🐍 ");
        super.interact();
    }
}
