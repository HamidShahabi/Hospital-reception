package ir.ac.kntu;

public class PatientInformationFile {

    private HospitalizationLog log;
    private String name;
    private String nationalId;
    private Date hospitalizationDate;
    private Enums.Sections hospitalizationSection;
    private Enums.Illness kindOfIllness;
    private Enums.Insurances insurance;
    private Enums.Gender gender;
    private int age;
    private Doctor doctor;
    private int fileId;

    public PatientInformationFile() {
    }

    public PatientInformationFile(String name, String nationalId,
                                  int insuranceIdentifier, int genderIdentifier, int age, int fileId) {
        this.name = name;
        this.nationalId = nationalId;
        this.age = age;
        this.fileId = fileId;
        switch (insuranceIdentifier) {
            case 1:
                insurance = Enums.Insurances.ARMEDFORCES;
                break;
            case 2:
                insurance = Enums.Insurances.HEALTHSERVICE;
                break;
            case 3:
                insurance = Enums.Insurances.SOCIALSECURITY;
                break;
            case 4:
                insurance = Enums.Insurances.NONE;

        }
        switch (genderIdentifier) {
            case 1:
                gender = Enums.Gender.MALE;
                break;
            case 2:
                gender = Enums.Gender.FEMALE;
        }
    }

    public Enums.Sections getHospitalizationSection() {
        return hospitalizationSection;
    }

    public void setHospitalizationSection() {
        if (log.getReferType() == Enums.ReferType.NORMAL) {
            hospitalizationSection = Enums.Sections.PRINCIPAL;
        } else if (log.getReferType() == Enums.ReferType.EMERGENCY) {
            hospitalizationSection = Enums.Sections.EMERGENCY;
        }
    }

    public HospitalizationLog getLog() {
        return log;
    }

    public void setLog(HospitalizationLog log) {
        this.log = log;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Enums.Illness getKindOfIllness() {
        return kindOfIllness;
    }

    public void setKindOfIllness(Enums.Illness kindOfIllness) {
        this.kindOfIllness = kindOfIllness;
    }

    public Enums.Insurances getInsurance() {
        return insurance;
    }

    public void setInsurance(Enums.Insurances insurance) {
        this.insurance = insurance;
    }

    public Enums.Gender getGender() {
        return gender;
    }

    public void setGender(Enums.Gender gender) {
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

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

}
