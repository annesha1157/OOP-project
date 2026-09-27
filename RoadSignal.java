public class RoadSignal extends TrafficSignal {

    private int vehicleCount;
    private int laneCount;

    public RoadSignal(String signalId, String location, int laneCount) {
        super(signalId, location);
        this.laneCount = laneCount;
        this.vehicleCount = 0;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public int getLaneCount() {
        return laneCount;
    }

    public void updateVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    public String getDensity() {
        if (vehicleCount <= 35) {
            return "LOW";
        } else if (vehicleCount <= 70) {
            return "MEDIUM";
        } else {
            return "HIGH";
        }
    }

    public int getGreenTime() {
        switch (getDensity()) {
            case "LOW":
                return 20;
            case "MEDIUM":
                return 40;
            default:
                return 60;
        }
    }

    @Override
    public String displaySignal() {
        return "Signal: " + signalId +
                "\nLocation: " + location +
                "\nState: " + state +
                "\nLanes: " + laneCount +
                "\nVehicles: " + vehicleCount +
                "\nDensity: " + getDensity() +
                "\nGreen Time: " + getGreenTime() + "s";
    }
}
