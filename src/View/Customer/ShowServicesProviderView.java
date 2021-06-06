package View.Customer;

import Controller.Customer;
import Model.CustomerDao;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;

public class ShowServicesProviderView {

    public void init() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try(
                Connection conn= DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Services",
                        "zjh","123456");
                PreparedStatement pstmt=conn.prepareStatement(
                        "select * from ServicesProvider")
                ) {
            ResultSet rs=pstmt.executeQuery();
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
            var jFrame=new JFrame("查看所有服务商");
            jFrame.setSize(680,480);
            jFrame.add(scrollPane);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
