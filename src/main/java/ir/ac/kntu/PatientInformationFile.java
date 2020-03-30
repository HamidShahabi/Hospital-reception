package ir.ac.kntu;

public class PatientInformationFile {


    private enum Illness {
        BURN, CRASH, IMPACT, OTHER
    }
    private HospitalizationLog log;
    private String firstName;
    private String lastName;
    private String nationalId;
    private Date hospitalizationDate;
    private  Enums.Sections hospitalizationSection;
    private Illness kindOfIllness;
    private Enums.Insurances Insurance;
    private String gender;
    private int age;
    private Doctor doctor;
    private String fileId;

    public HospitalizationLog getLog() {
        return log;
    }

    public void setLog(HospitalizationLog log) {
        this.log = log;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Date getHospitalizationDate() {
        return hospitalizationDate;
    }

    public void setHospitalizationDate(Date hospitalizationDate) {
        this.hospitalizationDate = hospitalizationDate;
    }

    public Illness getKindOfIllness() {
        return kindOfIllness;
    }

    public void setKindOfIllness(Illness kindOfIllness) {
        this.kindOfIllness = kindOfIllness;
    }

    public Enums.Insurances getInsurance() {
        return Insurance;
    }

    public void setInsurance(Enums.Insurances insurance) {
        Insurance = insurance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
