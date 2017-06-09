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
    public void machineAbleToRejectBadCoinsInserted() {

        String coinInserted = "asdfasfasdf";

        assertEquals("coin not valid", machine.acceptValidCoins(coinInserted));
    }

}
