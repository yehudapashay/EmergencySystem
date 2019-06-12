package Model;

import java.util.LinkedList;
import java.util.List;

public class Account {

    public Account(String _Email, String _Password, String _Status, Admin _Admin) {
        this._Email = _Email;
        this._Password = _Password;
        this._Status = _Status;
        this._Admin = _Admin;
        this._AccountNotice = new LinkedList<>();
    }

    private String _Email;

    private String _Password;

    private String _Status;

    private Admin _Admin;

    private List<AccountNotice> _AccountNotice ;
}
