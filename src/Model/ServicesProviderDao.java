package Model;

import Controller.Customer;
import Controller.ServicesProvider;

import java.sql.*;

public class ServicesProviderDao {
    public boolean loginFrame(String sid,String password) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "select * from ServicesProvider where sid=? and password=? ")
        ){
            pstmt.setString(1,sid);
            pstmt.setString(2,password);
            try (
                    ResultSet rs=pstmt.executeQuery()
            ){
                if (rs.next()){
                    //System.out.println("成功");
                    return true;
                }
            }
        }
        return false;
    }
    public boolean showInformation(String sid) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "select * from ServicesProvider where sid=?")
        ){
            pstmt.setString(1,sid);
            try (
                    ResultSet rs=pstmt.executeQuery()
            ){
                if (rs.next()){
                    ServicesProvider servicesProvider = ServicesProvider.getServicesProvider();
                    servicesProvider.setPassword(rs.getString(2));
                    servicesProvider.setSname(rs.getString(3));
                    servicesProvider.setPhone(rs.getString(4));
                    servicesProvider.setType(rs.getString(5));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean updateServicesProvider (String sid, String sname, String password, String phone,String type) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update ServicesProvider set sname = ?,password = ?, phone = ?,type = ? where sid = ?")
        ){
            pstmt.setString(1,sname);
            pstmt.setString(2,password);
            pstmt.setString(3,phone);
            pstmt.setString(4,type);
            pstmt.setString(5, sid);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 注册服务商
     * @param sid
     * @param sname
     * @param password
     * @param phone
     * @param type
     * @return
     * @throws ClassNotFoundException
     */
    public boolean registeredServicesProvider(String sid, String sname, String password, String phone,String type) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into ServicesProvider(sid,sname,password,phone,type)"+
                                "values (?,?,?,?,?)")
        )
        {

            pstmt.setString(1,sid);
            pstmt.setString(2,sname);
            pstmt.setString(3,password);
            pstmt.setString(4,phone);
            pstmt.setString(5,type);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean createTimeTable(String tid,String time,String sid) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Sechedule(tid,sid,time)"+
                                "values (?,?,?)")
        )
        {

            pstmt.setString(1,tid);
            pstmt.setString(2,sid);
            pstmt.setString(3,time);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean updateProject(String pid,String sid,Date startTime) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Project set sid = ?,startTime = ? where pid =?")
        ){
            pstmt.setString(1,sid);
            pstmt.setDate(2,startTime);
            pstmt.setString(3,pid);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 删除时间表
     * @param tid
     * @return
     * @throws Exception
     */
    public boolean deleteSechedule(String tid) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Sechedule where tid=?")
        ) {
            pstmt.setString(1,tid);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean deleteProject(String pid) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Sechedule where pid=?")
        ) {
            pstmt.setString(1,pid);
            pstmt.executeUpdate();
            int i=pstmt.getUpdateCount();
            if (i>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
