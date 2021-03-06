import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SelectProductTest {
    private VendingMachine machine;

    @Before
    public void setUp() {
        machine = new VendingMachine();
        machine.setCredit(0);
    }

    @Test
    public void machineDispensesCandyWithCorrectCredit() {
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("dime");
        machine.acceptValidCoins("nickel");

        assertEquals("THANK YOU", machine.dispenseProduct(VendingMachine.getCandyPrice()));
    }

    @Test
    public void machineDispensesCandyWithIncorrectCredit() {
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("dime");
        machine.acceptValidCoins("nickel");

        assertEquals("65", machine.dispenseProduct(VendingMachine.getCandyPrice()));
    }

    @Test
    public void machineDispensesSodaWithCorrectCredit() {
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("dime");
        machine.acceptValidCoins("dime");
        machine.acceptValidCoins("nickel");

        assertEquals("THANK YOU", machine.dispenseProduct(VendingMachine.getColaPrice()));
    }

    @Test
    public void machineDispensesSodaWithIncorrectCredit() {
        machine.acceptValidCoins("quarter");

        assertEquals("100", machine.dispenseProduct(VendingMachine.getColaPrice()));
    }

    @Test
    public void machineDispensesChipsWithCorrectCredit() {
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");

        assertEquals("THANK YOU", machine.dispenseProduct(VendingMachine.getChipsPrice()));
    }

    @Test
    public void machineDispensesChipsWithIncorrectCredit() {
        machine.acceptValidCoins("quarter");

        assertEquals("50", machine.dispenseProduct(VendingMachine.getChipsPrice()));
    }

    @Test
    public void chipsButtonPressedAfterDispensingShowsInsertCoin() {

        assertEquals("INSERT COIN", machine.dispenseProduct(VendingMachine.getChipsPrice()));
    }

    @Test
    public void giveCorrectChangeWhenTooMuchMoneyInMachine() {
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");

        assertEquals("25", machine.refundUser(VendingMachine.getColaPrice()));
    }

    @Test
    public void returnCoinsWhenReturnIsPressed() {
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");

        assertEquals("INSERT COIN", machine.coinReturnPressed());
    }

}
