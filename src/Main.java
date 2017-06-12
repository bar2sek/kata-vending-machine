import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachine machine = new VendingMachine();

        System.out.println("INSERT COIN\n");
        String coin = scanner.next();
        System.out.println(machine.acceptValidCoins(coin));
    }
}
