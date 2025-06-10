
import java.util.*;

public class PetData {
        public static final List<Pet> allPets = Arrays.asList(
                        new Pet("ants", 10, new String[] { // Sentences array defined explicitly here
                                        "The ants are marching.",
                                        "An ant scurries across the floor."
                        }, "🐜") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Pet("koala", 10, new String[] { // Sentences array defined explicitly here
                                        "The koala is munching eucalyptus.",
                                        "The koala looks very sleepy."
                        }, "🐨") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Pet("monkey", 10, new String[] { // Sentences array defined explicitly here
                                        "The monkey swings through the trees.",
                                        "A monkey chatters playfully."
                        }, "🐵") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Pet("squirrel", 10, new String[] { // Sentences array defined explicitly here
                                        "The squirrel buries a nut.",
                                        "A squirrel climbs swiftly up the tree."
                        }, "🐿️") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Pet("owl", 10, new String[] { // Sentences array defined explicitly here
                                        "The owl hoots softly.",
                                        "An owl gazes with wise eyes."
                        }, "🦉") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Pet("frog", 10, new String[] { // Sentences array defined explicitly here
                                        "The frog croaks by the pond.",
                                        "A frog leaps into the water."
                        }, "🐸") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Pet("bee", 10, new String[] { // Sentences array defined explicitly here
                                        "The bee buzzes around a flower.",
                                        "A bee collects nectar."
                        }, "🐝") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Caterpillar("caterpillar", 10), // Caterpillar already handles its own sentences internally
                        new Pet("snake", 10, new String[] { // Sentences array defined explicitly here
                                        "The snake slithers through the grass.",
                                        "A snake basks in the sun."
                        }, "🐍") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Pet("spider", 10, new String[] { // Sentences array defined explicitly here
                                        "The spider weaves a web.",
                                        "A spider hangs patiently from a thread."
                        }, "🕷️") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Pet("lizard", 10, new String[] { // Sentences array defined explicitly here
                                        "The lizard basks in the sun.",
                                        "A lizard scurries across a rock."
                        }, "🦎") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Pet("bird", 10, new String[] { // Sentences array defined explicitly here
                                        "The bird chirps a happy tune.",
                                        "A bird soars high in the sky."
                        }, "🦜") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        },
                        new Pet("sloth", 10, new String[] { // Sentences array defined explicitly here
                                        "The sloth moves very slowly.",
                                        "A sloth hangs upside down."
                        }, "🦥") {
                                @Override
                                public void interact() {
                                        System.out
                                                        .println(getIcon() + " " + getSentences()[new Random()
                                                                        .nextInt(getSentences().length)]);
                                }
                        });
}