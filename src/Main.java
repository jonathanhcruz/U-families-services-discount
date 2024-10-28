import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final int quantityOfFamilies = Integer.parseInt(new GetInfo("How many families are you going to register?").getResponse());

        if (quantityOfFamilies <= 0) {
            System.out.println("The quantity of families must be greater than 0.");
            return;
        }

        ArrayList<FamilyStructure> collectionOfFamilies  = familyRegistration(quantityOfFamilies);
        showResults(collectionOfFamilies);
    }

    @NotNull
    private static ArrayList<FamilyStructure> familyRegistration(int quantityOfFamilies) {
        ArrayList<FamilyStructure> collectionOfFamilies = new ArrayList<FamilyStructure>(quantityOfFamilies);

        for(int i = 0; i < quantityOfFamilies; i++) {
            collectionOfFamilies.add(new GetFamilyInfo(i).infoOfFamily());
        }

        return collectionOfFamilies;
    }

    private static void showResults(ArrayList<FamilyStructure> collectionOfFamilies) {
        for (FamilyStructure family : collectionOfFamilies) {
            System.out.println("\n------------------------------------------------------------"
                    + "\nFamily " + family.getLastName() + " information:"
                    + "\nThe family " + family.getLastName() + " has a stratum of " + family.getStratum() + " and a discount of " + (family.getDiscount() * 100) + "%."
                    + "\nElectricity bill: $" + family.getElectricityBill() + " with a discount of $" + calcDiscount(family.getElectricityBill(), family.getDiscount())
                    + "\nWater bill: $" + family.getWaterBill() + " with a discount of $" + calcDiscount(family.getWaterBill(), family.getDiscount())
                    + "\nGas bill: $" + family.getGasBill() + " with a discount of $" + calcDiscount(family.getGasBill(), family.getDiscount())
                    + "\nTotal bill: $" + (family.getElectricityBill() + family.getWaterBill() + family.getGasBill())
                    + "\nTotal bill with discount: $" + calcDiscount((family.getElectricityBill() + family.getWaterBill() + family.getGasBill()), (1 - family.getDiscount())) + "\n"
                    + "\n------------------------------------------------------------"
            );
        }
    }

    private static int calcDiscount (int valueOfBill, double discount) {
        return (int) (valueOfBill * discount);
    }
}