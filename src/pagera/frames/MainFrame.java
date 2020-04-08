package pagera.frames;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;

import pagera.logic.MainPanelsListener;

import pagera.view.MainNorthPanel;
import pagera.view.MainSouthPanel;
import pagera.view.PageraExam; 

public class MainFrame extends JFrame {
    private MainNorthPanel jPanel1;
    private MainSouthPanel jPanel2 ;
    private JSeparator jSeparator1 = new JSeparator();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu("File");
    private JMenuItem menuFileExit = new JMenuItem("Exit");
    private JMenu menuHelp = new JMenu("Help");
    private JMenuItem quesHelp = new JMenuItem("Make Questions");
    private JMenuItem me = new JMenuItem("About Me");
    private JMenuItem pe = new JMenuItem("About PageraExam");
    private JMenuItem createQuestions = new JMenuItem("Create Questions");
    public JMenu exam = new JMenu("Exam");
    private MainPanelsListener mainListener;

    public MainFrame()
    {
  
        super("Pagera Exam v 2.0");
        mainListener = new MainPanelsListener(this);
       
        jPanel1 = mainListener.getMnp();
        jPanel2 = mainListener.getMsp();
        
        
        menuFileExit.addActionListener( 
        new ActionListener() { 
        
        public void actionPerformed( ActionEvent ae )
        { 
        
          int res = JOptionPane.showConfirmDialog(null, 
                       "Are you sure you want to exit", "------------",
                        JOptionPane.YES_NO_OPTION , JOptionPane.WARNING_MESSAGE);
         if(res == JOptionPane.NO_OPTION)
           return;
         
          
          System.exit(0); 
        
        } 
        
        } 
        );
        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
          Dimension frameSize = new Dimension(530, 600);
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
        menuFile.add( createQuestions );
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        menuBar.add(exam);
        menuBar.add( menuHelp );
        menuHelp.add(quesHelp);
        menuHelp.add(me);
        menuHelp.add(pe);
        setJMenuBar( menuBar );
        getContentPane().setLayout( null );
        setSize(new Dimension(530, 600));
        jPanel1.setBounds(new Rectangle(0, 0, 525, 400));
        jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jPanel2.setBounds(new Rectangle(3, 410, 515, 160));
        jPanel2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        jSeparator1.setBounds(new Rectangle(0, 400, 525, 15));
        getContentPane().add(jSeparator1, null);
        getContentPane().add(jPanel2, null);
        getContentPane().add(jPanel1, null);
        setVisible(true);
    }

    public JMenuItem getCreateQuestions() {
        return createQuestions;
    }

    public JMenuItem getQuesHelp() {
        return quesHelp;
    }

    public JMenuItem getMe() {
        return me;
    }

    public void setPe(JMenuItem pe) {
        this.pe = pe;
    }

    public JMenuItem getPe() {
        return pe;
    }
}
