package View;

import Model.EventUpdate;

public class TableUpdate {
    private String _Date;
    private String _Content;
    private String _Event;
    private String _User;

    public TableUpdate(EventUpdate eventUpdate) {
        _Date = eventUpdate.get_Date();
        _Content = eventUpdate.get_Content();
        _Event = eventUpdate.get_Event().get_Title();
        _User = eventUpdate.get_User().get_name();
    }

    public String get_Date() {
        return _Date;
    }

    public void set_Date(String _Date) {
        this._Date = _Date;
    }

    public String get_Content() {
        return _Content;
    }

    public void set_Content(String _Content) {
        this._Content = _Content;
    }

    public String get_Event() {
        return _Event;
    }

    public void set_Event(String _Event) {
        this._Event = _Event;
    }

    public String get_User() {
        return _User;
    }
}
