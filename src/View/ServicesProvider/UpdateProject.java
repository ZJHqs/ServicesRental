package View.ServicesProvider;

import Controller.Customer;
import Controller.ServicesProvider;
import Model.CustomerDao;
import Model.ServicesProviderDao;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UpdateProject {
    JFrame jf = new JFrame("更新项目");
    JPanel jPanel = new JPanel(null);
    JLabel pid = new JLabel("项目ID:");
    JLabel sid = new JLabel("服务商ID:");
    JLabel startTime = new JLabel("开始时间:");
    JTextField pidtext = new JTextField();
    JTextField sidtext = new JTextField();
    JTextArea startTimetext = new JTextArea();
    JButton update = new JButton("修改");

    public void init() {
        jf.setSize(400, 300);
        pid.setBounds(10, 20, 80, 25);
        pidtext.setBounds(100, 20, 165, 25);
        sid.setBounds(10, 50, 80, 25);
        sidtext.setBounds(100, 50, 165, 25);
        startTime.setBounds(10, 80, 80, 25);
        startTimetext.setBounds(10, 110, 165, 50);
        update.setBounds(10, 200, 80, 25);

        ServicesProvider servicesProvider = ServicesProvider.getServicesProvider();
        sidtext.setText(servicesProvider.getSid());
        pidtext.setText("001");
        pidtext.setEditable(false);
        sidtext.setEditable(false);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        startTimetext.setText(dateFormat.format(c.getTime()));
        startTimetext.setEditable(false);
        Date date = new Date(c.get(Calendar.YEAR) - 1900, c.get(Calendar.MONTH), c.get(Calendar.DATE));
        ActionListener updateListener = e -> {
            try {
                new ServicesProviderDao().updateProject(pidtext.getText(), sidtext.getText(), date);
                JOptionPane.showMessageDialog(jPanel, "成功！", "提示信息", JOptionPane.PLAIN_MESSAGE);
                jf.dispose();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        update.addActionListener(updateListener);
        jPanel.add(pid);
        jPanel.add(sid);
        jPanel.add(startTime);
        jPanel.add(pidtext);
        jPanel.add(sidtext);
        jPanel.add(startTimetext);
        jPanel.add(update);
        jf.add(jPanel);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
