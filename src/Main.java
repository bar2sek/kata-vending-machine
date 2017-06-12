import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VendingMachine machine = new VendingMachine();

        System.out.println("INSERT COIN\n");
        String coin = sc.next();
        System.out.println(machine.acceptValidCoins(coin));
    }
}
