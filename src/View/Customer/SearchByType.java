package View.Customer;

import Controller.Customer;
import Model.CustomerDao;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SearchByType {
    JFrame jf = new JFrame("通过分类查询服务商");
    JPanel jPanel = new JPanel(null);
    JLabel type= new JLabel("类别");
    JTextField typetext = new JTextField();
    JButton search = new JButton("搜索");

    public void init() {
        jf.setSize(300,80);
        type.setBounds(10,20,80,25);
        typetext.setBounds(100,20,165,25);
        search.setBounds(10,50,80,25);
        jPanel.add(type);
        jPanel.add(typetext);
        jPanel.add(search);
        ActionListener searchListener = e -> {
            String s = typetext.getText();
            try {
                new CustomerDao().findByType(s);
                JOptionPane.showMessageDialog(jPanel,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                jf.dispose();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        };
        search.addActionListener(searchListener);
        jf.add(jPanel);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
