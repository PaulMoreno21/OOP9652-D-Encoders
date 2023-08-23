package ec.edu.espe.ferrinventory.model;

public abstract class User {
    private int id;
    private String name;
    private String password;
    private boolean permissions;
    private String typeUser;

    public User(int id, String name, String password, boolean permissions, String typeUser) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.permissions = permissions;
        this.typeUser = typeUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPermissions() {
        return permissions;
    }

    public void setPermissions(boolean permissions) {
        this.permissions = permissions;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", permissions=" + permissions +
                ", typeUser='" + typeUser + '\'' +
                '}';
    }
}
