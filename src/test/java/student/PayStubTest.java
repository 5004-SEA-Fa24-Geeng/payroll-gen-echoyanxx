package student;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PayStubTest {

    @Test
    public void testToCSV() {
        PayStub payStub = new PayStub("Echo", 1234.567, 200.345, 15000.125, 3000.50);

        String expectedCSV = "Echo,1234.57,200.35,15000.13,3000.5";

        assertEquals(expectedCSV, payStub.toCSV());
    }
}