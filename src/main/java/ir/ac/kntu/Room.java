package ir.ac.kntu;

import java.util.ArrayList;

public class Room {

    private int roomNum;
    private Enums.AvailabilityStatement statement;
    private Enums.Sections roomSection;
    private int bedsCount;
    private ArrayList<Bed> beds;
    private ArrayList<Patient> patients;
    private int roomCost;

    public Room(){}
    public Room(int roomNum, Enums.Sections roomSection, int bedsCount, int roomCost) {
        this.roomNum = roomNum;
        this.roomSection = roomSection;
        this.bedsCount = bedsCount;
        this.roomCost = roomCost;
        beds = new ArrayList<>();
        patients = new ArrayList<>();
        statement = Enums.AvailabilityStatement.AVAILABLE;
        for(int i = 0;i < bedsCount;i++){
            beds.add(new Bed());
        }
    }

    public boolean isFull() {
        boolean roomIsFull = true;
        for (int i = 0; i < beds.size(); i++) {
            if (beds.get(i).getEmpty() == true) {
                roomIsFull = false;
            }
        }
        return roomIsFull;
    }

    public int findEmptyBedsCount() {
        int count = 0;
        for (int i = 0; i < beds.size(); i++) {
            if (beds.get(i).getEmpty() == true) {
                count++;
            }
        }
        return count;
    }

    public int findFilledBedsCount() {

        return bedsCount - findEmptyBedsCount();
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public Enums.AvailabilityStatement getStatement() {
        return statement;
    }

    public void setStatement(Enums.AvailabilityStatement statement) {
        this.statement = statement;
    }

    public Enums.Sections getRoomSection() {
        return roomSection;
    }

    public void setRoomSection(Enums.Sections roomSection) {
        this.roomSection = roomSection;
    }


    public int getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }

    public Bed getBed(int index) {
        if (index >= 0 && index < beds.size()) {
            return beds.get(index);
        }
        return null;
    }

    public void setBeds(ArrayList<Bed> beds) {
        this.beds = beds;
    }

    public Patient getPatient(int index) {
        return patients.get(index);
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public int getRoomCost() {
        if (bedsCount > 1) {
            roomCost -= 0.1 * bedsCount * roomCost;
        }
        return roomCost;
    }

    public void setRoomCost(int roomCost) {
        if (bedsCount > 1) {
            roomCost -= 0.1 * bedsCount * roomCost;
        }

        this.roomCost = roomCost;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public Bed getEmptyBed() {
        for (int i = 0; i < beds.size(); i++) {
            if (beds.get(i).getEmpty() == true) {
                return beds.get(i);
            }
        }
        return null;
    }

    public void addBed(Bed bed) {
        this.bedsCount++;
        beds.add(bed);
    }

    public int getEmptyBedsCount() {
        int emptyBedsCount = 0;
        for (int i = 0; i < bedsCount; i++) {
            if (beds.get(i).getEmpty() == true) {
                emptyBedsCount++;
            }
        }
        return emptyBedsCount;
    }

    public int getPatientsCount() {
        return patients.size();
    }

}
