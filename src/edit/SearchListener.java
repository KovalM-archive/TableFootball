package edit;

import tablemodel.StudentModel;
import tablemodel.StudentTableModel;
import tableview.MainPanel;
import tableview.PageWork;
import tableview.StudentTableView;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchListener implements ActionListener {
    JTabbedPane tableTab;
    JFrame mainWindow;
    JDialog searchStudentFrame;

    public SearchListener(JFrame mainWindow,JTabbedPane tableTab){
        this.mainWindow = mainWindow;
        this.tableTab = tableTab;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")){
            //MainPanel mainPanel = (MainPanel)tableTab.getSelectedComponent();
            searchStudentFrame = new JDialog(mainWindow,"Search student",false);
            searchStudentFrame.setSize(400, 500);
            searchStudentFrame.setLocationRelativeTo(mainWindow);
            searchStudentFrame.setVisible(true);
            searchStudentFrame.setLayout(new GridBagLayout());

            StudentTableModel tableModel = new StudentTableModel(new ArrayList<StudentModel>());
            StudentTableView tableView = new StudentTableView(tableModel);
            PageWork pageWork = new PageWork(tableView);
            MainPanel mainPage = new MainPanel(tableView,pageWork);

            mainPage.setLayout(new GridBagLayout());
            JScrollPane scrollpane = new JScrollPane(tableView);
            mainPage.add(scrollpane, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                    GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                    1, 1, 1, 1), 0, 0) );
            mainPage.add(pageWork, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                    GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                    1, 1, 1, 1), 0, 0));

            searchStudentFrame.add(mainPage,new GridBagConstraints(0, 3, 1, 1, 0, 0,
                    GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                    1, 1, 1, 1), 0, 0));
        }
    }
}
