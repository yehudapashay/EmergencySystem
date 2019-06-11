package Model;

public class Command {

    private User _UserGetCommand;
    private User _UserGivesCommand;
    private String _Content;

    public Command(User userGetCommand, User userGivesCommand, String content) {
        _UserGetCommand = userGetCommand;
        _UserGivesCommand = userGivesCommand;
        _Content = content;
    }

    public User getUserGetCommand() {
        return _UserGetCommand;
    }

    public User getUserGivesCommand() {
        return _UserGivesCommand;
    }

    public String getContent() {
        return _Content;
    }
}
