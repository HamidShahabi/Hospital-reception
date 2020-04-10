package ir.ac.kntu;

public class Shift {
    private Enums.Weekday sat = Enums.Weekday.SATURDAY;
    private Enums.Weekday sun = Enums.Weekday.SUNDAY;
    private Enums.Weekday mon = Enums.Weekday.MONDAY;
    private Enums.Weekday tue = Enums.Weekday.TUESDAY;
    private Enums.Weekday wed = Enums.Weekday.WEDNESDAY;
    private Enums.Weekday thu = Enums.Weekday.THURSDAY;
    private Enums.Weekday fri = Enums.Weekday.FRIDAY;
    private int doctorPersonnelID;

    public int getDoctorPersonnelID() {
        return doctorPersonnelID;
    }

    public void setDoctorPersonnelID(int doctorPersonnelID) {
        this.doctorPersonnelID = doctorPersonnelID;
    }

    public Enums.Weekday getSat() {
        return sat;
    }

    public Enums.Weekday getSun() {
        return sun;
    }

    public Enums.Weekday getMon() {
        return mon;
    }

    public Enums.Weekday getTue() {
        return tue;
    }

    public Enums.Weekday getWed() {
        return wed;
    }

    public Enums.Weekday getThu() {
        return thu;
    }

    public Enums.Weekday getFri() {
        return fri;
    }
}
