package entityTest;

import org.junit.Test;

import Entities.Borrower;

import static org.junit.Assert.*;

import org.junit.Before;

public class BorrowerTest {
	
	private Borrower borrower;
	
	@Before
	public void prepareDependencies() {
		this.borrower =  new Borrower("Goku");
	}
	
    @Test 
    public void testConstructor() {
        assertEquals(borrower.getName(), "Goku");
    }
    
    @Test 
    public void testBorrowerToString() {
        assertEquals(borrower.toString(), "Goku");
    }
}