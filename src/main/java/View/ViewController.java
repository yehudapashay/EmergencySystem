package View;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public abstract class ViewController {

    @FXML
    private javafx.scene.control.Button BackButton;

    public void backHome() {
        Stage stage = (Stage) BackButton.getScene().getWindow();
        stage.close();
    }

    public void init() {

    }
}
