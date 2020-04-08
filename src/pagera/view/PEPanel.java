package pagera.view;
 

    import java.awt.Dimension;

    import java.awt.Rectangle;

    import javax.swing.BorderFactory;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.JScrollPane;
    import javax.swing.JTextArea;

    public class PEPanel extends JPanel {
        private JTextArea jTextArea1 = new JTextArea();
        private PageraExam pel = new PageraExam();
        private JLabel jLabel2 ;
        private String me = "Pagera Exam v 2.0 is a free program and an Open Source\n"+
                            "it programmed for some reasons one of these reasons is\n"+
                            "to fill my free time\n"+
                            "the second reason is to help the students who want to get \n"+
                            "Sun Certified Programmer for the Java\n"+
                            "Third to help the owner of web site's  who have a lot of good \n" +
                            "questions and they publish it on html pages , they can use\n" +
                            "this programe to collect their questions and present it in\n" +
                            "pretty way."+
                            "Be attention :::\n"+
                            "all these questions that exist in the program was collected\n" +
                            "by me and many friends from the internet so\n"+
                            "I'm not responsible for ( the answers were right or not )\n"+
                            "the program give you choice to add your own questions \n" + 
                            "and test yourself with it , it depends on you\n" +
                            "Find or Add more questions for the program here......\n" +
                            "http://members.lycos.co.uk/pagera2080/myprojects/pageraexam";

        private JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);

        public PEPanel() {
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
            jScrollPane1.setBorder(BorderFactory.createTitledBorder("about Pagera Exam"));
            jLabel2.setBounds(new Rectangle(5, 10, 514, 100));
            this.add(jScrollPane1, null);
            this.add(jLabel2, null);
        }
    }