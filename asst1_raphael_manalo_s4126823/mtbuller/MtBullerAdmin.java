import Customer.SkiingLevel;

public class MtBullerAdmin {

    public static void main(String[] args) {

        Customer alice = new Customer(00001, "Alice Piper", "25th of September, 2002", 23, "Female",
                SkiingLevel.Beginner);

        Customer grace = new Customer(00002, "Grace Parker", "7th of December, 2002", 23, "Female",
                SkiingLevel.Intermediate);

        System.out.println(alice);
        System.out.println(grace);
    }
}