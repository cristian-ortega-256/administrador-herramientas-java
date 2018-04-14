import controller.LoanController;
import model.LoanFormViewModel;
import model.ToolSystem;
import model.BorrowerSystem;
import view.View;

public class App {
	public static void main(String[] args) {
		View view = new View();
		
		ToolSystem ts = new ToolSystem();
		BorrowerSystem ws = new BorrowerSystem();
		
		LoanFormViewModel vm = new LoanFormViewModel();
		vm.setAllBorrowers(ws.getBorrowers());
		vm.setAllTools(ts.getAllTools());
		
		LoanController controller = new LoanController(view,vm);
		controller.initialize();
	}
}