public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private String gate;
    private double price;
    private int totalSeats;
    private int availableSeats;
    private boolean available;

    public Flight(String flightNumber, String origin, String destination,
                  String departureTime, String gate, double price, int totalSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.gate = gate;
        this.price = price;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.available = true;
    }

    // Getters
    public String getFlightNumber()  { return flightNumber; }
    public String getOrigin()        { return origin; }
    public String getDestination()   { return destination; }
    public String getDepartureTime() { return departureTime; }
    public String getGate()          { return gate; }
    public double getPrice()         { return price; }
    public int getTotalSeats()       { return totalSeats; }
    public int getAvailableSeats()   { return availableSeats; }
    public boolean isAvailable()     { return available && availableSeats > 0; }

    public void bookSeat()   { if (availableSeats > 0) availableSeats--; }
    public void cancelSeat() { if (availableSeats < totalSeats) availableSeats++; }

    public void display() {
        System.out.printf("%-10s %-15s %-15s %-12s %-6s $%-10.2f %-5d%n",
            flightNumber, origin, destination, departureTime, gate, price, availableSeats);
    }
}
