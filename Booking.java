public class Booking {
    private static int counter = 1000;

    private String bookingId;
    private String flightNumber;
    private String passengerName;
    private String passengerEmail;
    private int seats;
    private double totalPrice;

    public Booking(String flightNumber, String passengerName, String passengerEmail, int seats, double pricePerSeat) {
        this.bookingId     = "BK" + (++counter);
        this.flightNumber  = flightNumber;
        this.passengerName = passengerName;
        this.passengerEmail = passengerEmail;
        this.seats         = seats;
        this.totalPrice    = seats * pricePerSeat;
    }

    public String getBookingId()     { return bookingId; }
    public String getFlightNumber()  { return flightNumber; }
    public String getPassengerName() { return passengerName; }
    public int    getSeats()         { return seats; }
    public double getTotalPrice()    { return totalPrice; }

    public void display() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("          🎫 BOOKING CONFIRMED");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("  Booking ID    : " + bookingId);
        System.out.println("  Flight        : " + flightNumber);
        System.out.println("  Passenger     : " + passengerName);
        System.out.println("  Email         : " + passengerEmail);
        System.out.println("  Seats Booked  : " + seats);
        System.out.printf ("  Total Price   : $%.2f%n", totalPrice);
        System.out.println("════════════════════════════════════════");
    }
}
