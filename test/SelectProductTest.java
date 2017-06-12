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

        assertEquals("THANK YOU", machine.dispenseProduct(VendingMachine.getCANDY()));
    }

    @Test
    public void machineDispensesCandyWithIncorrectCredit() {
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("dime");
        machine.acceptValidCoins("nickel");

        assertEquals("65", machine.dispenseProduct(VendingMachine.getCANDY()));
    }

    @Test
    public void machineDispensesSodaWithCorrectCredit() {
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("dime");
        machine.acceptValidCoins("dime");
        machine.acceptValidCoins("nickel");

        assertEquals("THANK YOU", machine.dispenseProduct(VendingMachine.getCOLA()));
    }


}
