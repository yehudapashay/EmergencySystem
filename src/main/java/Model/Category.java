package Model;

import java.util.LinkedList;
import java.util.List;

public class Category {

    private String _Description;

    private List<Event> _Events ;

    private UserController UserCtrl ;


    public Category(String _Description,UserController userCtrl) {
        this._Description = _Description;
        this._Events = new LinkedList();
        UserCtrl = userCtrl;
        //this._Representitive = _Representitive;
    }

    public String get_Description() {
        return _Description;
    }

    public void addEvent(Event _Event){
        _Events.add(_Event);
    }
}
