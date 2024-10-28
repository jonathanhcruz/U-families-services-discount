import org.jetbrains.annotations.NotNull;

public class GetFamilyInfo {
    private final Integer numberOfFamily;
    private String lastName;

    public GetFamilyInfo(Integer numberOfFamily) {
        this.numberOfFamily = numberOfFamily;
    }

    private void getLastName() {
        final GetInfo lastName = new GetInfo("What is the last name of the family " + (numberOfFamily + 1) + "?");
        this.lastName = lastName.getResponse();
    }

    private int getStratum() {
        final GetInfo stratum = new GetInfo("What is the stratum of the family "+ (lastName) +"? (1 to 6)");
        final int stratumToInt = Integer.parseInt(stratum.getResponse());
        return stratumToInt >= 1 ? stratumToInt : 0;
    }

    private int electricityBill () {
        final GetInfo electricityBill = new GetInfo("What is the electricity bill of the family "+ (lastName) +"?");
        return Integer.parseInt(electricityBill.getResponse());
    }

    private int waterBill () {
        final GetInfo waterBill = new GetInfo("What is the water bill of the family "+ (lastName) +"?");
        return Integer.parseInt(waterBill.getResponse());
    }

    private int gasBill () {
        final GetInfo gasBill = new GetInfo("What is the gas bill of the family "+ (lastName) +"?");
        return Integer.parseInt(gasBill.getResponse());
    }


    public FamilyStructure infoOfFamily() {
        getLastName();
        return new FamilyStructure(lastName, getStratum(), electricityBill(), waterBill(), gasBill());
    }
}
