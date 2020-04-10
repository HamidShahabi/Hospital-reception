package ir.ac.kntu;
import java.util.Scanner;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static Emergency emergency = new Emergency();
    private static Principal principal = new Principal();
    private static int bedsCount = 0;

    public static void main(String[] args) {
        getFirstInformation();
    }

    public static void getFirstInformation() {
        System.out.println("Welcome to the hospital reception app!");
        System.out.println();
        System.out.println("Please Enter the startup information ");
        System.out.println();
        System.out.println("Let's start with the name , please enter a valid name : ");
        String name = scanner.nextLine();
        if (name.matches("^(?![\\s.]+$)[a-zA-Z\\s.]*$")) {
            Hospital.getInstance().setName(name);
        }
        System.out.println("Please enter hospital address");
        String address = scanner.nextLine();
        Hospital.getInstance().setAddress(address);
        System.out.println("Please enter hospital beds count:");
        int bedsCnt = Integer.parseInt(scanner.nextLine());
        if (bedsCnt > 0 && bedsCnt < 20000) {
            Hospital.getInstance().setBedsCount(bedsCnt);
            bedsCount = bedsCnt;
        }
        starterMenu();
    }

    public static void starterMenu() {
        System.out.println("---------------------------------------------------------------");
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
        System.out.println();
        System.out.println("Enter 0 to quit");
        int userSelection = Integer.parseInt(scanner.nextLine());
        switch (userSelection) {
            case 0:
                System.exit(0);
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

    public static void managePatients() {
        clearScreen();
        System.out.println("---------------------------------------------------------------");
        System.out.println("So,what to do now ?");
        System.out.println();
        System.out.println("1 - Hospitalization of a new patient");
        System.out.println();
        System.out.println("2 - Change a patient's information");
        System.out.println();
        System.out.println("3 - Show a patient's information");
        System.out.println();
        System.out.println("4 - Release a patient");
        System.out.println();
        System.out.println("5 - Show a patient's doctor info");
        System.out.println();
        System.out.println("6 - Show a patient's nurses info");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                patientCreator();
            case 2:
                changePatientInformation();
            case 3:
                showPatientInformation();
            case 4:
                releasePatient();
            case 5:
                showDoctorInfoFromPatient();
            case 6:
                showNursesInfoFromPatient();
        }

    }

    public static void manageDoctors() {
        clearScreen();
        System.out.println("---------------------------------------------------------------");
        System.out.println("So,what to do now ?");
        System.out.println("1 - Hire a new doctor");
        System.out.println();
        System.out.println("2 - Change a doctor's information");
        System.out.println();
        System.out.println("3 - Show a doctor's information");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                doctorCreator();
            case 2:
                changeDoctorInformation();
            case 3:
                showDoctorInformation();
        }
    }

    public static void manageNurses() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("So,what to do now ?");
        System.out.println();
        System.out.println("1 - Hire a new nurse");
        System.out.println();
        System.out.println("2 - Change a nurse's information");
        System.out.println();
        System.out.println("3 - Show a nurse's information");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                nurseCreator();
            case 2:
                changeNurseInformation();
            case 3:
                showNurseInformation();
        }
    }

    public static void manageSections() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Which section do you want ?");
        System.out.println("1 - Principal");
        System.out.println("2 - Emergency");
        int selection = Integer.parseInt(scanner.nextLine());
        System.out.println("So,which one of these two you wanna see?");
        System.out.println("1 - Show all patients");
        System.out.println("2 - Show all rooms");
        int selectedPart = Integer.parseInt(scanner.nextLine());
        if(selection == 1){
            if(selectedPart == 1){
                if(principal.getPatientsCount() == 0){
                    System.out.println("There are no any patients in this section");
                    starterMenu();
                }
                else{
                    for(int i = 0;i < principal.getPatientsCount();i++){
                        System.out.println("Name : " + principal.getPatient(i).getInformation().getName());
                        System.out.println("File ID : " + principal.getPatient(i).getInformation().getFileId());
                    }
                }
            }
            else if(selectedPart == 2){
                if(principal.getRoomsCount() == 0){
                    System.out.println("There are no any rooms in this section");
                    starterMenu();
                }
                else{
                    for(int i = 0;i < principal.getRoomsCount();i++){
                        System.out.println("Room num : " + principal.getRoom(i).getRoomNum());
                        System.out.println("Beds count :" + principal.getRoom(i).getBedsCount());
                    }
                }
            }
        }
        else if(selection == 2){
            if(selectedPart == 1){
                if(emergency.getPatientsCount() == 0){
                    System.out.println("There are no any patients in this section");
                    starterMenu();
                }
                else{
                    for(int i = 0;i < emergency.getPatientsCount();i++){
                        System.out.println("Name : " + emergency.getPatient(i).getInformation().getName());
                        System.out.println("File ID : " + emergency.getPatient(i).getInformation().getFileId());
                    }
                }
            }
            else if(selectedPart == 2){
                if(emergency.getRoomsCount() == 0){
                    System.out.println("There are no any rooms in this section");
                    starterMenu();
                }
                else{
                    for(int i = 0;i < emergency.getRoomsCount();i++){
                        System.out.println("Room num : " + emergency.getRoom(i).getRoomNum());
                        System.out.println("Beds count :" + emergency.getRoom(i).getBedsCount());
                    }
                }
            }
        }
        starterMenu();

    }

    public static void manageRooms() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("What to do now ? :");
        System.out.println("1 - Add a new room");
        System.out.println("2 - Edit a room info");
        System.out.println("3 - Delete room");
        System.out.println("4 - Show a room patients");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                roomCreator();
            case 2:
                roomEditor();
            case 3:
                roomRemover();
            case 4:
                showRoomPatients();
        }
    }

    public static void clearScreen() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void patientCreator() {
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
        int referType = Integer.parseInt(scanner.nextLine());
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
        System.out.println("Please enter the patient's name :");
        String name = scanner.nextLine();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter the patient's age :");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter the patient's national id : ");
        String nationalID = scanner.nextLine();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please specify patient's gender : ");
        System.out.println();
        System.out.println("1 - Male");
        System.out.println();
        System.out.println("2 - Female");
        int genderIdentifier = Integer.parseInt(scanner.nextLine());
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
        int kindOfIllness = Integer.parseInt(scanner.nextLine());
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please specify the insurance type :");
        System.out.println("1 - Armed forces ");
        System.out.println();
        System.out.println("2 - Health service");
        System.out.println();
        System.out.println("3 - Social security");
        System.out.println();
        System.out.println("4 - None");
        int insuranceType = Integer.parseInt(scanner.nextLine());
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter a fileID for the patient (a number with 3 to 6 digits) : ");
        int fileID = Integer.parseInt(scanner.nextLine());
        Date date = null;
        System.out.println("How do you want to find a room for the patient ?");
        System.out.println();
        System.out.println("1 - Search between crowd rooms");
        System.out.println();
        System.out.println("2 - Search between solitude rooms ");
        int findingMode = Integer.parseInt(scanner.nextLine());
        if (validatePatientInformation(name, age, nationalID,
                genderIdentifier, kindOfIllness, insuranceType, referType, fileID, findingMode)) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Do you want to manually enter the hospitalization date ?");
            System.out.println();
            System.out.println("1 - Yes");
            System.out.println();
            System.out.println("2 - No");
            int answer = Integer.parseInt(scanner.nextLine());
            if (answer == 1) {
                System.out.println("Please enter the year : ");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.println("Please enter the month :");
                int month = Integer.parseInt(scanner.nextLine());
                System.out.println("Please enter the day :");
                int day = Integer.parseInt(scanner.nextLine());
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
                principal.addPatient(new Patient(referType, kindOfIllness, insuranceType, name,
                        nationalID, genderIdentifier, age, fileID, date));
                principal.getPatient(principal.getPatientsCount() - 1).
                        findDoctor(principal.getPatient(principal.getPatientsCount() - 1).getInformation());
                if (findingMode == 1) {
                    principal.getPatient(principal.getPatientsCount() - 1).findCrowdPrincipalRoom(principal);
                } else {
                    principal.getPatient(principal.getPatientsCount() - 1).findSolitudePrincipalRoom(principal);
                }
                System.out.println("Patient hospitalized successfully in the principal section!");
                starterMenu();
            } else if (referType == 2) {
                emergency.addPatient(new Patient(referType, kindOfIllness, insuranceType, name,
                        nationalID, genderIdentifier, age, fileID, date));
                emergency.getPatient(emergency.getPatientsCount() - 1).
                        findDoctor(emergency.getPatient(emergency.getPatientsCount() - 1).getInformation());
                if (findingMode == 1) {
                    emergency.getPatient(emergency.getPatientsCount() - 1).findCrowdEmergencyRoom(emergency);
                } else {
                    emergency.getPatient(emergency.getPatientsCount() - 1).findSolitudeEmergencyRoom(emergency);
                }
                System.out.println("Patient hospitalized successfully in the emergency section !");
                starterMenu();
            }

        } else {
            System.out.println("Invalid information !!!");
            System.out.println("You will be redirected to the starter menu");
            //TimeUnit.SECONDS.sleep(1);
            System.out.println();
            System.out.println("---------------------------------------------------------------");
            starterMenu();
        }
    }

    public static boolean validatePatientInformation(String name, int age, String nationalID,
                                                     int gender, int kindOfIllness, int kindOfInsurance, int referType, int fileID, int findingMode) {
        boolean output = true;
        if (!name.matches("^(?![\\s.]+$)[a-zA-Z\\s.]*$")) {
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

    public static void changePatientInformation() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter patient's fileID : ");
        int fileID = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        int desiredPatientIndex = 0;
        boolean inEmergency = false;
        boolean inPrincipal = false;
        if (principal.getPatientsCount() != 0) {
            for (int i = 0; i < principal.getPatientsCount(); i++) {
                if (principal.getPatient(i).getInformation().getFileId() == fileID) {
                    isFound = true;
                    inPrincipal = true;
                    desiredPatientIndex = i;
                }
            }
        }
        if (emergency.getPatientsCount() != 0) {
            for (int i = 0; i < emergency.getPatientsCount(); i++) {
                if (principal.getPatient(i).getInformation().getFileId() == fileID) {
                    isFound = true;
                    inEmergency = true;
                    desiredPatientIndex = i;
                }
            }
        }

        if (isFound) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("So,which of the information fields do you want to change ?");
            System.out.println("Specify your choice with a number");
            System.out.println("1 - Name");
            System.out.println("2 - NationalID");
            System.out.println("3 - Hospitalization date");
            System.out.println("4 - Kind of illness");
            System.out.println("5 - Insurance");
            System.out.println("6 - Gender");
            System.out.println("7 - Age");
            System.out.println("8 - FileID");
            int selectedFileldIndex = Integer.parseInt(scanner.nextLine());
            if (selectedFileldIndex == 1) {
                System.out.println("---------------------------------------------------------------");
                System.out.println("Please enter a valid name :");
                String name = scanner.nextLine();

                if (inEmergency) {
                    emergency.getPatient(desiredPatientIndex).getInformation().setName(name);
                    emergency.getPatient(desiredPatientIndex).getInformation().getLog().setName(name);
                } else if (inPrincipal) {
                    principal.getPatient(desiredPatientIndex).getInformation().setName(name);
                    principal.getPatient(desiredPatientIndex).getInformation().getLog().setName(name);
                }
            } else if (selectedFileldIndex == 2) {
                System.out.println("Please enter a valid nationalID :");
                String nationalID = scanner.nextLine();
                if (validateNationalID(nationalID)) {
                    if (inEmergency) {
                        emergency.getPatient(desiredPatientIndex).getInformation().setNationalId(nationalID);
                    } else if (inPrincipal) {
                        principal.getPatient(desiredPatientIndex).getInformation().setNationalId(nationalID);
                    }
                    System.out.println("Change applied successfully");
                }
            } else if (selectedFileldIndex == 3) {
                System.out.println("Please enter the day :");
                int day = Integer.parseInt(scanner.nextLine());
                System.out.println("Please enter the month : ");
                int month = Integer.parseInt(scanner.nextLine());
                if (validateDate(month, day)) {
                    Date date = new Date(1399, month, day);
                    if (inEmergency) {
                        emergency.getPatient(desiredPatientIndex).getInformation().getLog().setHospitalizationDate(date);
                    } else if (inPrincipal) {
                        principal.getPatient(desiredPatientIndex).getInformation().getLog().setHospitalizationDate(date);
                    }
                    System.out.println("Change applied successfully");
                }
            } else if (selectedFileldIndex == 4) {
                System.out.println("Please select the illness :");
                System.out.println("1 - Burn");
                System.out.println();
                System.out.println("2 - Crash");
                System.out.println();
                System.out.println("3 -Impact");
                System.out.println();
                System.out.println("4 - Other");
                int kindOfIllness = Integer.parseInt(scanner.nextLine());
                switch (kindOfIllness) {
                    case 1: {
                        if (inEmergency) {
                            emergency.getPatient(desiredPatientIndex).getInformation().setKindOfIllness(Enums.Illness.BURN);
                        } else if (inPrincipal) {
                            principal.getPatient(desiredPatientIndex).getInformation().setKindOfIllness(Enums.Illness.BURN);
                        }
                        System.out.println("Change applied successfully");
                    }
                    case 2: {
                        if (inEmergency) {
                            emergency.getPatient(desiredPatientIndex).getInformation().setKindOfIllness(Enums.Illness.CRASH);
                        } else if (inPrincipal) {
                            principal.getPatient(desiredPatientIndex).getInformation().setKindOfIllness(Enums.Illness.CRASH);
                        }
                        System.out.println("Change applied successfully");
                    }
                    case 3: {
                        if (inEmergency) {
                            emergency.getPatient(desiredPatientIndex).getInformation().setKindOfIllness(Enums.Illness.IMPACT);
                        } else if (inPrincipal) {
                            principal.getPatient(desiredPatientIndex).getInformation().setKindOfIllness(Enums.Illness.IMPACT);
                        }
                        System.out.println("Change applied successfully");
                    }
                    case 4: {
                        if (inEmergency) {
                            emergency.getPatient(desiredPatientIndex).getInformation().setKindOfIllness(Enums.Illness.OTHER);
                        } else if (inPrincipal) {
                            principal.getPatient(desiredPatientIndex).getInformation().setKindOfIllness(Enums.Illness.OTHER);
                        }
                        System.out.println("Change applied successfully");
                    }
                }
            } else if (selectedFileldIndex == 5) {
                System.out.println("Please select insrance :");
                System.out.println("1 - Armed forces ");
                System.out.println();
                System.out.println("2 - Health service");
                System.out.println();
                System.out.println("3 - Social security");
                System.out.println();
                System.out.println("4 - None");
                int insuranceIdentifier = Integer.parseInt(scanner.nextLine());
                switch (insuranceIdentifier) {
                    case 1: {
                        if (inEmergency) {
                            emergency.getPatient(desiredPatientIndex).getInformation().setInsurance(Enums.Insurances.ARMEDFORCES);
                        } else if (inPrincipal) {
                            principal.getPatient(desiredPatientIndex).getInformation().setInsurance(Enums.Insurances.ARMEDFORCES);
                        }
                        System.out.println("Change applied successfully");
                    }
                    case 2: {
                        if (inEmergency) {
                            emergency.getPatient(desiredPatientIndex).getInformation().setInsurance(Enums.Insurances.HEALTHSERVICE);
                        } else if (inPrincipal) {
                            principal.getPatient(desiredPatientIndex).getInformation().setInsurance(Enums.Insurances.HEALTHSERVICE);
                        }
                        System.out.println("Change applied successfully");
                    }
                    case 3: {
                        if (inEmergency) {
                            emergency.getPatient(desiredPatientIndex).getInformation().setInsurance(Enums.Insurances.SOCIALSECURITY);
                        } else if (inPrincipal) {
                            principal.getPatient(desiredPatientIndex).getInformation().setInsurance(Enums.Insurances.SOCIALSECURITY);
                        }
                        System.out.println("Change applied successfully");
                    }
                    case 4: {
                        if (inEmergency) {
                            emergency.getPatient(desiredPatientIndex).getInformation().setInsurance(Enums.Insurances.NONE);
                        } else if (inPrincipal) {
                            principal.getPatient(desiredPatientIndex).getInformation().setInsurance(Enums.Insurances.NONE);
                        }
                        System.out.println("Change applied successfully");
                    }
                }
            } else if (selectedFileldIndex == 6) {
                System.out.println("Please specify the gender");
                System.out.println("1 - Male");
                System.out.println("2 - Female");
                int genderIdentifier = Integer.parseInt(scanner.nextLine());
                if (genderIdentifier == 1) {
                    if (inEmergency) {
                        emergency.getPatient(desiredPatientIndex).getInformation().setGender(Enums.Gender.MALE);
                    } else if (inPrincipal) {
                        principal.getPatient(desiredPatientIndex).getInformation().setGender(Enums.Gender.MALE);
                    }
                    System.out.println("Change applied successfully");
                } else if (genderIdentifier == 2) {
                    if (inEmergency) {
                        emergency.getPatient(desiredPatientIndex).getInformation().setGender(Enums.Gender.FEMALE);
                    } else if (inPrincipal) {
                        principal.getPatient(desiredPatientIndex).getInformation().setGender(Enums.Gender.FEMALE);
                    }
                    System.out.println("Change applied successfully");
                }
            } else if (selectedFileldIndex == 7) {
                System.out.println("Please enter the age :");
                int age = Integer.parseInt(scanner.nextLine());
                if (age > 0 && age <= 120) {
                    if (inEmergency) {
                        emergency.getPatient(desiredPatientIndex).getInformation().setAge(age);
                    } else if (inPrincipal) {
                        principal.getPatient(desiredPatientIndex).getInformation().setAge(age);
                    }
                    System.out.println("Change applied successfully");
                }
            } else if (selectedFileldIndex == 8) {
                System.out.println("Please enter a fileID (3 to 6 digits )");
                int newFileID = Integer.parseInt(scanner.nextLine());
                if (fileID > 99 && fileID < 1000000) {
                    if (inEmergency) {
                        emergency.getPatient(desiredPatientIndex).getInformation().setFileId(newFileID);
                    } else if (inPrincipal) {
                        principal.getPatient(desiredPatientIndex).getInformation().setFileId(newFileID);
                    }
                    System.out.println("Change applied successfully");
                }
            }

        }
        starterMenu();
    }

    public static void showPatientInformation() {
        PatientInformationFile info = new PatientInformationFile();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter patient's fileID : ");
        int fileID = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        int desiredPatientIndex = 0;
        boolean inEmergency = false;
        boolean inPrincipal = false;
        if (principal.getPatientsCount() != 0) {
            for (int i = 0; i < principal.getPatientsCount(); i++) {
                if (principal.getPatient(i).getInformation().getFileId() == fileID) {
                    isFound = true;
                    inPrincipal = true;
                    desiredPatientIndex = i;
                }
            }
        }
        if (emergency.getPatientsCount() != 0) {
            for (int i = 0; i < emergency.getPatientsCount(); i++) {
                if (principal.getPatient(i).getInformation().getFileId() == fileID) {
                    isFound = true;
                    inEmergency = true;
                    desiredPatientIndex = i;
                }
            }
        }

        if (isFound) {
            if (inEmergency) {
                info = emergency.getPatient(desiredPatientIndex).getInformation();
            } else if (inPrincipal) {
                info = principal.getPatient(desiredPatientIndex).getInformation();
            }
            System.out.println("Name : " + info.getName());
            System.out.println("NationalID : " + info.getNationalId());
            System.out.println("Hospitalization date : " + info.getHospitalizationDate());
            System.out.println("Kind of illness : " + info.getKindOfIllness());
            System.out.println("Insurance : " + info.getInsurance());
            System.out.println("Gender : " + info.getGender());
            System.out.println("Age : " + info.getAge());
            System.out.println("File ID : " + info.getFileId());
        }
        starterMenu();
    }

    public static void doctorCreator() {
        if (!checkEnoughNurses()) {
            System.out.println("There are no enough nurses right now");
            System.out.println("Please hire new nurses !");
            starterMenu();
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter full name :");
        String name = scanner.nextLine();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please specify a personnel ID (a number with 4 to 6 digits) :");
        int personnelID = Integer.parseInt(scanner.nextLine());
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter maximum shifts of this doctor : ");
        int maxShiftsCount = Integer.parseInt(scanner.nextLine());
        if (!validatePersonnelInfo(name, personnelID, maxShiftsCount)) {
            System.out.println("Invalid information !");
            starterMenu();
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please set shifts of this doctor ");
        Shift shift = new Shift();
        for (int i = 0; i < maxShiftsCount; i++) {
            System.out.println("select the day :");
            System.out.println("1 - Saturday");
            System.out.println("2 - Sunday");
            System.out.println("3 - Monday");
            System.out.println("4 - Tuesday");
            System.out.println("5 - Wednesday");
            System.out.println("6 - Thursday");
            System.out.println("7 - Friday");
            int weekDayIdentifier = Integer.parseInt(scanner.nextLine());
            int specifiedShift = 0;
            if (weekDayIdentifier == 1) {
                System.out.println("Enter the specified shift :");
                System.out.println("1 - Morning");
                System.out.println("2 - Afternoon");
                System.out.println("3 - Night");
                specifiedShift = Integer.parseInt(scanner.nextLine());
                if (specifiedShift == 1) {
                    shift.getSat().setShifts(0, true);
                } else if (specifiedShift == 2) {
                    shift.getSat().setShifts(1, true);
                } else if (specifiedShift == 3) {
                    shift.getSat().setShifts(2, true);
                }
            } else if (weekDayIdentifier == 2) {
                System.out.println("Enter the specified shift :");
                System.out.println("1 - Morning");
                System.out.println("2 - Afternoon");
                System.out.println("3 - Night");
                specifiedShift = Integer.parseInt(scanner.nextLine());
                if (specifiedShift == 1) {
                    shift.getSun().setShifts(0, true);
                } else if (specifiedShift == 2) {
                    shift.getSun().setShifts(1, true);
                } else if (specifiedShift == 3) {
                    shift.getSun().setShifts(2, true);
                }
            } else if (weekDayIdentifier == 3) {
                System.out.println("Enter the specified shift :");
                System.out.println("1 - Morning");
                System.out.println("2 - Afternoon");
                System.out.println("3 - Night");
                specifiedShift = Integer.parseInt(scanner.nextLine());
                if (specifiedShift == 1) {
                    shift.getMon().setShifts(0, true);
                } else if (specifiedShift == 2) {
                    shift.getMon().setShifts(1, true);
                } else if (specifiedShift == 3) {
                    shift.getMon().setShifts(2, true);
                }
            } else if (weekDayIdentifier == 4) {
                System.out.println("Enter the specified shift :");
                System.out.println("1 - Morning");
                System.out.println("2 - Afternoon");
                System.out.println("3 - Night");
                specifiedShift = Integer.parseInt(scanner.nextLine());
                if (specifiedShift == 1) {
                    shift.getTue().setShifts(0, true);
                } else if (specifiedShift == 2) {
                    shift.getTue().setShifts(1, true);
                } else if (specifiedShift == 3) {
                    shift.getTue().setShifts(2, true);
                }
            } else if (weekDayIdentifier == 5) {
                System.out.println("Enter the specified shift :");
                System.out.println("1 - Morning");
                System.out.println("2 - Afternoon");
                System.out.println("3 - Night");
                specifiedShift = Integer.parseInt(scanner.nextLine());
                if (specifiedShift == 1) {
                    shift.getWed().setShifts(0, true);
                } else if (specifiedShift == 2) {
                    shift.getWed().setShifts(1, true);
                } else if (specifiedShift == 3) {
                    shift.getWed().setShifts(2, true);
                }
            } else if (weekDayIdentifier == 6) {
                System.out.println("Enter the specified shift :");
                System.out.println("1 - Morning");
                System.out.println("2 - Afternoon");
                System.out.println("3 - Night");
                specifiedShift = Integer.parseInt(scanner.nextLine());
                if (specifiedShift == 1) {
                    shift.getThu().setShifts(0, true);
                } else if (specifiedShift == 2) {
                    shift.getThu().setShifts(1, true);
                } else if (specifiedShift == 3) {
                    shift.getThu().setShifts(2, true);
                }
            } else if (weekDayIdentifier == 7) {
                System.out.println("Enter the specified shift :");
                System.out.println("1 - Morning");
                System.out.println("2 - Afternoon");
                System.out.println("3 - Night");
                specifiedShift = Integer.parseInt(scanner.nextLine());
                if (specifiedShift == 1) {
                    shift.getFri().setShifts(0, true);
                } else if (specifiedShift == 2) {
                    shift.getFri().setShifts(1, true);
                } else if (specifiedShift == 3) {
                    shift.getFri().setShifts(2, true);
                }
            }
        }
        Hospital.getInstance().addDoctor(new Doctor(name, personnelID, maxShiftsCount, shift));
        System.out.println("Doctor hired successfully !");

        starterMenu();
    }

    public static void changeDoctorInformation() {

        System.out.println("Please enter the personnel ID :");
        int personnelID = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        int desiredDoctorIndex = 0;
        if (Hospital.getInstance().getDoctorsCount() != 0) {
            for (int i = 0; i < Hospital.getInstance().getDoctorsCount(); i++) {
                if (Hospital.getInstance().getDoctor(i).getPersonnelId() == personnelID) {
                    isFound = true;
                    desiredDoctorIndex = i;
                }
            }
        }

        if (isFound) {
            System.out.println("So,what change do you want to perform ?");
            System.out.println("1 - Change name");
            System.out.println("2 - Change personnel ID");
            System.out.println("3 - Change maximum shifts count");
            System.out.println("4 - Change shifts");
            int selectedField = Integer.parseInt(scanner.nextLine());
            if (selectedField == 1) {
                System.out.println("Please enter the name :");
                String name = scanner.nextLine();
                if (name.matches("^(?![\\s.]+$)[a-zA-Z\\s.]*$")) {
                    Hospital.getInstance().getDoctor(desiredDoctorIndex).setName(name);
                }
            } else if (selectedField == 2) {
                System.out.println("Please enter the new personnel ID");
                int newPersonnelID = Integer.parseInt(scanner.nextLine());
                if (personnelID > 999 && personnelID < 1000000) {
                    Hospital.getInstance().getDoctor(desiredDoctorIndex).setPersonnelId(newPersonnelID);
                }
            } else if (selectedField == 3) {
                System.out.println("Please enter the maximum shifts count :");
                int maxShiftsCount = Integer.parseInt(scanner.nextLine());
                Hospital.getInstance().getDoctor(desiredDoctorIndex).setMaxShiftsCount(maxShiftsCount);
            } else if (selectedField == 4) {
                Shift shift = new Shift();
                int weekDayIdentifier = Integer.parseInt(scanner.nextLine());
                int specifiedShift = 0;
                for (int i = 0; i < Hospital.getInstance().getDoctor(desiredDoctorIndex).getMaxShiftsCount(); i++) {
                    System.out.println("select the day :");
                    System.out.println("1 - Saturday");
                    System.out.println("2 - Sunday");
                    System.out.println("3 - Monday");
                    System.out.println("4 - Tuesday");
                    System.out.println("5 - Wednesday");
                    System.out.println("6 - Thursday");
                    System.out.println("7 - Friday");
                    if (weekDayIdentifier == 1) {
                        System.out.println("Enter the specified shift :");
                        System.out.println("1 - Morning");
                        System.out.println("2 - Afternoon");
                        System.out.println("3 - Night");
                        specifiedShift = Integer.parseInt(scanner.nextLine());
                        if (specifiedShift == 1) {
                            shift.getSat().setShifts(0, true);
                        } else if (specifiedShift == 2) {
                            shift.getSat().setShifts(1, true);
                        } else if (specifiedShift == 3) {
                            shift.getSat().setShifts(2, true);
                        }
                    } else if (weekDayIdentifier == 2) {
                        System.out.println("Enter the specified shift :");
                        System.out.println("1 - Morning");
                        System.out.println("2 - Afternoon");
                        System.out.println("3 - Night");
                        specifiedShift = Integer.parseInt(scanner.nextLine());
                        if (specifiedShift == 1) {
                            shift.getSun().setShifts(0, true);
                        } else if (specifiedShift == 2) {
                            shift.getSun().setShifts(1, true);
                        } else if (specifiedShift == 3) {
                            shift.getSun().setShifts(2, true);
                        }
                    } else if (weekDayIdentifier == 3) {
                        System.out.println("Enter the specified shift :");
                        System.out.println("1 - Morning");
                        System.out.println("2 - Afternoon");
                        System.out.println("3 - Night");
                        specifiedShift = Integer.parseInt(scanner.nextLine());
                        if (specifiedShift == 1) {
                            shift.getMon().setShifts(0, true);
                        } else if (specifiedShift == 2) {
                            shift.getMon().setShifts(1, true);
                        } else if (specifiedShift == 3) {
                            shift.getMon().setShifts(2, true);
                        }
                    } else if (weekDayIdentifier == 4) {
                        System.out.println("Enter the specified shift :");
                        System.out.println("1 - Morning");
                        System.out.println("2 - Afternoon");
                        System.out.println("3 - Night");
                        specifiedShift = Integer.parseInt(scanner.nextLine());
                        if (specifiedShift == 1) {
                            shift.getTue().setShifts(0, true);
                        } else if (specifiedShift == 2) {
                            shift.getTue().setShifts(1, true);
                        } else if (specifiedShift == 3) {
                            shift.getTue().setShifts(2, true);
                        }
                    } else if (weekDayIdentifier == 5) {
                        System.out.println("Enter the specified shift :");
                        System.out.println("1 - Morning");
                        System.out.println("2 - Afternoon");
                        System.out.println("3 - Night");
                        specifiedShift = Integer.parseInt(scanner.nextLine());
                        if (specifiedShift == 1) {
                            shift.getWed().setShifts(0, true);
                        } else if (specifiedShift == 2) {
                            shift.getWed().setShifts(1, true);
                        } else if (specifiedShift == 3) {
                            shift.getWed().setShifts(2, true);
                        }
                    } else if (weekDayIdentifier == 6) {
                        System.out.println("Enter the specified shift :");
                        System.out.println("1 - Morning");
                        System.out.println("2 - Afternoon");
                        System.out.println("3 - Night");
                        specifiedShift = Integer.parseInt(scanner.nextLine());
                        if (specifiedShift == 1) {
                            shift.getThu().setShifts(0, true);
                        } else if (specifiedShift == 2) {
                            shift.getThu().setShifts(1, true);
                        } else if (specifiedShift == 3) {
                            shift.getThu().setShifts(2, true);
                        }
                    } else if (weekDayIdentifier == 7) {
                        System.out.println("Enter the specified shift :");
                        System.out.println("1 - Morning");
                        System.out.println("2 - Afternoon");
                        System.out.println("3 - Night");
                        specifiedShift = Integer.parseInt(scanner.nextLine());
                        if (specifiedShift == 1) {
                            shift.getFri().setShifts(0, true);
                        } else if (specifiedShift == 2) {
                            shift.getFri().setShifts(1, true);
                        } else if (specifiedShift == 3) {
                            shift.getFri().setShifts(2, true);
                        }
                    }
                }
                Hospital.getInstance().getDoctor(desiredDoctorIndex).setShifts(shift);
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (Hospital.getInstance().getDoctor(desiredDoctorIndex)
                                .getAssistantNurse(i).getShift(j).getDoctorPersonnelID() == personnelID) {
                            Hospital.getInstance().getDoctor(desiredDoctorIndex).
                                    getAssistantNurse(i).setShift(j, shift);
                            System.out.println("Done !");
                            starterMenu();
                        }
                    }
                }
            }
        }
        else{
            System.out.println("The ID you have entered, doesn't exist");
        }
        starterMenu();
    }

    public static void showDoctorInformation() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter a personnel ID");
        int personnelID = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        Doctor doctor = new Doctor();
        if (Hospital.getInstance().getDoctorsCount() != 0) {
            for (int i = 0; i < Hospital.getInstance().getDoctorsCount(); i++) {
                if (Hospital.getInstance().getDoctor(i).getPersonnelId() == personnelID) {
                    isFound = true;
                    doctor = Hospital.getInstance().getDoctor(i);
                }
            }
        }

        if (isFound) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Name :" + doctor.getName());
            System.out.println("Personnel ID :" + doctor.getPersonnelId());
            System.out.println("Assistant nurses :");
            System.out.println("\t 1 - " + doctor.getAssistantNurse(0).getName());
            System.out.println("\t 2 - " + doctor.getAssistantNurse(1).getName());
            System.out.println("Patients :");
            for (int i = 0; i < doctor.getPatientsCount(); i++) {
                System.out.println("\t" + (i + 1) + " - " + doctor.getPatient(i).getInformation().getName());
            }
            doctor.printShifts();
        }
        else{
            System.out.println("The ID you have entered, doesn't exist");
        }
        starterMenu();
    }

    public static void nurseCreator() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter the name :");
        String name = scanner.nextLine();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please set a personnel ID for this nurse (a number with 4 to 6 digits) :");
        int personnelID = Integer.parseInt(scanner.nextLine());
        System.out.println("Please set maximum shifts count for this nurse :");
        int maxShiftsCount = Integer.parseInt(scanner.nextLine());
        if (!validatePersonnelInfo(name, personnelID, maxShiftsCount)) {
            System.out.println("Invalid information !");
            starterMenu();
        }
        Hospital.getInstance().addNurse(new Nurse(name, personnelID, maxShiftsCount));
        System.out.println("Nurse hired successfully !");
        starterMenu();

    }

    public static void changeNurseInformation() {
        System.out.println("Please enter a personnel ID : ");
        int personnelID = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        int desiredNurseIndex = 0;
        if (Hospital.getInstance().getNursesCount() != 0) {
            for (int i = 0; i < Hospital.getInstance().getNursesCount(); i++) {
                if (personnelID == Hospital.getInstance().getNurse(i).getPersonnelId()) {
                    isFound = true;
                    desiredNurseIndex = i;
                }
            }
        }
        if (isFound) {
            System.out.println("So,which field do you want to change ?");
            System.out.println("1 - Name");
            System.out.println("2 - PersonnelID");
            System.out.println("3 - maxShiftsCount");
            int selectedFieldIndex = Integer.parseInt(scanner.nextLine());
            if (selectedFieldIndex == 1) {
                System.out.println("Please enter the new name :");
                String name = scanner.nextLine();
                Hospital.getInstance().getNurse(desiredNurseIndex).setName(name);
                System.out.println("Change applied successfully");
            } else if (selectedFieldIndex == 2) {
                System.out.println("Please enter new personnel ID :");
                int newID = Integer.parseInt(scanner.nextLine());
                Hospital.getInstance().getNurse(desiredNurseIndex).setPersonnelId(newID);
                System.out.println("Change applied successfully");
            } else if (selectedFieldIndex == 3) {
                System.out.println("Please enter the maximum shifts count");
                int newCount = Integer.parseInt(scanner.nextLine());
                Hospital.getInstance().getNurse(desiredNurseIndex).setMaxShiftsCount(newCount);
            }
        } else {
            System.out.println("The entered ID doesn't exist");
        }
        starterMenu();
    }

    public static void showNurseInformation() {
        System.out.println("Please enter a personnel ID :");
        int personnelID = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        int desiredNurseIndex = 0;
        if (Hospital.getInstance().getNursesCount() != 0) {
            for (int i = 0; i < Hospital.getInstance().getNursesCount(); i++) {
                if (Hospital.getInstance().getNurse(i).getPersonnelId() == personnelID) {
                    isFound = true;
                    desiredNurseIndex = i;
                }
            }
        }
        if (isFound) {
            System.out.println("Name : " + Hospital.getInstance().getNurse(desiredNurseIndex).getName());
            System.out.println("Personnel ID : " + Hospital.getInstance().getNurse(desiredNurseIndex).getPersonnelId());
            System.out.println("Connected doctors :");
            if (Hospital.getInstance().getNurse(desiredNurseIndex).getConnectedDoctorsCount() != 0) {
                for (int i = 0; i < Hospital.getInstance().getNurse(desiredNurseIndex).getConnectedDoctorsCount(); i++) {
                    System.out.println("\t" + Hospital.getInstance().getNurse(desiredNurseIndex).getConnectedDoctor(i).getName());
                }
            }
            Hospital.getInstance().getNurse(desiredNurseIndex).printShifts();
        } else {
            System.out.println("the personnelID you have entered,doesn't exist");
        }
        starterMenu();
    }

    public static boolean validateNationalID(String id) {
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

    public static boolean validateDate(int month, int day) {
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

    public static boolean checkAvailableDoctors() {
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

    public static boolean validatePersonnelInfo(String name, int personnelID, int maxShiftsCount) {
        boolean output = true;
        if (!name.matches("^(?![\\s.]+$)[a-zA-Z\\s.]*$")) {
            output = false;
        }
        if (personnelID > 999999 || personnelID < 1000) {
            output = false;
        }
        if (maxShiftsCount <= 0) {
            output = false;
        }
        return output;
    }

    public static void roomCreator() {
        System.out.println("Please set a room number :");
        int roomNum = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the beds count :");
        int bedsCnt = Integer.parseInt(scanner.nextLine());
        System.out.println("Which section do you want this room for ?");
        System.out.println("1 - Principal ");
        System.out.println("2 - Emergency");
        int sectionIdentifier = Integer.parseInt(scanner.nextLine());
        System.out.println("Please enter the room cost for 24 hours :");
        int roomCost = Integer.parseInt(scanner.nextLine());
        if (sectionIdentifier == 1) {
            if (bedsCnt <= bedsCount && roomNum > 0) {
                principal.addRoom(new Room(roomNum, Enums.Sections.PRINCIPAL, bedsCnt, roomCost));
                bedsCount -= bedsCnt;
                System.out.println("DONE !");
            } else if (bedsCnt > bedsCount) {
                System.out.println("There are no any beds remaining !");
                System.out.println();
            }
        } else if (sectionIdentifier == 2) {
            if (bedsCnt <= bedsCount && roomNum > 0) {
                emergency.addRoom(new Room(roomNum, Enums.Sections.PRINCIPAL, bedsCnt, roomCost));
                bedsCount -= bedsCnt;
                System.out.println("DONE !");
            } else if (bedsCnt > bedsCount) {
                System.out.println("There are no any beds remaining !");
                System.out.println();
            }
        }
        starterMenu();
    }

    public static void roomEditor() {
        System.out.println("Please enter a room number : ");
        int roomNum = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        boolean inEmergency = false;
        boolean inPricipal = false;
        int desiredRoomIndex = 0;
        if (emergency.getRoomsCount() != 0) {
            for (int i = 0; i < emergency.getRoomsCount(); i++) {
                if (roomNum == emergency.getRoom(i).getRoomNum()) {
                    isFound = true;
                    inEmergency = true;
                }
            }
        }
        if (principal.getRoomsCount() != 0) {
            for (int i = 0; i < principal.getRoomsCount(); i++) {
                if (roomNum == principal.getRoom(i).getRoomNum()) {
                    isFound = true;
                    inPricipal = true;
                }
            }
        }

        if (isFound) {
            System.out.println("Ok,what change do you want to perform on this room ?");
            System.out.println("1 - Change roomNum");
            System.out.println("2 - Change Availability statement ");
            System.out.println("3 - Change room cost");
            System.out.println("4 - Add a bed to this room ");
            int input = Integer.parseInt(scanner.nextLine());
            if (input == 1) {
                System.out.println("Enter the new room num :");
                int newRoomNum = Integer.parseInt(scanner.nextLine());
                if (inEmergency) {
                    emergency.getRoom(desiredRoomIndex).setRoomNum(newRoomNum);
                } else if (inPricipal) {
                    principal.getRoom(desiredRoomIndex).setRoomNum(newRoomNum);
                }
            } else if (input == 2) {
                if (inEmergency) {
                    if (emergency.getRoom(desiredRoomIndex).getStatement() == Enums.AvailabilityStatement.AVAILABLE) {
                        emergency.getRoom(desiredRoomIndex).setStatement(Enums.AvailabilityStatement.UNAVAILABLE);
                    } else if (emergency.getRoom(desiredRoomIndex).getStatement() == Enums.AvailabilityStatement.UNAVAILABLE) {
                        emergency.getRoom(desiredRoomIndex).setStatement(Enums.AvailabilityStatement.AVAILABLE);
                    }
                } else if (inPricipal) {
                    if (principal.getRoom(desiredRoomIndex).getStatement() == Enums.AvailabilityStatement.AVAILABLE) {
                        principal.getRoom(desiredRoomIndex).setStatement(Enums.AvailabilityStatement.UNAVAILABLE);
                    } else if (principal.getRoom(desiredRoomIndex).getStatement() == Enums.AvailabilityStatement.UNAVAILABLE) {
                        principal.getRoom(desiredRoomIndex).setStatement(Enums.AvailabilityStatement.AVAILABLE);
                    }
                }
            } else if (input == 3) {
                System.out.println("Please enter the room cost :");
                int roomCost = Integer.parseInt(scanner.nextLine());
                if (inEmergency) {
                    emergency.getRoom(desiredRoomIndex).setRoomCost(roomCost);
                } else if (inPricipal) {
                    principal.getRoom(desiredRoomIndex).setRoomCost(roomCost);
                }
            } else if (input == 4) {
                if (inEmergency) {
                    emergency.getRoom(desiredRoomIndex).addBed(new Bed());
                    bedsCount--;
                }
            }
        }
        starterMenu();
    }

    public static void roomRemover() {
        System.out.println("Please enter a room num :");
        int roomNum = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        boolean inEmergency = false;
        boolean inPrincipal = false;
        int desiredRoomIndex = 0;
        if (emergency.getRoomsCount() != 0) {
            for (int i = 0; i < emergency.getRoomsCount(); i++) {
                if (emergency.getRoom(i).getRoomNum() == roomNum) {
                    isFound = true;
                    inEmergency = true;
                    desiredRoomIndex = i;
                }
            }
        }
        if (principal.getRoomsCount() != 0) {
            for (int i = 0; i < principal.getRoomsCount(); i++) {
                if (principal.getRoom(i).getRoomNum() == roomNum) {
                    isFound = true;
                    inPrincipal = true;
                    desiredRoomIndex = i;
                }
            }
        }

        if (isFound) {
            int emptyBedsCount;
            emergency.getRoom(desiredRoomIndex).setStatement(Enums.AvailabilityStatement.UNAVAILABLE);
            if (inEmergency) {
                emptyBedsCount = emergency.getEmptyBedsCount();
                emptyBedsCount -= emergency.getRoom(desiredRoomIndex).getEmptyBedsCount();
                if (emptyBedsCount == emergency.getRoom(desiredRoomIndex).getPatientsCount()) {
                    for (int i = 0; i < emergency.getRoom(desiredRoomIndex).getPatientsCount(); i++) {
                        emergency.getRoom(desiredRoomIndex).getPatient(i).findCrowdEmergencyRoom(emergency);
                    }
                    emergency.removeRoom(desiredRoomIndex);
                    System.out.println("Room removed successfully !");
                } else {
                    System.out.println("There is no space to move the patients");
                    System.out.println("you will be redirected to the Starter menu");
                }
            } else if (inPrincipal) {
                emptyBedsCount = emergency.getEmptyBedsCount();
                emptyBedsCount -= emergency.getRoom(desiredRoomIndex).getEmptyBedsCount();
                if (emptyBedsCount == emergency.getRoom(desiredRoomIndex).getPatientsCount()) {
                    for (int i = 0; i < emergency.getRoom(desiredRoomIndex).getPatientsCount(); i++) {
                        emergency.getRoom(desiredRoomIndex).getPatient(i).findCrowdEmergencyRoom(emergency);
                    }
                    emergency.removeRoom(desiredRoomIndex);
                    System.out.println("Room removed successfully !");
                } else {
                    System.out.println("There is no space in other rooms to move the patients");
                    System.out.println("you will be redirected to the Starter menu");
                }
            }
        } else {
            System.out.println("There is no room with this number !");
        }
        starterMenu();
    }

    public static void releasePatient() {
        System.out.println("Please enter a fileID");
        int fileID = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        boolean inEmergency = false;
        boolean inPrincipal = false;
        ReleasingFactor releasingFactor = new ReleasingFactor();
        int desiredPatientIndex = 0;
        Patient patient = new Patient();
        if (emergency.getPatientsCount() != 0) {
            for (int i = 0; i < emergency.getPatientsCount(); i++) {
                if (emergency.getPatient(i).getInformation().getFileId() == fileID) {
                    isFound = true;
                    inEmergency = true;
                    desiredPatientIndex = i;
                }
            }
        }
        if (principal.getPatientsCount() != 0) {
            for (int i = 0; i < principal.getPatientsCount(); i++) {
                if (principal.getPatient(i).getInformation().getFileId() == fileID) {
                    isFound = true;
                    inPrincipal = true;
                    desiredPatientIndex = i;
                }
            }
        }
        if (isFound) {
            if (inEmergency) {
                releasingFactor = emergency.getPatient(desiredPatientIndex).release();
                patient = emergency.getPatient(desiredPatientIndex);
            } else if (inPrincipal) {
                releasingFactor = principal.getPatient(desiredPatientIndex).release();
                patient = principal.getPatient(desiredPatientIndex);
            }
            System.out.println("Patient released !");
            System.out.println("This is the releasing factor :");
            System.out.println("Patient's name :" + patient.getInformation().getName());
            System.out.println("Hospitalization Date : " + patient.getInformation().getHospitalizationDate());
            System.out.println("Release date : " + releasingFactor.getReleaseDate());
            System.out.println("Hospitalization days count :" + releasingFactor.getHospitalizationDaysCount());
            System.out.println("Room daily cost :" + releasingFactor.getRoomDailyCost());
            System.out.println("Full cost :" + releasingFactor.getFullCost());
            System.out.println("Final cost" + releasingFactor.getFinalCost());

        } else if (!isFound) {
            System.out.println("INVALID ID");
        }
        starterMenu();
    }

    public static boolean checkEnoughNurses() {
        int cnt = 0;
        if (Hospital.getInstance().getNursesCount() == 0) {
            return false;
        }
        for (int i = 0; i < Hospital.getInstance().getNursesCount(); i++) {
            if (Hospital.getInstance().getNurse(i).getDoctorsCount() < 2) {
                cnt++;
            }
            if (cnt == 2) {
                return true;
            }
        }
        return false;
    }
    public static void showDoctorInfoFromPatient(){
        System.out.println("Please enter a fileID :");
        int fileID = Integer.parseInt(scanner.nextLine());
        boolean isFound= false;
        boolean inEmergency = false;
        boolean inPrincipal = false;
        int desiredPatientIndex = 0;
        if(principal.getPatientsCount() != 0){
            for(int i = 0;i < principal.getPatientsCount();i++){
                if(fileID == principal.getPatient(i).getInformation().getFileId()){
                    isFound = true;
                    inPrincipal = true;
                    desiredPatientIndex = i;
                }
            }
        }
        if(emergency.getPatientsCount() != 0){
            for(int i = 0;i < emergency.getPatientsCount();i++){
                if(fileID == emergency.getPatient(i).getInformation().getFileId()){
                    isFound = true;
                    inEmergency = true;
                    desiredPatientIndex = i;
                }
            }
        }
        if(isFound){
            if(inEmergency){
                System.out.println("Name : " + emergency.getPatient(desiredPatientIndex).getInformation().getDoctor().getName());
                System.out.println("Personnel ID : " + emergency.getPatient(desiredPatientIndex).getInformation().getDoctor().getPersonnelId());
            }
            else if(inPrincipal){
                System.out.println("Name : " + principal.getPatient(desiredPatientIndex).getInformation().getDoctor().getName());
                System.out.println("Personnel ID : " + principal.getPatient(desiredPatientIndex).getInformation().getDoctor().getPersonnelId());
            }
        }
        else{
            System.out.println("There is no patient with this File ID");
        }
        starterMenu();
    }
    public static void showNursesInfoFromPatient(){
        System.out.println("Please enter a fileID :");
        int fileID = Integer.parseInt(scanner.nextLine());
        boolean isFound= false;
        boolean inEmergency = false;
        boolean inPrincipal = false;
        int desiredPatientIndex = 0;
        if(principal.getPatientsCount() != 0){
            for(int i = 0;i < principal.getPatientsCount();i++){
                if(fileID == principal.getPatient(i).getInformation().getFileId()){
                    isFound = true;
                    inPrincipal = true;
                    desiredPatientIndex = i;
                }
            }
        }
        if(emergency.getPatientsCount() != 0){
            for(int i = 0;i < emergency.getPatientsCount();i++){
                if(fileID == emergency.getPatient(i).getInformation().getFileId()){
                    isFound = true;
                    inEmergency = true;
                    desiredPatientIndex = i;
                }
            }
        }
        if(isFound){
            if(inEmergency){
                for(int i = 0;i < 2;i++){
                    System.out.println("Name : " + emergency.getPatient(desiredPatientIndex)
                            .getInformation().getDoctor().getAssistantNurse(i).getName());
                    System.out.println("Personnel ID : " + emergency.getPatient(desiredPatientIndex)
                            .getInformation().getDoctor().getAssistantNurse(i).getPersonnelId());
                }
            }
            else if(inPrincipal){
                for(int i = 0;i < 2;i++){
                    System.out.println("Name : " + principal.getPatient(desiredPatientIndex)
                            .getInformation().getDoctor().getAssistantNurse(i).getName());
                    System.out.println("Personnel ID : " + principal.getPatient(desiredPatientIndex)
                            .getInformation().getDoctor().getAssistantNurse(i).getPersonnelId());
                }
            }
        }
        else{
            System.out.println("There is no patient with this File ID");
        }
        starterMenu();
    }
    public static void showRoomPatients(){
        System.out.println("Please enter a room number :");
        int roomNum = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        boolean inEmergency = false;
        boolean inPrincipal = false;
        int desiredRoomIndex = 0;
        if(principal.getRoomsCount() != 0){
            for(int i = 0;i < principal.getRoomsCount();i++){
                if(roomNum == principal.getRoom(i).getRoomNum()){
                    isFound = true;
                    inPrincipal = true;
                    desiredRoomIndex = i;
                }
            }
        }
        if(emergency.getRoomsCount() != 0){
            for(int i = 0;i < emergency.getRoomsCount();i++){
                if(roomNum == emergency.getRoom(i).getRoomNum()){
                    isFound = true;
                    inEmergency = true;
                    desiredRoomIndex = i;
                }
            }
        }
        if(isFound){
            if (inEmergency){
                for(int i = 0;i < emergency.getRoom(desiredRoomIndex).getPatientsCount();i++){
                    System.out.println("Name : " + emergency.getRoom(desiredRoomIndex).
                            getPatient(i).getInformation().getName());
                    System.out.println("File ID :" + emergency.getRoom(desiredRoomIndex).
                            getPatient(i).getInformation().getFileId());
                }
            }
            if(inPrincipal){
                for(int i = 0;i < principal.getRoom(desiredRoomIndex).getPatientsCount();i++){
                    System.out.println("Name : " + principal.getRoom(desiredRoomIndex).
                            getPatient(i).getInformation().getName());
                    System.out.println("File ID :" + principal.getRoom(desiredRoomIndex).
                            getPatient(i).getInformation().getFileId());
                }
            }
        }
        else{
            System.out.println("There is no room with this number ");
        }
        starterMenu();
    }
}
