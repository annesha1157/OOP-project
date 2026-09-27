public class EmergencyVehicle extends Vehicle {

    private String emergencyType;
    private int priority;
    private String emergencyStatus;

    public EmergencyVehicle(String accountId, String name, String phone,
                             String vehicleNumber, String vehicleType,
                             String currentLocation, String destination,
                             String emergencyType) {

        super(accountId, name, phone, vehicleNumber, vehicleType, currentLocation, destination);
        this.emergencyType = emergencyType;
        this.priority = calculatePriority(emergencyType);
        this.emergencyStatus = "STANDBY";
    }

    private int calculatePriority(String type) {
        switch (type) {
            case "Ambulance":
                return 5;
            case "Fire Truck":
                return 4;
            case "Police Vehicle":
                return 3;
            default:
                return 1;
        }
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public int getPriority() {
        return priority;
    }

    public String getEmergencyStatus() {
        return emergencyStatus;
    }

    public void setEmergencyStatus(String emergencyStatus) {
        this.emergencyStatus = emergencyStatus;
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
                "\nEmergency Type: " + emergencyType +
                "\nPriority: " + priority +
                "\nEmergency Status: " + emergencyStatus;
    }
}
