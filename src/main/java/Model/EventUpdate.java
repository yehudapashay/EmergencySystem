package Model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventUpdate {
    public EventUpdate(EventUpdate _PreviousUpdate, User _User, String _Date, String _Content ,Event _Event , int _UpdateNum, String _InitialContent) {
        this._PreviousUpdate = _PreviousUpdate;
        this._User = _User;
        this._UpdatesVersions = new LinkedList();
        this._Date = _Date;
        this._Content = _Content;
        this._Event =_Event;
        this._UpdateNum = _UpdateNum;
        this._InitialContent =_InitialContent;
    }


    private EventUpdate _PreviousUpdate;

    //private EventUpdate _NextUpdate;

    private User _User;

    private List<Version > _UpdatesVersions ;

    private String _Date ;

    private String _Content;

    private String _InitialContent;

    private Event _Event;

    private int _UpdateNum;

    public Event get_Event() {
        return _Event;
    }

    public EventUpdate get_PreviousUpdate() {
        return _PreviousUpdate;
    }

    public User get_User() {
        return _User;
    }

    public String get_Date() {
        return _Date;
    }

    public String get_Content() {
        return _Content;
    }

    public String get_InitialContent() {
        return _InitialContent;
    }

    public int get_UpdateNum() {
        return _UpdateNum;
    }

}
