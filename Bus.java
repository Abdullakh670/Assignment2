public class Bus extends Vehicle {
    private int passengerCapacity;
  public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    // Capacity must be positive.
    public final void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be > 0.");
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee(int currentYear) {
        int age = getAge(currentYear);

        // TODO: choose a different formula than Car.
        // Example: 7% from basePrice + age factor + capacity factor
        return getBasePrice() * 0.07 + age * 150 + passengerCapacity * 5;
    }

    @Override
    public void performService() {
        System.out.println("Bus #" + getId() + ": service done (brakes + engine check).");
    }

    @Override
    public int getServiceIntervalKm() {
        return 7000; // TODO: you can change this value
    }

    @Override
    public String toString() {
        return "Bus{id=" + getId() +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", basePrice=" + getBasePrice() +
                ", capacity=" + passengerCapacity +
                '}';
    }
}
