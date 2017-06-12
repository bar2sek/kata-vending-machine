
public class VendingMachine {

    private static final int COLA = 100;
    private static final int CHIPS = 50;
    private static final int CANDY = 65;
    private Integer credit;

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getTotalCredit() {
        String total = credit.toString();
        return total;
    }

    public String acceptValidCoins(String coin) {
        if (coin == "nickel" || coin == "dime" || coin == "quarter") {
            creditUser(coin);
            return credit.toString();
        }
        else return "INSERT COIN\n";
    }

    private void creditUser(String coin) {
        if (coin == "nickel") {
            credit += 5;
        }
        else if (coin == "dime") {
            credit += 10;
        }
        else { credit += 25; }
    }
}