package ir.ac.kntu;

import java.util.ArrayList;

public class Principal {
    private ArrayList<Room> rooms;
//    private ArrayList<Patient> patients;

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    public Room findSolitudeRoom() {
        int min = Integer.MAX_VALUE;
        Room selectedRoom = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isFull() == false) {
                if (rooms.get(i).findEmptyBedsCount() < min) {
                    min = rooms.get(i).findEmptyBedsCount();
                    selectedRoom = rooms.get(i);
                }
            }
        }
        return selectedRoom;
    }
    public Room findCrowdRoom(){
        int max = Integer.MIN_VALUE;
        Room selectedRoom = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isFull() == false) {
                if (rooms.get(i).findFilledBedsCount() > max) {
                    max = rooms.get(i).findEmptyBedsCount();
                    selectedRoom = rooms.get(i);
                }
            }
        }
        return selectedRoom;
    }

}
