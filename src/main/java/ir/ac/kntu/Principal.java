package ir.ac.kntu;

import java.util.ArrayList;

public class Principal {
    private ArrayList<Room> rooms;

    private ArrayList<Patient> patients;

    public Principal() {
        rooms = new ArrayList<>();
        patients = new ArrayList<>();
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

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public Patient getPatient(int index) {
        if(index < patients.size()){
            return patients.get(index);
        }
        return null;

    }

    public int getPatientsCount() {
        return patients.size();
    }

    public void setPatient(int index, Patient patient) {
        patients.set(index, patient);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public int getRoomsCount() {
        return rooms.size();
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }

    public int getEmptyBedsCount() {
        int emptyBedsCount = 0;
        for (int i = 0; i < getRoomsCount(); i++) {
            emptyBedsCount += rooms.get(i).getEmptyBedsCount();
        }
        return emptyBedsCount;
    }

    public void removeRoom(int index) {
        rooms.remove(index);
    }
}
