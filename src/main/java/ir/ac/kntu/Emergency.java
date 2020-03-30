package ir.ac.kntu;

import java.util.ArrayList;

public class Emergency {
    private ArrayList<Room> rooms;
    public Emergency(){
        rooms = new ArrayList<>();
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
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isFull() == false) {
                if (rooms.get(i).findEmptyBedsCount() < min) {
                    min = rooms.get(i).findEmptyBedsCount();
                    index = i;
                }
            }
        }
        return rooms.get(index);
    }
    public Room findCrowdRoom(){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isFull() == false) {
                if (rooms.get(i).findFilledBedsCount() > max) {
                    max = rooms.get(i).findEmptyBedsCount();
                    index = i;
                }
            }
        }
        return rooms.get(index);
    }
//    private ArrayList<Patient> patients;
}
