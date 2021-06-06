import Controller.Customer;
import Controller.Manager;
import Controller.ServicesProvider;
import Model.CustomerDao;
import Model.ManagerDao;
import Model.ServicesProviderDao;
import View.Customer.CustomerMainView;
import View.Customer.CustomerRegist;
import View.Manager.ManagerMainView;
import View.ServicesProvider.ServicesProviderMainView;
import View.ServicesProvider.ServicesProviderRegist;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView {
    public void init() {
        JFrame jf =new JFrame("登录界面");
        jf.setSize(350,200);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jPanel=new JPanel();
        jf.add(jPanel);
        jPanel.setLayout(null);
        JLabel user=new JLabel("Id:");
        user.setBounds(10,20,80,25);
        jPanel.add(user);
        JTextField userText=new JTextField(20);
        userText.setBounds(100,20,165,25);
        jPanel.add(userText);
        JLabel password=new JLabel("Password:");
        password.setBounds(10,50,80,25);
        jPanel.add(password);
        JPasswordField passwordText=new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        jPanel.add(passwordText);
        JButton login=new JButton("login");
        login.setBounds(10,80,80,25);
        jPanel.add(login);
        JButton regist=new JButton("regist");
        regist.setBounds(10,110,80,25);
        jPanel.add(regist);

        JRadioButton customer=new JRadioButton("客户",true);
        customer.setBounds(100,80,100,25);
        JRadioButton manager=new JRadioButton("管理员",false);
        manager.setBounds(200,80,100,25);
        JRadioButton servicesProvider = new JRadioButton("服务商",false);
        servicesProvider.setBounds(100, 110,100,25);
        ButtonGroup bg = new ButtonGroup();
        bg.add(customer);
        bg.add(manager);
        bg.add(servicesProvider);
        jPanel.add(customer);
        jPanel.add(manager);
        jPanel.add(servicesProvider);

        ActionListener loginListener= e -> {
            try {
                String s1=userText.getText();
                String s2=passwordText.getText();
                //Customer登录成功
                if (new CustomerDao().loginFrame(s1,s2)&&customer.isSelected()){
                    JOptionPane.showMessageDialog(jPanel,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                    jf.dispose();
                    Customer customer1 = Customer.getCustomer();
                    customer1.setCid(s1);
                    new CustomerMainView().init();
                }
                //Manager登录成功
                else if (new ManagerDao().loginFrame(s1,s2)&&manager.isSelected()){
                    JOptionPane.showMessageDialog(jPanel,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                    jf.dispose();
                    Manager manager1 =Manager.getManager();
                    manager1.setId(s1);
                    //System.out.println(r1.getId());
                    new ServicesProviderMainView().init();
                }
                else if(new ServicesProviderDao().loginFrame(s1,s2) && servicesProvider.isSelected()) {
                    JOptionPane.showMessageDialog(jPanel,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                    jf.dispose();
                    ServicesProvider servicesProvider1 = ServicesProvider.getServicesProvider();
                    servicesProvider1.setSid(s1);
                    new ServicesProviderMainView().init();
                }
                //登录失败
                else {
                    JOptionPane.showMessageDialog(jPanel,"失败！","提示信息",JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        login.addActionListener(loginListener);

        ActionListener registListener = e -> {
            try {
                if(customer.isSelected()) {
                    new CustomerRegist().init();
                }
                else if(servicesProvider.isSelected()) {
                    new ServicesProviderRegist().init();
                }
            }catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        regist.addActionListener(registListener);

        jf.setVisible(true);
    }
    public static void main(String [] args) {
        new LoginView().init();
    }
}
