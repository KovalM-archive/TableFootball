package edit;

import tableview.MainPanel;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionListener implements ActionListener {
    JTabbedPane tableTab;
    JFrame mainWindow;
    JDialog additionStudentFrame;
    public AdditionListener(JFrame mainWindow,JTabbedPane tableTab){
        this.mainWindow = mainWindow;
        this.tableTab = tableTab;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Addition")){
            MainPanel mainPanel = (MainPanel)tableTab.getSelectedComponent();
            additionStudentFrame = new JDialog(mainWindow,"Addition of student",false);
            additionStudentFrame.setSize(400, 400);
            additionStudentFrame.setLocationRelativeTo(mainPanel);
            additionStudentFrame.setVisible(true);
            additionStudentFrame.setLayout(new BorderLayout());

            AdditionDialogPanel additionDialogPanel = new AdditionDialogPanel(mainPanel);
            additionStudentFrame.add(additionDialogPanel,BorderLayout.NORTH);
        }
    }
}
