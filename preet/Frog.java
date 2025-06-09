public class Frog extends Pet {
    public FrogPet() {
        super("Frog", "🐸");
    }

    @Override
    public void react() {
        System.out.println("🐸 Ribbit!");
    }
}
