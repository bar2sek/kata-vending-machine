import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SoldOutTest {
    private VendingMachine machine;

    @Before
    public void setUp() {
        machine = new VendingMachine();
    }

    @Test
    public void checkStockOfChips() {
        machine.setCandyStock(5);

        assertEquals("5", machine.checkStock(machine.getCandyStock()));
    }

    @Test
    public void displaySoldOutIfNoMoreOfAnyOneItem() {
        machine.setCandyStock(0);

        assertEquals("SOLD OUT", machine.checkStock(machine.getCandyStock()));
    }

    @Test
    public void findNumberOfQuartersInMachine() {
        machine.setQuartersInMachine(5);

        assertEquals(5, machine.getQuartersInMachine());
    }

    @Test
    public void findNumberOfNickelsInMachine() {
        machine.setDimesInMachine(10);


        assertEquals(10, machine.getDimesInMachine());
    }

    @Test
    public void findNumberOfDimesInMachine() {
        machine.setNickelsInMachine(15);


        assertEquals(15, machine.getNickelsInMachine());
    }

    @Test
    public void attemptToMakeChangeWithNoCoinsInMachine() {
        machine.setCredit(0);

        machine.setQuartersInMachine(0);
        machine.setDimesInMachine(0);
        machine.setNickelsInMachine(0);

        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");

        machine.dispenseProduct(VendingMachine.getCandyPrice());

        assertEquals("EXACT CHANGE ONLY", machine.returnChange());
    }

    @Test
    public void makeCorrectChangeWithOnlyOneNickelInMachine() {
        machine.setCredit(0);

        machine.setQuartersInMachine(0);
        machine.setDimesInMachine(0);
        machine.setNickelsInMachine(1);

        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("quarter");
        machine.acceptValidCoins("dime");
        machine.acceptValidCoins("dime");

        machine.dispenseProduct(VendingMachine.getCandyPrice());

        assertEquals("1 nickel", machine.returnChange());
    }
}
