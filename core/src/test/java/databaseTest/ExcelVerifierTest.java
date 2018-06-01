package databaseTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import com.codoid.products.exception.FilloException;

import Entities.ErrorType;
import database.ExcelVerifier;
import model.ErrorObserver;
import model.ErrorSystem;

public class ExcelVerifierTest {
	
	@Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	private ErrorSystem errorSystem;
	private ErrorObserver errorObserver;
	private ExcelVerifier excelVerifier;
	
	@Before
	public void prepareDependencies() {
		this.errorSystem = new ErrorSystem(false);
		this.excelVerifier = new ExcelVerifier();
		this.errorObserver = new ErrorObserver(this.errorSystem);
		this.excelVerifier.addObserver(errorObserver);
	}
	
	@Test
	public void  testExcelNotFound() {
		exit.expectSystemExit();
		 exit.checkAssertionAfterwards(new Assertion() {
	            @Override
	            public void checkAssertion() throws Exception {
	            	assertEquals(errorSystem.getErrors().size(), 1);
	            	assertEquals(errorSystem.getErrors().get(0).getErrorType(),ErrorType.MissingExcelFile);
	            }
	        });
		this.excelVerifier.verifyExcelFile("excel/Test_Missing_File.xlsx");
	}
	
	@Test
	public void  testExcelFound() {
		this.excelVerifier.verifyExcelFile("excel/Test.xlsx");
		assertEquals(this.errorSystem.getErrors().size(), 0);
	}
	
	@Test
	public void testMissingSheet() {
		this.excelVerifier.verifyExcelFile("excel/Test_Missing_Sheet.xlsx");
		exit.expectSystemExit();
		 exit.checkAssertionAfterwards(new Assertion() {
	            @Override
	            public void checkAssertion() throws Exception {
	            	assertEquals(errorSystem.getErrors().size(), 1);
	            	assertEquals(errorSystem.getErrors().get(0).getErrorType(),ErrorType.MissingExcelSheet);
	            }
	        });
		this.excelVerifier.verifyExcelSheets();
	}
	
	@Test
	public void testNoMissingSheet() {
		this.excelVerifier.verifyExcelFile("excel/Test.xlsx");
		this.excelVerifier.verifyExcelSheets();
		assertEquals(this.errorSystem.getErrors().size(), 0);
	}
	
	@Test
	public void testMissingColumns() throws FilloException {
		this.excelVerifier.verifyExcelFile("excel/Test_Missing_Column.xlsx");
		exit.expectSystemExit();
		 exit.checkAssertionAfterwards(new Assertion() {
	            @Override
	            public void checkAssertion() throws Exception {
	                assertEquals(errorSystem.getErrors().size(), 1);
	                assertEquals(errorSystem.getErrors().get(0).getErrorType(),ErrorType.MissingExcelColumn);
	            }
	        });
		this.excelVerifier.verifyAllSheetsColumns();
	}
	
	@Test
	public void testNoMissingColumns() throws FilloException {
		this.excelVerifier.verifyExcelFile("excel/Test.xlsx");
		this.excelVerifier.verifyAllSheetsColumns();
		assertEquals(this.errorSystem.getErrors().size(), 0);
	}
	
	@Test
	public void testExtraColumns() throws FilloException {
		this.excelVerifier.verifyExcelFile("excel/Test_Extra_Column.xlsx");
		this.excelVerifier.verifyAllSheetsColumns();
		assertEquals(2,errorSystem.getErrors().size());
		assertEquals(errorSystem.getErrors().get(0).getErrorType(),ErrorType.ExtraExcelColumn);
		assertEquals(errorSystem.getErrors().get(1).getErrorType(),ErrorType.ExtraExcelColumn);
	}
	
}
