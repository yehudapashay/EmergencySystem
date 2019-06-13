package View;

import Model.Admin;
import Model.Command;
import Model.User;
import Model.Model;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class CommandsController extends ViewController {
    public TextArea command;
    public TableColumn recipientColumnS;
    public TableColumn commandColumnS;
    public ComboBox recipientChoose;
    public ComboBox defaultCommand;
    public CheckBox defaultCheck;
    public TableView commandsReceivedTable;
    public TableView commandsSentTable;
    public TableColumn commandColumnR;
    public TableColumn senderColumnR;
    public Button sendCommand;

    public void clearTable(TableView table) {
        for (int i = 0; i < table.getItems().size(); i++) {
            table.getItems().clear();
        }
    }

    public void sendCommand() {
        String content = "";
        if (defaultCheck.isSelected() && !defaultCommand.getValue().toString().equals(null)) {
            content = defaultCommand.getValue().toString();
        } else if (!command.getText().equals("")) {
            content = command.getText();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Empty Command");
            alert.show();
            return;
        }
        String recipient = " ";
        if (recipientChoose.getValue() != null)
            recipient = recipientChoose.getValue().toString();
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No chosen recipient");
            alert.show();
        }

        if (!Model.addCommand(View.currentUser.get_name(), recipient, content)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Failed To add Command");
            alert.show();
            return;
        }
        clearTable(commandsSentTable);
        initSentTable();

    }

    private void initRecievedTable() {
        List<Command> commands = Model.getAllCommandsRecieved(View.currentUser.get_name());
        commandColumnR.setCellValueFactory(new PropertyValueFactory<>("_Content"));
        senderColumnR.setCellValueFactory(new PropertyValueFactory<>("_UserGivesCommand"));

        for (Command command :
                commands) {
            TableCommand tableCommand = new TableCommand(command);
            commandsReceivedTable.getItems().add(tableCommand);
        }
    }

    private void initSentTable() {
        List<Command> commands = Model.getAllCommandsSent(View.currentUser.get_name());
        commandColumnS.setCellValueFactory(new PropertyValueFactory<>("_Content"));
        recipientColumnS.setCellValueFactory(new PropertyValueFactory<>("_UserGetCommand"));

        for (Command command :
                commands) {
            TableCommand tableCommand = new TableCommand(command);
            commandsSentTable.getItems().add(tableCommand);
        }
    }

    @Override
    public void init() {
        if (View.currentUser instanceof Admin)
            sendCommand.setDisable(false);
        initRecievedTable();
        initSentTable();
        List<String> userNames = Model.getAllUsersForCommand(View.currentUser);
        defaultCommand.getItems().add("Back to station");
        defaultCommand.getItems().add("Back up");
        defaultCommand.getItems().add("Update about current Event");

        if (userNames==null) {
            return;
        }
        for (String userName :
                userNames) {
            recipientChoose.getItems().add(userName);
        }

    }


}
