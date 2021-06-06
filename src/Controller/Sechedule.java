package Controller;

public class Sechedule {
    private static Sechedule sechedule;
    private Sechedule() {

    }
    private String tid;
    private String  sid;
    private String time;

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTid() {
        return tid;
    }

    public String getSid() {
        return sid;
    }

    public String getTime() {
        return time;
    }

    public static Sechedule getSechedule() {
        if(sechedule == null) {
            synchronized (Sechedule.class) {
                if(sechedule == null) {
                    sechedule = new Sechedule();
                }
            }
        }
        return sechedule;
    }
}
