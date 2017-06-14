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

        assertEquals(5, machine.quantityOfQuarters());
    }

//    @Test
//    public void findNumberOfNickelsInMachine() {
//
//        assertEquals("SOLD OUT", machine.checkStock(machine.getCandyStock()));
//    }
//
//    @Test
//    public void findNumberOfDimesInMachine() {
//
//        assertEquals("SOLD OUT", machine.checkStock(machine.getCandyStock()));
//    }

}
