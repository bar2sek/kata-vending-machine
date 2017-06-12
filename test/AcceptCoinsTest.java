import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class AcceptCoinsTest {
    private VendingMachine machine;

    @Before
    public void setUp() {
        machine = new VendingMachine();
    }

    @Test
    public void machineAcceptsAnyCoinWhenInserted() {

        assertEquals("dime", machine.getCoinsInserted("dime"));
    }

    @Test
    public void machineAcceptsNickelWhenInserted() {

        assertEquals("nickel", machine.getCoinsInserted("nickel"));
    }

    @Test
    public void machineAbleToIdentifyBadCoinsInserted() {

        String coinInserted = "asdfasfasdf";

        assertEquals("INSERT COIN\n", machine.acceptValidCoins(coinInserted));
    }

    @Test
    public void machineAbleToIdentifyGoodCoinsInserted() {

        String coinInserted = "dime";

        assertEquals("10", machine.acceptValidCoins(coinInserted));
    }

    @Test
    public void machineAbleToIdentifyAQuarterInserted() {

        String coinInserted = "quarter";

        assertEquals("25", machine.acceptValidCoins(coinInserted));
    }

//    @Test
//    public void machineReturnsBadCoinsToCoinReturn() {
//
//    }

//    @Test
//    public void creditOneCoinInserted() {
//
//        String coinInserted = "dime";
//
//        assertEquals(10, machine.acceptValidCoins(coinInserted));
//    }

//    @Test
//    public void creditMultipleCoinsInserted() {
//
//    }
//
//    @Test
//    public void invalidCoinsPlacedInCoinReturn() {
//
//    }

}
