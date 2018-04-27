package entityTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Entities.Tool;
import Entities.ToolType;

public class ToolTest {

	private Tool tool;
	
	@Before
	public void prepareDependencies() {
		this.tool = new Tool("Martillo - 03", ToolType.Martillo);
	}
	
	@Test
	public void testToolToString() {
		assertEquals(tool.toString(), "Martillo - 03");
	}
	
}
