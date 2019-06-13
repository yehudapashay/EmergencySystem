package Model;

import java.util.LinkedList;
import java.util.List;

public class UserController {
    private static UserController obj;

    private UserController() {
        this._ActionLogger = new ActionLogger();
        this._ErrorLogger = new ErrorLogger();
        this._EventsNotice = new LinkedList();
        this._Events = new LinkedList();
        this._Users = new LinkedList();
        this._Categories = new LinkedList();
        this._Commands = new LinkedList();
        this._EventUpdates = new LinkedList();
    }


    public static UserController getInstance() {
        if (obj == null)
            obj = new UserController();
        return obj;
    }

    private ActionLogger _ActionLogger;

    public ErrorLogger _ErrorLogger;

    private List<EventNotice> _EventsNotice;

    private List<Event> _Events;

    private List<User> _Users;

    private List<Category> _Categories;

    private List<Command> _Commands;

    private List<EventUpdate> _EventUpdates;

    public List<Event> get_Events() {
        return _Events;
    }
    public List<Event> get_AllUserEvents() {
        return _Events;
    }

    public List<User> get_Users() {
        return _Users;
    }

    public List<EventUpdate> get_EventUpdates() {
        return _EventUpdates;
    }

    public List<Category> get_Categories() {
        return _Categories;
    }

    public List<EventUpdate> getEventUpdates(String eventTitle) {
        Event _Event = findEventByTitle(eventTitle);
        if (_Event != null) {
            return _Event.get_EventUpdates();
        }
        return null;
    }

    public List<Command> getAllCommandsSent(String _User) {
        User _current = findUserByName(_User);
        if (_current != null) {
            return _current.get_Commands();
        }
        return null;
    }

    public List<Command> getAllCommandsRecieved(String _User) {
        User _current = findUserByName(_User);
        if (_current != null) {
            return _current.get_ReceivedCommands();
        }
        return null;
    }


    public List<String> getAllUserNames() {
        List<String> users = new LinkedList();
        for (User obj : _Users) {
            users.add(obj.get_name());
        }
        return users;
    }

    public User findUserByName(String name) {
        for (User obj : _Users) {
            if (obj.get_name().equals(name)) {
                return obj;
            }
        }
        return null;
    }


    public RepresentitiveAdmin findRepresentitiveAdminByName(String name) {
        for (User obj : _Users) {
            if ((obj instanceof RepresentitiveAdmin) && (obj.get_name().equals(name))) {
                return (RepresentitiveAdmin) obj;
            }
        }
        return null;
    }

    public EmergencyUser findEmergencyUserByName(String name) {
        for (User obj : _Users) {
            if ((obj instanceof EmergencyUser) && (obj.get_name().equals(name))) {
                return (EmergencyUser) obj;
            }
        }
        return null;
    }


    public Event findEventByTitle(String name) {
        for (Event obj : _Events) {
            if (obj.get_Title().equals(name)) {
                return obj;
            }
        }
        return null;
    }

    public Category findCategoryByDescription(String _Description) {
        for (Category obj : _Categories) {
            if (obj.get_Description().equals(_Description)) {
                return obj;
            }
        }
        return null;
    }

    public EventUpdate findEventUpdate(String _EventTitle, int _UpdateNum) {
        for (EventUpdate obj : _EventUpdates) {
            if (obj.get_Event().get_Title().equals(_EventTitle) && obj.get_UpdateNum() == _UpdateNum) {
                return obj;
            }
        }
        return null;
    }


    public void addUser(User _User) {
        _Users.add(_User);
    }

    public void addEvent(Event _Event) {
        _Events.add(_Event);
        findUserByName(_Event.get_Representitive().get_name()).addEvent(_Event);
    }

    //////////////////////////////////////////////////////////
    public void addEventToUser(String _UserName, String _Title) {
        Event _Event = findEventByTitle(_Title);
        User _User = findUserByName(_UserName);
        if (_Event != null && _User != null) {
            _Event.addUser(_User);
        }
        //findEventByTitle(_Title).addUser(findUserByName(_UserName));
    }

    public void addUserToEvent(String _UserName, String _Title) {
        Event _Event = findEventByTitle(_Title);
        User _User = findUserByName(_UserName);
        if (_Event != null && _User != null) {
            _User.addEvent(_Event);
        }
        //findUserByName(_UserName).addEvent(findEventByTitle(_Title));
    }
    ////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////////////////
    public void addEventToCategory(String _EventTitle, String _Description) {
        Category _Category = findCategoryByDescription(_Description);
        Event _Event = findEventByTitle(_EventTitle);
        if (_Event != null && _Category != null) {
            _Category.addEvent(_Event);
        }
        //findCategoryByDescription(_Description).addEvent(findEventByTitle(_EventTitle));
    }

    public void addCategoryToEvent(String _EventTitle, String _Description) {
        Category _Category = findCategoryByDescription(_Description);
        Event _Event = findEventByTitle(_EventTitle);
        if (_Event != null && _Category != null) {
            _Event.addCategory(_Category);
        }
        //findEventByTitle(_EventTitle).addCategory(findCategoryByDescription(_Description));
    }
    ////////////////////////////////////////////////////////////////

