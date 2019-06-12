package Model;

import java.sql.*;
import java.sql.Connection;
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
                            Model._UserCtrl,
                            resultSet.getString(2),
                            Model._AdminCtrl,
                            resultSet.getString(1));

                    Model._UserCtrl.addUser(_RepresentiveAdmin);
                    System.out.println("USER ADDED:" + resultSet.getString(1));   // ------------ delete in the end
                }
                if (_userType.equals("Admin")) {
                    Admin _Admin = new Admin(
                            Model._UserCtrl,
                            resultSet.getString(2),
                            Model._AdminCtrl,
                            resultSet.getString(1));

                    Model._UserCtrl.addUser(_Admin);
                    System.out.println("USER ADDED:" + resultSet.getString(1));   // ------------ delete in the end
                }
                if (_userType.equals("EmergencyUser")) {
                    EmergencyUser _EmergencyUser = new EmergencyUser(
                            Model._UserCtrl,
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getString(1));

                    Model._UserCtrl.addUser(_EmergencyUser);
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
                User _Representitive = Model._UserCtrl.findUserByName(resultSet.getString(3));
                if (_Representitive == null) {
                    System.out.println("The _Representitive is null");
                } else {
                    Event _Event = new Event(resultSet.getString(1),
                            resultSet.getString(4),
                            Model._UserCtrl,
                            _Representitive,
                            resultSet.getString(9));
                    Model._UserCtrl.addEvent(_Event);
                    Model._UserCtrl.addEventToUser(resultSet.getString(5), resultSet.getString(1));
                    Model._UserCtrl.addUserToEvent(resultSet.getString(5), resultSet.getString(1));

                    Model._UserCtrl.addEventToUser(resultSet.getString(6), resultSet.getString(1));
                    Model._UserCtrl.addUserToEvent(resultSet.getString(6), resultSet.getString(1));


                    Model._UserCtrl.addEventToUser(resultSet.getString(7), resultSet.getString(1));
                    Model._UserCtrl.addUserToEvent(resultSet.getString(7), resultSet.getString(1));


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
                User _User1 = Model._UserCtrl.findUserByName(resultSet.getString(1));
                User _User2 = Model._UserCtrl.findUserByName(resultSet.getString(2));
                if (_User1 == null || _User2 == null) {
                    System.out.println("The user is null");
                } else {
                    Command _Command = new Command(_User1,
                            _User2,
                            resultSet.getString(3));

                    Model._UserCtrl.addCommand(_Command);
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
                    Category _Category = new Category(_Description, Model._UserCtrl);
                    Model._UserCtrl.addCategory(_Category);
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
                Event _Event = Model._UserCtrl.findEventByTitle(resultSet.getString(2));
                User _User = Model._UserCtrl.findUserByName(resultSet.getString(1));
                if (_Event == null || _User == null) {
                    System.out.println("The event or the user is null");
                } else {
                    Model._UserCtrl.addEventToUser(resultSet.getString(1), resultSet.getString(2));
                    Model._UserCtrl.addUserToEvent(resultSet.getString(1), resultSet.getString(2));
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
                Category _Category = Model._UserCtrl.findCategoryByDescription(resultSet.getString(2));
                Event _Event = Model._UserCtrl.findEventByTitle(resultSet.getString(1));
                if (_Event == null || _Category == null) {
                    System.out.println("The event or the Category is null");
                } else {
                    Model._UserCtrl.addCategoryToEvent(resultSet.getString(1), resultSet.getString(2));
                    Model._UserCtrl.addEventToCategory(resultSet.getString(1), resultSet.getString(2));
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


    public void initEventUpdates() {
        Connection connection = this.connect();
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT * FROM Updates");
            while (resultSet.next()) {
                Event _Event = Model._UserCtrl.findEventByTitle(resultSet.getString(1));
                if (_Event == null) {
                    System.out.println("The event is null");
                } else {
                    EventUpdate _PreviousUpdate;
                    if (resultSet.getString(4).equals("NULL")) {
                        _PreviousUpdate = null;
                    } else {
                        _PreviousUpdate = Model._UserCtrl.findEventUpdate(resultSet.getString(1), Integer.parseInt(resultSet.getString(4)));
                    }
                    User _User= Model._UserCtrl.findUserByName(resultSet.getString(5));
                    EventUpdate _EventUpdate = new EventUpdate(_PreviousUpdate ,
                            _User ,
                            resultSet.getString(3),
                            resultSet.getString(6),
                            _Event,
                            Integer.parseInt(resultSet.getString(2)),
                            resultSet.getString(7));

                    Model._UserCtrl.addEventUpdate(_EventUpdate);
                    Model._UserCtrl.addEventUpdateToEvent(resultSet.getString(1), _EventUpdate);
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


    /**
     * This function add a category to the Categories table in the DB
     *
     * @param _Category
     * @return
     */
    public boolean addCategoryToDB(Category _Category) {
        Connection conn = null;
        String sql = "INSERT INTO Categories(CategoryDescription) VALUES(?)";
        try {
            conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, _Category.get_Description());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }


    /**
     * This function add a command to the Commands table in the DB
     *
     * @param _Command
     * @return
     */
    public boolean addCommandToDB(Command _Command) {
        Connection conn = null;
        String sql = "INSERT INTO Commands(UserGetCommand ,UserGivesCommand , Content ) VALUES(?,?,?)";
        try {
            conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, _Command.getUserGetCommand().get_name());
            pstmt.setString(2, _Command.get_UserGivesCommand().get_name());
            pstmt.setString(3, _Command.getContent());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }


    public boolean addEventUpdateToDB(EventUpdate _EventUpdate) {
        Connection conn = null;
        String sql = "INSERT INTO Updates(EventTitle ,UpdateNum , Date ,PreviousUpdateNum ,UserName,Description,InitialDescription   ) VALUES(?,?,?,?,?,?,?)";
        try {
            conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, _EventUpdate.get_Event().get_Title());
            pstmt.setString(2,  Integer.toString(_EventUpdate.get_UpdateNum()));
            pstmt.setString(3, _EventUpdate.get_Date());
            pstmt.setString(4, Integer.toString(_EventUpdate.get_PreviousUpdate().get_UpdateNum()));
            pstmt.setString(5, _EventUpdate.get_User().get_name());
            pstmt.setString(6, _EventUpdate.get_Content());
            pstmt.setString(7, _EventUpdate.get_InitialContent());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return updateLastUpdateNum(_EventUpdate);
    }

    public boolean updateLastUpdateNum(EventUpdate _EventUpdate) {
        Connection conn = null;
        String sql = "UPDATE Events SET LastUpdateNum =? WHERE Title =?";
        try {
            conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Integer.toString(_EventUpdate.get_UpdateNum()));
            pstmt.setString(2, _EventUpdate.get_Event().get_Title());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }


}
