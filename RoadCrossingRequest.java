public class RoadCrossingRequest {

    private String requestId;
    private String passengerId;
    private String location;
    private int numberOfPeople;
    private String status;

    public RoadCrossingRequest(String requestId, String passengerId,
                                String location, int numberOfPeople) {

        this.requestId = requestId;
        this.passengerId = passengerId;
        this.location = location;
        this.numberOfPeople = numberOfPeople;
        this.status = "PENDING";
    }

    public String getRequestId() {
        return requestId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getLocation() {
        return location;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public String getStatus() {
        return status;
    }

    public String getDensity() {
        if (numberOfPeople <= 10) {
            return "LOW";
        } else if (numberOfPeople <= 30) {
            return "MEDIUM";
        } else {
            return "HIGH";
        }
    }

    public int getCrossingTime() {
        switch (getDensity()) {
            case "LOW":
                return 15;
            case "MEDIUM":
                return 25;
            default:
                return 40;
        }
    }

    public void approve() {
        status = "APPROVED";
    }

    @Override
    public String toString() {
        return "Crossing Request: " + requestId +
                "\nPassenger: " + passengerId +
                "\nLocation: " + location +
                "\nPeople: " + numberOfPeople +
                "\nDensity: " + getDensity() +
                "\nCrossing Time: " + getCrossingTime() + "s" +
                "\nStatus: " + status;
    }
}
