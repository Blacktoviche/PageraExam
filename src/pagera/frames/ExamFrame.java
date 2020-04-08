package pagera.frames;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

import pagera.logic.Collector;

import pagera.view.MainPanel;
import pagera.view.PageraExam;
import pagera.view.QuestionPanel;
import pagera.view.WriterPanel;


public class ExamFrame extends JFrame 
{
    
    private MainPanel jPanel1 ;
    public static int state = 0;
    public static final int FINISHED = 1;
    public static final int MARK = 2;
    public static int ISMARK = 0;
    private JPanel jPanel2;
    private Container cont;
    private Collector coll;
    private JScrollPane scroll;
    private JMenu menuFile = new JMenu("File");
    private JMenuItem menuFileExit = new JMenuItem("Exit");
    
    private JMenuBar menuBar = new JMenuBar();
    
    private JMenu about = new JMenu("about");
    private JMenuItem quesWrite = new JMenuItem("Questions Writer");
    public JProgressBar jp = new JProgressBar();
    
    public ExamFrame(String examName)
    {
       
        super("Pagera Exam v 2.0");
        coll = new Collector(this , examName);
        jPanel2 = coll.getPanels().get(0);
    
        jPanel1 = coll.getMainPanel();
        cont = getContentPane();
     
        setTitle("www.pageraz.com  -- www.pageraz.com/forum");
 
        
        
        quesWrite.addActionListener( new ActionListener() 
        {
            public void actionPerformed(ActionEvent event) 
            {
                showFrame();
            }
        }
        );
        
        menuFileExit.addActionListener( 
        new ActionListener() { 
        
        public void actionPerformed( ActionEvent ae )
        { 
        
          int res = JOptionPane.showConfirmDialog(null, 
                       "Are you sure you want to exit", "------------",
                        JOptionPane.YES_NO_OPTION , JOptionPane.INFORMATION_MESSAGE);
         if(res == JOptionPane.NO_OPTION)
           return;
         
          
          System.exit(0); 
        
        } 
        
        } 
        );
       
        try {
            
            jbInit();
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

      
        
    }

    private void jbInit() throws Exception {
       
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          Dimension frameSize = new Dimension(600,680);
          if (frameSize.height > screenSize.height)
          {
            frameSize.height = screenSize.height;
          }
          if (frameSize.width > screenSize.width)
          {
            frameSize.width = screenSize.width;
          }
          setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
         
        menuFile.add(menuFileExit);
        about.add(quesWrite);
        menuBar.add(menuFile);
        menuBar.add(about);
        menuBar.add(PageraExam.timeProgress2);
        setJMenuBar(menuBar);
        
        setResizable(false); 
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(602,700));
        jPanel1.setBounds(new Rectangle(0, 505, 594, 150));
        jPanel2.setBounds(new Rectangle(0, 0, 590, 465));
        this.getContentPane().add(jPanel2, null);
        this.getContentPane().add(jPanel1, null);
        setVisible(true);
     
    }
  
    private void showFrame()
    {
        
        WriterPanel wp = new WriterPanel();
        wp.jButton1.setVisible(false);
        wp.jTextArea1.setText(PageraExam.writer.getDescription());
        wp.jTextArea1.setEditable(false);
        wp.jTextField1.setText(PageraExam.writer.getName());
        wp.jTextField1.setEditable(false);
        wp.jTextField2.setText(PageraExam.writer.getMail());
        wp.jTextField2.setEditable(false);
        wp.jTextField3.setText(PageraExam.writer.getWebAddress());
        wp.jTextField3.setEditable(false);
        WriterFrame wf = new WriterFrame(wp);
        wf.validate();
        
    }//
    
    
    public void replace(JPanel pan , int u)
    { 
       if(state != FINISHED )
        organize(u);
        
        cont.getComponents()[0].setVisible(false);
        cont.remove(0);
        cont.validate();
        cont.add(pan,0);
        cont.validate();
        validate();
    }//
    
    public void finish(JPanel pan)
    {
      
        state = FINISHED;
        ISMARK = MARK;
        cont.getComponents()[0].setVisible(false);
        cont.remove(0);
        cont.validate();
        cont.add(pan,0);
        cont.validate();
        validate();
        
    }//
    
     public void mark(JPanel pan)
     {
       
         cont.getComponents()[0].setVisible(false);
         cont.remove(0);
         cont.validate();
         cont.add(pan,0);
         cont.validate();
         validate();
         
     }//
    private void organize(int h) 
    {
        
     coll.getPanels().remove(h);
     coll.getPanels().add( h , ( QuestionPanel) cont.getComponents()[0]);
        
    }//
}//
