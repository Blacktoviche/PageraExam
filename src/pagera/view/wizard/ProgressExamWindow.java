package pagera.view.wizard;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JWindow;

public class ProgressExamWindow extends JFrame
{
    
    public ProgressExamWindow(ProgressPanel panel)
    {
       
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          Dimension frameSize = new Dimension(340, 150);
          if (frameSize.height > screenSize.height)
          {
            frameSize.height = screenSize.height;
          }
          if (frameSize.width > screenSize.width)
          {
            frameSize.width = screenSize.width;
          }
          setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
          
       getContentPane().add(panel);
       setSize(new Dimension(340, 150));
       setVisible(true);
       validate();
    }
}
