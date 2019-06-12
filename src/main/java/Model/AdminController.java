package Model;

import java.util.LinkedList;
import java.util.List;

public class AdminController {

    private static AdminController obj;

    private AdminController() {
        _Admins = new LinkedList();

        _Reports = new LinkedList();

        _Warnings = new LinkedList();

        _ErrorLogger = new ErrorLogger();

        _ActionLogger = new ActionLogger();

        _Feedbacks = new LinkedList();
    }

    public static AdminController getInstance()
    {
        if (obj==null)
            obj = new AdminController();
        return obj;
    }

    private List<Feedback> _Feedbacks;

    private List<Admin> _Admins;

    private List<Report> _Reports;

    private List<Warning> _Warnings;

    private Logger _ErrorLogger;

    private Logger _ActionLogger;

    public void updateLogger() {
    }

    public void getAdmins() {
    }

    public void getFeedbacks() {
    }

    public void readReport() {
    }

    public void createNewReport() {
    }

    public void createNewCategory() {
    }
}
