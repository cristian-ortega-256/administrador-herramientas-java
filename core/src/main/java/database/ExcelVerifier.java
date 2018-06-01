package database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

import com.codoid.products.exception.FilloException;

import Entities.Alarm;
import Entities.ErrorNotification;
import Entities.ErrorType;

public class ExcelVerifier extends Observable{
	
	private ExcelDB excelDB;
	private final String title = "Error de integridad del excel";
	private String path;
	
	public void verifyExcelFile(String path) {
		try {
			this.excelDB = new ExcelDB(path);
			this.path = path;
		}
		catch(FilloException e) {
			this.generateError(this.title, "No se ha encontrado el excel Tesx.xlsx\nPor favor verifique el archivo.", ErrorType.MissingExcelFile,1);
		}
	}
	
	public void verifyExcelSheets() {
		ArrayList<String> excelSheets = excelDB.getExcelSheetNames();
		List<ExcelSheets> expectedSheets = Arrays.asList(ExcelSheets.values());
		for(ExcelSheets sheet:expectedSheets) {
			if(excelSheets.indexOf(sheet.name()) == -1)
				this.generateError(this.title,"La hoja " + sheet.name() + " no existe.",ErrorType.MissingExcelSheet,1);
		}
	}
	
	public void verifyAllSheetsColumns() throws FilloException {
		ArrayList<String> excelSheets = excelDB.getExcelSheetNames();
		for(String sheet:excelSheets) {
			this.verifySingleSheetColumns(sheet);
		}
	}
	
	public void verifySingleSheetColumns(String sheetName) throws FilloException {
		this.excelDB = new ExcelDB(this.path);
		ArrayList<String> readedSheetColumns = this.excelDB.getSheetColumns(sheetName);
		List<String> sheetColumns = ExcelSheets.valueOf(sheetName).getColumns();
		this.generateColumnError(readedSheetColumns,sheetColumns, sheetName);
	}

	private void generateColumnError(ArrayList<String> readedSheetColumns, List<String> sheetColumns, String sheetName) {
		for(String column:sheetColumns) {
			if(readedSheetColumns.indexOf(column) == -1)
				this.generateError(this.title, generateSingleColumnMsg(column,"no se ha encontrado, por favor verifique los datos de la hoja " + sheetName), ErrorType.MissingExcelColumn,1);
			else
				readedSheetColumns.remove(readedSheetColumns.indexOf(column));
		}
		if(readedSheetColumns.size() > 1)
			this.generateError(this.title, generateMultipleColumnsMsg(readedSheetColumns) + sheetName, ErrorType.ExtraExcelColumn,2);
		else if(readedSheetColumns.size() == 1){
			this.generateError(this.title, generateSingleColumnMsg(readedSheetColumns.get(0),"no forma parte de la hoja " + sheetName), ErrorType.ExtraExcelColumn,2);
		}
	}

	private String generateMultipleColumnsMsg(ArrayList<String> readedSheetColumns) {
		String msg = "Las columnas [ ";
		for(String c:readedSheetColumns) {
			msg += c + " / ";
		}
		msg = msg.substring(0, msg.length() - 2);
		return msg += "] no forman parte de la hoja ";
	}

	private String generateSingleColumnMsg(String column, String endMsg) {
		return "La columna \"" + column + "\" " + endMsg;
	}
	
	private void generateError(String title, String msg, ErrorType type, int errorLevel) {
		ErrorNotification error = new ErrorNotification(title,msg,type,errorLevel);
		notifyAllObservers(error);
	}

	private void notifyAllObservers(ErrorNotification error) {
		setChanged();
        notifyObservers(error);
	}

}
