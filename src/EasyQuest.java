public class EasyQuest extends Quest {
    public EasyQuest(String description, int plusHp) {
        super(description, plusHp);
    }

    public String getDescription() {
        return "Drink 2 glasses of water 💧";
    }

    public int getReward() {
        return 1;
    }

    @Override
    public void complete(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'complete'");
    }
}