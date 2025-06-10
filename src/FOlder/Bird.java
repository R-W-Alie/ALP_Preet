package FOlder;
//🦜
public class Bird extends Pet {
    private static final String[] bird_sentences = {
        "The bird chirps melodiously.",
        "The bird flutters its wings.",
        "The bird sings a morning song.",
        "The bird tilts its head curiously."
    };

    public Bird(String name, int fun) {
        super(name, fun, bird_sentences, "🦜");
    }

    @Override
    public void interact() {
        System.out.print("🦜 ");
        super.interact();
    }
}
