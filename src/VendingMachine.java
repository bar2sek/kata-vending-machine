
public class VendingMachine {

    private static final Integer COLA = 100;
    private static final Integer CHIPS = 50;
    private static final Integer CANDY = 65;
    private Integer credit;

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
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

    public String dispenseCandy() {
        Integer credit = getCredit();
        if (credit >= CANDY) {
            //dispense.product
            return "THANK YOU";
        }
        else return CANDY.toString();
    }

    public String dispenseSoda() {
        Integer credit = getCredit();
        if (credit >= COLA) {
            //dispense.product
            return "THANK YOU";
        }
        else return COLA.toString();

    }
}