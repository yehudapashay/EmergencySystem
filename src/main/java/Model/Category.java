package Model;

import java.util.LinkedList;
import java.util.List;

public class Category {

    private String _Description;

    private List<Event> _Events ;

    private UserController UserCtrl ;

    //private Representitive _Representitive ;

    public Category(String _Description,UserController userCtrl) {//, Representitive _Representitive) {
        this._Description = _Description;
        this._Events = new LinkedList();
        UserCtrl = userCtrl;
        //this._Representitive = _Representitive;
    }
}
