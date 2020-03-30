package ir.ac.kntu;

public class Patient {
    private PatientInformationFile information;

    public void setPatientInformation(PatientInformationFile info) {
        information = info;
    }

    public PatientInformationFile getInformation() {
        return information;
    }

    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void findDoctor(PatientInformationFile information) {
        int min = Integer.MAX_VALUE;
        int selectedIndex = 0;
        for (int i = 0; i < Hospital.getInstance().getDoctorsCount(); i++) {
            if (Hospital.getInstance().getDoctor(i).canCureNewPatient()) {
                if (Hospital.getInstance().getDoctor(i).getPatientsCount() < min) {
                    min = Hospital.getInstance().getDoctor(i).getPatientsCount();
                    selectedIndex = i;
                }
            }
        }
        information.setDoctor(Hospital.getInstance().getDoctor(selectedIndex));
        Hospital.getInstance().getDoctor(selectedIndex).addPatient(this);
    }

    public void findCrowdEmergencyRoom(Emergency emergency) {
        room = emergency.findCrowdRoom();
        emergency.findCrowdRoom().addPatient(this);
        emergency.findCrowdRoom().getEmptyBed().setPatient(this);
        emergency.findCrowdRoom().getEmptyBed().setEmpty(false);

    }

    public void findSolitudeEmergencyRoom(Emergency emergency) {
        room = emergency.findSolitudeRoom();
        emergency.findSolitudeRoom().addPatient(this);
        emergency.findSolitudeRoom().getEmptyBed().setPatient(this);
        emergency.findSolitudeRoom().getEmptyBed().setEmpty(false);

    }

    public void findSolitudePrincipalRoom(Principal principal) {
        room = principal.findSolitudeRoom();
        principal.findSolitudeRoom().addPatient(this);
        principal.findSolitudeRoom().getEmptyBed().setPatient(this);
        principal.findSolitudeRoom().getEmptyBed().setEmpty(false);
    }

    public void findCrowdPrincipalRoom(Principal principal) {
        room = principal.findCrowdRoom();
        principal.findCrowdRoom().addPatient(this);
        principal.findCrowdRoom().getEmptyBed().setPatient(this);
        principal.findCrowdRoom().getEmptyBed().setEmpty(false);
    }
}
