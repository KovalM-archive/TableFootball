package file;

import tableview.PageWork;
import tableview.StudentTableView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Михаил on 18.05.2015.
 */
public class GoToFirstPageListener implements ActionListener {
    private PageWork pageWork;

    public GoToFirstPageListener(PageWork pageWork){
        this.pageWork = pageWork;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StudentTableView tableView = pageWork.getTableView();
        tableView.goToPage(1);
        pageWork.getCurrentPageIndex().setText(String.valueOf(1));
    }
}
