
public class VendingMachine {

    private static final Integer COLA_PRICE = 100;
    private static final Integer CHIPS_PRICE = 50;
    private static final Integer CANDY_PRICE = 65;
    private Integer colaStock;
    private Integer chipsStock;
    private Integer candyStock;

    public Integer getColaStock() {
        return colaStock;
    }

    public void setColaStock(Integer colaStock) {
        this.colaStock = colaStock;
    }

    public Integer getChipsStock() {
        return chipsStock;
    }

    public void setChipsStock(Integer chipsStock) {
        this.chipsStock = chipsStock;
    }

    public Integer getCandyStock() {
        return candyStock;
    }

    public void setCandyStock(Integer candyStock) {
        this.candyStock = candyStock;
    }

    public static Integer getColaPrice() {
        return COLA_PRICE;
    }

    public static Integer getChipsPrice() {
        return CHIPS_PRICE;
    }

    public static Integer getCandyPrice() {
        return CANDY_PRICE;
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

    public String checkStock(Integer productStock) {
        if (productStock > 0) {
            return productStock.toString();
        }
        else return "SOLD OUT";
    }
}