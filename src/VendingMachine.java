
public class VendingMachine {

    private static final Integer COLA = 100;
    private static final Integer CHIPS = 50;
    private static final Integer CANDY = 65;

    public static Integer getCOLA() {
        return COLA;
    }

    public static Integer getCHIPS() {
        return CHIPS;
    }

    public static Integer getCANDY() {
        return CANDY;
    }
    private Integer credit;

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String acceptValidCoins(String coin) {
        if (coin.equals("nickel") || coin.equals("dime") || coin.equals("quarter")) {
            creditUser(coin);
            return credit.toString();
        }
        else return "INSERT COIN\n";
    }

    private void creditUser(String coin) {
        if (coin.equals("nickel")) {
            credit += 5;
        }
        else if (coin.equals("dime")) {
            credit += 10;
        }
        else { credit += 25; }
    }

    public String dispenseProduct(Integer product) {
        Integer credit = getCredit();
        if (credit >= product) {
            refundUser(product);
            setCredit(0);
            return "THANK YOU";
        }
        else if (credit > 0 && credit < product) {
            return product.toString();
        }
        else return "INSERT COIN\n";
    }

    public String refundUser(Integer product) {
        if (credit > product) {
            credit -= product;
            return credit.toString();
        }
        else return "";
    }

    public String coinReturnPressed() {
        if (credit > 0) {
            setCredit(0);
            return "INSERT COIN\n";
        }
        else return "INSERT COIN\n";
    }
}