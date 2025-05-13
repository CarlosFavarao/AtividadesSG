import java.util.Scanner;

public class SaqueView {
    Scanner scanner = new Scanner(System.in);
    private double value;

    public double showSaqueView(){
        System.out.println("Insira o valor a ser sacado: ");
        value = scanner.nextDouble();
        return value;
    }

    public double getValue() {
        return value;
    }
}
