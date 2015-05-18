package file;

//import tablemodel.TableModel;
//import tableview.TableView;

import constants.PageConst;
import tablemodel.StudentModel;
import tablemodel.StudentTableModel;
import tableview.MainPanel;
import tableview.PageWork;
import tableview.StudentTableView;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.text.TabableView;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class NewTableListener implements ActionListener {
    JTabbedPane tableTab;
    JToolBar jtbMain;

    public NewTableListener(JTabbedPane tableTab,JToolBar jtbMain){
        this.tableTab = tableTab;
        this.jtbMain = jtbMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("New table")){
          jtbMain.setVisible(true);
          StudentTableModel tableModel = new StudentTableModel(new ArrayList<StudentModel>());
          StudentTableView tableView = new StudentTableView(tableModel);
          PageWork pageWork = new PageWork(tableView);
          MainPanel mainPage = new MainPanel(tableView,pageWork);
          mainPage.setLayout(new BorderLayout());
          JScrollPane scrollpane = new JScrollPane(tableView);
          mainPage.add(scrollpane, BorderLayout.CENTER);
          mainPage.add(pageWork, BorderLayout.SOUTH);
          tableTab.add("No name",mainPage);
          tableTab.setSelectedComponent(mainPage);
      }
    }
}
