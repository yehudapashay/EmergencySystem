package Model;

import java.util.LinkedList;
import java.util.List;

public class UserController {
    public UserController() {
        this._ActionLogger = new ActionLogger();
        this._ErrorLogger = new ErrorLogger();
        this._EventsNotice = new LinkedList();
        this._Events = new LinkedList();
        this._Users = new LinkedList();
        this._Categories = new LinkedList();
        this._Commands = new LinkedList();
    }

    public User findUserByName(String name) {
        for (User obj : _Users) {
            if (obj.get_name().equals(name)) {
                return obj;
            }
        }
        return null;
    }

    public int findUserByRankName(String name) {
        for (User obj : _Users) {
            if (obj.get_name().equals(name) ) {
                if (obj instanceof EmergencyUser){
                    return ((EmergencyUser) obj).get_Rank();
                }
                else if(obj instanceof Representitive){
                    return ((Representitive) obj).get_Rank();
                }
                else{
                   return -1;
                }

            }
        }
        return -1;
    }

    /*

    public Representitive findRepresentitiveByName(String name) {
        for (User obj : _Users) {
            if ((obj instanceof Representitive) && (obj.get_name().equals(name))) {
                return (Representitive) obj;
            }
        }
        return null;
    }

    */

    public Event findEventByTitle(String name) {
        for (Event obj : _Events) {
            if (obj.get_Title().equals(name)){
                return obj;
            }
        }
        return null;
    }

    public Category findCategoryByDescription(String _Description) {
        for (Category obj : _Categories) {
            if (obj.get_Description().equals(_Description)){
                return obj;
            }
        }
        return null;
    }

    private ActionLogger _ActionLogger;

    public ErrorLogger _ErrorLogger;

    private List<EventNotice> _EventsNotice;

    private List<Event> _Events;

    private List<User> _Users;

    private List<Category> _Categories;

    private List<Command> _Commands;

    public void addUser(User _User) {
        _Users.add(_User);
    }

    public void addEvent(Event _Event) {
        _Events.add(_Event);
        findUserByName(_Event.get_Representitive().get_name()).addEvent(_Event);
    }

    //////////////////////////////////////////////////////////
    public void addEventToUser(String _UserName , String _Title) {
        findEventByTitle(_Title).addUser(findUserByName(_UserName));
    }

    public void addUserToEvent(String _UserName , String _Title) {
        findUserByName(_UserName).addEvent(findEventByTitle(_Title));
    }
    ////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////
    public void addEventToCategory(String _EventTitle , String _Description) {
        findCategoryByDescription(_Description).addEvent(findEventByTitle(_EventTitle));
    }

    public void addCategoryToEvent(String _EventTitle , String _Description) {
        findEventByTitle(_EventTitle).addCategory(findCategoryByDescription(_Description));
    }
    ////////////////////////////////////////////////////////////////

    public void removeUser(User _User) {
        _Users.remove(_User);
    }

    public void addCommand(Command _Command) {
        _Commands.add(_Command);
        findUserByName(_Command.getUserGetCommand().get_name()).addReceivedCommand(_Command);
        findUserByName(_Command.getUserGetCommand().get_name()).addCommand(_Command);
    }

    public void addCategory(Category _Category) {
        _Categories.add(_Category);
    }


    public void createNewEvent() {
    }

    public void addComplaint() {
    }

    public void addCommand() {
    }

    public void createNewUpdate() {
    }

    public void fillFeedback() {
    }

    public void getUsers() {
    }
}
