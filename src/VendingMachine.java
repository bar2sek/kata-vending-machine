
public class VendingMachine {

    private static final Integer COLA_PRICE = 100;
    private static final Integer CHIPS_PRICE = 50;
    private static final Integer CANDY_PRICE = 65;
    private Integer colaStock;
    private Integer chipsStock;
    private Integer candyStock;
    private int quartersInMachine;
    private int nickelsInMachine;
    private int dimesInMachine;

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

    public int getQuartersInMachine() {
        return quartersInMachine;
    }

    public void setQuartersInMachine(int quartersInMachine) {
        this.quartersInMachine = quartersInMachine;
    }

    public int getNickelsInMachine() {
        return nickelsInMachine;
    }

    public void setNickelsInMachine(int nickelsInMachine) {
        this.nickelsInMachine = nickelsInMachine;
    }

    public int getDimesInMachine() {
        return dimesInMachine;
    }

    public void setDimesInMachine(int dimesInMachine) {
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
            nickelsInMachine ++;
        }
        else if (coin.equals("dime")) {
            credit += 10;
            dimesInMachine ++;
        }
        else {
            credit += 25;
            quartersInMachine ++;
        }
    }

    public String dispenseProduct(Integer product) {
        Integer credit = getCredit();
        if (credit >= product) {
            refundUser(product);
            returnChange();
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

    public String returnChange() {
        int dimes = this.dimesInMachine;
        int nickels = this.nickelsInMachine;

        if (credit == 20) {
            if (dimes >= 2) {
                return "2 dimes";
            }
            else if (dimes >= 1 && nickels >= 2) {
                return "1 dime, 2 nickels";
            }
            else if (dimes >= 0 && nickels >= 4) {
                return "4 nickels";
            }
            else return "EXACT CHANGE ONLY";
        }
        else if (credit == 15) {
            if (dimes >= 1 && nickels >= 1) {
                return "1 dime, 1 nickel";
            }
            else if (dimes == 0 && nickels >= 3) {
                return "3 nickels";
            }
            else return "EXACT CHANGE ONLY";
        }
        else if (credit == 10) {
            if (dimes >= 1) {
                return "1 dime";
            }
            else if (dimes == 0 && nickels >= 2) {
                return "2 nickels";
            }
            else return "EXACT CHANGE ONLY";
        }
        else if (credit == 5) {
            if (nickels >= 1) {
                return "1 nickel";
            }
            else return "EXACT CHANGE ONLY";
        }
        else return "EXACT CHANGE ONLY";
    }
}