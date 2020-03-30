package ir.ac.kntu;

public class HospitalizationLog {
    enum Illness {
        BURN, CRASH, IMPACT, OTHER
    }

    enum ReferType {
        NORMAL, EMERGENCY
    }

    private String firstName;
    private String lastName;
    private String HospitalizationSection;


    private Illness kindOfIllness;
    private ReferType referType;
    private Date hospitalizationDate;
    private Time hospitalizationTime;

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

    public String getHospitalizationSection() {
        return HospitalizationSection;
    }

    public void setHospitalizationSection(String hospitalizationSection) {
        HospitalizationSection = hospitalizationSection;
    }

    public Illness getKindOfIllness() {
        return kindOfIllness;
    }

    public void setKindOfIllness(Illness kindOfIllness) {
        this.kindOfIllness = kindOfIllness;
    }

    public ReferType getReferType() {
        return referType;
    }

    public void setReferType(ReferType referType) {
        this.referType = referType;
    }

    public Date getHospitalizationDate() {
        return hospitalizationDate;
    }

    public void setHospitalizationDate(Date hospitalizationDate) {
        this.hospitalizationDate = hospitalizationDate;
    }

    public Time getHospitalizationTime() {
        return hospitalizationTime;
    }

    public void setHospitalizationTime(Time hospitalizationTime) {
        this.hospitalizationTime = hospitalizationTime;
    }
}
