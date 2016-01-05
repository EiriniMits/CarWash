package carwashclient;

import java.awt.*;
import javax.swing.*;

/**
 * The first window class that the client sees. It creates the virtual keyboard and it asks for the client to give his cars licence.
 * @author Tomvar
 */
public class FirstWinClient extends JFrame {

    private static JTextField textfield = new JTextField();
    public static int lang;
    
    public FirstWinClient() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon img=new ImageIcon("carWash.gif");
        this.setIconImage(img.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1666, 600);
        this.setResizable(false);
        lang=0;
        this.setTitle("Καλωσήρθατε στο Car-Wash. Δώστε αριθμό κυκλοφορίας");
        textfield.getInputMap().setParent(null);
        Font font1 = new Font("SansSerif", Font.ITALIC, 200);
        textfield.setFont(font1);
        textfield.setBackground(new Color(0,0,0));
        textfield.setForeground(new Color(255,255,153));
        textfield.setHorizontalAlignment(JTextField.CENTER);//gia na anabosbinei kersoras stin mesi tou textField
        this.add(textfield, BorderLayout.NORTH);

        JPanel keyboardPanel = new JPanel(new FlowLayout());
        KeyboardOnScreen panel = new KeyboardOnScreen();
        keyboardPanel.add(panel);
        this.add(keyboardPanel, BorderLayout.CENTER);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    /**
     * Changes the language in the window title.
     * @param lang 
     */
    public void setTitle(int lang){
        if(lang==0)
            this.setTitle("Καλωσήρθατε στο Car-Wash. Δώστε αριθμό κυκλοφορίας");
        else
            this.setTitle("Welcome to Car-Wash. Please enter licence Number");
    }
    
    public static String getTextfield() {
        return textfield.getText();
    }

    public static void setTextfield(String textfield) {
        FirstWinClient.textfield.setText(textfield);
    }
}