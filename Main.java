import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static FlightManager manager = new FlightManager();

    public static void main(String[] args) {
        printBanner();
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("  Enter your choice: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1": manager.showAllFlights();              break;
                case "2": handleSearch();                        break;
                case "3": manager.showGateAllotments();          break;
                case "4": handleBooking();                       break;
                case "5": handleCancellation();                  break;
                case "6": handleViewBooking();                   break;
                case "7": running = false; printGoodbye();       break;
                default:  System.out.println("\n    Invalid choice. Please try again."); break;
            }
        }
        sc.close();
    }

    // ─── Menu Handlers ────────────────────────────────────────────────────────

    private static void handleSearch() {
        System.out.print("\n  Enter destination city: ");
        String dest = sc.nextLine().trim();
        if (dest.isEmpty()) { System.out.println("    Destination cannot be empty."); return; }
        manager.searchByDestination(dest);
    }

    private static void handleBooking() {
        System.out.println("\n──── BOOK A TICKET ────");

        System.out.print("  Flight Number (e.g. AI-101) : ");
        String flightNo = sc.nextLine().trim().toUpperCase();
        if (flightNo.isEmpty()) { System.out.println("  ⚠️  Flight number cannot be empty."); return; }

        System.out.print("  Passenger Name              : ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) { System.out.println("  ⚠️  Name cannot be empty."); return; }

        System.out.print("  Passenger Email             : ");
        String email = sc.nextLine().trim();
        if (email.isEmpty()) { System.out.println("  ⚠️  Email cannot be empty."); return; }

        System.out.print("  Number of Seats             : ");
        int seats;
        try {
            seats = Integer.parseInt(sc.nextLine().trim());
            if (seats <= 0) { System.out.println("  ⚠️  Seats must be at least 1."); return; }
        } catch (NumberFormatException e) {
            System.out.println("  ⚠️  Invalid number of seats.");
            return;
        }

        manager.bookTicket(flightNo, name, email, seats);
    }

    private static void handleCancellation() {
        System.out.println("\n──── CANCEL A BOOKING ────");
        System.out.print("  Enter Booking ID (e.g. BK1001): ");
        String bookingId = sc.nextLine().trim().toUpperCase();
        if (bookingId.isEmpty()) { System.out.println("  ⚠️  Booking ID cannot be empty."); return; }
        manager.cancelBooking(bookingId);
    }

    private static void handleViewBooking() {
        System.out.println("\n──── VIEW BOOKING ────");
        System.out.print("  Enter Booking ID (e.g. BK1001): ");
        String bookingId = sc.nextLine().trim().toUpperCase();
        if (bookingId.isEmpty()) { System.out.println("  ⚠️  Booking ID cannot be empty."); return; }
        manager.viewBooking(bookingId);
    }

    // ─── UI ──────────────────────────────────────────────────────────────────

    private static void printBanner() {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║    ✈️   FLIGHT MANAGEMENT SYSTEM   ✈️     ║");
        System.out.println("║         Welcome to AirJava Airlines      ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }

    private static void printMenu() {
        System.out.println("\n┌──────────────────────────────┐");
        System.out.println("│           MAIN MENU          │");
        System.out.println("├──────────────────────────────┤");
        System.out.println("│  1. View All Flights         │");
        System.out.println("│  2. Search by Destination    │");
        System.out.println("│  3. View Gate Allotments     │");
        System.out.println("│  4. Book a Ticket            │");
        System.out.println("│  5. Cancel a Booking         │");
        System.out.println("│  6. View My Booking          │");
        System.out.println("│  7. Exit                     │");
        System.out.println("└──────────────────────────────┘");
    }

    private static void printGoodbye() {
        System.out.println("\n  ✈️  Thank you for using AirJava Airlines!");
        System.out.println("      Have a safe flight. Goodbye! 👋\n");
    }
}
