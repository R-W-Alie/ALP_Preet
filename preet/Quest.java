public abstract class Quest {
    protected String description;

    public Quest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void performQuest(); // Can print a message or trigger animations
}
