package database;

import java.util.Arrays;
import java.util.List;

public enum ExcelSheets {
	Tools("ID/Nombre/Tipo de herramienta"),
	Supplies("ID/Nombre/Stock/MinimumStock"),
	Borrowers("Nombre"),
	Loans("Numero/Herramienta/Trabajador/Fecha"),
	PrestamosLog("Numero/Elemento/Trabajador/Accion/Fecha"),
	RetirosLog("Elemento/Cantidad/Trabajador/Fecha"),
	TipoHerramienta("ID/Nombre");
	
	private String columns;

    ExcelSheets(String columns) {
        this.columns = columns;
    }

    public List<String> getColumns() {
        return Arrays.asList(columns.split("/"));
    }
}
