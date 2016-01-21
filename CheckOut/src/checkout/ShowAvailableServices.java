/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Anestis, Eirini
 */
public class ShowAvailableServices extends JFrame{
    private static final int MAX1 = 60;
    private static final int MAX2 = 15;
    private static ButtonGroup vehicle;
    private static ArrayList<JCheckBox> servicesArrayBox;

    private static JButton changeButton;
    private static JButton addButton;
    private static JButton removeButton;
    private static JButton returnButton;
    private static int flagVihicle = 0;   


    public ShowAvailableServices()throws IOException{
        
        
        JFrame frame= new JFrame();
        addButton = new JButton(" Προσθήκη Υπηρεσίας");
        removeButton = new JButton(" Διαγραφή Υπηρεσίας");
        changeButton = new JButton(" Τροποποίηση Tιμών");
        returnButton = new JButton("Επιστροφή");
        vehicle = new ButtonGroup();
        servicesArrayBox = new ArrayList<>();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon img=new ImageIcon("carWash.gif");
        this.setIconImage(img.getImage());
        this.setTitle("Pυθμίσεις Υπηρεσιών");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1100, 768);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel nameLabel = new JLabel("Κατάλογος υπηρεσιών");
        nameLabel.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 40));
        gbc.insets = new Insets(50, 50, 50, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nameLabel, gbc);

        JRadioButton ayto = new JRadioButton("Αυτοκίνητο");
        ayto.setFont(new Font("SansSerif", Font.ITALIC, 20));
        ayto.setOpaque(false);
        JRadioButton truck = new JRadioButton("Φορτηγό");
        truck.setFont(new Font("SansSerif", Font.ITALIC, 20));
        truck.setOpaque(false);
        JRadioButton bike = new JRadioButton("Μηχανή");
        bike.setFont(new Font("SansSerif", Font.ITALIC, 20));
        bike.setOpaque(false);
        ayto.addItemListener((ItemListener) new ListenerForVehicle());
        truck.addItemListener((ItemListener) new ListenerForVehicle());
        bike.addItemListener((ItemListener) new ListenerForVehicle());
        vehicle.add(ayto);
        vehicle.add(truck);
        vehicle.add(bike);
        JPanel firstPanel = new JPanel(new GridLayout(3, 1));
        firstPanel.setBorder(BorderFactory.createTitledBorder("Όχημα"));
        firstPanel.add(ayto);
        firstPanel.add(truck);
        firstPanel.add(bike);
        firstPanel.setOpaque(false);
        gbc.insets = new Insets(50, 50, 50, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(firstPanel, gbc);
        gbc.fill = GridBagConstraints.BASELINE;
        JPanel secondPanel = new JPanel(new GridLayout(AvailableServices.getListServices().size(), 1));//gia na prosarmozetai to megethos
        secondPanel.setBorder(BorderFactory.createTitledBorder("Υπηρεσίες"));
        for (int i = 0; i < AvailableServices.getListServices().size(); i++) {
            JCheckBox chB = new JCheckBox(AvailableServices.getListServices().get(i).getName());
            chB.setFont(new Font("SansSerif", Font.BOLD, 20));
            chB.setText(servSetText(chB.getText(), MAX1));
            chB.addActionListener((ActionListener) new ListenerForListServices());
            chB.setEnabled(false);
            servicesArrayBox.add(chB);
            chB.setOpaque(false);// To kanei aorato apo piso
            secondPanel.add(chB);
        }
        secondPanel.setOpaque(false);
        gbc.insets = new Insets(50, 50, 50, 0);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(secondPanel, gbc);
        addButton.setIcon(new javax.swing.ImageIcon("Button-Add-icon.png"));
        addButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                    try {
                    AvailableServices a1=new AvailableServices();
                } catch (IOException ex) {
                    Logger.getLogger(ShowAvailableServices.class.getName()).log(Level.SEVERE, null, ex);
                }
                    AddServise add = new AddServise();                    
            }
        });
        gbc.insets = new Insets(50, 50, 50, 0);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        add(addButton, gbc);
        removeButton.setIcon(new javax.swing.ImageIcon("Button-Delete-icon.png"));
        removeButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    AvailableServices a1=new AvailableServices();
                } catch (IOException ex) {
                    Logger.getLogger(ShowAvailableServices.class.getName()).log(Level.SEVERE, null, ex);
                }
                DeleteServise delete = new DeleteServise();
                
            }
        });
        gbc.insets = new Insets(50, 50, 50, 0);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 0;
        gbc.gridwidth = 2;
        add(removeButton, gbc);
        
        changeButton.setIcon(new javax.swing.ImageIcon("Ecommerce-Price-Tag-Euro-icon.png"));
        changeButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    AvailableServices a1=new AvailableServices();
                } catch (IOException ex) {
                    Logger.getLogger(ShowAvailableServices.class.getName()).log(Level.SEVERE, null, ex);
                }
                ChangePrice change = new ChangePrice();               
            }
        });
        gbc.insets = new Insets(50, 50, 50, 0);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = -1;
        gbc.gridwidth = 2;
        add(changeButton, gbc);
        returnButton.setIcon(new javax.swing.ImageIcon("Back-2-2-icon.png"));
        returnButton.setFont(new Font("SansSerif", Font.PLAIN, 30));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 dispose();
         }
        });
        gbc.insets = new Insets(50, 50, 50, 50);
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        add(returnButton, gbc);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

    
    }
    public static String servSetText(String a, int max) {//gia stixisi
        for (int j = 0; j < max - a.length(); j++) {
            a = a.concat(" ");
        }
        return a;
    }

    public static int getMAX1() {
        return MAX1;
    }

    public static int getMAX2() {
        return MAX2;
    }
   

    public static ArrayList<JCheckBox> getServicesArrayBox() {
        return servicesArrayBox;
    }
    public static int getFlagVihicle() {
        return flagVihicle;
    }
    public static void setFlagVihicle(int flagVihicle) {
        ShowAvailableServices.flagVihicle = flagVihicle;
    }


    public static JButton getReturnButton() {
        return returnButton;
    }

    public static ButtonGroup getVihicle() {
        return vehicle;
    }

}