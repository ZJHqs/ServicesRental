package View.Customer;

import Controller.Customer;
import Model.CustomerDao;

import javax.swing.*;
import java.awt.event.ActionListener;

public class UpdateInformationView {
    JFrame jFrame=new JFrame("修改个人信息");
    JPanel jPanel=new JPanel(null);
    JLabel cid=new JLabel("用户名:");
    JLabel cname=new JLabel("用户昵称:");
    JLabel password=new JLabel("密码:");
    JLabel phone=new JLabel("联系电话:");
    JTextField idtext=new JTextField(20);
    JTextField nametext=new JTextField(20);
    JTextField passwordtext=new JPasswordField(20);
    JTextField phonetext=new JTextField(20);
    JButton update=new JButton("修改");
    public void init() {
        jFrame.setSize(400,300);
        cid.setBounds(10,20,80,25);
        idtext.setBounds(100,20,165,25);
        cname.setBounds(10,50,80,25);
        nametext.setBounds(100,50,165,25);
        password.setBounds(10,80,80,25);
        passwordtext.setBounds(100,80,165,25);
        phone.setBounds(10,110,80,25);
        phonetext.setBounds(100,110,165,25);
        update.setBounds(10,200,80,25);
        Customer customer = Customer.getCustomer();
        idtext.setText(customer.getCid());
        nametext.setText(customer.getCnmae());
        passwordtext.setText(customer.getPassword());
        phonetext.setText(customer.getPhone());
        idtext.setEditable(false);

        ActionListener updateListener = e -> {
            try {
                new CustomerDao().updateCustomer(idtext.getText(),nametext.getText(),
                        passwordtext.getText(),phonetext.getText());
                new ShowInformationView().init();
                JOptionPane.showMessageDialog(jPanel,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                jFrame.dispose();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        update.addActionListener(updateListener);
        jPanel.add(cid);
        jPanel.add(idtext);
        jPanel.add(cname);
        jPanel.add(nametext);
        jPanel.add(password);
        jPanel.add(passwordtext);
        jPanel.add(phone);
        jPanel.add(phonetext);
        jPanel.add(update);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
