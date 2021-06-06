package View.ServicesProvider;

import Controller.ServicesProvider;
import Model.ServicesProviderDao;
import View.Customer.NewProjectView;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ServicesProviderMainView {
    JFrame jFrame=new JFrame("服务出租系统-服务商端");
    JMenuBar mb=new JMenuBar();
    JMenu information=new JMenu("个人信息");
    JMenu project = new JMenu("项目管理");
    JMenuItem viewInformation=new JMenuItem("查看个人信息");
    JMenuItem updateInformation=new JMenuItem("修改个人信息");
    JMenuItem updateProject =new JMenuItem("项目管理");
    JMenu timeTable = new JMenu("时间表管理");
    JMenuItem addTimeTable = new JMenuItem("新建时间表");
    JMenuItem updateTimeTable = new JMenuItem("修改时间表");

    public void init() {
        jFrame.setSize(400,300);
        information.add(viewInformation);
        information.add(updateInformation);
        project.add(updateProject);
        timeTable.add(addTimeTable);
        timeTable.add(updateTimeTable);

        mb.add(information);
        mb.add(project);
        mb.add(timeTable);
        jFrame.setJMenuBar(mb);

        ActionListener viewInformationListener = e -> {
            try {
                ServicesProvider servicesProvider = ServicesProvider.getServicesProvider();
                new ServicesProviderDao().showInformation(servicesProvider.getSid());
                new ShowInformation().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        viewInformation.addActionListener(viewInformationListener);
        ActionListener updateProjectListener = e -> {
            try {
                new UpdateProject().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        updateProject.addActionListener(updateProjectListener);
        ActionListener createTimeTableListener = e -> {
            try {
                new NewTimeTable().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        addTimeTable.addActionListener(createTimeTableListener);



        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
