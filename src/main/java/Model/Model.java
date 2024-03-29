package Model;

import java.util.List;

public class Model {

    public static UserController _UserCtrl = UserController.getInstance();

    public static AdminController _AdminCtrl = AdminController.getInstance();

    public static DBManagement DB = new DBManagement();

    public Model() {
        DB.initUsers();
        DB.initEvent();
        DB.initCommands();
        DB.initCategories();
        DB.initEventCategory();
        DB.initEventForUsers();
        DB.initEventUpdates();
    }


    /////////////////////////////// UC-1
    public static boolean createNewCategory(String _RepresentitiveName, String _Description) {
        if (_RepresentitiveName == null || _RepresentitiveName.isEmpty()||
                _Description == null || _Description.isEmpty()){
            return false;
        }
        if (_UserCtrl.checkCategoryExist(_Description)) {
            System.out.println("The category already exists in the system");
            return false;
        }
        Category _Category = _UserCtrl.CreateNewCategory(_RepresentitiveName, _Description);
        if (_Category != null) {
            return (DB.addCategoryToDB(_Category));
        } else {
            System.out.println("Something is wrong");
            return false;
        }

    }

    /////////////////////////////// UC-2
    public static boolean addCommand(String _userGivesCommand, String _userGetCommand,
                                     String _content) {
        if (_userGivesCommand == null || _userGivesCommand.isEmpty()||
                _userGetCommand == null || _userGetCommand.isEmpty() ||
                _content == null || _content.isEmpty() ){
            return false;
        }
        Command _Command = _UserCtrl.addCommand(_userGivesCommand, _userGetCommand, _content);
        if (_Command != null) {
            return (DB.addCommandToDB(_Command));
        } else {
            System.out.println("Something is wrong");
            return false;
        }

    }

    /////////////////////////////// UC-3
    public static boolean publishUpdate(String _userName, String _eventTitle, String Date, String _content) {
        if (_userName == null || _userName.isEmpty()||
                _eventTitle == null || _eventTitle.isEmpty() ||
                Date == null || Date.isEmpty() ||
                _content == null || _content.isEmpty() ){
            return false;
        }
        EventUpdate _EventUpdate = _UserCtrl.createNewUpdate(_userName, _eventTitle, Date, _content);
        if (_EventUpdate != null) {
            return (DB.addEventUpdateToDB(_EventUpdate));
        } else {
            System.out.println("Something is wrong");
            return false;
        }

    }


    public static List<Event> getAllEvents() {
        return _UserCtrl.get_Events();
    }

    public static List<Event> getAllUserEvents() {
        return _UserCtrl.get_AllUserEvents();
    }

    public static List<EventUpdate> getAllUpdates() {
        return _UserCtrl.get_EventUpdates();

    }

    public static List<EventUpdate> getEventUpdates(String eventTitle) {
        return _UserCtrl.getEventUpdates(eventTitle);
    }


    public static List<Command> getAllCommandsSent(User current) {
        return current.get_Commands();
    }

    public static List<Command> getAllCommandsSent(String _User) {
        return _UserCtrl.getAllCommandsSent(_User);
    }

    public static List<Command> getAllCommandsRecieved(User current) {
        return current.get_ReceivedCommands();
    }

    public static List<Command> getAllCommandsRecieved(String _User) {
        return _UserCtrl.getAllCommandsRecieved(_User);
    }

    public static List<String> getAllUserNames() {
        return _UserCtrl.getAllUserNames();
    }

    public static List<Category> getAllCategories() {
        return _UserCtrl.get_Categories();
    }

    public static User login(String userName) {
        return _UserCtrl.findUserByName(userName);
    }

    public static List<String> getAllUsersForCommand(User current) {
        return _UserCtrl.getAllUsersForCommand(current);
    }


}
