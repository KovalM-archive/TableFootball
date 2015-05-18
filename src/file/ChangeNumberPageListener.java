package file;

import tableview.PageWork;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeNumberPageListener implements ActionListener {
    private PageWork pageWork;

    public ChangeNumberPageListener(PageWork pageWork){
        this.pageWork = pageWork;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pageWork.getTableView().setNumberRecordsOnPage(pageWork.getNumberPage().getSelectedIndex()+1);
        pageWork.getTableView().goToPage(1);
        pageWork.getAllPage().setText(String.valueOf(pageWork.getTableView().getNumberPage()));
        pageWork.getCurrentPageIndex().setText(String.valueOf(pageWork.getTableView().getIndexPage()));
    }
}
