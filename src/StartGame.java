import Contoller.Controller;
import View.UIControl;
import View.GameBoardView;


public class StartGame {

    public static void main(String[] args) {
            UIControl ui = new GameBoardView();
            Controller controller = new Controller();
            controller.setUiControl(ui);
            ui.setController(controller);
            ui.launchGame();
    }
}
