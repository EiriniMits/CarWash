/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * 
 * @author Anestis
 */
public class CheckOnExit extends JDialog {

    private JLabel BackGround;
    private JLabel confirmLabel;
    private JButton exitbutton;
    private JButton cancelbutton;
    private JDialog dialog;

    /**
     * Creates a pop-up window when the user tries to terminate the programm asking if 
     * he is sure. 
     */
    
    public CheckOnExit(){
        setTitle("Έξοδος!");
        setSize(470, 250);
        setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        dialog = new JDialog();
        BackGround = new JLabel(new ImageIcon("exit.gif"));
        add(BackGround);
        BackGround.setLayout(new FlowLayout());
        confirmLabel = new JLabel("Είστε σύγουρος πως θέλετε να τερματιστεί το πρόγραμμα;");
        confirmLabel.setFont(new Font("", Font.TYPE1_FONT, 14));
        confirmLabel.setForeground(Color.BLACK);
        exitbutton = new JButton(new ImageIcon("check-icon.png"));
        exitbutton.setBackground(Color.WHITE);
        exitbutton.setOpaque(false);
        exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cancelbutton = new JButton(new ImageIcon("Actions-dialog-cancel-icon.png"));
        cancelbutton.setBackground(Color.WHITE);
        cancelbutton.setOpaque(false);
        cancelbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckOnExit.this.setVisible(false);
            }
        });
        Box buttonsPanel = new Box(BoxLayout.X_AXIS);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 270)));
        buttonsPanel.add(exitbutton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(60, 0)));
        buttonsPanel.add(cancelbutton);
        BackGround.add(confirmLabel, BorderLayout.CENTER);
        BackGround.add(buttonsPanel, BorderLayout.SOUTH);
        
    }
}

