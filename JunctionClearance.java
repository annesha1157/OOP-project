public class JunctionClearance {

    private String junctionId;
    private String officerName;
    private String status;

    public JunctionClearance() {
        this("J000", "Unknown");
    }

    public JunctionClearance(String junctionId, String officerName) {
        this.junctionId = junctionId;
        this.officerName = officerName;
        this.status = "REQUESTED";
    }

    public String getJunctionId() {
        return junctionId;
    }

    public String getOfficerName() {
        return officerName;
    }

    public String getStatus() {
        return status;
    }

    public void startClearance() {
        status = "PROCESSING";
    }

    public void clear() {
        status = "CLEARED";
    }

    public void cancel() {
        status = "CANCELLED";
    }

    @Override
    public String toString() {
        return "Junction: " + junctionId +
                "\nOfficer: " + officerName +
                "\nClearance Status: " + status;
    }
}
