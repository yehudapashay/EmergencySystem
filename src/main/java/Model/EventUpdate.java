package Model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventUpdate {
    public EventUpdate(EventUpdate _PreviousUpdate, User _User, Date _Date, String _Content) {
        this._PreviousUpdate = _PreviousUpdate;
        this._User = _User;
        this._UpdatesVersions = new LinkedList();
        this._Date = _Date;
        this._Content = _Content;
    }

    private EventUpdate _PreviousUpdate;

    //private EventUpdate _NextUpdate;

    private User _User;

    private List<Version > _UpdatesVersions ;

    private Date _Date ;

    private String _Content;

}
