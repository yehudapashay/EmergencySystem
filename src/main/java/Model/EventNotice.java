package Model;

public class EventNotice {

    private UserController _UserCtrl ;
    private User _UserGivesNotice;
    private EmergencyUser _responsible;

    public EventNotice(UserController _UserCtrl, User _UserGivesNotice, EmergencyUser _responsible) {
        this._UserCtrl = _UserCtrl;
        this._UserGivesNotice = _UserGivesNotice;
        this._responsible = _responsible;
    }

    public UserController get_UserCtrl() {
        return _UserCtrl;
    }

    public User get_UserGivesNotice() {
        return _UserGivesNotice;
    }

    public EmergencyUser get_responsible() {
        return _responsible;
    }
}
