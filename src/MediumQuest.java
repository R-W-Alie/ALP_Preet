public class MediumQuest extends Quest {
    public MediumQuest(String description, int plusHp) {
        super(description, plusHp);
    }

    public String getDescription() {
        return "Drink 2 glasses of water 💧";
    }

    public int getReward() {
        return 2;
    }

    @Override
    public void complete(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'complete'");
    }
}