//🐸
public class Frog extends Pet {
    private static final String[] frog_sentences = {
        "The frog croaks loudly.",
        "The frog jumps high!",
        "The frog catches a fly.",
        "The frog sits calmly on a lily pad."
    };

    public Frog(String name, int hp) {
        super(name, hp, frog_sentences, "🐸");
    }

    @Override
    public void interact() {
        System.out.print("🐸 ");
        super.interact();
    }
}