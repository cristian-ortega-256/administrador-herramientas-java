import controller.Controller;
import view.View;
import model.Model;

public class App {
	public static void main(String[] args) {
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller(view, model);
		controller.initialize();
	}
}
