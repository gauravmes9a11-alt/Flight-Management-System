#  Flight Management System

A Java-based console application that allows users to search for available flights, view gate assignments, and check ticket prices — all through a simple interactive interface.

---

##  Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Getting Started](#getting-started)
- [How to Run](#how-to-run)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

---

##  About the Project

The Flight Management System is a beginner-friendly Java console application designed to simulate a basic flight information system. Users can interact with the system to find available flights, check which gate a flight is departing from, and view the ticket price — all from the command line.

---

##  Features

-  **View Available Flights** — Displays a list of currently available flights
-  **Gate Allotment** — Shows which gate is assigned to each flight
-  **Ticket Pricing** — Displays the price for each available flight
-  **Console-Based UI** — Simple and easy-to-use text interface
-  **User Input Handling** — Takes real-time input from the user to filter or browse flights

---

##  Getting Started

### Prerequisites

Make sure you have the following installed:

- [Java JDK 8 or above](https://www.oracle.com/java/technologies/downloads/)
- A terminal / command prompt
- *(Optional)* An IDE like [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/)

### Clone the Repository

```bash
git clone https://github.com/your-username/flight-management-system.git
cd flight-management-system
```

---

##  How to Run

### Using the Terminal

1. **Compile the Java files:**
   ```bash
   javac *.java
   ```

2. **Run the program:**
   ```bash
   java Main
   ```

### Using an IDE

1. Open the project folder in your IDE
2. Locate the `Main.java` file
3. Click **Run**

---

##  Usage

Once the program starts, follow the on-screen prompts:

```
Welcome to Flight Management System
------------------------------------
Enter your destination: New York

Available Flights:
--------------------------------------------------
Flight No.   Destination    Gate    Price
--------------------------------------------------
AI-101       New York       G-12    $250
AI-205       New York       G-07    $310
--------------------------------------------------
```

The system will display all matching flights along with their gate numbers and prices.

---

##  Project Structure

```
flight-management-system/
│
├── Main.java          # Entry point of the application
├── Flight.java        # Flight class / data model
├── FlightManager.java # Core logic for managing flights
└── README.md          # Project documentation
```

>  File names may vary depending on your implementation.

---

## 🛠️ Technologies Used

| Technology | Details          |
|------------|------------------|
| Language   | Java             |
| I/O        | Console (Scanner)|
| IDE        | Any Java IDE     |
| Build Tool | None (plain Java)|

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

---

--THANKYOU--
