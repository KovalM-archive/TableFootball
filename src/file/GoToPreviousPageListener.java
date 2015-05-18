package file;

import tableview.PageWork;
import tableview.StudentTableView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoToPreviousPageListener implements ActionListener {
    private PageWork pageWork;

    public GoToPreviousPageListener(PageWork pageWork){
        this.pageWork = pageWork;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StudentTableView tableView = pageWork.getTableView();
        int currentPageIndex = tableView.getIndexPage();
        if (currentPageIndex > 1){
            tableView.goToPage(currentPageIndex-1);
            pageWork.getCurrentPageIndex().setText(String.valueOf(currentPageIndex-1));
        }
    }
}
