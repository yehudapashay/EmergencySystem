package Model;

public class Feedback {

    public Feedback(int _Rating, User _UserGivesFeedback, User _UserRecivesFeedback,
                    Event _Event, AdminController _AdminCtrl) {
        this._Rating = _Rating;
        this._UserGivesFeedback = _UserGivesFeedback;
        this._UserRecivesFeedback = _UserRecivesFeedback;
        this._Event = _Event;
        this._AdminCtrl = _AdminCtrl;
        _FeedbackID =0;////
    }

    /////////////////////////// static ont feedbackid
    private int _FeedbackID;

    private int _Rating;

    private User _UserGivesFeedback ;

    private User _UserRecivesFeedback ;

    private Event _Event;

    private AdminController _AdminCtrl;

    public void getUserGrades(){}

    public void addGradeToUser(){}

    public void updateFeedback(){}
}
