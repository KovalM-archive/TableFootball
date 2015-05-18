package edit;

import javax.swing.JTabbedPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionListener implements ActionListener {
    JTabbedPane tableTab;
    public AdditionListener(JTabbedPane tableTab){
        this.tableTab = tableTab;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Addition")){

        }
    }
}
