package pagera.frames;

import javax.swing.UIManager;

public class MainClass
{
    
    
    public MainClass()
    {
    }

   
    public static void main(String[] args)
    {
        try{
         
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
            MainFrame mainClass = new MainFrame();
            mainClass.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        }
        catch(Exception ex)
        {
            
            MainFrame mainClass = new MainFrame();
            mainClass.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
            
        }
     
    }
}
