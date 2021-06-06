package Model;

import Controller.Customer;
import Controller.Project;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import java.util.Vector;

public class CustomerDao {
    /**
     * 客户登录
     * @param cid
     * @param password
     * @return
     * @throws Exception
     */
    public boolean loginFrame(String cid,String password) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "select * from Customer where cid=? and password=? ")
        ){
            pstmt.setString(1,cid);
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
     * 查看客户个人信息
     * @param cid
     * @return
     * @throws Exception
     */
    public boolean showInformation(String cid) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "select * from Customer where cid=?")
        ){
            pstmt.setString(1,cid);
            try (
                    ResultSet rs=pstmt.executeQuery()
            ){
                if (rs.next()){
                    Customer customer = Customer.getCustomer();
                    customer.setCnmae(rs.getString(2));
                    customer.setPassword(rs.getString(3));
                    customer.setPhone(rs.getString(4));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 更新用户个人信息
     * @param cid
     * @param cname
     * @param password
     * @param phone
     * @return
     * @throws Exception
     */
    public boolean updateCustomer(String cid, String cname, String password, String phone) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Customer set cname = ?,password = ?, phone = ? where cid = ?")
        ){
            pstmt.setString(1,cname);
            pstmt.setString(2,password);
            pstmt.setString(3,phone);
            pstmt.setString(4,cid);
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
     * 客户注册
     * @param cid
     * @param cname
     * @param password
     * @param phone
     * @return
     * @throws ClassNotFoundException
     */
    public boolean registeredCustomer(String cid, String cname, String password, String phone) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Customer(cid,cname,password,phone)"+
                                "values (?,?,?,?)")
        )
        {

            pstmt.setString(1,cid);
            pstmt.setString(2,cname);
            pstmt.setString(3,password);
            pstmt.setString(4,phone);
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
     * 通过类别寻找服务商
     * @param type
     * @return
     * @throws ClassNotFoundException
     */
    public boolean findByType(String type) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "select * from ServicesProvider where type = ?"
                )
                ){
            pstmt.setString(1,type);
            try (
                    ResultSet rs=pstmt.executeQuery();
                    ){
                ResultSetMetaData rsmd= rs.getMetaData();
                Vector<String> columnNames=new Vector<>();
                Vector<Vector<String>> data=new Vector<>();
                for (var i=0;i<rsmd.getColumnCount();i++){
                    columnNames.add(rsmd.getColumnName(i+1));
                }
                while (rs.next()){
                    Vector<String> v=new Vector<>();
                    for (var i=0;i<rsmd.getColumnCount();i++){
                        v.add(rs.getString(i+1));
                    }
                    data.add(v);
                }
                var table=new JTable(data,columnNames);
                var scrollPane=new JScrollPane(table);
                var jFrame=new JFrame("服务商详情");
                jFrame.setSize(680,480);
                jFrame.add(scrollPane);
                jFrame.setVisible(true);
                jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 添加项目
     * @param pid
     * @param pname
     * @param detail
     * @param cid
     * @return
     * @throws ClassNotFoundException
     */
    public boolean addProject(String pid,String pname, String detail,String cid) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "insert into Project(pid,pname,detail,cid)"+
                                "values (?,?,?,?)")
        )
        {

            pstmt.setString(1,pid);
            pstmt.setString(2,pname);
            pstmt.setString(3,detail);
            pstmt.setString(4,cid);
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
     * 显示项目详情
     * @param pid
     * @return
     * @throws Exception
     */
    public boolean showProject(String pid) throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "select * from Project where pid=?")
        ){
            pstmt.setString(1,pid);
            try (
                    ResultSet rs=pstmt.executeQuery()
            ){
                if (rs.next()){
                    Project project = Project.getProject();
                    project.setPname(rs.getString(2));
                    project.setDetail(rs.getString(3));
                    project.setCid(rs.getString(4));
                    project.setSid(rs.getString(5));
                    project.setStartTime(rs.getDate(6));
                    project.setEndTime(rs.getDate(7));
                    project.setCost(rs.getFloat(8));
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param pid
     * @param pname
     * @param detail
     * @param cid
     * @return
     * @throws Exception
     */
    public boolean updateProject(String pid, String pname, String detail, String cid) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "update Project set pname= ?,detail = ?,cid = ? where pid = ?")
        ){
            pstmt.setString(1,pname);
            pstmt.setString(2,detail);
            pstmt.setString(3,cid);
            pstmt.setString(4,pid);
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
