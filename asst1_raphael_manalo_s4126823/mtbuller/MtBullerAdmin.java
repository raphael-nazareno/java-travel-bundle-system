package mtbuller;

import java.util.Scanner;

public class MtBullerAdmin {

    public static void main(String[] args) {
        MtBullerResort resort = new MtBullerResort();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(); // Spacing
            System.out.println("\n===== Mt Buller Resort Menu =====");

            System.out.println("1. List all accommodations");

            System.out.println("2. List available accommodations");

            System.out.println("3. Add customer");

            System.out.println("4. List customers");

            System.out.println("5. Create a bundle");

            System.out.println("6. List bundles");

            System.out.println("7. Add a lift pass to bundle");

            System.out.println("8. Add lesson fees to bundle");

            System.out.println("9. Save bundles to file");

            System.out.println("10. Read bundles from file");

            System.out.println("11. Quit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    resort.listAllAccommodations();
                    break;
                case 2:
                    resort.listAvailableAccommodations();
                    break;
                case 3:
                    resort.createCustomer();
                    break;
                case 4:
                    resort.listCustomers();
                    break;
                case 5:
                    resort.createBundle();
                    break;
                case 6:
                    resort.listBundles();
                    break;
                case 7:
                    resort.addLiftPassToBundle();
                    break;
                case 8:
                    resort.addLessonToBundle();
                    break;
                case 9:
                    resort.saveBundlesToFile();
                    break;
                case 10:
                    resort.readBundlesFromFile();
                    break;
                case 11:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        }

    }
}