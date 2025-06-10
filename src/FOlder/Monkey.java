package FOlder;
//🐵
public class Monkey extends Pet {
    private static final String[] monkey_sentences = {
        "The monkey swings from branch to branch.",
        "The monkey chatters playfully.",
        "The monkey throws a banana!",
        "The monkey scratches its head curiously."
    };

    public Monkey(String name, int fun) {
        super(name, fun, monkey_sentences, "🐵");
    }

    @Override
    public void interact() {
        System.out.print("🐵 ");
        super.interact();
    }
}
