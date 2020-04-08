package pagera.view.wizard;

import java.awt.Dimension;

import javax.swing.JPanel;

public class WizardPanel extends JPanel {
    public WizardPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception 
    {
        this.setLayout( null );
        this.setSize(new Dimension(540, 408));
    }
}
