public abstract class Vehicle implements Serviceable {
    private int id;
    private static int idGen = 1;

    private String model;
    private int year;
    private double basePrice;

    // We set id automatically. Then we use setters to validate inputs.
    protected Vehicle(String model, int year, double basePrice) {
        this.id = idGen;
        idGen++;

        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    // Model must not be null or empty.
    public final void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model is empty.");
        }
        this.model = model.trim();
    }

    public int getYear() {
        return year;
    }

    // Year must be in a reasonable range.
    public final void setYear(int year) {
        // TODO: choose a reasonable range (example: 1886..2100)
        if (year < 1886 || year > 2100) {
            throw new IllegalArgumentException("Year is out of range.");
        }
        this.year = year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    // Base price must be greater than 0.
    public final void setBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be > 0.");
        }
        this.basePrice = basePrice;
    }

    // This method returns how old the vehicle is.
    public int getAge(int currentYear) {
        return currentYear - year;
    }

    // Each subclass must implement its own insurance formula.
    public abstract double calculateInsuranceFee(int currentYear);

    @Override
    public String toString() {
        return "Vehicle{id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", basePrice=" + basePrice +
                '}';
    }
}
