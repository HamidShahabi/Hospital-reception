package ir.ac.kntu;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    Scanner scanner = new Scanner(System.in);
    private Emergency emergency = new Emergency();
    private Principal principal = new Principal();

    public void getFirstInformation() {
        System.out.println("Welcome to the hospital reception app!");
        System.out.println();
        System.out.println("Please Enter the startup information :");
        System.out.println("Let's start with the name , please enter a valid name : ");
        String name = scanner.nextLine();
        if (name.matches("^[a-zA-Z][ ]*$")) {
            Hospital.getInstance().setName(name);
        }
        System.out.println("Please enter hospital address");
        String address = scanner.nextLine();
        Hospital.getInstance().setAddress(address);
        System.out.println("Please enter hospital beds count:");
        int bedsCount = scanner.nextInt();
        if (bedsCount > 0 && bedsCount < 20000) {
            Hospital.getInstance().setBedsCount(bedsCount);
        }

    }

    public void starterMenu() {
        System.out.println("Welcome to the hospital reception app!");
        System.out.println("What do you want to do ?");
        System.out.println();
        System.out.println("1 - Manage patients");
        System.out.println();
        System.out.println("2 - Manage doctors");
        System.out.println();
        System.out.println("3 - Manage nurses");
        System.out.println();
        System.out.println("4 - Manage sections");
        System.out.println();
        System.out.println("5 - Manage rooms");
        int userSelection = scanner.nextInt();
        switch (userSelection) {
            case 1:
                managePatients();
                break;
            case 2:
                manageDoctors();
                break;
            case 3:
                manageNurses();
                break;
            case 4:
                manageSections();
                break;
            case 5:
                manageRooms();
        }

    }

    public void managePatients() {
        clearScreen();
        System.out.println("---------------------------------------------------------------");
        System.out.println("So,what to do now ?");
        System.out.println();
        System.out.println("1 - Hospitalization of a new patient");
        System.out.println();
        System.out.println("2 - Change a patient's information");
        System.out.println();
        System.out.println("3 - Show a patient's information");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                patientCreator();
            case 2:
                changePatientInformation();
            case 3:
                showPatientInformation();
        }

    }

    public void manageDoctors() {
        clearScreen();
        System.out.println("---------------------------------------------------------------");
        System.out.println("So,what to do now ?");
        System.out.println("1 - Hire a new doctor");
        System.out.println();
        System.out.println("2 - Change a doctor's information");
        System.out.println();
        System.out.println("3 - Show a doctor's information");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                doctorCreator();
            case 2:
                changeDoctorInformation();
            case 3:
                showDoctorInformation();
        }
    }

    public void manageNurses() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("So,what to do now ?");
        System.out.println();
        System.out.println("1 - Hire a new nurse");
        System.out.println();
        System.out.println("2 - Change a nurse's information");
        System.out.println();
        System.out.println("3 - Show a nurse's information");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                nurseCreator();
            case 2:
                changeNurseInformation();
            case 3:
                showNurseInformation();
        }
    }

    public void manageSections() {
        System.out.println("---------------------------------------------------------------");
        //todo
    }

    public void manageRooms() {
        System.out.println("---------------------------------------------------------------");
        //todo
    }

    public void clearScreen() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void patientCreator() {
        if (!checkAvailableDoctors()) {
            System.out.println("There are no available doctors right now");
            System.out.println("You must hire a new doctor or release a patient ");
            System.out.println("You will be directed to the starting menu");
            System.out.println("---------------------------------------------------------------");
            starterMenu();
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please specify refer type :");
        System.out.println();
        System.out.println("1 - Normal");
        System.out.println();
        System.out.println("2 - Emergency");
        int referType = scanner.nextInt();
        if (referType == 1) {
            if (principal.findCrowdRoom() == null) {
                System.out.println("There is no space for a new patient,you must release a patient or add a room");
                System.out.println("You will be redirected to starting Menu");
                System.out.println("---------------------------------------------------------------");
                starterMenu();
            }
        } else if (referType == 2) {
            if (emergency.findCrowdRoom() == null) {
                System.out.println("There is no space for a new patient,you must release a patient or add a room");
                System.out.println("You will be redirected to starting Menu");
                System.out.println("---------------------------------------------------------------");
                starterMenu();
            }
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter the patient's first name :");
        String firstName = scanner.nextLine();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter the patient's last name : ");
        String lastName = scanner.nextLine();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter the patient's age :");
        int age = scanner.nextInt();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter the patient's national id : ");
        String nationalID = scanner.nextLine();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please specify patient's gender : ");
        System.out.println();
        System.out.println("1 - Male");
        System.out.println();
        System.out.println("2 - Female");
        int genderIdentifier = scanner.nextInt();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please specify illness type : ");
        System.out.println();
        System.out.println("1 - Burn");
        System.out.println();
        System.out.println("2 - Crash");
        System.out.println();
        System.out.println("3 -Impact");
        System.out.println();
        System.out.println("4 - Other");
        int kindOfIllness = scanner.nextInt();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please specify the insurance type :");
        System.out.println("1 - Armed forces ");
        System.out.println();
        System.out.println("2 - Health service");
        System.out.println();
        System.out.println("3 - Social security");
        System.out.println();
        System.out.println("4 - None");
        int insuranceType = scanner.nextInt();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter a fileID for the patient (a number with 3 to 6 digits) : ");
        int fileID = scanner.nextInt();
        Date date = null;
        System.out.println("How do you want to find a room for the patient ?");
        System.out.println();
        System.out.println("1 - Search between crowd rooms");
        System.out.println();
        System.out.println("2 - Search between solitude rooms ");
        int findingMode = scanner.nextInt();
        if (validatePatientInformation(firstName, lastName, age, nationalID,
                genderIdentifier, kindOfIllness, insuranceType, referType, fileID, findingMode)) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Do you want to manually enter the hospitalization date ?");
            System.out.println();
            System.out.println("1 - Yes");
            System.out.println();
            System.out.println("2 - No");
            int answer = scanner.nextInt();
            if (answer == 1) {
                System.out.println("Please enter the year : ");
                int year = scanner.nextInt();
                System.out.println("Please enter the month :");
                int month = scanner.nextInt();
                System.out.println("Please enter the day :");
                int day = scanner.nextInt();
                if (!validateDate(month, day)) {
                    System.out.println("Invalid date !!!");
                    System.out.println("Hospitalization date will be set as today");
                    date = new Date();
//                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("---------------------------------------------------------------");
                } else {
                    date = new Date(1399, month, day);
                }

            } else if (answer == 2) {
                date = new Date();
            }

            if (referType == 1) {
                principal.addPatient(new Patient(referType, kindOfIllness, insuranceType, firstName,
                        lastName, nationalID, genderIdentifier, age, fileID, date));
                principal.getPatient(principal.getPatientsCount() - 1).
                        findDoctor(principal.getPatient(principal.getPatientsCount() - 1).getInformation());
                if (findingMode == 1) {
                    principal.getPatient(principal.getPatientsCount() - 1).findCrowdPrincipalRoom(principal);
                } else {
                    principal.getPatient(principal.getPatientsCount() - 1).findSolitudePrincipalRoom(principal);
                }
                System.out.println("Patient hospitalized successfully !");
                starterMenu();
            } else if (referType == 2) {
                emergency.addPatient(new Patient(referType, kindOfIllness, insuranceType, firstName,
                        lastName, nationalID, genderIdentifier, age, fileID, date));
                emergency.getPatient(emergency.getPatientsCount() - 1).
                        findDoctor(emergency.getPatient(emergency.getPatientsCount() - 1).getInformation());
                if (findingMode == 1) {
                    emergency.getPatient(emergency.getPatientsCount() - 1).findCrowdEmergencyRoom(emergency);
                } else {
                    emergency.getPatient(emergency.getPatientsCount() - 1).findSolitudeEmergencyRoom(emergency);
                }
                System.out.println("Patient hospitalized successfully !");
                starterMenu();
            }

        } else {
            System.out.println("Invalid information !!!");
            System.out.println("You will be redirected to the starter menu");
//                    TimeUnit.SECONDS.sleep(1);
            System.out.println();
            System.out.println("---------------------------------------------------------------");
            starterMenu();
        }
    }

    public boolean validatePatientInformation(String firstName, String lastName, int age, String nationalID,
                                              int gender, int kindOfIllness, int kindOfInsurance, int referType, int fileID, int findingMode) {
        boolean output = true;
        if (!firstName.matches("^[a-zA-Z][ ]*$")) {
            output = false;
        }
        if (!lastName.matches("^[a-zA-Z][ ]*$")) {
            output = false;
        }
        if (age < 0 || age > 120) {
            output = false;
        }
        if (!validateNationalID(nationalID)) {
            output = false;
        }
        if (kindOfIllness > 4 || kindOfIllness <= 0) {
            output = false;
        }
        if (kindOfInsurance > 4 || kindOfInsurance <= 0) {
            output = false;
        }
        if (referType > 2 || referType <= 0) {
            output = false;
        }
        if (fileID < 99 && fileID > 999999) {
            output = false;
        }
        if (findingMode != 1 && findingMode != 2) {
            output = false;
        }
        return output;
    }

    public void changePatientInformation() {
        //todo
    }

    public void showPatientInformation() {
        //todo
    }

    public void doctorCreator() {
        //todo
    }

    public void changeDoctorInformation() {
        //todo
    }

    public void showDoctorInformation() {
        //todo
    }

    public void nurseCreator() {
        //todo
    }

    public void changeNurseInformation() {
        //todo
    }

    public void showNurseInformation() {
        //todo
    }

    public boolean validateNationalID(String id) {
        if (id == null || id == "") {
            return false;
        }
        long sum = 0;
        long controlNum;
        long convertedID = Long.parseLong(id);
        int num_cnt = 0;
        while (convertedID > 0) {
            convertedID /= 10;
            num_cnt++;
        }
        convertedID = Long.parseLong(id);
        if (num_cnt > 10 || num_cnt < 8 || id == null) {
            return false;
        } else {
            controlNum = convertedID % 10;
            convertedID /= 10;
            for (int i = 2; i <= num_cnt; i++) {
                sum += (convertedID % 10) * i;
                convertedID /= 10;
            }
            if (sum % 11 < 2) {
                if (controlNum == sum % 11) {
                    return true;
                } else {
                    return false;
                }
            } else if (sum % 11 >= 2) {
                if (controlNum == 11 - (sum % 11)) {
                    return true;
                } else {
                    return false;
                }

            }

        }
        return false;

    }


    public boolean validateDate(int month, int day) {
        boolean output = true;
        if (month < 0 || month > 12) {
            output = false;
        } else if (month <= 6) {
            if (day > 31 || day <= 0) {
                output = false;
            }
        } else if (month > 6) {
            if (day > 30 || day <= 0) {
                output = false;
            }
        }
        return output;
    }

    public boolean checkAvailableDoctors() {
        boolean output = false;
        if (Hospital.getInstance().getDoctorsCount() == 0) {
            return false;
        }
        for (int i = 0; i < Hospital.getInstance().getDoctorsCount(); i++) {
            if (Hospital.getInstance().getDoctor(i).canCureNewPatient()) {
                output = true;
            }

        }
        return output;
    }
}
