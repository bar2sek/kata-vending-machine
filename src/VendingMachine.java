
public class VendingMachine {
    public String getCoinsInserted(String coin) {
        return coin;
    }

    public String acceptValidCoins(String coin) {
        if (coin == "nickel" || coin == "dime" || coin == "quarter") {
            return coin;
        }
        else return "coin not valid";
    }
}