package entityTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Entities.ToolType;

public class ToolTypeTest {

	private ToolType tt;
	
	@Before
	public void prepareDependencies() {
		this.tt = new ToolType("");
		this.tt.setName("Martillos");
	}
	
	@Test
	public void testGetName() {
		assertEquals("Martillos", this.tt.getName());
	}
	
}
