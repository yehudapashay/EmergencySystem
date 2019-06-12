package View;

import Model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This class is main class for running of the application
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Model model = new Model();//model.createNewDatabase("v4uDB");
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane root = fxmlLoader.load(getClass().getClassLoader().getResource("EmergencyMainView.fxml").openStream());
        View view = (View)fxmlLoader.getController();
        view.setController(model);
        primaryStage.setTitle("Welcome To Emergency System!");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
