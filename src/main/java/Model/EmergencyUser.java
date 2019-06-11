package Model;

public class EmergencyUser extends  User {

    public EmergencyUser(UserController _UserCtrl, String _Organization, int _Rank , String name) {
        super(_UserCtrl, _Organization ,name);
        this._Rank = _Rank;
    }

    public void set_Rank(int _Rank) {
        this._Rank = _Rank;
    }

    private int _Rank;

    public void giveFeedback(){}

    public User noticeUser(){return null;}

    public Complaint createComplaint(){return null;}

    public Command createCommand(){return null;}

    public EventUpdate addUpdateToEvent(){return null;}

    @Override
    public void addFeedback() {

    }

    @Override
    public void getWarningNum() {

    }

    @Override
    public void demoteUser() {

    }
}
