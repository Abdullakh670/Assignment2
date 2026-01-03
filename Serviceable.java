public interface Serviceable {
    // This method should describe what service we do for this object.
    void performService();

    // This method returns how often (in km) the object needs service.
    int getServiceIntervalKm();
}
