package carwashclient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Generic class for creating an error dialog window with custom message and title which given to the constructor.
 * @author Tomvar
 */
public class ErrorMessage extends JDialog{

    public ErrorMessage(Object parent,String message,String title) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.setAlwaysOnTop(true);
        this.requestFocusInWindow();
        this.setModal(true);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(800, 250);
        this.setResizable(false);
        this.setLayout(new GridLayout(2,1));
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        JPanel firstPanel=new JPanel(new FlowLayout());
        firstPanel.setBackground(Color.WHITE);
        JLabel image=new JLabel(new ImageIcon("error.jpg"));
        firstPanel.add(image);
        JLabel Message=new JLabel(message);
        Message.setFont(new Font("SansSerif", Font.ITALIC, 20));
        firstPanel.add(Message);
        add(firstPanel);
        JPanel secondPanel=new JPanel(new FlowLayout());
        secondPanel.setBackground(Color.WHITE);
        JButton but=new JButton("Ok");
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ErrorMessage.this.dispose();
            }
        });
        but.setPreferredSize(new Dimension(100,45));
        secondPanel.add(but);
        add(secondPanel);
    }
}
