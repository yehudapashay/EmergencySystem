package Model;

public class Complaint {

    private User _UserGetComplaint;
    private User _UserGivesComplaint;
    private String _Content;

    public Complaint(User userGetComplaint, User userGivesComplaint, String content) {
        _UserGetComplaint = userGetComplaint;
        _UserGivesComplaint = userGivesComplaint;
        _Content = content;
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
