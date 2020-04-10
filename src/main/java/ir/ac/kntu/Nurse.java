package ir.ac.kntu;

import java.util.*;

public class Nurse {
    private String name;
    private int personnelId;
    private Enums.Sections workingSection;
    private ArrayList<Doctor> connectedDoctors;
    private ArrayList<Shift> shifts;
    private int maxShiftsCount;

    public int getMaxShiftsCount() {
        return maxShiftsCount;
    }

    public void setMaxShiftsCount(int maxShiftsCount) {
        this.maxShiftsCount = maxShiftsCount;
    }

    public Nurse(String name, int personnelId, int maxShiftsCount) {
        this.name = name;
        this.personnelId = personnelId;
        connectedDoctors = new ArrayList<>();
        shifts = new ArrayList<>();
        this.maxShiftsCount = maxShiftsCount;
        this.automateShifts();
        this.automateShifts();
    }

    public Nurse() {
        connectedDoctors = new ArrayList<>();
        shifts = new ArrayList<>();
        maxShiftsCount = 6;
    }
    public int getConnectedDoctorsCount(){
        return connectedDoctors.size();
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

    public void addDoctor(Doctor doctor) {
        if (connectedDoctors.size() < 2) {
            connectedDoctors.add(doctor);
        }
    }
    public Doctor getConnectedDoctor(int index ){
        return connectedDoctors.get(index);
    }

    public void setShift(int index, Shift shift) {
        shifts.set(index, shift);
    }

    public void removeDoctor(Doctor doctor) {
        connectedDoctors.remove(doctor);
    }

    public int getDoctorsCount() {
        return connectedDoctors.size();
    }

    public Shift getShift(int index) {
        return shifts.get(index);
    }

    public void automateShifts() {
        Random rand = new Random();
        int weekDayIdentifier = 0;
        int specifiedShift = 0;
        Shift shift = new Shift();
        for (int i = 0; i < maxShiftsCount / 2;) {
            weekDayIdentifier = rand.nextInt(7);
            if (weekDayIdentifier == 0) {
                specifiedShift = rand.nextInt(3);
                if (specifiedShift == 0) {
                    if (shift.getSat().getShift(0) == false) {
                        shift.getSat().setShifts(0,true);
                        i++;
                    }
                } else if (specifiedShift == 1) {
                    if (shift.getSat().getShift(1) == false) {
                        shift.getSat().setShifts(1,true);
                        i++;
                    }
                } else if (specifiedShift == 2) {
                    if (shift.getSat().getShift(2) == false) {
                        shift.getSat().setShifts(2,true);
                        i++;
                    }
                }
            } else if (weekDayIdentifier == 1) {
                specifiedShift = rand.nextInt(3);
                if (specifiedShift == 0) {
                    if (shift.getSun().getShift(0) == false) {
                        shift.getSun().setShifts(0,true);
                        i++;
                    }
                } else if (specifiedShift == 1) {
                    if (shift.getSun().getShift(1) == false) {
                        shift.getSun().setShifts(1,true);
                        i++;
                    }
                } else if (specifiedShift == 2) {
                    if (shift.getSun().getShift(2) == false) {
                        shift.getSun().setShifts(2,true);
                        i++;
                    }
                }
            } else if (weekDayIdentifier == 2) {
                specifiedShift = rand.nextInt(3);
                if (specifiedShift == 0) {
                    if (shift.getMon().getShift(0) == false) {
                        shift.getMon().setShifts(0,true);
                        i++;
                    }
                } else if (specifiedShift == 1) {
                    if (shift.getMon().getShift(1) == false) {
                        shift.getMon().setShifts(1,true);
                        i++;
                    }
                } else if (specifiedShift == 2) {
                    if (shift.getMon().getShift(2) == false) {
                        shift.getMon().setShifts(2,true);
                        i++;
                    }
                }
            } else if (weekDayIdentifier == 3) {
                specifiedShift = rand.nextInt(3);
                if (specifiedShift == 0) {
                    if (shift.getTue().getShift(0) == false) {
                        shift.getTue().setShifts(0,true);
                        i++;
                    }
                } else if (specifiedShift == 1) {
                    if (shift.getTue().getShift(1) == false) {
                        shift.getTue().setShifts(1,true);
                        i++;
                    }
                } else if (specifiedShift == 2) {
                    if (shift.getTue().getShift(2) == false) {
                        shift.getTue().setShifts(2,true);
                        i++;
                    }
                }
            } else if (weekDayIdentifier == 4) {
                specifiedShift = rand.nextInt(3);
                if (specifiedShift == 0) {
                    if (shift.getWed().getShift(0) == false) {
                        shift.getWed().setShifts(0,true);
                        i++;
                    }
                } else if (specifiedShift == 1) {
                    if (shift.getWed().getShift(1) == false) {
                        shift.getWed().setShifts(1,true);
                        i++;
                    }
                } else if (specifiedShift == 2) {
                    if (shift.getWed().getShift(2) == false) {
                        shift.getWed().setShifts(2,true);
                        i++;
                    }
                }
            } else if (weekDayIdentifier == 5) {
                specifiedShift = rand.nextInt(3);
                if (specifiedShift == 0) {
                    if (shift.getThu().getShift(0) == false) {
                        shift.getThu().setShifts(0,true);
                        i++;
                    }
                } else if (specifiedShift == 1) {
                    if (shift.getThu().getShift(1) == false) {
                        shift.getThu().setShifts(1,true);
                        i++;
                    }
                } else if (specifiedShift == 2) {
                    if (shift.getThu().getShift(2) == false) {
                        shift.getThu().setShifts(2,true);
                        i++;
                    }
                }
            } else if (weekDayIdentifier == 6) {
                specifiedShift = rand.nextInt(3);
                if (specifiedShift == 0) {
                    if (shift.getFri().getShift(0) == false) {
                        shift.getFri().setShifts(0,true);
                        i++;
                    }
                } else if (specifiedShift == 1) {
                    if (shift.getFri().getShift(1) == false) {
                        shift.getFri().setShifts(1,true);
                        i++;
                    }
                } else if (specifiedShift == 2) {
                    if (shift.getFri().getShift(2) == false) {
                        shift.getFri().setShifts(2,true);
                        i++;
                    }
                }
            }
            shifts.add(shift);
        }
    }
    public void printShifts() {
        for(int j = 0;j < shifts.size();j++){
            System.out.println("Shifts :");
            System.out.print("Saturday : ");
            System.out.println("\t");
            for (int i = 0; i < 3; i++) {
                if (this.getShift(j).getSat().getShift(i) == true) {
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
                if (this.getShift(j).getSun().getShift(i) == true) {
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
                if(this.getShift(j).getMon().getShift(i) == true){
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
                if (this.getShift(j).getTue().getShift(i) == true) {
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
                if (this.getShift(j).getWed().getShift(i) == true) {
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
                if (this.getShift(j).getThu().getShift(i) == true) {
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
                if (this.getShift(j).getFri().getShift(i) == true) {
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

}


