package ir.ac.kntu;

public class Patient {
    private PatientInformationFile information;
    private Room room;
    private boolean isHealed = false;
    private ReleasingFactor releasingFactor;

    public Patient() {
    }

    public boolean isHealed() {
        return isHealed;
    }

    public Patient(int referTypeIdentifier, int kindOfIllnessIdentifier, int insuranceIdentifier,
                   String name, String nationalId,
                   int genderIdentifier, int age, int fileId, Date date) {
        room = new Room();
        information = new PatientInformationFile(name, nationalId,
                insuranceIdentifier, genderIdentifier, age, fileId);
        information.setLog(new HospitalizationLog(referTypeIdentifier, kindOfIllnessIdentifier, name, date));
        information.setHospitalizationSection();
        information.setHospitalizationDate(date);
        information.setKindOfIllness(information.getLog().getKindOfIllness());
        releasingFactor = new ReleasingFactor();
    }

    public void setPatientInformation(PatientInformationFile info) {
        information = info;
    }

    public PatientInformationFile getInformation() {
        return information;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean findDoctor(PatientInformationFile information) {
        int min = Integer.MAX_VALUE;
        int selectedIndex = 0;
        if (Hospital.getInstance().getDoctorsCount() == 0) {
            return false;
        }
        boolean foundADoctor = false;
        for (int i = 0; i < Hospital.getInstance().getDoctorsCount(); i++) {
            if (Hospital.getInstance().getDoctor(i).canCureNewPatient()) {
                if (Hospital.getInstance().getDoctor(i).getPatientsCount() < min) {
                    min = Hospital.getInstance().getDoctor(i).getPatientsCount();
                    selectedIndex = i;
                    foundADoctor = true;
                }
            }
        }
        if (foundADoctor) {
            information.setDoctor(Hospital.getInstance().getDoctor(selectedIndex));
            Hospital.getInstance().getDoctor(selectedIndex).addPatient(this);
            return true;
        }
        return false;

    }

    public void findCrowdEmergencyRoom(Emergency emergency) {
        room = emergency.findCrowdRoom();
        emergency.findCrowdRoom().addPatient(this);
        emergency.findCrowdRoom().getEmptyBed().setEmpty(false);

    }

    public void findSolitudeEmergencyRoom(Emergency emergency) {
        room = emergency.findSolitudeRoom();
        emergency.findSolitudeRoom().addPatient(this);
        emergency.findSolitudeRoom().getEmptyBed().setEmpty(false);

    }

    public void findSolitudePrincipalRoom(Principal principal) {
        room = principal.findSolitudeRoom();
        principal.findSolitudeRoom().addPatient(this);
        principal.findSolitudeRoom().getEmptyBed().setEmpty(false);
    }

    public void findCrowdPrincipalRoom(Principal principal) {
        room = principal.findCrowdRoom();
        principal.findCrowdRoom().addPatient(this);
        principal.findCrowdRoom().getEmptyBed().setEmpty(false);
    }

    public ReleasingFactor release() {
        for (int i = 0; i < room.getBedsCount(); i++) {
            if (room.getBed(i).getEmpty() == false) {
                room.getBed(i).setEmpty(true);
                ReleasingFactor releasingFactor = new ReleasingFactor(this);
                information.getDoctor().removePatient(this);
                this.isHealed = true;
                this.releasingFactor = releasingFactor;
                return releasingFactor;
            }
        }
        return null;
    }
}
