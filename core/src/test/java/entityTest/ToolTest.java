package entityTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Entities.Tool;
import Entities.ToolType;

public class ToolTest {

	private Tool tool;
	private ToolType tt;
	
	@Before
	public void prepareDependencies() {
		this.tt = new ToolType("Martillo");
		this.tool = new Tool("Martillo - 03", tt);
		this.tool.setId(0);
	}
	
	@Test
	public void testToolToString() {
		assertEquals(tool.toString(), "Martillo - 03");
	}
	
	@Test
	public void equalsTest() {
		Tool tool2 = new Tool("Martillo - 04", tt);
		tool2.setId(1);
		assertTrue(tool.equals(tool));
		assertFalse(tool.equals(tool2));
	}
	
}
