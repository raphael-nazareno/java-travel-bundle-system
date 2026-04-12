package mtbuller;

import java.util.Scanner;

public class MtBullerAdmin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MtBullerResort resort = new MtBullerResort(scanner);

        while (true) {
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

            System.out.println("11. Cancel a bundle");

            System.out.println("12. Filter accommodations by type");

            System.out.println("13. Filter accommodations by maximum price");

            System.out.println("14. Sort accommodations by price");

            System.out.println("15. Quit");

            System.out.print("Select an option: ");
            String input = scanner.nextLine().trim();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 15.");
                continue;
            }

            System.out.println(); // Spacing

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

                case 12:

                case 13:
                    resort.listAccommodationsByMaxPrice();
                    break;
                case 14:
                    resort.listAccommodationsSortedByPrice();
                    break;
                case 15:
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