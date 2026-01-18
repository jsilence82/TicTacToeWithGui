import Contoller.Controller;
import View.UIControl;
import View.View;


public class StartGame {

    public static void main(String[] args) {
            UIControl ui = new View();
            Controller controller = new Controller();
            controller.setUiControl(ui);
            ui.setController(controller);
            ui.launchGame();
    }
}
