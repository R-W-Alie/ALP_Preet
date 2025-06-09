// 🕷️
public class Spider extends Pet {
    private static final String[] spider_sentences = {
        "The spider spins a delicate web.",
        "The spider crawls silently.",
        "The spider hides in the corner.",
        "The spider waits patiently for prey."
    };

    public Spider(String name, int hp) {
        super(name, hp, spider_sentences, "🕷️");
    }

    @Override
    public void interact() {
        System.out.print("🕷️ ");
        super.interact();
    }
}
