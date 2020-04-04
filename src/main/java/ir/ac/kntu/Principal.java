package ir.ac.kntu;

import java.util.ArrayList;

public class Principal {
    private ArrayList<Room> rooms;

    private ArrayList<Patient> patients;

    public Principal() {
        rooms = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Room findSolitudeRoom() {
        int min = Integer.MAX_VALUE;
        int index = 0;
        boolean foundARoom = false;
        if (rooms.size() == 0) {
            return null;
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isFull() == false &&
                    rooms.get(i).getStatement() == Enums.AvailabilityStatement.AVAILABLE) {
                if (rooms.get(i).findEmptyBedsCount() < min) {
                    min = rooms.get(i).findEmptyBedsCount();
                    index = i;
                    foundARoom = true;
                }
            }
        }
        if (foundARoom) {
            return rooms.get(index);
        }
        return null;
    }

    public Room findCrowdRoom() {
        int max = Integer.MIN_VALUE;
        int index = 0;
        boolean foundARoom = false;
        if (rooms.size() == 0) {
            return null;
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isFull() == false &&
                    rooms.get(i).getStatement() == Enums.AvailabilityStatement.AVAILABLE) {
                if (rooms.get(i).findFilledBedsCount() > max) {
                    max = rooms.get(i).findEmptyBedsCount();
                    index = i;
                    foundARoom = true;
                }
            }
        }
        if (foundARoom) {
            return rooms.get(index);
        }
        return null;

    }
    public void addPatient(Patient patient){
        patients.add(patient);
    }
    public Patient getPatient(int index){
        return patients.get(index);
    }
    public int getPatientsCount(){
        return patients.size();
    }

}
