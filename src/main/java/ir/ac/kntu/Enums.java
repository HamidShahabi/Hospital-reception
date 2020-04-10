package ir.ac.kntu;
import java.util.*;
public class Enums {
    public enum Sections {
        PRINCIPAL, EMERGENCY
    }

    public enum Insurances {
        SOCIALSECURITY, ARMEDFORCES, HEALTHSERVICE, NONE;
    }

    public enum Illness {
        BURN, CRASH, IMPACT, OTHER
    }

    public enum Gender {
        MALE, FEMALE
    }

    public enum ReferType {
        NORMAL, EMERGENCY
    }

    public enum AvailabilityStatement {
        AVAILABLE, UNAVAILABLE
    }

    public enum Weekday {
        SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;
        private ArrayList<Boolean> shifts = new ArrayList<>();
        void setShifts(int index,boolean isfull){
            shifts.set(index,isfull);
        }
        boolean getShift(int index){
            return shifts.get(index);
        }
        Weekday(){
            for(int i = 0; i < 3;i++){
                shifts.add(false);
            }
        }

    }
    public enum Shifts {
        MORNING, AFTERNOON, NIGHT;
        private boolean isFull;

        public boolean getIsFull() {
            return isFull;
        }

        public void setIsFull(boolean full) {
            isFull = full;
        }
    }

}
