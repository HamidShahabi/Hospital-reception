package ir.ac.kntu;

public class HospitalizationLog {



    private String name;
    private Enums.Illness kindOfIllness;
    private Enums.ReferType referType;
    private Date hospitalizationDate;
    private Time hospitalizationTime;
    public HospitalizationLog(int referTypeIdentifier ,int kindOfIllnessIdentifier,
                              String name,Date date){
        this.name = name;
        hospitalizationDate = new Date(date.getYear(),date.getMonth(),date.getDay());
        hospitalizationTime = new Time();
        switch (referTypeIdentifier){
            case 1:
                referType = Enums.ReferType.NORMAL;break;
            case 2:
                referType = Enums.ReferType.EMERGENCY;
        }
        switch (kindOfIllnessIdentifier){
            case 1:
                kindOfIllness = Enums.Illness.BURN;break;
            case 2:
                kindOfIllness = Enums.Illness.CRASH;break;
            case 3:
                kindOfIllness = Enums.Illness.IMPACT;break;
            case 4:
                kindOfIllness = Enums.Illness.OTHER;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enums.Illness getKindOfIllness() {
        return kindOfIllness;
    }

    public void setKindOfIllness(Enums.Illness kindOfIllness) {
        this.kindOfIllness = kindOfIllness;
    }

    public Enums.ReferType getReferType() {
        return referType;
    }

    public void setReferType(Enums.ReferType referType) {
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
