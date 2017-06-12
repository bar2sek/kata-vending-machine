
public class VendingMachine {

    private Integer credit = 0;

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getTotalCredit(String coin) {
        creditUser(coin);
        coin = credit.toString();
        return coin;
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