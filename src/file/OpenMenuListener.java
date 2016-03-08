package file;

import chooser.FileChooser;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenMenuListener implements ActionListener {
    private JTabbedPane tableTab;
    private JToolBar jtbMain;
    private JFileChooser jFileChooser;

    public OpenMenuListener(JTabbedPane tableTab,JToolBar jtbMain){
        this.tableTab = tableTab;
        this.jtbMain = jtbMain;
        jFileChooser = new JFileChooser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileChooser chooser = new FileChooser(System.getProperty("user.dir"));
        chooser.showOpenDialog(null);
        if (chooser.isSelectedFlag()) {
            if (chooser.getSelectedFile().getName().contains(".xml")) {
                jtbMain.setVisible(true);
                //jtpVkladka.setTitleAt(jtpVkladka.getSelectedIndex(), jFileChooser.getSelectedFile().getName());
                new XMLFile(chooser.getSelectedFile().getPath(), tableTab).readFile(chooser.getSelectedFile().getName());
            }
        }
    }
}
