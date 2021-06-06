package View.Customer;

import Controller.Customer;
import Model.CustomerDao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMainView {
    JFrame jFrame=new JFrame("服务出租系统-客户端");
    JMenuBar mb=new JMenuBar();
    JMenu information=new JMenu("个人信息");
    JMenu services = new JMenu("服务商查询");
    JMenu project = new JMenu("项目管理");
    JMenuItem viewInformation=new JMenuItem("查看个人信息");
    JMenuItem updateInformation=new JMenuItem("修改个人信息");
    JMenuItem viewServicesProvider=new JMenuItem("查看全部服务商");
    JMenuItem viewByType = new JMenuItem("通过类别查询服务商");
    JMenuItem newProject =new JMenuItem("新建项目");
    JMenuItem updateProject =new JMenuItem("项目管理");

    public void init() {
        jFrame.setSize(400,300);
        information.add(viewInformation);
        information.add(updateInformation);
        services.add(viewServicesProvider);
        services.add(viewByType);
        project.add(newProject);
        project.add(updateProject);
        mb.add(information);
        mb.add(services);
        mb.add(project);
        jFrame.setJMenuBar(mb);
        ActionListener viveInformationListener = e -> {
            try {
                Customer customer = Customer.getCustomer();
                new CustomerDao().showInformation(customer.getCid());
                new ShowInformationView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        viewInformation.addActionListener(viveInformationListener);
        ActionListener updateInformationListener= e -> {
            try {
                Customer customer = Customer.getCustomer();
                new CustomerDao().showInformation(customer.getCid());
                new UpdateInformationView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        updateInformation.addActionListener(updateInformationListener);
        ActionListener viewServicesProviderListener = e -> {
            try {
                new ShowServicesProviderView().init();;
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        };
        viewServicesProvider.addActionListener(viewServicesProviderListener);
        ActionListener viewByTypeListener = e -> {
            try {
                new SearchByType().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        viewByType.addActionListener(viewByTypeListener);
        ActionListener addProjectListener = e -> {
            try {
                new NewProjectView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        newProject.addActionListener(addProjectListener);
        ActionListener updateProjectListener = e -> {
            try {
                new UpdateProjectView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        updateProject.addActionListener(updateProjectListener);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
