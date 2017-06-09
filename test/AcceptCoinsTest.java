import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class AcceptCoinsTest {
    private VendingMachine machine;

    @Before
    public void setUp() throws Exception {
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


}
