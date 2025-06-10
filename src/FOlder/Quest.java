import User;

package FOlder;
public abstract class Quest {
    protected String description;
    protected int plusHp;
    protected int pluspoint;

    public Quest(String description, int plusHp) {
        this.description = description;
        this.pluspoint = pluspoint;
    }

    public abstract void complete(User user);
    
    public String getDescription() {
        return description;
    }
    public abstract int getReward();
}