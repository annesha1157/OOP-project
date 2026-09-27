public class EmergencyRequest {

    private String requestId;
    private String vehicleId;
    private String location;
    private String destination;
    private int priority;
    private String status;

    public EmergencyRequest(String requestId, String vehicleId, String location,
                             String destination, int priority) {

        this.requestId = requestId;
        this.vehicleId = vehicleId;
        this.location = location;
        this.destination = destination;
        this.priority = priority;
        this.status = "PENDING";
    }

    public String getRequestId() {
        return requestId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getLocation() {
        return location;
    }

    public String getDestination() {
        return destination;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        status = "APPROVED";
    }

    public void reject() {
        status = "REJECTED";
    }

    public void complete() {
        status = "COMPLETED";
    }

    @Override
    public String toString() {
        return "Request: " + requestId +
                "\nVehicle: " + vehicleId +
                "\nLocation: " + location +
                "\nDestination: " + destination +
                "\nPriority: " + priority +
                "\nStatus: " + status;
    }
}
