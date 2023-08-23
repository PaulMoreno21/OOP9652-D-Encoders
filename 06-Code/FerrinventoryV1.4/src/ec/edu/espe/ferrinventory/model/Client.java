package ec.edu.espe.ferrinventory.model;

public class Client {
    private static int lastId = 0; 
    private final int id;
    private String name;
    private String email;
    private String address;
    private String phone;

    public Client(String name, String email, String address, String phone) {
        this.id = ++lastId; // Generar el nuevo ID automáticamente
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public static int getLastUsedId() {
        return lastId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
