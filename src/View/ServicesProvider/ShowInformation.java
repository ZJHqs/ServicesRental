package View.ServicesProvider;

import Controller.Customer;
import Controller.ServicesProvider;

import javax.swing.*;

public class ShowInformation {
    JFrame jFrame=new JFrame("查看个人信息");
    JPanel jPanel=new JPanel(null);
    JLabel sid=new JLabel("用户名:");
    JLabel sname=new JLabel("用户昵称:");
    JLabel password=new JLabel("密码:");
    JLabel phone=new JLabel("联系电话:");
    JLabel type = new JLabel("类型:");
    JTextField idtext=new JTextField(20);
    JTextField nametext=new JTextField(20);
    JTextField passwordtext=new JPasswordField(20);
    JTextField phonetext=new JTextField(20);
    JTextField typetext = new JTextField(20);

    public void init() {
        jFrame.setSize(400,300);
        sid.setBounds(10,20,80,25);
        idtext.setBounds(100,20,165,25);
        sname.setBounds(10,50,80,25);
        nametext.setBounds(100,50,165,25);
        password.setBounds(10,80,80,25);
        passwordtext.setBounds(100,80,165,25);
        phone.setBounds(10,110,80,25);
        phonetext.setBounds(100,110,165,25);
        type.setBounds(10,140,80,25);
        typetext.setBounds(100,140,165,25);

        ServicesProvider servicesProvider = ServicesProvider.getServicesProvider();
        idtext.setText(servicesProvider.getSid());
        nametext.setText(servicesProvider.getSname());
        passwordtext.setText(servicesProvider.getPassword());
        phonetext.setText(servicesProvider.getPhone());
        typetext.setText(servicesProvider.getType());
        idtext.setEditable(false);
        nametext.setEditable(false);
        passwordtext.setEditable(false);
        phonetext.setEditable(false);
        typetext.setEditable(false);
        jPanel.add(sid);
        jPanel.add(idtext);
        jPanel.add(sname);
        jPanel.add(nametext);
        jPanel.add(password);
        jPanel.add(passwordtext);
        jPanel.add(phone);
        jPanel.add(phonetext);
        jPanel.add(type);
        jPanel.add(typetext);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
