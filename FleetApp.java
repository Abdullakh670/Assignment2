import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choose: ");

            switch (choice) {
                case 1:
                    printAllVehicles();
                    break;
                case 2:
                    addCar();
                    break;
                case 3:
                    addBus();
                    break;
                case 4:
                    showTotalInsurance();
                    break;
                case 5:
                    showOlderThanN();
                    break;
                case 6:
                    serviceAll();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Wrong option.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nFleet Management System");
        System.out.println("1. Print all vehicles");
        System.out.println("2. Add new car");
        System.out.println("3. Add new bus");
        System.out.println("4. Show total yearly insurance fees");
        System.out.println("5. Show vehicles older than N years");
        System.out.println("6. Perform service for all vehicles");
        System.out.println("7. Quit");
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return;
        }
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void addCar() {
        try {
            String model = readLine("Model: ");
            int year = readInt("Year: ");
            double price = readDouble("Base price: ");
            int doors = readInt("Doors: ");

            Car car = new Car(model, year, price, doors);
            vehicles.add(car);
            System.out.println("Added: " + car);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }
private void addBus() {
        try {
            String model = readLine("Model: ");
            int year = readInt("Year: ");
            double price = readDouble("Base price: ");
            int cap = readInt("Capacity: ");

            Bus bus = new Bus(model, year, price, cap);
            vehicles.add(bus);
            System.out.println("Added: " + bus);
        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }

    private void showTotalInsurance() {
        int currentYear = readInt("Current year: ");
        double total = 0;

        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee(currentYear);
        }
        System.out.println("Total insurance: " + total);
    }

    private void showOlderThanN() {
        int currentYear = readInt("Current year: ");
        int n = readInt("N years: ");

        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v + " | age=" + v.getAge(currentYear));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles older than " + n + " years.");
        }
    }

    private void serviceAll() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return;
        }

        // Polymorphism: we call methods through the interface type.
        for (Vehicle v : vehicles) {
            Serviceable s = v; // Vehicle implements Serviceable
            System.out.println("Interval: " + s.getServiceIntervalKm() + " km");
            s.performService();
        }

        // One more simple polymorphism example (as in requirements).
        Serviceable demo = new Car("Demo", 2020, 10000, 4);
        demo.performService();
    }

    // ---------- input helpers ----------
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer.");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}
