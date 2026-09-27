public class Police extends Account {

    private String policeId;
    private String assignedLocation;
    private boolean onDuty;

    public Police(String accountId, String name, String phone,
                  String policeId, String assignedLocation) {

        super(accountId, name, phone);
        this.policeId = policeId;
        this.assignedLocation = assignedLocation;
        this.onDuty = true;
    }

    public String getPoliceId() {
        return policeId;
    }

    public String getAssignedLocation() {
        return assignedLocation;
    }

    public boolean isOnDuty() {
        return onDuty;
    }

    public void setOnDuty(boolean onDuty) {
        this.onDuty = onDuty;
    }

    public boolean approveEmergency(EmergencyRequest request) {
        if (!onDuty) {
            return false;
        }
        request.approve();
        return true;
    }

    public boolean clearJunction(JunctionClearance clearance) {
        if (!onDuty) {
            return false;
        }
        clearance.clear();
        return true;
    }

    public void monitorTraffic() {
        System.out.println("Officer " + name + " monitoring " + assignedLocation);
    }

    @Override
    public String displayInfo() {
        return super.displayInfo() +
                "\nPolice ID: " + policeId +
                "\nAssigned Location: " + assignedLocation +
                "\nOn Duty: " + (onDuty ? "YES" : "NO");
    }
}
