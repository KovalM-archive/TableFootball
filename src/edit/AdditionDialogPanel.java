package edit;

import constants.StudentsConst;
import tablemodel.StudentModel;
import tableview.MainPanel;
import tableview.StudentTableView;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public class AdditionDialogPanel extends JPanel {
    private MainPanel mainPanel;
    public AdditionDialogPanel(final MainPanel mainPanel){
        this.mainPanel = mainPanel;
        this.setLayout(new GridBagLayout());

        JLabel enterFirstNameText = new JLabel("Имя:");
        final JTextField enterFirstName = new JTextField("",10);
        JLabel enterSecondNameText = new JLabel("Фамилия:");
        final JTextField enterSecondName = new JTextField("",10);
        JLabel enterThirdNameText = new JLabel("Отчество:");
        final JTextField enterThirdName = new JTextField("",10);
        JLabel enterFootballTeamNameText = new JLabel("Футбольная команда:");
        final JTextField enterFootballTeamName = new JTextField("",10);
        JLabel enterFacultyText = new JLabel("Факультет:");
        final JComboBox<String> enterFaculty = new JComboBox<String>(StudentsConst.FACULTY);
        JLabel enterSquadText = new JLabel("Состав:");
        final JComboBox<Integer> enterSquad = new JComboBox<Integer>(StudentsConst.SQUAD);
        JLabel enterPositionText = new JLabel("Позиция:");
        final JTextField enterPosition = new JTextField("",10);
        JButton enterButton = new JButton("ОК");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentModel currentStudent = new StudentModel();
                currentStudent.setFirstName(enterFirstName.getText());
                currentStudent.setSecondName(enterSecondName.getText());
                currentStudent.setThirdName(enterThirdName.getText());
                currentStudent.setDateBirth(new GregorianCalendar(1995, GregorianCalendar.NOVEMBER, 23));
                currentStudent.setFootballTeamName(enterFootballTeamName.getText());
                currentStudent.setFacultyName((String)enterFaculty.getSelectedItem());
                currentStudent.setSquad(enterSquad.getSelectedIndex()+1);
                String position = enterPosition.getText();
                int weight = 0;
                for (int i=0; i<position.length(); i++){
                    weight = weight*10 + (int)position.charAt(i)-48;
                }
                currentStudent.setPosition(weight);
                mainPanel.getTableView().addStudent(currentStudent);
                mainPanel.getPageWork().getAllRecord().setText(
                        String.valueOf(mainPanel.getTableView().getCountRecord()));
                mainPanel.getPageWork().getAllPage().setText(
                        String.valueOf(mainPanel.getTableView().getNumberPage()));
                enterFirstName.setText("");
                enterSecondName.setText("");
                enterThirdName.setText("");
                enterFootballTeamName.setText("");
                enterFaculty.setSelectedIndex(0);
                enterSquad.setSelectedIndex(0);
                enterPosition.setText("");
            }
        });

        add(enterFirstNameText, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterFirstName,new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterSecondNameText,new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterSecondName,new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterThirdNameText,new GridBagConstraints(0, 4, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterThirdName,new GridBagConstraints(0, 5, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterFootballTeamNameText,new GridBagConstraints(0, 6, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterFootballTeamName,new GridBagConstraints(0, 7, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterFacultyText,new GridBagConstraints(0, 8, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterFaculty,new GridBagConstraints(0, 9, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterSquadText,new GridBagConstraints(0, 10, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterSquad,new GridBagConstraints(0, 11, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterPositionText,new GridBagConstraints(0, 12, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterPosition,new GridBagConstraints(0, 13, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(enterButton,new GridBagConstraints(0, 14, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
    }
}
