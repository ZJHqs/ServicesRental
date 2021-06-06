package View.Customer;

import Controller.Customer;
import Controller.Project;
import Model.CustomerDao;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NewProjectView {
    JFrame jf = new JFrame("创建项目");
    JPanel jPanel = new JPanel(null);
    JLabel pid = new JLabel("项目ID:");
    JLabel pname = new JLabel("项目名:");
    JLabel detail = new JLabel("详情:");
    JLabel cid = new JLabel("用户ID:");
    JTextField pidtext = new JTextField();
    JTextField pnametext = new JTextField();
    JTextArea detailtext = new JTextArea();
    JTextField cidtext = new JTextField();
    JButton newProject = new JButton("新建");

    public void init() {
        jf.setSize(400,300);
        pid.setBounds(10,20,80,25);
        pidtext.setBounds(100,20,165,25);
        pname.setBounds(10,50,80,25);
        pnametext.setBounds(100,50,165,25);
        detail.setBounds(10,80,80,25);
        detailtext.setBounds(10,110,165,50);
        cid.setBounds(10,170,80,25);
        cidtext.setBounds(100,170,165,25);
        newProject.setBounds(10,200,80,25);

        Customer customer= Customer.getCustomer();
        cidtext.setText(customer.getCid());
        cidtext.setEditable(false);

        Project project = Project.getProject();
        project.setPid(pidtext.getText());
        ActionListener newProjectListener = e -> {
            try {
                new CustomerDao().addProject(pidtext.getText(), pnametext.getText(),
                        detailtext.getText(),cidtext.getText());
                JOptionPane.showMessageDialog(jPanel,"成功！","提示信息",JOptionPane.PLAIN_MESSAGE);
                jf.dispose();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        };
        newProject.addActionListener(newProjectListener);

        jPanel.add(pid);
        jPanel.add(pname);
        jPanel.add(detail);
        jPanel.add(cid);
        jPanel.add(pidtext);
        jPanel.add(pnametext);
        jPanel.add(detailtext);
        jPanel.add(cidtext);
        jPanel.add(newProject);
        jf.add(jPanel);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
