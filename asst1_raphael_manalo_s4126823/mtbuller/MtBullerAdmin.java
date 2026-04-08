package mtbuller;

public class MtBullerAdmin {

    public static void main(String[] args) {

        MtBullerResort resort = new MtBullerResort();

        Customer alice = new Customer(00001, "Alice Piper", 23, "Female",
                SkiingLevel.BEGINNER);

        Customer grace = new Customer(00002, "Grace Parker", 23, "Female",
                SkiingLevel.INTERMEDIATE);

        System.out.println(alice);
        System.out.println(grace);
    }
}