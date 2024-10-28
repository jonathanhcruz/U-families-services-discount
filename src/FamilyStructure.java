import java.util.Map;

public class FamilyStructure {
  private final String lastName;
  private final int stratum;
  private final int electricityBill;
  private final int waterBill;
  private final int gasBill;
  private double discount;



  public FamilyStructure(String lastName, int stratum, int electricityBill, int waterBill, int gasBill) {
    this.lastName = lastName;
    this.stratum = stratum;
    this.electricityBill = electricityBill;
    this.waterBill = waterBill;
    this.gasBill = gasBill;
    this.discount = selectDiscount(stratum);
  }

  public double selectDiscount(int stratum) {
    return switch (stratum) {
      case 1 -> 0.2;
      case 2 -> 0.15;
      default -> 0.09;
    };
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public String getLastName() {
      return lastName;
  }

  public int getStratum() {
    return stratum;
  }

  public int getElectricityBill() {
    return electricityBill;
  }

  public int getWaterBill() {
    return waterBill;
  }

  public int getGasBill() {
    return gasBill;
  }

  public double getDiscount() {
    return discount;
  }
}
