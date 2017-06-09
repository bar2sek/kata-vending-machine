import org.junit.Test;

import static junit.framework.TestCase.*;

public class AcceptCoinsTest {
    @Test
    public void machineAcceptsAnyCoinWhenInserted() {
        VendingMachine machine = new VendingMachine();

        assertEquals("dime", machine.getCoinsInserted("dime"));
    }

    @Test
    public void machineAcceptsNickelWhenInserted() {
        VendingMachine machine = new VendingMachine();

        assertEquals("nickel", machine.getCoinsInserted("nickel"));
    }
}
