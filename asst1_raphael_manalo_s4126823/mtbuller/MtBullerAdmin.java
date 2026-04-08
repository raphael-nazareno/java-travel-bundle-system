package mtbuller;

public class MtBullerAdmin {

    public static void main(String[] args) {

        MtBullerResort resort = new MtBullerResort();

        Customer alice = new Customer("Alice Piper", 23, "Female",
                SkiingLevel.EXPERT);

        Customer grace = new Customer("Grace Parker", 23, "Female",
                SkiingLevel.INTERMEDIATE);

        Customer mark = new Customer("Mark Howard", 35, "Male",
                SkiingLevel.BEGINNER);

        resort.addCustomer(alice);
        resort.addCustomer(grace);
        resort.addCustomer(mark);

        resort.listCustomers();
    }
}