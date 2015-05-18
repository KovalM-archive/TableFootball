package tableview;

import tablemodel.StudentModel;
import tablemodel.StudentTableModel;

import javax.swing.JTable;
import java.util.ArrayList;
import java.util.List;

public class StudentTableView extends JTable {
    StudentTableModel tableModel;
    private List<StudentModel> studentList;
    private int numberPage;

    public StudentTableView(StudentTableModel tableModel){
        super(tableModel);
        this.tableModel = tableModel;
        studentList = new ArrayList<StudentModel>();
        tableModel.setNumberRecordsOnPage(1);
        tableModel.setIndexPage(1);
        calculateNumberPage();
        goToPage(1);
    }

    public int getNumberPage() {
        calculateNumberPage();
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public void setNumberRecordsOnPage(int newNumber){
        tableModel.setNumberRecordsOnPage(newNumber);
    }

    public int getIndexPage() {
        return tableModel.getIndexPage();
    }

    public void goToPage(int newPageIndex){
        if (newPageIndex <= numberPage){
            List<StudentModel> studentListBuffer = new ArrayList<StudentModel>();

            int l = tableModel.getNumberRecordsOnPage()*(newPageIndex-1);
            int r = l + tableModel.getNumberRecordsOnPage();
            for (int i = l+1; i <=r; i++) {
                if (i > studentList.size()){
                    break;
                }
                studentListBuffer.add(studentList.get(i-1));
            }
            StudentTableModel newTableModel = new StudentTableModel(studentListBuffer);
            newTableModel.setIndexPage(newPageIndex);
            newTableModel.setNumberRecordsOnPage(tableModel.getNumberRecordsOnPage());
            tableModel = newTableModel;
            this.setModel(newTableModel);
        }
    }

    public int getCountRecord(){
        return studentList.size();
    }

    private void calculateNumberPage(){
        int x = 0;
        int numberRecordsOnPage = tableModel.getNumberRecordsOnPage();
        while (x*numberRecordsOnPage < studentList.size()) {
            x++;
        }
        numberPage = x;
    }

    public void addStudent(StudentModel currentStudent){
        studentList.add(currentStudent);
        calculateNumberPage();
        goToPage(tableModel.getIndexPage());
    }

    public void setStudentList(List<StudentModel> studentList){
        this.studentList = studentList;
    }

    public List<StudentModel> getStudentList(){
        return studentList;
    }
}
