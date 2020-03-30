package ir.ac.kntu;

public class Bed {
    private Room room;
    private Patient patient;
    private boolean empty;

    public Bed(Room room, Patient patient, boolean empty) {
        this.room = room;
        this.patient = patient;
        this.empty = empty;
    }
    public Bed(){
        empty = false;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public boolean getEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