    public void addEventUpdateToEvent(String _EventTitle, EventUpdate _EventUpdate) {
        Event _Event = findEventByTitle(_EventTitle);
        if (_Event != null && _EventUpdate != null) {
            _Event.addEventUpdate(_EventUpdate);
        }
        //findEventByTitle(_EventTitle).addEventUpdate(_EventUpdate);
    }
    ////////////////////////////////////////////////////////////////

    public void addEventUpdate(EventUpdate _EventUpdate) {
        _EventUpdates.add(_EventUpdate);
    }
    ////////////////////////////////////////////////////////////////

    public void removeUser(User _User) {
        _Users.remove(_User);
    }

    public void addCommand(Command _Command) {
        _Commands.add(_Command);
        findUserByName(_Command.getUserGetCommand().get_name()).addReceivedCommand(_Command);
        findUserByName(_Command.get_UserGivesCommand().get_name()).addCommand(_Command);
    }

    public void addCategory(Category _Category) {
        _Categories.add(_Category);
    }

    /**
     * This function check if the category exists in the categories list
     *
     * @param _CategoryDescription
     * @return
     */
    public boolean checkCategoryExist(String _CategoryDescription) {
        for (Category obj : _Categories) {
            if ((obj.get_Description().equals(_CategoryDescription))) {
                return true;
            }
        }
        return false;
    }

    public Category CreateNewCategory(String _RepresentitiveName, String _Description) {
        if (checkCategoryExist(_Description)) {
            System.out.println("The category already exists in the system");
            return null;
        }
        RepresentitiveAdmin _RepAdmin = findRepresentitiveAdminByName(_RepresentitiveName);
        if (_RepAdmin == null) {
            System.out.println("The Representitive Admin is null");
            return null;
        } else {
            Category _Category = new Category(_Description, this);
            _Categories.add(_Category);
            return _Category;

        }
    }

    /**
     * This function checks if users are from the same organization
     *
     * @param _U1
     * @param _U2
     * @return
     */
    public boolean checkUsersFromSameOrganization(User _U1, User _U2) {
        if (_U1.get_Organization().get_OrgaizationName().equals(
                _U2.get_Organization().get_OrgaizationName())) {
            return true;
        }
        return false;
    }

    /**
     * This function adds new command to user in the system
     *
     * @param _userGivesCommand
     * @param _userGetCommand
     * @param _content
     * @return
     */
    public Command addCommand(String _userGivesCommand, String _userGetCommand, String _content) {
        EmergencyUser _UserGivesCommand = findEmergencyUserByName(_userGivesCommand);
        EmergencyUser _UserGetCommand = findEmergencyUserByName(_userGetCommand);
        if (_UserGivesCommand == null || _UserGetCommand == null) {
            System.out.println("The user is not exists in the system");
            return null;
        }
        if (!checkUsersFromSameOrganization(_UserGivesCommand, _UserGetCommand)) {
            System.out.println("The users are not from the same organization");
            return null;
        }
        int _UserGivesRank = _UserGivesCommand.get_Rank();
        int _UserGetRank = _UserGetCommand.get_Rank();
        if (_UserGivesRank <= _UserGetRank) {
            System.out.println("The rank of the user who gives the command is smaller than the rank of the user who receives the command");
            return null;
        }
        Command _Command = new Command(_UserGetCommand, _UserGivesCommand, _content);
        _Commands.add(_Command);
        _UserGivesCommand.addCommand(_Command);
        _UserGetCommand.addReceivedCommand(_Command);
        return _Command;


    }

    public boolean checkUserBelongsToEvent(User _User, Event _Event) {
        return _Event.checkUserExists(_User);
    }

    public EventUpdate createNewUpdate(String _userName, String _eventTitle, String Date, String _content) {
        User _User = findUserByName(_userName);
        Event _Event = findEventByTitle(_eventTitle);
        if (_User == null || _Event == null) {
            System.out.println("The user or the event is null");
            return null;
        }
        if (!checkUserBelongsToEvent(_User, _Event)) {
            System.out.println("The Uuser is not belongs to event");
            return null;
        }

        EventUpdate _EventUpdate = new EventUpdate(_Event.getLastUpdate(), _User, Date, _content, _Event,
                _Event.getAndIcreseCounter(), _Event.get_InitialDescription());
        _Event.addNewEventUpdate(_EventUpdate);
        addEventUpdate(_EventUpdate);
        return _EventUpdate;
    }

    public List<String> getAllUsersForCommand(User current) {
        if (!(current instanceof EmergencyUser)) {
            return null;
        }
        List<String> users = new LinkedList<>();
        for (User obj : _Users) {
            if (obj != current && obj instanceof EmergencyUser) {
                if (((EmergencyUser) obj).get_Rank() < ((EmergencyUser) current).get_Rank() &&
                        ((EmergencyUser) obj).get_Organization().get_OrgaizationName().equals(
                                ((EmergencyUser) current).get_Organization().get_OrgaizationName())) {
                    users.add(obj.get_name());
                }
            }
        }
        return users;
    }


    public void createNewEvent() {
    }

    public void addComplaint() {
    }


    public void fillFeedback() {
    }

    public void getUsers() {
    }
}
