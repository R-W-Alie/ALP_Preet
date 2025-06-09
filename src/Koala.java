// 🐨
public class Koala extends Pet {
    private static final String[] koala_sentences = {
        "The koala yawns lazily.",
        "The koala climbs a eucalyptus tree.",
        "The koala munches on some leaves.",
        "The koala takes a cozy nap."
    };

    public Koala(String name, int hp) {
        super(name, hp, koala_sentences, "🐨");
    }

    @Override
    public void interact() {
        System.out.print("🐨 ");
        super.interact();
    }
}
