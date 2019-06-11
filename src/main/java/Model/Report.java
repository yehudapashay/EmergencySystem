package Model;

import java.util.LinkedList;
import java.util.List;

public class Report {

    private String _Description;

    public Report(String _Description, User userGivesReport, AdminController _AdminCtrl) {
        this._Description = _Description;
        _UsersGetReport = new LinkedList();
        _UserGivesReport = userGivesReport;
        this._AdminCtrl = _AdminCtrl;
    }

    private List<User> _UsersGetReport;

    private User _UserGivesReport;

    public Double calculateAvg(){
        return null;
    }

    public Report getEventReport(){
        return null;
    }

    private AdminController _AdminCtrl;

}
