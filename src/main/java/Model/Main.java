package Model;

import java.util.Date;

public class Main {

    public static UserController _UserCtrl = new UserController();

    public static AdminController _AdminCtrl = new AdminController();

    public static void main(String[] args) {
        //Date d =new Date();
        //System.out.println(d.toString());

        DBManagement DB = new DBManagement();
        DB.initUsers();
        DB.initEvent();
        DB.initCommands();
        DB.initCategories();
        DB.initEventCategory();
        DB.initEventForUsers();


    }
}
