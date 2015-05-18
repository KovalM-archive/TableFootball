package tableview;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.xml.bind.JAXBPermission;
import java.awt.BorderLayout;

public class MainPanel extends JPanel {
    private StudentTableView tableView;
    private PageWork pageWork;
    public MainPanel(StudentTableView tableView,PageWork pageWork){
        this.tableView = tableView;
        this.pageWork = pageWork;
    }

    public StudentTableView getTableView() {
        return tableView;
    }

    public PageWork getPageWork() {
        return pageWork;
    }
}
