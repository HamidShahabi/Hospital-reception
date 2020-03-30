package ir.ac.kntu;

import java.util.*;

public class Hospital {
    private String name;
    private String address;
    private int bedsCount;
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Nurse> nurses = new ArrayList<>();

    private static Hospital hospital;

    private Hospital() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }

    public static Hospital getInstance() {
        if (hospital == null) {
            hospital = new Hospital();
        }
        return hospital;
    }

    public Doctor getDoctor(int index) {
        if (index >= 0 && index < doctors.size()) {
            return doctors.get(index);
        } else {
            return null;
        }
    }
    public Nurse getNurse(int index) {
        if (index >= 0 && index < nurses.size()) {
            return nurses.get(index);
        } else {
            return null;
        }

    }
    public int getDoctorsCount() {
        return doctors.size();
    }
    public int getNursesCount(){
        return nurses.size();
    }
}
