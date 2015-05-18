package tablemodel;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {
    private List<StudentModel> studentList;
    private List<StudentModel> studentListBuffer;
    private int numberPage;
    private int numberRecordsOnPage;
    private int indexPage;

    public StudentTableModel(){
        studentList = new ArrayList<StudentModel>();
        numberRecordsOnPage = 1;
        indexPage = 1;
        calculateNumberPage();
        goToPage(1);
    }

    public int getCountRecord(){
        return studentList.size();
    }

    public void addStudent(StudentModel currentStudent){
        studentList.add(currentStudent);
        goToPage(indexPage);
        calculateNumberPage();
    }

    @Override
    public int getRowCount() {
        return studentListBuffer.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex != 0){
            return studentListBuffer.get(rowIndex).getField(columnIndex);
        } else {
            return numberRecordsOnPage*(indexPage-1)+rowIndex+1;
        }
    }

    @Override
    public String getColumnName(int column) {
        String columnName[] ={
            "№",
            "ФИО студента",
            "Дата рождения",
            "Футбольная команда",
            "Факультет",
            "Состав",
            "Позиция"
        };
        return columnName[column];
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public int getNumberRecordsOnPage() {
        return numberRecordsOnPage;
    }

    public void setNumberRecordsOnPage(int numberRecordsOnPage) {
        this.numberRecordsOnPage = numberRecordsOnPage;
        calculateNumberPage();
    }

    private void calculateNumberPage(){
        int x = 0;
        while (x*numberRecordsOnPage < studentList.size()) {
            x++;
        }
        numberPage = x;
    }

    public int getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(int indexPage) {
        this.indexPage = indexPage;
    }

    public void goToPage(int newPageNumber){
        studentListBuffer = new ArrayList<StudentModel>();
        if (newPageNumber <= numberPage){
            int l = numberRecordsOnPage*(newPageNumber-1);
            int r = l + numberRecordsOnPage;
            for (int i = l+1; i <=r; i++) {
                if (i > studentList.size()){
                    break;
                }
                studentListBuffer.add(studentList.get(i-1));
            }
            indexPage = newPageNumber;
        }
    }
}
