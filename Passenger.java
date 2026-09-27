public class Passenger extends Account implements Trackable {

    private String currentLocation;
    private String destination;

    public Passenger(String accountId, String name, String phone, String currentLocation) {
        super(accountId, name, phone);
        this.currentLocation = currentLocation;
        this.destination = "Unknown";
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String getLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }

    public RoadCrossingRequest requestRoadCrossing(String requestId, int numberOfPeople) {
        return new RoadCrossingRequest(requestId, accountId, currentLocation, numberOfPeople);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
                "\nCurrent Location: " + currentLocation +
                "\nDestination: " + destination;
    }
}
