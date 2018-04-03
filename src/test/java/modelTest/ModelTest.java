package modelTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Model;

public class ModelTest {

	@Test
	public void addValueTest() {
		String data = "foo";
		
		Model model = new Model();
		model.addValue(data);
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add(data);
		
		assertEquals(expected, model.getData());
		assertEquals(expected.size(), model.getData().size());
	}
}
