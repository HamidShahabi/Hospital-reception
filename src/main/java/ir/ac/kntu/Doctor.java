package ir.ac.kntu;

import java.util.*;
import java.util.Objects;

public class Doctor {

    private String name;
    private int personnelId;
    private int maxShiftsCount;
    private String workingSection;
    private Shift shifts;
    private ArrayList<Patient> patients;
    private ArrayList<Nurse> AssistantNurses;

    public Doctor(String name, int personnelId, int maxShiftsCount, Shift shift) {
        this.name = name;
        this.personnelId = personnelId;
        this.maxShiftsCount = maxShiftsCount;
        this.shifts = shift;
        patients = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            patients.add(new Patient());
//        }

        AssistantNurses = new ArrayList<>();
        shifts.setDoctorPersonnelID(personnelId);
        this.findNurse();
//        AssistantNurses.add(new Nurse());
//        AssistantNurses.add(new Nurse());
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
        AssistantNurses = new ArrayList<>();
        shifts = new Shift();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(int personnelId) {
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

    public Shift getShifts() {
        return shifts;
    }

    public void setShifts(Shift shifts) {
        this.shifts = shifts;
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public Nurse getAssistantNurse(int index) {
        if (index >= 0 && index < 2) {
            return AssistantNurses.get(index);
        }
        return null;
    }


    public void findNurse() {
        while (AssistantNurses.size() != 2) {
            for (int i = 0; i < Hospital.getInstance().getNursesCount(); i++) {
                if (Hospital.getInstance().getNurse(i).getDoctorsCount() == 0) {
                    AssistantNurses.add(Hospital.getInstance().getNurse(i));
                    Hospital.getInstance().getNurse(i).addDoctor(this);
                    Hospital.getInstance().getNurse(i).setShift(0, this.shifts);
                } else if (Hospital.getInstance().getNurse(i).getDoctorsCount() == 1) {
                    AssistantNurses.add(Hospital.getInstance().getNurse(i));
                    Hospital.getInstance().getNurse(i).addDoctor(this);
                    Hospital.getInstance().getNurse(i).setShift(1, this.shifts);
                }
            }
        }

    }

    public Patient getPatient(int index) {
        return patients.get(index);
    }
    public void printShifts() {
        System.out.println("Shifts :");
        System.out.print("Saturday : ");
        System.out.println("\t");
        for (int i = 0; i < 3; i++) {
            if (this.getShifts().getSat().getShift(i) == true) {
                switch (i) {
                    case 0:
                        System.out.print("Morning - ");break;
                    case 1:
                        System.out.print("Afternoon - ");break;
                    case 2:
                        System.out.print("Night - ");break;
                }
            }
        }
        System.out.println();
        System.out.print("Sunday :");
        System.out.println("\t");
        for (int i = 0; i < 3; i++) {
            if (this.getShifts().getSun().getShift(i) == true) {
                switch (i) {
                    case 0:
                        System.out.print("Morning - ");break;
                    case 1:
                        System.out.print("Afternoon - ");break;
                    case 2:
                        System.out.print("Night - ");break;
                }
            }
        }
        System.out.println();
        System.out.println("Monday :");
        System.out.println("\t");
        for(int i = 0; i < 3;i++){
            if(this.getShifts().getMon().getShift(i) == true){
                switch(i){
                    case 0:
                        System.out.print("Morning - ");break;
                    case 1:
                        System.out.print("Afternoon - ");break;
                    case 2:
                        System.out.print("Night - ");break;
                }
            }
        }
        System.out.println();
        System.out.println("Tuesday");
        System.out.println("\t");
        for (int i = 0; i < 3; i++) {
            if (this.getShifts().getTue().getShift(i) == true) {
                switch (i) {
                    case 0:
                        System.out.print("Morning - ");break;
                    case 1:
                        System.out.print("Afternoon - ");break;
                    case 2:
                        System.out.print("Night - ");break;
                }
            }
        }
        System.out.println();
        System.out.println("Wednesday :");
        System.out.println("\t");
        for (int i = 0; i < 3; i++) {
            if (this.getShifts().getWed().getShift(i) == true) {
                switch (i) {
                    case 0:
                        System.out.print("Morning - ");break;
                    case 1:
                        System.out.print("Afternoon - ");break;
                    case 2:
                        System.out.print("Night - ");break;
                }
            }
        }
        System.out.println();
        System.out.println("Thursday :");
        System.out.println("\t");
        for (int i = 0; i < 3; i++) {
            if (this.getShifts().getThu().getShift(i) == true) {
                switch (i) {
                    case 0:
                        System.out.print("Morning - ");break;
                    case 1:
                        System.out.print("Afternoon - ");
                    case 2:
                        System.out.print("Night - ");
                }
            }
        }
        System.out.println();
        System.out.println("Friday :");
        System.out.println("\t");
        for (int i = 0; i < 3; i++) {
            if (this.getShifts().getFri().getShift(i) == true) {
                switch (i) {
                    case 0:
                        System.out.print("Morning - ");
                    case 1:
                        System.out.print("Afternoon - ");
                    case 2:
                        System.out.print("Night - ");
                }
            }
        }
        System.out.println();
    }
}
