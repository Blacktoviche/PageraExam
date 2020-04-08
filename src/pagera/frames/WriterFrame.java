package pagera.frames;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import pagera.view.WriterPanel;

public class WriterFrame extends JFrame
{
    public WriterFrame(WriterPanel wp) 
    {
    
     getContentPane().add(wp);
     
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          Dimension frameSize = new Dimension(520, 480);
          if (frameSize.height > screenSize.height)
          {
            frameSize.height = screenSize.height;
          }
          if (frameSize.width > screenSize.width)
          {
            frameSize.width = screenSize.width;
          }
          setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
         
         
     setVisible(true);
     setSize(513, 473);
     setResizable(false);
    
    }
}
