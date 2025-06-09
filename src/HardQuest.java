public class HardQuest extends Quest {
    public HardQuest(String description, int plusHp) {
        super(description, plusHp);
    }

    public String getDescription() {
        return "Drink 2 glasses of water 💧";
    }

    public int getReward() {
        return 3;
    }

    @Override
    public void complete(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'complete'");
    }
}