package Model;

import java.util.LinkedList;
import java.util.List;

public class Representitive extends EmergencyUser {


    public Representitive(UserController _UserCtrl, String _Organization, int _Rank , String name) {
        super(_UserCtrl, _Organization, _Rank ,name);
        _Events = new LinkedList();
    }


    private List<Event > _Events;
}
