package ir.ac.kntu;

import java.util.*;

public class Nurse {
    private enum Shifts {
        MORNING, AFTERNOON, NIGHT
    }

    private String name;
    private String personnelId;
    private Enums.Sections workingSection;
    private ArrayList<Doctor> connectedDoctors;
    private ArrayList<Shifts> shifts;
    private int maxShiftsCount;

    public Nurse(String name, String personnelId) {
        this.name = name;
        this.personnelId = personnelId;
        connectedDoctors = new ArrayList<>();
        shifts = new ArrayList<>();
        maxShiftsCount = 6;
    }

    public Nurse(){
        connectedDoctors = new ArrayList<>();
        shifts = new ArrayList<>();
        maxShiftsCount = 6;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(String personnelId) {
        this.personnelId = personnelId;
    }

    public void addShift() {
        if (shifts.size() < maxShiftsCount) {
            Random rand = new Random();
            int randInt = rand.nextInt(3);
            switch (randInt) {
                case 0:
                    shifts.add(Nurse.Shifts.MORNING);
                case 1:
                    shifts.add(Nurse.Shifts.AFTERNOON);
                case 2:
                    shifts.add(Nurse.Shifts.NIGHT);
            }

        }

    }

    public Nurse.Shifts getCurrentShift() {
        return shifts.get(shifts.size() - 1);
    }

    public void addDoctor(Doctor doctor) {
        if (connectedDoctors.size() < 2) {
            connectedDoctors.add(doctor);
        }
    }

    public void removeDoctor(Doctor doctor) {
        connectedDoctors.remove(doctor);
    }

    public int getDoctorsCount() {
        return connectedDoctors.size();
    }

}
