package View;

import Model.Model;
import Model.Event;
import Model.EventUpdate;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;

public class UpdatesController extends ViewController {

    public TableView updatesTable;
    public TableColumn publishedByColumn;
    public TableColumn dateColumn;
    public TableColumn eventColumn;
    public TableColumn updateColumn;
    public ComboBox EventComboBox;
    public TextArea updateText;

    public void createUpdate() {
        String update = updateText.getText();
        if (update.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Empty Update");
            alert.show();
        }
        String event = "";
        if (EventComboBox.getValue() != null)
            event = EventComboBox.getValue().toString();
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No chosen event");
            alert.show();
        }

        if (!Model.publishUpdate(View.currentUser.get_name(), event, (new Date()).toString(), update)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Failed To add Update");
            alert.show();
            return;
        }
        clearTable(updatesTable);
        initTable();
    }

    public void clearTable(TableView table) {
        for (int i = 0; i < table.getItems().size(); i++) {
            table.getItems().clear();
        }
    }


    private void initTable() {
        List<EventUpdate> eventUpdates = Model.getAllUpdates();

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("_Date"));
        publishedByColumn.setCellValueFactory(new PropertyValueFactory<>("_User"));
        eventColumn.setCellValueFactory(new PropertyValueFactory<>("_Event"));
        updateColumn.setCellValueFactory(new PropertyValueFactory<>("_Content"));

        for (EventUpdate eventUpdate :
                eventUpdates) {
            TableUpdate tableUpdate;

            tableUpdate = new TableUpdate(eventUpdate);
            updatesTable.getItems().add(tableUpdate);

        }
    }



    @Override
    public void init() {
        initTable();
        List<Event> events = Model.getAllEvents();
        for (Event event :
                events) {
            if(event.checkUserExists(View.currentUser))
                EventComboBox.getItems().add(event.get_Title());
        }
        //initTable();

    }

}
