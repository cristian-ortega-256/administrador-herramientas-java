package database;

public class ToolTypeDAO {

	public String GetOne(String IdToolType) {
		//TODO -> Changes this method and write like other ObjectDAO. This is wrong. 
		String query = "SELECT * FROM ToolTypes WHERE ID='" + IdToolType + "'";
		return query;
	}
	
}
