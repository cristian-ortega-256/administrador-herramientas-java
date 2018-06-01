package databaseTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Entities.Tool;
import Entities.ToolType;
import database.ToolDAO;

public class ToolDAOTest {
	
	private ToolDAO tDao;
	private Tool tool;
	private List<Tool> lTool;
	private List<Tool> lToolDAO;
	private ToolType tt;
	
	@Before
	public void prepareDependencies() {
		try {
			this.tDao = new ToolDAO();
			this.lToolDAO = tDao.GetAll();
			this.tt = new ToolType("Martillos");
			this.lTool = new ArrayList<Tool>();
			this.lTool.add(new Tool(1,"Taladro #1", this.tt));
			this.lTool.add(new Tool(7,"Martillo #1", this.tt));
			this.lTool.add(new Tool(4,"Destornillador #1", this.tt));
			this.lTool.add(new Tool(2,"Taladro #2", this.tt));
			this.lTool.add(new Tool(3,"Destornillador #2", this.tt));
			this.tool = tDao.GetOne("1");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testGetAll() {
		assertEquals(this.lToolDAO.size(), this.lTool.size());
	}
	
	@Test
	public void testGetOne() {
		assertEquals(this.lTool.get(0).getName(), this.tool.getName());
	}

}
