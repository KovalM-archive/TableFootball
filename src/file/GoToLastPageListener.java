package file;

import tableview.PageWork;
import tableview.StudentTableView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoToLastPageListener implements ActionListener {
    private PageWork pageWork;

    public GoToLastPageListener(PageWork pageWork){
        this.pageWork = pageWork;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StudentTableView tableView = pageWork.getTableView();
        tableView.goToPage(tableView.getNumberPage());
        pageWork.getCurrentPageIndex().setText(String.valueOf(tableView.getNumberPage()));
    }
}
