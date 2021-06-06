package Controller;

public class Manager {
    private volatile static Manager manager;
    private Manager(){

    }
    private String id;
    private String password;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
    public static Manager getManager() {
        if(manager == null) {
            synchronized (Manager.class) {
                if (manager == null) {
                    manager = new Manager();
                }
            }
        }
        return manager;
    }

}
