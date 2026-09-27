public class Vehicle extends Account implements Trackable {

    protected String vehicleNumber;
    protected String vehicleType;
    protected String currentLocation;
    protected String destination;
    protected String status;

    public Vehicle(String accountId, String name, String phone,
                    String vehicleNumber, String vehicleType,
                    String currentLocation, String destination) {

        super(accountId, name, phone);
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.currentLocation = currentLocation;
        this.destination = destination;
        this.status = "ACTIVE";
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getDestination() {
        return destination;
    }

    public String getStatus() {
        return status;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }

    public void registerVehicle() {
        System.out.println("Vehicle registered: " + vehicleNumber);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
                "\nVehicle Number: " + vehicleNumber +
                "\nVehicle Type: " + vehicleType +
                "\nCurrent Location: " + currentLocation +
                "\nDestination: " + destination +
                "\nStatus: " + status;
    }
}
