public abstract class Pet {
    protected String name;
    protected String emoji;

    public Pet(String name, String emoji) {
        this.name = name;
        this.emoji = emoji;
    }

    public String getDisplay() {
        return emoji + " " + name;
    }

    public abstract void react(); // Polymorphism!
}
