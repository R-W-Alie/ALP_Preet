// 🦉
public class Owl extends Pet {
    private static final String[] owl_sentences = {
        "The owl blinks wisely.",
        "The owl turns its head 270°.",
        "The owl hoots softly.",
        "The owl watches you in silence."
    };

    public Owl(String name, int fun) {
        super(name, fun, owl_sentences, "🦉");
    }

    @Override
    public void interact() {
        System.out.print("🦉 ");
        super.interact();
    }
}