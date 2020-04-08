package pagera.frames;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import pagera.view.PEPanel;
import pagera.view.PageraExam;

public class PEFrame extends JFrame {
    
    private PEPanel pe = new PEPanel();
    
    public PEFrame()
    {
        super("Pagera Exam v 2.0");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          Dimension frameSize = new Dimension(531, 360);
          if (frameSize.height > screenSize.height)
          {
            frameSize.height = screenSize.height;
          }
          if (frameSize.width > screenSize.width)
          {
            frameSize.width = screenSize.width;
          }
          setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
         
        setResizable(false); 
        getContentPane().add(pe);
        setSize( new Dimension(531, 360) );
        setVisible(true);
    }
}
