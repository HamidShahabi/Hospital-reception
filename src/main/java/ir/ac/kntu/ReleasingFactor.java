package ir.ac.kntu;

public class ReleasingFactor {
    private int hospitalizationDaysCount;

    public ReleasingFactor(double roomDailyCost) {
        this.roomDailyCost = roomDailyCost;
    }
    private Date releaseDate;
    private double roomDailyCost;
    private double fullCost;
    private double finalCost;

    public ReleasingFactor(Patient patient) {
        roomDailyCost = patient.getRoom().getRoomCost();
        setHospitalizationDaysCount(patient.getInformation().getHospitalizationDate());
        setFinalCost(patient);
        setFullCost();
        releaseDate = new Date();

    }


    public void setHospitalizationDaysCount(Date hospitalizationDate) {
        Date today = new Date();
        this.hospitalizationDaysCount = today.getDayOfYear()
                - hospitalizationDate.getDayOfYear();
    }

    public void setRoomDailyCost(double RoomDailyCost) {
        this.roomDailyCost = roomDailyCost;
    }

    public void setFullCost() {
        this.fullCost = roomDailyCost * hospitalizationDaysCount;
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


