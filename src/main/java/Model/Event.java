package Model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Event {

    public Event(String _Title, String _Status,
                 UserController _UserCtrl, User _Representitive) {
        this._Title = _Title;
        this._PublishTime = new Date();
        this._Status = _Status;
        this._UserCtrl = _UserCtrl;
        this._Representitive = _Representitive;
        this._Categories = new LinkedList();
        this._Users = new LinkedList();
    }

    private List<User> _Users;

    private String _Title;

    private Date _PublishTime ;

    private String _Status ;

    private UserController _UserCtrl ;

    private User _Representitive ;

    private List<Category> _Categories ;

    public Event createEvent(){return null;}

    public EventNotice createEventNotice(){return null;}

    public void updateEvent(){};

    public void createFedbacks(){};

    public EventUpdate addEventUpdate(){ return null;}

    public void addUser(User _User){
        if (!_Users.contains(_User)){
            _Users.add(_User);
        }
    }

    public void addCategory(Category _Category){
        if (!_Categories.contains(_Category)){
            _Categories.add(_Category);
        }
    }

    public User get_Representitive() {
        return _Representitive;
    }

    public String get_Title() {
        return _Title;
    }





}
