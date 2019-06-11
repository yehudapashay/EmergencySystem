package Model;

import java.util.LinkedList;
import java.util.List;

public class AdminController {

    public AdminController() {
        _Admins = new LinkedList();

        _Reports = new LinkedList();

        _Warnings = new LinkedList();

        _ErrorLogger = new ErrorLogger();

        _ActionLogger = new ActionLogger();

        _Feedbacks = new LinkedList();
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
