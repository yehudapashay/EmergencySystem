package Model;

public abstract class Organization {

    private String _OrgaizationName ;

    public Organization(String _OrgaizationName) {
        this._OrgaizationName = _OrgaizationName;
    }

    public String get_OrgaizationName() {
        return _OrgaizationName;
    }
}
