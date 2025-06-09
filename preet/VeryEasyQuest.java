public class VeryEasyQuest extends Quest {
    public VeryEasyQuest(String description) {
        super(description);
    }

    @Override
    public void performQuest() {
        System.out.println("Performing a very easy quest: " + description);
    }
}
