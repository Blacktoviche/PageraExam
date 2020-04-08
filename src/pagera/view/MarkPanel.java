package pagera.view;

    import java.awt.Dimension;
    import java.awt.Rectangle;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.JScrollPane;
    import javax.swing.JTable;

    public class MarkPanel extends JPanel 
    {

        private JLabel jLabel1 = new JLabel();
        private JScrollPane jScrollPane1 ;

        public MarkPanel(JTable table) {
            try {
            
               jScrollPane1 = new JScrollPane(table);   
               
                jbInit(table);
        
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

            private void jbInit(JTable jTable1) throws Exception 
            {
            
            this.setLayout( null );
            this.setSize(new Dimension(PageraExam.width, 452));
            jLabel1.setText("Click on the question number which you want to go to");
            jLabel1.setBounds(new Rectangle(160, 10, 480, 30));
            jScrollPane1.setBounds(new Rectangle(5, 40, 590, 420));
            this.add(jLabel1, null);
            this.add(jScrollPane1, null);
            

        }
    }
