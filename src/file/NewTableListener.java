package file;

//import tablemodel.TableModel;
//import tableview.TableView;

import constants.PageConst;
import tablemodel.StudentModel;
import tablemodel.StudentTableModel;
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
          StudentTableModel tableModel = new StudentTableModel();
          for (int i = 0; i < 10; i++) {
              StudentModel currentStudent = new StudentModel();
              currentStudent.setFirstName("Misha");
              currentStudent.setSecondName("Kovalev");
              currentStudent.setThirdName("Vladimirivich");
              currentStudent.setDateBirth(new GregorianCalendar(1995, GregorianCalendar.NOVEMBER, 23));
              currentStudent.setFootballTeamName("GT");
              currentStudent.setFacultyName("FITU");
              currentStudent.setSquad(1);
              currentStudent.setPosition(1);
              tableModel.addStudent(currentStudent);
          }

          StudentTableView tableView = new StudentTableView(tableModel);
          JScrollPane scrollpane = new JScrollPane(tableView);

          JPanel mainPage = new JPanel(new BorderLayout());
          mainPage.add(scrollpane, BorderLayout.CENTER);

          JPanel pageWork = new JPanel(new FlowLayout());
          JToolBar jtbPage = new JToolBar("Work with page", JToolBar.HORIZONTAL);
          ImageIcon imFirst = new ImageIcon(PageConst.FIRST_TOOLBAR_PAGE);
          ImageIcon imPrevious = new ImageIcon(PageConst.PREVIOUS_TOOLBAR_PAGE);
          ImageIcon imNext = new ImageIcon(PageConst.NEXT_TOOLBAR_PAGE);
          ImageIcon imLast = new ImageIcon(PageConst.LAST_TOOLBAR_PAGE);

          JButton jbFirst = new JButton(imFirst);
          jbFirst.setActionCommand("First page");
          JButton jbPrevious = new JButton(imPrevious);
          jbPrevious.setActionCommand("Previous page");
          JButton jbNext = new JButton(imNext);
          jbNext.setActionCommand("Next page");
          JButton jbLast = new JButton(imLast);
          jbLast.setActionCommand("Last page");

          jtbPage.add(jbFirst);
          jtbPage.add(jbPrevious);
          jtbPage.add(jbNext);
          jtbPage.add(jbLast);
          jtbPage.setFloatable(false);
          pageWork.add(jtbPage);

          JComboBox<Integer> numberPage = new JComboBox<Integer>(PageConst.NUMBER_PAGE);
          pageWork.add(numberPage);

          JLabel allPageText = new JLabel("Всего страниц: ");
          JLabel allPage = new JLabel(String.valueOf(tableView.getNumberPage()));
          JLabel allRecordText = new JLabel("Всего записей: ");
          JLabel allRecord = new JLabel(String.valueOf(tableView.getCountRecords()));

          pageWork.add(allPageText);
          pageWork.add(allPage);
          pageWork.add(allRecordText);
          pageWork.add(allRecord);
          numberPage.addActionListener(new ChangeNumberPageListener(numberPage,tableView,allPage));

          mainPage.add(pageWork,BorderLayout.SOUTH);
          tableTab.add("No name",mainPage);
          tableTab.setSelectedComponent(mainPage);
      }
    }
}
