package View;

import Model.Model;
import Model.User;
import Model.Admin;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

//import Model.RegisteredUser;

/**
 * View class is managing the windows of the crud gui
 */

public class View {
    /**
     * fields of View
     */

    public static Model model;
    public static User currentUser;
    public javafx.scene.control.TextField userName;
    //    public javafx.scene.control.TextField userPassword;
    public javafx.scene.control.Button ExitButton;
    public Button categoriesButton;
    public Button commandsButton;
    public Button updatesButton;
    public Button logoutButton;

    /**
     * Setting the view's controller. implement mvc paradigm
     *
     * @param _model mvc's controller
     */
    public void setController(Model _model) {
        model = _model;
    }

    /**
     * check whether the user's details are correct
     */
    public void login() {
        User user = Model.login(userName.getText());
        if (user != null) {
            currentUser = user;
            logoutButton.setDisable(true);
            if (user instanceof Admin){
                categoriesButton.setDisable(false);
                updatesButton.setDisable(false);
            }
            else {
                commandsButton.setDisable(false);
                updatesButton.setDisable(false);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid User Name");
        }
    }

    /**
     * Opens mainWindow when the user press back button
     */
//    public void backHome() {
//        Stage stage = (Stage) BackButton.getScene().getWindow();
//        stage.close();
//    }
    private void openWindow(String fxmlPath, String title) {
        Stage stage = new Stage();
        stage.setResizable(true);
        stage.setTitle(title);
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlPath));
//            root.getStylesheets().add(getClass().getClassLoader().getResource("flightCSS.css").toExternalForm());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (Exception e) {
            e.getCause().printStackTrace();
        }
    }

    public void openCategories() {
        this.openWindow("EmergencyCategories.fxml", "Categories Management");
    }

    public void openCommands() {
        this.openWindow("EmergencyCommands.fxml", "Commands Management");
    }

    public void openUpdates() {
        this.openWindow("EmergencyUpdates.fxml", "Updates Management");
    }

    public void logout(){
        currentUser=null;
        categoriesButton.setDisable(true);
        commandsButton.setDisable(true);
        updatesButton.setDisable(true);
        logoutButton.setDisable(true);

    }

    /**
     * Exit the system
     */
    public void exitSystem() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure you want to exit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Stage stage = (Stage) ExitButton.getScene().getWindow();
            stage.close();
        }
    }


}
