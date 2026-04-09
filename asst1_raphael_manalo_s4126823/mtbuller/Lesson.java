package mtbuller;

public class Lesson {
    private SkiingLevel level;

    public Lesson(SkiingLevel level) {
        this.level = level;
    }

    public double calculatePrice() {
        if (level == SkiingLevel.BEGINNER) {
            return 25;
        }
        if (level == SkiingLevel.INTERMEDIATE) {
            return 20;
        }
        return 15;
    }
}