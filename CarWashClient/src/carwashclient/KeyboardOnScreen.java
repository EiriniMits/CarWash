package carwashclient;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * This class creates the virtual keyboard which it sets to the main window.
 * @author Anestis
 */
public class KeyboardOnScreen extends JPanel {

    private ArrayList<JButton> CharArray = new ArrayList<>(26);
    private ArrayList<JButton> NumberButtonArray = new ArrayList<>(10);
    private ArrayList<JButton> elseButtonArray = new ArrayList<>(5);
    private JButton language;
    private String allChar;

    public KeyboardOnScreen() {
        language=new JButton("EN");
        setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //Create the Buttons and the ActionListener of them.
        String allChar = "QWERTYUIOPASDFGHJKLZXCVBNM";
        for (int i = 0; i < allChar.length(); i++) {
            JButton but = new JButton("" + allChar.charAt(i));
            but.addActionListener(new ClickListener());
            this.CharArray.add(i, but);
        }
        String allNum = "7894561230";
        for (int i = 0; i < allNum.length(); i++) {
            JButton but = new JButton("" + allNum.charAt(i),new ImageIcon("0.jpg"));
            but.addActionListener(new ClickListener());
            this.NumberButtonArray.add(i, but);
        }
        this.elseButtonArray.add(new JButton("Space"));
        this.elseButtonArray.add(new JButton("BackSpace"));
        this.elseButtonArray.add(new JButton("Enter"));
        this.elseButtonArray.add(new JButton(","));
        this.elseButtonArray.add(new JButton("-"));
        this.elseButtonArray.add(new JButton("/"));
        this.elseButtonArray.add(language);
        for(int i=0;i<6;i++){
            this.elseButtonArray.get(i).addActionListener(new ClickListener());
        }
        this.elseButtonArray.get(6).setBackground(Color.RED);
        this.elseButtonArray.get(6).addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(FirstWinClient.lang==0){
                    FirstWinClient.lang=1;
                    language.setText("GR");
                    CarWashClient.getWin1().setTitle(1);
                    CarWashClient.Redraw();
                    elseButtonArray.get(6).setBackground(Color.BLUE);
                }
                else{
                    FirstWinClient.lang=0;
                    language.setText("EN");
                    CarWashClient.getWin1().setTitle(0);
                    CarWashClient.Redraw();
                    elseButtonArray.get(6).setBackground(Color.RED);
                }
            }
        });
        //Add the Buttons
        //Prota toys xaraktires
        for (int i = 0; i < allChar.length(); i++) {
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.ipadx = 40;
            gbc.ipady = 40;
            if (i < 10) {
                gbc.gridx = i;
                gbc.gridy = 0;
            } else if (i < 19) {
                gbc.gridx = i - 10;
                gbc.gridy = 1;
            } else if (i < 26) {
                gbc.gridx = i - 19;
                gbc.gridy = 2;
            }
            this.add(this.CharArray.get(i), gbc);
        }
        //Toys arithmoys
        for (int i = 0; i < allNum.length() - 1; i++) {
            gbc.insets = new Insets(5, 5, 5, 5);
            if (i < 3) {
                gbc.gridx = 10 + i;
                gbc.gridy = 0;
            } else if (i < 6) {
                gbc.gridx = 7 + i;
                gbc.gridy = 1;
            } else if (i < 10) {
                gbc.gridx = 4 + i;
                gbc.gridy = 2;
            }
            this.add(this.NumberButtonArray.get(i), gbc);
        }
        //to miden
        gbc.gridx = 10;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.NumberButtonArray.get(9), gbc);
        //to .
        gbc.gridx = 12;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(this.elseButtonArray.get(3), gbc);
        //to backspace
        gbc.gridx = 13;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(this.elseButtonArray.get(1), gbc);
        //to enter
        gbc.gridx = 13;
        gbc.gridy = 2;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(this.elseButtonArray.get(2), gbc);
        //to -
        gbc.gridx = 7;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.elseButtonArray.get(4), gbc);
        //to space
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.elseButtonArray.get(0), gbc);
        //to /
        gbc.gridx = 7;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.elseButtonArray.get(5), gbc);
        //to GR
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.elseButtonArray.get(6), gbc);
    }
    void changeLang(int a){
    if(a==1){
            allChar=":΅ΕΡΤΥΘΙΟΠΑΣΔΦΓΗΞΚΛΖΧΨΩΒΝΜ";
        }
    }
}
