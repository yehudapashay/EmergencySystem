package Model;

public class OrganizationFactory {
    public OrganizationFactory() {
    }

    public Organization getOrganization(String OrganizationType) {
        if (OrganizationType == null) {
            return null;
        }
        if (OrganizationType.equalsIgnoreCase("Police")) {
            return new Police();
        } else if (OrganizationType.equalsIgnoreCase("FireFighters")) {
            return new FireFighters();
        } else if (OrganizationType.equalsIgnoreCase("MDA")) {
            return new MDA();
        }
        return null;
    }
}
