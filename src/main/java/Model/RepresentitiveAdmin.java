package Model;

import java.util.LinkedList;
import java.util.List;

public class RepresentitiveAdmin extends Admin {

    private List<Category> _Categories;

    public RepresentitiveAdmin(UserController _UserCtrl, String _Organization,
                               AdminController _AdminCtrl , String name) {
        super(_UserCtrl, _Organization, _AdminCtrl ,name);
        this._Categories = new LinkedList();
    }

    public void createCategory(){}
}
