package entityTest;

import org.junit.Test;

import Entities.Borrower;

import static org.junit.Assert.*;

public class BorrowerTest {
    @Test 
    public void testConstructor() {
        Borrower borrower =  new Borrower("Goku");
        assertEquals(borrower.getName(), "Goku");
    }
    
    @Test 
    public void testBorrowerToString() {
        Borrower borrower =  new Borrower("Goku");
        assertEquals(borrower.toString(), "Goku");
    }
}