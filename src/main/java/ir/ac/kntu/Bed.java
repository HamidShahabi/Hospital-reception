package ir.ac.kntu;

public class Bed {
    private Room room;
    private boolean empty;

    public Bed(Room room, boolean empty) {
        this.room = room;
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

    public boolean getEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}
