package file;

import chooser.FileChooser;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveMenuListener implements ActionListener {
    private JTabbedPane tableTab;
    private JFileChooser jFileChooser;

    public SaveMenuListener(JTabbedPane tableTab) {
        this.tableTab = tableTab;
        jFileChooser = new JFileChooser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileChooser chooser = new FileChooser();
        chooser.showSaveDialog(null);
        if (chooser.isSelectedFlag()){
            try {
                new XMLFile(chooser.getSelectedFile().getPath(), tableTab).writeFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (TransformerException e1) {
                e1.printStackTrace();
            } catch (ParserConfigurationException e1) {
                e1.printStackTrace();
            }
        }
    }
}
