package pagera.frames;

    import javax.swing.*;
    import java.awt.*;
    import java.net.URL;
    import java.net.MalformedURLException;
    import java.io.*;
    import javax.swing.text.*;
    import javax.swing.event.*;

     
    public class MakeQuestionHelp extends JFrame {
      
         URL url;
        Cursor cursor;
        
        
        public MakeQuestionHelp() {
            super("Help , How to create your own questions");

            
            
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
              Dimension frameSize = new Dimension(600,500);
              if (frameSize.height > screenSize.height)
              {
                frameSize.height = screenSize.height;
              }
              if (frameSize.width > screenSize.width)
              {
                frameSize.width = screenSize.width;
              }
              setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
             
             
             setSize(600,500);
            HtmlShow html = new HtmlShow();
            setResizable(false); 
            setContentPane(html);
            setVisible(true);
        }

   

 
    private class HtmlShow extends JScrollPane implements HyperlinkListener {
        JEditorPane html;

        public HtmlShow() {
            try {
                File f = new File ("HelpFiles"+System.getProperty("file.separator")+"MakeQuestions.htm");
                String s = f.getAbsolutePath();
                s = "file:"+s;
                URL url = new URL(s);
                html = new JEditorPane(s);
                html.setEditable(false);
                html.addHyperlinkListener(this);

                JViewport vp = getViewport();
                vp.add(html);
            } catch (MalformedURLException e)
            {
            e.printStackTrace(); 
            } catch (IOException e) {
              e.printStackTrace();
            }       
        }

        public void hyperlinkUpdate(HyperlinkEvent e) {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                linkActivated(e.getURL());
            }
        }


        protected void linkActivated(URL u) {
            Cursor c = html.getCursor();
            Cursor waitCursor = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
            html.setCursor(waitCursor);
            SwingUtilities.invokeLater(new PageLoader(u, c));
        }

     
        class PageLoader implements Runnable {
            
            PageLoader(URL u, Cursor c) {
                url = u;
                cursor = c;
            }

            public void run() {
                if (url == null) {

                    html.setCursor(cursor);

            
                    Container parent = html.getParent();
                    parent.repaint();
                } else {
                    Document doc = html.getDocument();
                    try {
                        html.setPage(url);
                    } catch (IOException ioe)
                    {
                    
                        html.setDocument(doc);
                        getToolkit().beep();
                    } finally {
                    
                        url = null;
                        SwingUtilities.invokeLater(this);
                    }
                }
            }

            
        }
 
    }
 
 }