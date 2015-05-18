package file;

import tableview.PageWork;
import tableview.StudentTableView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Михаил on 18.05.2015.
 */
public class GoToNextPageListener implements ActionListener {
    private PageWork pageWork;

    public GoToNextPageListener(PageWork pageWork){
        this.pageWork = pageWork;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StudentTableView tableView = pageWork.getTableView();
        int currentPageIndex = tableView.getIndexPage();
        if (currentPageIndex < tableView.getNumberPage()){
            tableView.goToPage(currentPageIndex+1);
            pageWork.getCurrentPageIndex().setText(String.valueOf(currentPageIndex+1));
        }
    }
}
