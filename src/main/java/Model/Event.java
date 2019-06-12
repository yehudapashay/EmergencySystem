package Model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Event {

    public Event(String _Title, String _Status,
                 UserController _UserCtrl, User _Representitive , String _InitialDescription) {
        this._Title = _Title;
        this._PublishTime = new Date();
        this._Status = _Status;
        this._UserCtrl = _UserCtrl;
        this._Representitive = _Representitive;
        this._Categories = new LinkedList();
        this._Users = new LinkedList();
        this._UpdateCounter=0;
        this._EventUpdates = new LinkedList();
        this._InitialDescription = _InitialDescription;
    }

    private int _UpdateCounter ;

    private String _InitialDescription ;

    private List<User> _Users;

    private String _Title;

    private Date _PublishTime ;

    private String _Status ;

    private UserController _UserCtrl ;

    private User _Representitive ;

    private List<Category> _Categories ;

    private List<EventUpdate> _EventUpdates;

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

    public void addEventUpdate(EventUpdate _EventUpdate){
        if (!_EventUpdates.contains(_EventUpdate)){
            _EventUpdates.add(_EventUpdate);
            _UpdateCounter++;     // ------------------------ should be here?
        }
    }

    public void addNewEventUpdate(EventUpdate _EventUpdate){
        if (!_EventUpdates.contains(_EventUpdate)){
            _EventUpdates.add(_EventUpdate);
        }
    }

    public User get_Representitive() {
        return _Representitive;
    }

    public String get_InitialDescription() {
        return _InitialDescription;
    }

    public String get_Title() {
        return _Title;
    }

    public boolean checkUserExists(User _User) {
        return _Users.contains(_User);
    }

    public EventUpdate getLastUpdate(){
        return _EventUpdates.get(_EventUpdates.size()-1);
    }

    public int getAndIcreseCounter(){
        return this._UpdateCounter++;
    }

    public List<EventUpdate> get_EventUpdates() {
        return _EventUpdates;
    }





}
