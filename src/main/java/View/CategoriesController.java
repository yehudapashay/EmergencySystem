package View;

import Model.RepresentitiveAdmin;
import Model.Model;
import Model.Category;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CategoriesController extends ViewController {
    public Button createCategoryButton;
    public TableColumn categoriesColumn;
    public ScrollBar scrollbar;
    public TextField categoryName;
    public TableView categoriesTable;

    public void createCategory() {
        if (categoryName.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Empty Category Name");
            alert.show();
            return;
        }
       if(!Model.createNewCategory(View.currentUser.get_name(), categoryName.getText())){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setContentText("CategoryAlreadyExists");
           alert.show();
           return;
       }
        this.clearTable();
        this.initTable();
    }

    public void clearTable() {
        for (int i = 0; i < categoriesTable.getItems().size(); i++) {
            categoriesTable.getItems().clear();
        }
    }

    private void initTable() {
        List<Category> categories = Model.getAllCategories();
        categoriesColumn.setCellValueFactory(new PropertyValueFactory<>("_Description"));
        for (Category category :
                categories) {
            categoriesTable.getItems().add(category);

        }
    }

    @Override
    public void init() {
        createCategoryButton.setDisable(true);
        if (View.currentUser instanceof RepresentitiveAdmin)
            createCategoryButton.setDisable(false);
        initTable();
    }


}
