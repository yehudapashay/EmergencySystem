package Model;

import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManagement {

    public DBManagement() {
    }

    private Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\EmergencyDB.db";
        System.out.println("our url is : " + url);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void initUsers() {
        Connection connection = this.connect();
        ResultSet resultSet = null;
        Statement statement = null;


        try {
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                String _userType = resultSet.getString(5);
                if (_userType.equals("RepresentiveAdmin")) {
                    RepresentitiveAdmin _RepresentiveAdmin = new RepresentitiveAdmin(
                            Main._UserCtrl,
                            resultSet.getString(2),
                            Main._AdminCtrl,
                            resultSet.getString(1));

                    Main._UserCtrl.addUser(_RepresentiveAdmin);
                    System.out.println("USER ADDED:" + resultSet.getString(1));   // ------------ delete in the end
                }
                if (_userType.equals("Representitive")) {
                    Representitive _Representive = new Representitive(
                            Main._UserCtrl,
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getString(1));

                    Main._UserCtrl.addUser(_Representive);
                    System.out.println("USER ADDED:" + resultSet.getString(1));   // ------------ delete in the end
                }
                if (_userType.equals("Admin")) {
                    Admin _Admin = new Admin(
                            Main._UserCtrl,
                            resultSet.getString(2),
                            Main._AdminCtrl,
                            resultSet.getString(1));

                    Main._UserCtrl.addUser(_Admin);
                    System.out.println("USER ADDED:" + resultSet.getString(1));   // ------------ delete in the end
                }
                if (_userType.equals("EmergencyUser")) {
                    EmergencyUser _EmergencyUser = new EmergencyUser(
                            Main._UserCtrl,
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getString(1));

                    Main._UserCtrl.addUser(_EmergencyUser);
                    System.out.println("USER ADDED:" + resultSet.getString(1));   // ------------ delete in the end
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void initEvent() {
        Connection connection = this.connect();
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT * FROM Events");
            while (resultSet.next()) {
                User _Representitive = Main._UserCtrl.findUserByName(resultSet.getString(3));
                if (_Representitive == null) {
                    System.out.println("The _Representitive is null");
                } else {
                    Event _Event = new Event(resultSet.getString(1),
                            resultSet.getString(4),
                            Main._UserCtrl,
                            _Representitive);
                    Main._UserCtrl.addEvent(_Event);
                    /// create connection between organization Representitives and the event
                    User _User = Main._UserCtrl.findUserByName(resultSet.getString(5));
                    int rank = Main._UserCtrl.findUserByRankName(resultSet.getString(5));
                    Representitive _PoliceRepresentitive = new Representitive(Main._UserCtrl,
                            _User.get_Organization().get_OrgaizationName(),
                            rank,
                            resultSet.getString(5));
                    Main._UserCtrl.removeUser(_User);
                    Main._UserCtrl.addUser(_PoliceRepresentitive);
                    Main._UserCtrl.addEventToUser(resultSet.getString(5) ,resultSet.getString(1) );
                    Main._UserCtrl.addUserToEvent(resultSet.getString(5) ,resultSet.getString(1) );

                    //////////////////////////////////////////
                    _User = Main._UserCtrl.findUserByName(resultSet.getString(6));
                    rank = Main._UserCtrl.findUserByRankName(resultSet.getString(6));
                    Representitive _FireRepresentitive = new Representitive(Main._UserCtrl,
                            _User.get_Organization().get_OrgaizationName(),
                            rank,
                            resultSet.getString(6));
                    Main._UserCtrl.removeUser(_User);
                    Main._UserCtrl.addUser(_FireRepresentitive);
                    Main._UserCtrl.addEventToUser(resultSet.getString(6) ,resultSet.getString(1) );
                    Main._UserCtrl.addUserToEvent(resultSet.getString(6) ,resultSet.getString(1) );

                    /////////////////////////////////////////
                    _User = Main._UserCtrl.findUserByName(resultSet.getString(7));
                    rank = Main._UserCtrl.findUserByRankName(resultSet.getString(7));
                    Representitive _MDARepresentitive = new Representitive(Main._UserCtrl,
                            _User.get_Organization().get_OrgaizationName(),
                            rank,
                            resultSet.getString(7));
                    Main._UserCtrl.removeUser(_User);
                    Main._UserCtrl.addUser(_MDARepresentitive);
                    Main._UserCtrl.addEventToUser(resultSet.getString(7) ,resultSet.getString(1) );
                    Main._UserCtrl.addUserToEvent(resultSet.getString(7) ,resultSet.getString(1) );


                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void initCommands() {
        Connection connection = this.connect();
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT * FROM Commands");
            while (resultSet.next()) {
                User _User1 = Main._UserCtrl.findUserByName(resultSet.getString(1));
                User _User2 = Main._UserCtrl.findUserByName(resultSet.getString(2));
                if (_User1 == null || _User2 == null) {
                    System.out.println("The user is null");
                } else {
                    Command _Command = new Command(_User1,
                            _User2,
                            resultSet.getString(3));

                    Main._UserCtrl.addCommand(_Command);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void initCategories() {
        Connection connection = this.connect();
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT * FROM Categories");
            while (resultSet.next()) {
                String _Description = resultSet.getString(1);
                if (_Description == null) {
                    System.out.println("The category is null");
                } else {
                    Category _Category = new Category(_Description, Main._UserCtrl);
                    Main._UserCtrl.addCategory(_Category);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void initEventForUsers() {
        Connection connection = this.connect();
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT * FROM UserEvents");
            while (resultSet.next()) {
                Event _Event = Main._UserCtrl.findEventByTitle(resultSet.getString(2));
                User _User = Main._UserCtrl.findUserByName(resultSet.getString(1));
                if (_Event == null || _User == null) {
                    System.out.println("The event or the user is null");
                } else {
                    Main._UserCtrl.addEventToUser(resultSet.getString(1), resultSet.getString(2));
                    Main._UserCtrl.addUserToEvent(resultSet.getString(1), resultSet.getString(2));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void initEventCategory() {
        Connection connection = this.connect();
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT * FROM EventCategory");
            while (resultSet.next()) {
                Category _Category = Main._UserCtrl.findCategoryByDescription(resultSet.getString(2));
                Event _Event = Main._UserCtrl.findEventByTitle(resultSet.getString(1));
                if (_Event == null || _Category == null) {
                    System.out.println("The event or the Category is null");
                } else {
                    Main._UserCtrl.addCategoryToEvent(resultSet.getString(1), resultSet.getString(2));
                    Main._UserCtrl.addEventToCategory(resultSet.getString(1), resultSet.getString(2));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
