import org.junit.Test;

import static junit.framework.TestCase.*;

public class AcceptCoinsTest {
    @Test
    public void machineAcceptsOneCoinWhenInserted() {
        VendingMachine machine = new VendingMachine();

        assertEquals("dime", machine.getCoinsInserted("dime"));
    }
}
