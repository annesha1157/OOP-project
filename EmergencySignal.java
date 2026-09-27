public class EmergencySignal extends RoadSignal {

    private boolean emergencyActive;
    private String emergencyVehicleId;

    public EmergencySignal(String signalId, String location, int laneCount) {
        super(signalId, location, laneCount);
        this.emergencyActive = false;
        this.emergencyVehicleId = null;
    }

    public boolean isEmergencyActive() {
        return emergencyActive;
    }

    public String getEmergencyVehicleId() {
        return emergencyVehicleId;
    }

    public void activateEmergency(String emergencyVehicleId) {
        this.emergencyActive = true;
        this.emergencyVehicleId = emergencyVehicleId;
        this.state = "GREEN";
        this.on = true;
    }

    public void completeEmergency() {
        this.emergencyActive = false;
        this.emergencyVehicleId = null;
        this.state = "RED";
    }

    @Override
    public String displaySignal() {
        String base = super.displaySignal();
        if (emergencyActive) {
            base += "\nEMERGENCY ACTIVE for vehicle: " + emergencyVehicleId;
        }
        return base;
    }
}
