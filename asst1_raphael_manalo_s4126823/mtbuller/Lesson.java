package mtbuller;

import java.io.Serializable;

public class Lesson implements Serializable, Pricable {
    private static final long serialVersionUID = 1L;

    private SkiingLevel level;
    private int numberOfLessons;

    public Lesson(SkiingLevel level, int numberOfLessons) {
        this.level = level;
        this.numberOfLessons = numberOfLessons;
    }

    @Override
    public double calculatePrice() {
        if (level == SkiingLevel.BEGINNER) {
            return 25 * numberOfLessons;
        }
        if (level == SkiingLevel.INTERMEDIATE) {
            return 20 * numberOfLessons;
        }
        return 15 * numberOfLessons;
    }

    public int getNumberOfLessons() {
        return this.numberOfLessons;
    }

    public SkiingLevel getLevel() {
        return this.level;
    }
}