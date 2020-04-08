package pagera.view;

import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MePanel extends JPanel {
    private JTextArea jTextArea1 = new JTextArea();
    private PageraExam pel = new PageraExam();
    private JLabel jLabel2 ;
    private String me = "Name : Malek Tarboush\n"+
                        "E-Mail : syriandevelopers@gmail.com\n"+
                        "I got :\n"+
                        "Sun Certified Programmer for the Java 1.4 , \n"+
                        "Sun Certified Web Component Developer for the java 2 Enterprise Edition 1.4\n"+
                        "Additional Categories :\n"+
                        "EJB 3.0 , JSF , GIS  ( Oracle Spatial Data ) , SQL \n" +
                        "Strust , JavaMail  , Linux , Java Script , XML\n"+
                        "depth overview  of Oracle Database 9i , 10g\n"+
                        "I got an overview on additional Programming Languages \n" + 
                        "C++ , ADA , C# \n"+
                        "IDE's used : JDeveloper , Eclipse  \n";

    private JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);

    public MePanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(600, 333));
        jTextArea1.setText(me);
        jTextArea1.setLineWrap(true);
        jLabel2 = new JLabel(pel.getLogo());
        jScrollPane1.setBounds(new Rectangle(5, 125, 520, 200));
        jScrollPane1.setBorder(BorderFactory.createTitledBorder("about me"));
        jLabel2.setBounds(new Rectangle(5, 10, 514, 100));
        this.add(jScrollPane1, null);
        this.add(jLabel2, null);
    }
}
