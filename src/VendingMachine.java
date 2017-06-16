
public class VendingMachine {

    private static final Integer COLA_PRICE = 100;
    private static final Integer CHIPS_PRICE = 50;
    private static final Integer CANDY_PRICE = 65;
    private Integer colaStock;
    private Integer chipsStock;
    private Integer candyStock;
    private Integer quartersInMachine;
    private Integer nickelsInMachine;
    private Integer dimesInMachine;

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

    public Integer getQuartersInMachine() {
        return quartersInMachine;
    }

    public void setQuartersInMachine(Integer quartersInMachine) {
        this.quartersInMachine = quartersInMachine;
    }

    public Integer getNickelsInMachine() {
        return nickelsInMachine;
    }

    public void setNickelsInMachine(Integer nickelsInMachine) {
        this.nickelsInMachine = nickelsInMachine;
    }

    public Integer getDimesInMachine() {
        return dimesInMachine;
    }

    public void setDimesInMachine(Integer dimesInMachine) {
        this.dimesInMachine = dimesInMachine;
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

    public Integer quantityOfQuarters() {
        return getQuartersInMachine();
    }

    public Integer quantityOfDimes() {
        return getDimesInMachine();
    }

    public Integer quantityOfNickels() {
        return getNickelsInMachine();
    }
}