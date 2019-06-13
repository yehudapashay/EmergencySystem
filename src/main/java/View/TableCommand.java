package View;

import Model.Command;

public class TableCommand {
    private String _Content;
    private String _UserGivesCommand;
    private String _UserGetCommand;

    TableCommand(Command command) {
        _Content = command.getContent();
        _UserGetCommand = command.getUserGetCommand().get_name();
        _UserGivesCommand = command.get_UserGivesCommand().get_name();
    }

    public String get_Content() {
        return _Content;
    }

    public String get_UserGivesCommand() {
        return _UserGivesCommand;
    }

    public String get_UserGetCommand() {
        return _UserGetCommand;
    }

}
