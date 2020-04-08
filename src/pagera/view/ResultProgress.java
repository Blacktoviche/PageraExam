package pagera.view;

import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ResultProgress
{

    private int min = 0;
    private int max;
    private int counter = 0;
    private JProgressBar jpb;
    private String result = "Failed";
    
    public ResultProgress(int max)
    {
  
    jpb = new JProgressBar();
    jpb.setMinimum(min);
    jpb.setMaximum(100);
    jpb.setStringPainted(true);
    jpb.setForeground(Color.RED);
     
    if(max >= PageraExam.examAverage)
     result = "Pass";
     this.max = max;
     
    }
    
    public void runProgress()
    {
        Thread runner = new Thread(){
        
        public void run()
        {
              counter = min;
        
            while (counter <= max) 
            {
               Runnable runme = new Runnable()
              {
                 public void run()
                 {
                   jpb.setValue(counter);
                   
                 if(counter >= PageraExam.examAverage)
                   {
                  
                    jpb.setForeground(Color.GREEN);
                   
                   }
            
               }
            };
        
               SwingUtilities.invokeLater(runme);
               counter++;
        try {
        Thread.sleep(100);
         
        }
        catch (Exception ex)
        {
        ex.printStackTrace();
        }
        }
        
            jpb.setString(max+"%   "+result);
      }
     };
        runner.start();
        
    }//

    public void setJpb(JProgressBar jpb)
    {
        this.jpb = jpb;
    }

    public JProgressBar getJpb() {
        return jpb;
    }
}


