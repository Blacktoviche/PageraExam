package pagera.frames;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JFrame;

import pagera.view.MePanel;
import pagera.view.PageraExam;

public class MeFrame extends JFrame {
    
    private MePanel me = new MePanel();
    
    public MeFrame()
    {
        super("About Pagera");
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
        getContentPane().add(me);
        setSize( new Dimension(531, 360) );
        setVisible(true);
    }
}
