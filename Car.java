public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    // Doors must be positive.
    public final void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <= 0) {
            throw new IllegalArgumentException("Doors must be > 0.");
        }
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee(int currentYear) {
        int age = getAge(currentYear);

        // TODO: choose a simple formula.
        // Example: 5% from basePrice + age factor + doors small factor
        return getBasePrice() * 0.05 + age * 100 + numberOfDoors * 20;
    }

    @Override
    public void performService() {
        System.out.println("Car #" + getId() + ": service done (oil + check).");
    }

    @Override
    public int getServiceIntervalKm() {
        return 10000; // TODO: you can change this value
    }

    @Override
    public String toString() {
        return "Car{id=" + getId() +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", basePrice=" + getBasePrice() +
                ", doors=" + numberOfDoors +
                '}';
    }
}
