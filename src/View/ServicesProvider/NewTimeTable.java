package View.ServicesProvider;

import Controller.ServicesProvider;
import Model.ServicesProviderDao;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NewTimeTable {

    public void init() {
        JFrame jf = new JFrame("创建时间表");
        JPanel jp = new JPanel(null);
        JLabel sid = new JLabel("用户名:");
        JLabel time = new JLabel("时间表:");
        JLabel tid = new JLabel("时间表ID：");
        JTextField sidtext = new JTextField(20);
        JTextField timetext = new JTextField(20);
        JTextField tidtext = new JTextField(20);
        JButton create = new JButton("创建");
        jf.setSize(300, 240);
        sid.setBounds(10, 20, 80, 25);
        sidtext.setBounds(100, 20, 165, 25);
        time.setBounds(10, 50, 80, 25);
        timetext.setBounds(100, 50, 165, 25);
        tid.setBounds(10, 80, 80, 25);
        tidtext.setBounds(100, 80, 165, 25);
        create.setBounds(10, 170, 80, 25);

        jp.add(sid);
        jp.add(sidtext);
        jp.add(time);
        jp.add(timetext);
        jp.add(tid);
        jp.add(tidtext);
        jp.add(create);
        jf.add(jp);
        ServicesProvider servicesProvider = ServicesProvider.getServicesProvider();
        sidtext.setText(servicesProvider.getSid());
        sidtext.setEditable(false);

        ActionListener registListener = e -> {
            try {
                String s1 = sidtext.getText();
                String s2 = timetext.getText();
                String s3 = tidtext.getText();
                if (new ServicesProviderDao().createTimeTable(s3,s2,s1)) {
                    JOptionPane.showMessageDialog(jp, "成功！", "提示信息", JOptionPane.PLAIN_MESSAGE);
                    jf.dispose();
                }

            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        };
        create.addActionListener(registListener);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
