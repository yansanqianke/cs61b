import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FlikTest {
    @Test
    public void testIsSameNumber(){
        assertTrue("127",Flik.isSameNumber(127, 127));
        assertTrue("128",Flik.isSameNumber(128, 128));
        assertTrue("129",Flik.isSameNumber(129, 129));
    }
}
