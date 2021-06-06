package Controller;

public class Customer {
    private volatile static Customer customer;
    private Customer(){

    }
    private String cid;
    private String cnmae;
    private String password;
    private String phone;

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setCnmae(String cnmae) {
        this.cnmae = cnmae;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCid() {
        return cid;
    }

    public String getCnmae() {
        return cnmae;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public static Customer getCustomer() {
        if(customer == null) {
            synchronized (Customer.class) {
                if (customer == null) {
                    customer= new Customer();
                }
            }
        }
        return customer;
    }
}
