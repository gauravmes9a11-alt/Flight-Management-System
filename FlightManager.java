import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightManager {

    private List<Flight> flights = new ArrayList<>();
    private Map<String, Booking> bookings = new HashMap<>();

    public FlightManager() {
        loadFlights();
    }

    // ─── Hardcoded flight data ────────────────────────────────────────────────
    private void loadFlights() {
        flights.add(new Flight("AI-101", "Mumbai",    "New York",    "08:00 AM", "G-12", 250.00, 5));
        flights.add(new Flight("AI-202", "Delhi",     "London",      "10:30 AM", "G-07", 320.00, 5));
        flights.add(new Flight("AI-303", "Chennai",   "Dubai",       "01:00 PM", "G-03", 150.00, 5));
        flights.add(new Flight("AI-404", "Kolkata",   "Singapore",   "03:45 PM", "G-09", 180.00, 5));
        flights.add(new Flight("AI-505", "Bangalore", "Tokyo",       "06:15 PM", "G-11", 400.00, 5));
        flights.add(new Flight("AI-606", "Hyderabad", "Paris",       "09:00 PM", "G-05", 350.00, 5));
        flights.add(new Flight("AI-707", "Mumbai",    "Sydney",      "11:30 PM", "G-14", 500.00, 5));
        flights.add(new Flight("AI-808", "Delhi",     "New York",    "02:15 AM", "G-02", 270.00, 5));
        flights.add(new Flight("AI-909", "Chennai",   "Singapore",   "05:00 AM", "G-08", 160.00, 5));
        flights.add(new Flight("AI-110", "Bangalore", "London",      "07:30 AM", "G-06", 330.00, 5));
    }

    // ─── Display all available flights ───────────────────────────────────────
    public void showAllFlights() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                         ALL AVAILABLE FLIGHTS                             ");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════╝");
        printTableHeader();
        boolean found = false;
        for (Flight f : flights) {
            if (f.isAvailable()) {
                f.display();
                found = true;
            }
        }
        if (!found) System.out.println("  No flights available at the moment.");
        System.out.println("════════════════════════════════════════════════════════════════════════════");
    }

    // ─── Search flights by destination ───────────────────────────────────────
    public void searchByDestination(String destination) {
        System.out.println("\n╔══════════════════════════════════════════════════════════════════════════╗");
        System.out.println("  FLIGHTS TO: " + destination.toUpperCase());
        System.out.println("╚══════════════════════════════════════════════════════════════════════════╝");
        printTableHeader();
        boolean found = false;
        for (Flight f : flights) {
            if (f.getDestination().equalsIgnoreCase(destination) && f.isAvailable()) {
                f.display();
                found = true;
            }
        }
        if (!found) System.out.println("  No flights found to " + destination + ".");
        System.out.println("════════════════════════════════════════════════════════════════════════════");
    }

    // ─── Show gate allotments ─────────────────────────────────────────────────
    public void showGateAllotments() {
        System.out.println("\n╔═══════════════════════════════════╗");
        System.out.println("         GATE ALLOTMENTS              ");
        System.out.println("╚═══════════════════════════════════╝");
        System.out.printf("%-10s %-20s %-6s%n", "Flight No.", "Destination", "Gate");
        System.out.println("────────────────────────────────────");
        for (Flight f : flights) {
            System.out.printf("%-10s %-20s %-6s%n", f.getFlightNumber(), f.getDestination(), f.getGate());
        }
        System.out.println("════════════════════════════════════");
    }

    // ─── Book a ticket ────────────────────────────────────────────────────────
    public void bookTicket(String flightNumber, String passengerName, String passengerEmail, int seats) {
        Flight flight = findFlight(flightNumber);

        if (flight == null) {
            System.out.println("\n  ❌ Flight " + flightNumber + " not found.");
            return;
        }
        if (!flight.isAvailable()) {
            System.out.println("\n  ❌ Flight " + flightNumber + " is not available.");
            return;
        }
        if (seats > flight.getAvailableSeats()) {
            System.out.println("\n  ❌ Only " + flight.getAvailableSeats() + " seat(s) available on this flight.");
            return;
        }

        for (int i = 0; i < seats; i++) flight.bookSeat();

        Booking booking = new Booking(flightNumber, passengerName, passengerEmail, seats, flight.getPrice());
        bookings.put(booking.getBookingId(), booking);

        System.out.println();
        booking.display();
        System.out.println("  Gate      : " + flight.getGate());
        System.out.println("  Departure : " + flight.getDepartureTime());
        System.out.println("════════════════════════════════════════");
        System.out.println("  ✅ Please keep your Booking ID safe!");
    }

    // ─── Cancel a booking ────────────────────────────────────────────────────
    public void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);

        if (booking == null) {
            System.out.println("\n  ❌ Booking ID " + bookingId + " not found.");
            return;
        }

        Flight flight = findFlight(booking.getFlightNumber());
        if (flight != null) {
            for (int i = 0; i < booking.getSeats(); i++) flight.cancelSeat();
        }

        bookings.remove(bookingId);
        System.out.println("\n  ✅ Booking " + bookingId + " has been successfully cancelled.");
        System.out.printf("  Refund of $%.2f will be processed.%n", booking.getTotalPrice());
    }

    // ─── View a booking ──────────────────────────────────────────────────────
    public void viewBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking == null) {
            System.out.println("\n  ❌ No booking found with ID: " + bookingId);
            return;
        }
        System.out.println();
        booking.display();

        Flight flight = findFlight(booking.getFlightNumber());
        if (flight != null) {
            System.out.println("  Gate      : " + flight.getGate());
            System.out.println("  Departure : " + flight.getDepartureTime());
            System.out.println("════════════════════════════════════════");
        }
    }

    // ─── Helpers ──────────────────────────────────────────────────────────────
    private Flight findFlight(String flightNumber) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equalsIgnoreCase(flightNumber)) return f;
        }
        return null;
    }

    private void printTableHeader() {
        System.out.printf("%-10s %-15s %-15s %-12s %-6s %-12s %-5s%n",
            "Flight No.", "From", "To", "Departure", "Gate", "Price", "Seats");
        System.out.println("────────────────────────────────────────────────────────────────────────────");
    }
}
