package pagera.view;

import java.awt.Image;
import java.awt.Toolkit;

import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JProgressBar;

import pagera.bean.Writer;

public class PageraExam
{
   
    public  Icon logo ;
    public static int width = 600;
    public static int hight = 600;
    public static Writer writer = new Writer();
    public static JLabel time = new JLabel("Time : ");
    public static int examTime = 0;
    public static int examAverage = 0;
    public static JProgressBar timeProgress;
    public static JProgressBar timeProgress2 = new JProgressBar();
    
    
    public PageraExam()
    {
      
     //URLClassLoader urlLoader = (URLClassLoader ) getClass().getClassLoader();
     logo  = new ImageIcon(getClass().getResource("logo.gif"));
        
    }

    public void setLogo(Icon logo) {
        this.logo = logo;
    }

    public Icon getLogo() {
        return logo;
    }
}
