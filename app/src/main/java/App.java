import controller.LoanController;
import controller.RetreatController;
import model.LoanFormViewModel;
import model.RetreatFormViewModel;
import model.SupplySystem;
import model.ToolSystem;
import model.BorrowerSystem;
import view.RetreatView;
import view.View;

public class App {
	public static void main(String[] args) {
		View view = new View();
		RetreatView rView = new RetreatView();
		
		ToolSystem ts = new ToolSystem();
		BorrowerSystem ws = new BorrowerSystem();
		SupplySystem ss = new SupplySystem();
		
		LoanFormViewModel vm = new LoanFormViewModel();
		vm.setAllBorrowers(ws.getBorrowers());
		vm.setAllTools(ts.getAllTools());
		
		RetreatFormViewModel rvm = new RetreatFormViewModel();
		rvm.setAllBorrowers(ws.getBorrowers());
		rvm.setAllSupplies(ss.getAllSupplies());
		
		LoanController controller = new LoanController(view,vm);
		controller.initialize();
		
		RetreatController rController = new RetreatController(rView, rvm, controller.getAdapterUI());
		rController.initialize();
	}
}