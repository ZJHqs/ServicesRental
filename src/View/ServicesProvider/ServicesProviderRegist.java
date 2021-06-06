package View.ServicesProvider;

import Model.CustomerDao;
import Model.ServicesProviderDao;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ServicesProviderRegist {
    private JPanel jp;
    private JLabel sid, sname, password, phone, type;
    private JTextField idtext, nametext, phonetext, typetext;
    private JPasswordField passwordtext;
    private JButton regist;

    public void init() {
        JFrame jf = new JFrame("注册界面");
        jp = new JPanel(null);
        sid = new JLabel("用户名:");
        sname = new JLabel("用户昵称:");
        password = new JLabel("用户密码:");
        phone = new JLabel("联系电话:");
        type = new JLabel("类别:");
        idtext = new JTextField(20);
        nametext = new JTextField(20);
        passwordtext = new JPasswordField(20);
        phonetext = new JTextField(20);
        typetext = new JTextField(20);
        regist = new JButton("注册");
        jf.setSize(300, 240);
        sid.setBounds(10, 20, 80, 25);
        idtext.setBounds(100, 20, 165, 25);
        sname.setBounds(10, 50, 80, 25);
        nametext.setBounds(100, 50, 165, 25);
        password.setBounds(10, 80, 80, 25);
        passwordtext.setBounds(100, 80, 165, 25);
        phone.setBounds(10, 110, 80, 25);
        phonetext.setBounds(100, 110, 165, 25);
        type.setBounds(10, 140, 80, 25);
        typetext.setBounds(100, 140, 165, 25);
        regist.setBounds(10, 170, 80, 25);

        jp.add(sid);
        jp.add(idtext);
        jp.add(sname);
        jp.add(nametext);
        jp.add(password);
        jp.add(passwordtext);
        jp.add(phone);
        jp.add(phonetext);
        jp.add(type);
        jp.add(typetext);
        jp.add(regist);
        jf.add(jp);

        ActionListener registListener = e -> {
            try {
                String s1 = idtext.getText();
                String s2 = nametext.getText();
                String s3 = passwordtext.getText();
                String s4 = phonetext.getText();
                String s5 = typetext.getText();
                if (new ServicesProviderDao().registeredServicesProvider(s1, s2, s3, s4, s5)) {
                    JOptionPane.showMessageDialog(jp, "成功！", "提示信息", JOptionPane.PLAIN_MESSAGE);
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
