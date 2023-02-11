import javax.swing.*;
import java.awt.*;

class GUI {
    AVL modell;
    JFrame vindu;
    JPanel panel;
    int bredde, lengde;
    

    GUI (AVL m) 
    {
        modell = m;
        bredde = 1400;
        lengde = 1200;
        try
        { 
            // UIManager.setLookAndFeel("javax.swing.plaf.gtk.GTKLookAndFeel");
            // UIManager.getCrossPlatformLookAndFeelClassName();
        }
        catch (Exception e) { System.exit(0); }

        //  ALLE JPANELS SOM TILSAMMEN BESTEMMER HVORDAN PROGRAMMET SER UT
        vindu = new JFrame("AVL");
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(bredde, lengde));
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);

        //  LEGGER SAMMEN ALLE JPANELS
        
        lagNode("50", bredde/2, 100);
        lagNode("70",(3*bredde)/4, 200);
        lagNode("20", bredde/4, 200);
        vindu.add(panel);

        

        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        vindu.setFocusable(true); 
        vindu.pack();
        vindu.setVisible(true);
    }
    
    
    void lagNode(String e,int x,int y)
    {
        Dimension node_dim = new Dimension(100,100);
        Insets insets = panel.getInsets();
        JPanel node = new JPanel();
        JLabel element = new JLabel(e);
        node.add(element); node.setPreferredSize(node_dim);
        node.setBounds(x + insets.right, y + insets.left, 25,25);
        this.panel.add(node);
    }

    void update() 
    {
        vindu.setVisible(true); 
    }

    public static void main(String[] args)
    {
        GUI avl = new GUI(new AVL());
    }
}