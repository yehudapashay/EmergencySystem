package Model;

public class Complaint {

    private User _UserGetComplaint;
    private User _UserGivesComplaint;
    private String _Content;
    private Admin _AdminConfirmedCommand;

    public Complaint(User _UserGetComplaint, User _UserGivesComplaint, String _Content, Admin _AdminConfirmedCommand) {
        this._UserGetComplaint = _UserGetComplaint;
        this._UserGivesComplaint = _UserGivesComplaint;
        this._Content = _Content;
        this._AdminConfirmedCommand = _AdminConfirmedCommand;
    }


    public User getUserGetComplaint() {
        return _UserGetComplaint;
    }

    public User getUserGivesComplaint() {
        return _UserGivesComplaint;
    }

    public String getContent() {
        return _Content;
    }
}
