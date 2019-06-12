package Model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static UserController _UserCtrl = new UserController();

    public static AdminController _AdminCtrl = new AdminController();

    public static DBManagement DB = new DBManagement();

    public static void main(String[] args) {
        //Date d =new Date();
        //System.out.println(d.toString());


        DB.initUsers();
        DB.initEvent();
        DB.initCommands();
        DB.initCategories();
        DB.initEventCategory();
        DB.initEventForUsers();
        DB.initEventUpdates();
        //publishUpdate("Yuval" , "Violence - Rager St",(new Date()).toString(),"A Police arrived to te event location");
        //createNewCategory("Yehuda" ,"Attack Event" );
        //createNewCategory("Lior" ,"v Event" );
        //addCommand( "Sharon" ,"Tomer" , "Go home");





    }


    /////////////////////////////// UC-1
    public static boolean createNewCategory(String _RepresentitiveName , String _Description){
        if (_UserCtrl.checkCategoryExist(_Description)){
            System.out.println("The category already exists in the system");
            return false;
        }
        Category _Category = _UserCtrl.CreateNewCategory(_RepresentitiveName , _Description);
       if (_Category != null){
           return (DB.addCategoryToDB(_Category));
       }
       else{
           System.out.println("Something is wrong");
           return false;
       }

    }

    /////////////////////////////// UC-2
    public static boolean addCommand(String _userGivesCommand , String _userGetCommand,
                                     String _content){
        Command _Command = _UserCtrl.addCommand(_userGivesCommand ,_userGetCommand,_content );
        if (_Command != null){
            return (DB.addCommandToDB(_Command));
        }
        else{
            System.out.println("Something is wrong");
            return false;
        }

    }

    /////////////////////////////// UC-3
    public static boolean publishUpdate(String _userName , String _eventTitle,String Date,String _content){

        EventUpdate _EventUpdate = _UserCtrl.createNewUpdate( _userName ,  _eventTitle, Date, _content);
        if (_EventUpdate != null){
            return (DB.addEventUpdateToDB(_EventUpdate));
        }
        else{
            System.out.println("Something is wrong");
            return false;
        }

    }



    //////////////////////////////////////   Functions for ron
    public static List<Event> getAllEvents(){
        return _UserCtrl.get_Events();
    }

    public static List<EventUpdate> getAllUpdates(){
        return _UserCtrl.get_EventUpdates();

    }

    public static List<EventUpdate> getEventUpdates(String eventTitle){
        return _UserCtrl.getEventUpdates(eventTitle);
    }


    public static List<Command> getAllCommandsSent(User current){
        return current.get_Commands();
    }

    public static List<Command> getAllCommandsSent(String _User){
        return _UserCtrl.getAllCommandsSent(_User);
    }

    public static List<Command> getAllCommandsRecieved(User current){
        return current.get_ReceivedCommands();
    }

    public static List<Command> getAllCommandsRecieved(String _User){
        return _UserCtrl.getAllCommandsRecieved(_User);
    }

    public static List<String> getAllUserNames(){
        return _UserCtrl.getAllUserNames();
    }

    public static List<Category> getAllCategories(){
        return _UserCtrl.get_Categories();
    }

    public static User login(String userName){
        return _UserCtrl.findUserByName(userName);
    }


}
