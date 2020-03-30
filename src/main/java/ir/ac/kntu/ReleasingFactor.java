package ir.ac.kntu;

public class ReleasingFactor {
    private PatientInformationFile information;
    private int hospitalizationDaysCount;

    public ReleasingFactor(double roomDailyCost) {
        this.roomDailyCost = roomDailyCost;
    }

    private double roomDailyCost;
    private double fullCost;
    private double finalCost;

    public ReleasingFactor(PatientInformationFile information) {
        this.information = information;
    }

    public void getPatientInformation(PatientInformationFile info) {
        information = info;
    }

    public void setHospitalizationDaysCount(Date firstDate, Date lastDate) {

        this.hospitalizationDaysCount = lastDate.getDayOfYear()
                - firstDate.getDayOfYear();
    }

    public void setRoomDailyCost(int RoomDailyCost) {
        this.roomDailyCost = roomDailyCost;
    }

    public void setFullCost() {
        this.fullCost = roomDailyCost * hospitalizationDaysCount;
    }

    public PatientInformationFile getInformation() {
        return information;
    }

    public int getHospitalizationDaysCount() {
        return hospitalizationDaysCount;
    }

    public double getRoomDailyCost() {
        return roomDailyCost;
    }

    public double getFullCost() {
        return fullCost;
    }

    public double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Patient patient) {
        if (patient.getInformation().getInsurance() == Enums.Insurances.ARMEDFORCES) {
            finalCost = 0.5 * fullCost;
        } else if (patient.getInformation().getInsurance() == Enums.Insurances.HEALTHSERVICE) {
            finalCost = 0.75 * fullCost;
        } else if (patient.getInformation().getInsurance() == Enums.Insurances.SOCIALSECURITY) {
            finalCost = 0.9 * fullCost;
        } else if (patient.getInformation().getInsurance() == Enums.Insurances.NONE) {
            finalCost = fullCost;
        }
    }


}


