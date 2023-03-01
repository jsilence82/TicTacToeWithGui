import Contoller.Controller;
import View.View;


public class StartGame {

    public static void main(String[] args) {
            View view = new View();
            Controller controller = new Controller();
            controller.setView(view);
            view.setController(controller);
    }
}
