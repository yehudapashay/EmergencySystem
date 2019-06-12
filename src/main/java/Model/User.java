package Model;

import java.util.LinkedList;
import java.util.List;

public abstract class User {


    public User(UserController _UserCtrl, String _Organization , String name) {
        this._ReceivedCommands = new LinkedList();
        this._Commands  = new LinkedList();
        this._ReceivedComplaint = new LinkedList();
        this._Complaints = new LinkedList();
        this._Warnings = new LinkedList();
        this._UserCtrl = _UserCtrl;
        this._EventNotice = new LinkedList();
        this._EventUpdate = new LinkedList();
        OrganizationFactory _0F = new OrganizationFactory();
        this._Organization = _0F.getOrganization(_Organization);
        this._Reports  = new LinkedList();
        this._Feedbacks = new LinkedList();
        this._name =name;

        this._Events = new LinkedList();
    }

    public List<Command> get_ReceivedCommands() {
        return _ReceivedCommands;
    }

    public List<Command> get_Commands() {
        return _Commands;
    }
    /*
    public boolean equals(Object obj) {
        if (!(obj instanceof User)) {
            return false;
        }
        return ((User)obj).get_name().equals(this.get_name());
    }
*/

    public String get_name() {
        return _name;
    }

    public void addReceivedCommand(Command _Command){
        if (!_ReceivedCommands.contains(_Command)){
            _ReceivedCommands.add(_Command);
        }
    }

    public void addCommand(Command _Command){
        if (!_Commands.contains(_Command)){
            _Commands.add(_Command);
        }
    }

    public void addEvent(Event _Event){
        if (!_Events.contains(_Event)){
            _Events.add(_Event);
        }
    }

    protected String _name;

    protected List <Command> _ReceivedCommands ; //= new LinkedList();

    protected List <Command> _Commands ;

    protected List <Complaint> _ReceivedComplaint ; //= new LinkedList();

    protected List <Complaint> _Complaints ;

    protected List <Warning>  _Warnings ;

    protected UserController _UserCtrl ;

    protected List <EventNotice> _EventNotice ;

    protected List <EventUpdate> _EventUpdate ;

    protected Organization _Organization ;

    protected List <Report> _Reports ;

    protected List <Feedback> _Feedbacks ;

    protected List <Event> _Events ;

    public Organization get_Organization() {
        return _Organization;
    }

    public abstract void addFeedback();

    public abstract void getWarningNum();

    public abstract void demoteUser();

}
