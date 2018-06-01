package database;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import Entities.Borrower;
import Entities.Retreat;
import Entities.Supply;

public class RetreatLogDAO {
	
	public void Add(Retreat retreat) throws FilloException {
		String query = "INSERT INTO RetirosLog(Elemento, Cantidad, Trabajador, Fecha) VALUES ('"+ retreat.getSupply().getName() + "',"
																							+ "'"+ retreat.getQuantity() +"',"
																									+ "'"+ retreat.getBorrower().getName() +"',"
																											+ "'"+ retreat.getDate() +"')"; 
		ExcelDB db = new ExcelDB();
		db.Write(query);
	}
	
	public List<Retreat> GetAll() throws FilloException {
		String query = "SELECT * FROM RetirosLog";
		ExcelDB db = new ExcelDB();
		return parseRetreatsLog(db.Read(query));
	}
	
	public List<Retreat> parseRetreatsLog(Recordset rs) throws FilloException{
		try {
		List<Retreat> retreats = new ArrayList<Retreat>();
		while(rs != null & rs.next()) {
			HashMap<String,String> dataSet = this.generateDataHash(rs);
			if(this.isValidSet(dataSet))
				retreats.add(this.generateRetreat(dataSet));
		}
		rs.close();
		return retreats;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private HashMap<String,String> generateDataHash(Recordset rs) throws FilloException {
		HashMap<String,String> data = new HashMap<String,String>();
		for(String column:rs.getFieldNames()) {
			data.put(column,rs.getField(column));
		}
		return data;
	}
	
	private boolean isValidSet(HashMap<String, String> dataSet) {
		Iterator it = dataSet.entrySet().iterator();
		while(it.hasNext()) {
			if(it.next().equals(""))
				return false;
		}
		return true;
	}
	
	private Retreat generateRetreat(HashMap<String, String> dataSet) throws FilloException, ParseException {
		BorrowerDAO bDao = new BorrowerDAO();
		SupplyDAO sDao = new SupplyDAO();
		Supply supply = sDao.GetOne(dataSet.get("Elemento"));
		Borrower borrower = bDao.GetOne(dataSet.get("Trabajador"));
		int quantity = Integer.parseInt(dataSet.get("Cantidad"));
		Retreat retreat = new Retreat(0, borrower, supply, quantity);
		DateFormat df = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		retreat.setDate(df.parse(dataSet.get("Fecha")));
		return retreat;
	}
	

}
