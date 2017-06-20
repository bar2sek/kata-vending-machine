
public class VendingMachine {

    private static final int COLA_PRICE = 100;
    private static final int CHIPS_PRICE = 50;
    private static final int CANDY_PRICE = 65;
    private int colaStock = 0;
    private int chipsStock = 0;
    private int candyStock = 0;
    private int quartersInMachine = 0;
    private int nickelsInMachine = 0;
    private int dimesInMachine = 0;

    public int getColaStock() {
        return colaStock;
    }

    public void setColaStock(int colaStock) {
        this.colaStock = colaStock;
    }

    public int getChipsStock() {
        return chipsStock;
    }

    public void setChipsStock(int chipsStock) {
        this.chipsStock = chipsStock;
    }

    public int getCandyStock() {
        return candyStock;
    }

    public void setCandyStock(int candyStock) {
        this.candyStock = candyStock;
    }

    public static int getColaPrice() {
        return COLA_PRICE;
    }

    public static int getChipsPrice() {
        return CHIPS_PRICE;
    }

    public static int getCandyPrice() {
        return CANDY_PRICE;
    }
    private int credit;

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
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
            return Integer.toString(credit);
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

    public String dispenseProduct(int product) {
        int credit = getCredit();
        if (credit >= product) {
            refundUser(product);
            returnChange();
            return "THANK YOU";
        }
        else if (credit > 0 && credit < product) {
            return Integer.toString(product);
        }
        else return "INSERT COIN\n";
    }

    public String refundUser(int product) {
        if (credit > product) {
            credit -= product;
            return Integer.toString(credit);
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

    public String checkStock(int productStock) {
        if (productStock > 0) {
            return Integer.toString(productStock);
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