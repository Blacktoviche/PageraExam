package pagera.frames;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pagera.view.AnswersView;
import pagera.view.PageraExam;
import pagera.view.QuestionView;

public class AnsQueFrame extends JFrame
{
    
    private JButton button ;
    
    public AnsQueFrame(QuestionView que , AnswersView ans) 
    {
     
        AnsQueFrameListener listener = new AnsQueFrameListener();
        
    
     if(que == null)
      {
          button = ans.getJButton1();
          getContentPane().add(ans);
      }
   
     else{
         button = que.getJButton1();  
         getContentPane().add(que);
     }
     button.addActionListener(listener);
     
     
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          Dimension frameSize = new Dimension(580, 560);
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
     setSize( new Dimension(580, 560) );
     setVisible(true);
    }
    
    private class AnsQueFrameListener implements ActionListener
    {
        
        
        public void actionPerformed(ActionEvent event)
        {
        
        
          if(event.getSource() == button)
              hideFrame();
            
        }
    }
    
    private void hideFrame()
    {
        
        setVisible(false);
        System.gc();
        
    }
}
