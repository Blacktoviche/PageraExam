package pagera.view.wizard;

    import javax.swing.JProgressBar;

    public class ExamProgress extends JProgressBar
    {

        private int min = 0;
        
        public ExamProgress()
        {

        setMinimum(min);
        setMaximum(50);
        setStringPainted(true);
         
    }//

     public void setValue(int value)
     {
         
             super.setValue(value);
     
         
      
     }
     
}/////
