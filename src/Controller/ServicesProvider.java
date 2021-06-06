package Controller;

import java.sql.Date;

public class ServicesProvider {
    private volatile static ServicesProvider servicesProvider;
    private ServicesProvider() {

    }
    private String sid;
    private String password;
    private String sname;
    private String phone;
    private String type;

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }

    public String getPassword() {
        return password;
    }

    public static ServicesProvider getServicesProvider() {
        if(servicesProvider == null) {
            synchronized (ServicesProvider.class) {
                if(servicesProvider == null) {
                    servicesProvider = new ServicesProvider();
                }
            }
        }
        return servicesProvider;
    }
}
