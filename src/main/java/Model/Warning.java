package Model;

public class Warning {

    private User _UserGetWarning;
    private User _UserGivesWarning;

    public Warning(User userGetWarning, User userGivesWarning) {
        _UserGetWarning = userGetWarning;
        _UserGivesWarning = userGivesWarning;
    }

    public User getUserGetWarning() {
        return _UserGetWarning;
    }

    public User getUserGivesWarning() {
        return _UserGivesWarning;
    }
}
