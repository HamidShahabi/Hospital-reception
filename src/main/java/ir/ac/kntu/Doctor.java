package ir.ac.kntu;

import java.util.*;
import java.util.Objects;

public class Doctor {
    private enum Shifts {
        MORNING, AFTERNOON, NIGHT
    }

    private String name;
    private String personnelId;
    private int maxShiftsCount;
    private String workingSection;
    private ArrayList<Shifts> shifts;
    private ArrayList<Patient> patients;
    private ArrayList<Nurse> connectedNurses;

    public Doctor(String name, String personnelId,int maxShiftsCount) {
        this.name = name;
        this.personnelId = personnelId;
        this.maxShiftsCount = maxShiftsCount;
        patients = new ArrayList<>();
        for(int i = 0;i < 5;i++){
            patients.add(new Patient());
        }

        connectedNurses = new ArrayList<>();
        connectedNurses.add(new Nurse());
        connectedNurses.add(new Nurse());
        shifts = new ArrayList<>();
    }

    public int getMaxShiftsCount() {
        return maxShiftsCount;
    }

    public void setMaxShiftsCount(int maxShiftsCount) {
        this.maxShiftsCount = maxShiftsCount;
    }

    public Doctor() {
        maxShiftsCount = 3;
        patients = new ArrayList<>();
        connectedNurses = new ArrayList<>();
        shifts = new ArrayList<>();
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


    public boolean canCureNewPatient() {
        if (patients.size() == 5) {
            return false;
        } else {
            return true;
        }

    }

    public int getPatientsCount() {
        return patients.size();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void addShift() {
        if (shifts.size() < maxShiftsCount) {
            Random rand = new Random();
            int randInt = rand.nextInt(3);
            switch (randInt) {
                case 0:
                    shifts.add(Shifts.MORNING);break;
                case 1:
                    shifts.add(Shifts.AFTERNOON);break;
                case 2:
                    shifts.add(Shifts.NIGHT);
            }
        }


    }

    public Shifts getCurrentShift() {
        return shifts.get(shifts.size() - 1);
    }

    public void findNurse() {
        for (int i = 0; i < Hospital.getInstance().getNursesCount(); i++) {
            if (Hospital.getInstance().getNurse(i).getDoctorsCount() < 2) {
                connectedNurses.add(Hospital.getInstance().getNurse(i));
                Hospital.getInstance().getNurse(i).addDoctor(this);
                return;
            } else if (Hospital.getInstance().getNurse(i).getDoctorsCount() == 2) {
                //TODO
            }
        }
    }
}
