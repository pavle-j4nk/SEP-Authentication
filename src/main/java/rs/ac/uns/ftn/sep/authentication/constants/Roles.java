package rs.ac.uns.ftn.sep.authentication.constants;

public enum Roles {
    SELLER("SELLER");

    private final String name;

    Roles(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
