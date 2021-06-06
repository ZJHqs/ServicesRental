package View.Customer;

import Model.CustomerDao;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CustomerRegist {
    private JPanel jp;
    private JLabel cid,cname,password,phone;
    private JTextField idtext,nametext,phonetext;
    private JPasswordField passwordtext;
    private JButton regist;
    public void init() {
        JFrame jf=new JFrame("客户注册界面");
        jp=new JPanel(null);
        cid=new JLabel("用户名:");
        cname=new JLabel("用户昵称:");
        password=new JLabel("用户密码:");
        phone = new JLabel("电话号：");
        idtext=new JTextField(20);
        nametext=new JTextField(20);
        passwordtext=new JPasswordField(20);
        phonetext=new JTextField(20);
        regist=new JButton("注册");
        jf.setSize(300,240);
        cid.setBounds(10,20,80,25);
        idtext.setBounds(100,20,165,25);
        cname.setBounds(10,50,80,25);
        nametext.setBounds(100,50,165,25);
        password.setBounds(10,80,80,25);
        passwordtext.setBounds(100,80,165,25);
        phone.setBounds(10,110,80,25);
        phonetext.setBounds(100,110,165,25);
        regist.setBounds(10,170,80,25);

        jp.add(cid);
        jp.add(idtext);
        jp.add(cname);
        jp.add(nametext);
        jp.add(password);
        jp.add(passwordtext);
        jp.add(phone);
        jp.add(phonetext);
        jp.add(regist);
        jf.add(jp);
        ActionListener registListener= e -> {
            try {
                String s1=idtext.getText();
                String s2=nametext.getText();
                String s3=passwordtext.getText();
                String s4=phonetext.getText();
                if (new CustomerDao().registeredCustomer(s1,s2,s3,s4)){
                    JOptionPane.showMessageDialog(jp,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                    jf.dispose();
                }

            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        };
        regist.addActionListener(registListener);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
