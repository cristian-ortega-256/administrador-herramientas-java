import controller.Controller;
import model.LoanSystem;
import view.View;

public class App {
	public static void main(String[] args) {
		View view = new View(); 
		LoanSystem loanSystem = new LoanSystem();
		Controller controller = new Controller(view, loanSystem);
		controller.initialize();
	}
}