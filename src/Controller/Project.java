package Controller;

import java.sql.*;

public class Project {
    private volatile static Project project;
    private Project(){

    }
    private String pid;
    private String pname;
    private String detail;
    private String cid;
    private String sid;
    private Date startTime;
    private Date endTime;
    private float cost;

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public String getDetail() {
        return detail;
    }

    public String getCid() {
        return cid;
    }

    public String getSid() {
        return sid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public float getCost() {
        return cost;
    }
    public static Project getProject() {
        if(project == null) {
            synchronized (Project.class) {
                if(project == null) {
                    project = new Project();
                }
            }
        }
        return project;
    }
}
