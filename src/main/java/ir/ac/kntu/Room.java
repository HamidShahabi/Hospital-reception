package ir.ac.kntu;

import java.util.ArrayList;

public class Room {


    private enum AvailabilityStatement {
        AVAILABLE, UNAVAILABLE
    }

    private int roomNum;

    private AvailabilityStatement statement;
    private Sections roomSection;
    private int bedsCount;
    private ArrayList<Bed> beds = new ArrayList<>(bedsCount);
    private ArrayList<Patient> patients;
    private int roomCost;

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

    public ir.ac.kntu.Room.AvailabilityStatement getStatement() {
        return statement;
    }

    public void setStatement(ir.ac.kntu.Room.AvailabilityStatement statement) {
        this.statement = statement;
    }

    public ir.ac.kntu.Room.Sections getRoomSection() {
        return roomSection;
    }

    public void setRoomSection(ir.ac.kntu.Room.Sections roomSection) {
        this.roomSection = roomSection;
    }


    public int getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }

    public ArrayList<Bed> getBeds() {
        return beds;
    }

    public void setBeds(ArrayList<Bed> beds) {
        this.beds = beds;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
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
    public void addPatient(Patient patient){
        patients.add(patient);
    }
    public Bed getEmptyBed(){
        for(int i = 0;i < beds.size();i++){
            if(beds.get(i).getEmpty() == true){
                return beds.get(i);
            }
        }
        return null;
    }


}
