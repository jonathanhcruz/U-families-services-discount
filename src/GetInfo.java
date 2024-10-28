import java.util.Scanner;

public class GetInfo {
  final private String stringToPrint;

    public GetInfo(String stringToPrint) {
        this.stringToPrint = stringToPrint;
    }

    public String getResponse () {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(stringToPrint);
        return scanner.nextLine();
    }
}
