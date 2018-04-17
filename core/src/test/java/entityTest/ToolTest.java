package entityTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Entities.Tool;
import Entities.ToolType;

public class ToolTest {

	@Test
	public void testToolToString() {
		Tool tool = new Tool("Martillo - 03", ToolType.Martillo);
		assertEquals(tool.toString(), "Martillo - 03");
	}
	
}
