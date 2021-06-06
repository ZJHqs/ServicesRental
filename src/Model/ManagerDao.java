package Model;
import Controller.Manager;
import java.sql.*;

public class ManagerDao {
    public ManagerDao(){

    }

    /**
     * 管理员登录
     * @param id
     * @param password
     * @return
     * @throws Exception
     */
    public boolean loginFrame(String id, String password) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "select * from Manager where id=? and password=? ")
        ){
            pstmt.setString(1,id);
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

    /**
     * 查看管理员个人信息
     * @param id
     * @return
     * @throws Exception
     */
    public boolean showInformation(String id) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "select * from Manager where id=?")
        ){
            pstmt.setString(1,id);
            try (
                    ResultSet rs=pstmt.executeQuery()
            ){
                if (rs.next()){
                    Manager manager=Manager.getManager();
                    manager.setPassword(rs.getString(2));
                    manager.setName( rs.getString(3));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 创建管理员
     * @param id
     * @param password
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    public boolean registeredManager(String id,String password, String name) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Manager(id,password,name)"+
                                "values (?,?,?)")
        )
        {
            pstmt.setString(1,id);
            pstmt.setString(2,password);
            pstmt.setString(3,name);
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
     * 删除管理员
     * @param id
     * @return
     * @throws ClassNotFoundException
     */
    public boolean deleteManager(String id) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Manager where id=?")
        ) {
            pstmt.setString(1,id);
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
     * 更新管理员信息
     * @param id
     * @param password
     * @param name
     * @return
     * @throws Exception
     */

    public boolean updateManager(String id, String password, String name) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Manager set password=?,name=? where id=?")
        ){
            pstmt.setString(1,password);
            pstmt.setString(2,name);
            pstmt.setString(3,id);
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
     * 删除客户
     * @param cid
     * @return
     * @throws ClassNotFoundException
     */
    public boolean deleteCustomer(String cid) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Customer where cid=?")
        ) {
            pstmt.setString(1,cid);
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
     * 删除服务商
     * @param sid
     * @return
     * @throws Exception
     */
    public boolean deleteServicesProvider(String sid) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from ServicesProvider where sid=?")
        ) {
            pstmt.setString(1,sid);
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
     * 删除project
     * @param pid
     * @return
     * @throws Exception
     */
    public boolean deleteProject (String pid) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "delete from Project where pid=?")
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


}
