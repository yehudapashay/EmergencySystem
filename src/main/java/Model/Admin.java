package Model;

import java.util.List;

public class Admin extends  User {

    private AdminController _AdminCtrl;

    public Admin(UserController _UserCtrl, String _Organization, AdminController _AdminCtrl , String name) {
        super(_UserCtrl, _Organization ,name);
        this._AdminCtrl = _AdminCtrl;
    }

    private List<Account> _AdminAccounts ;

    private List<Warning> _AdminWarnings ;

    private List<Complaint> _AdminComplaints ;

    private List<Report> _AdminReports ;
    @Override

    public void addFeedback() {

    }

    @Override
    public void getWarningNum() {

    }

    @Override
    public void demoteUser() {

    }

    public void createWarning(){}

    public void approveComplaint(){}
}
