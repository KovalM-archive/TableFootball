package file;

//import tablemodel.TableModel;
//import tableview.TableView;

import tablemodel.StudentModel;
import tableview.StudentTableModel;
import tableview.TablePanel;
import tableview.ChangeTablePanel;
import tableview.StudentTableView;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
          ChangeTablePanel changeTablePanel = new ChangeTablePanel(tableView);
          TablePanel mainPage = new TablePanel(tableView, changeTablePanel);
          mainPage.setLayout(new BorderLayout());
          JScrollPane scrollpane = new JScrollPane(tableView);
          mainPage.add(scrollpane, BorderLayout.CENTER);
          mainPage.add(changeTablePanel, BorderLayout.SOUTH);
          tableTab.add("No name",mainPage);
          tableTab.setSelectedComponent(mainPage);
      }
    }
}
