package mtbuller;

public class MtBullerAdmin {

    public static void main(String[] args) {

        MtBullerResort resort = new MtBullerResort();

        Customer alice = new Customer("Alice Piper", 23, "Female",
                SkiingLevel.BEGINNER);

        Customer grace = new Customer("Grace Parker", 23, "Female",
                SkiingLevel.INTERMEDIATE);

        resort.addCustomer(alice);
        resort.addCustomer(grace);

        resort.listCustomers();
    }
}