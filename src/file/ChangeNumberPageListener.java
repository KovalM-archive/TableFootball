package file;

import tablemodel.StudentTableModel;
import tableview.StudentTableView;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeNumberPageListener implements ActionListener {
    private StudentTableView tableView;
    private JComboBox<Integer> numberPage;
    private JLabel allPage;

    public ChangeNumberPageListener(JComboBox<Integer> numberPage, StudentTableView tableView,JLabel allPage){
        this.tableView = tableView;
        this.numberPage = numberPage;
        this.allPage = allPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tableView.setNumberRecordsOnPage(numberPage.getSelectedIndex()+1);
        tableView.goToPage(1);
        allPage.setText(String.valueOf(tableView.getNumberPage()));
    }
}
