package mtbuller;

public class MtBullerAdmin {

    public static void main(String[] args) {

        MtBullerResort resort = new MtBullerResort();

        Customer alice = new Customer(1, "Alice Piper", 23, "Female",
                SkiingLevel.BEGINNER);

        Customer grace = new Customer(2, "Grace Parker", 23, "Female",
                SkiingLevel.INTERMEDIATE);

        resort.addCustomer(alice);
        resort.addCustomer(grace);

        resort.listCustomers();
    }
}