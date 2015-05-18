package tableview;

import tablemodel.StudentTableModel;

import javax.swing.JTable;

public class StudentTableView extends JTable {
    StudentTableModel tableModel;

    public StudentTableView(StudentTableModel tableModel){
        super(tableModel);
        this.tableModel = tableModel;
    }

    public int getCountRecords(){
        return tableModel.getCountRecord();
    }

    public int getNumberPage(){
        return tableModel.getNumberPage();
    }

    public void setNumberRecordsOnPage(int newNumber){
        tableModel.setNumberRecordsOnPage(newNumber);
    }

    public void goToPage(int newPageNumber){
        tableModel.goToPage(newPageNumber);
    }
}
