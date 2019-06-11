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

    public Representitive findRepresentitiveByName(String name) {
        for (User obj : _Users) {
            if ((obj instanceof Representitive) && (obj.get_name().equals(name))) {
                return (Representitive) obj;
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
