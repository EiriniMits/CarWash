package carwashclient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
 * This class opens the second window for the user to choose the services he wishes from the list. The services supports three types of vehicles (for now) Cars, Trucks and Motorbikes.
 * @author Anestis
 */
public class SecondWinClient extends JFrame {

    private static final int MAX1 = 60;
    private static final int MAX2 = 15;
    private static ButtonGroup vehicle;
    private static ArrayList<JCheckBox> servicesArrayBox;
    private AvailableServices services;
    private static JLabel costField;
    private static JButton okButton;
    private static int flagVihicle = 0;

    public SecondWinClient() {
        AvailableServices a1=new AvailableServices();
        okButton = new JButton("Ok");
        vehicle = new ButtonGroup();
        servicesArrayBox = new ArrayList<>();
        services = new AvailableServices();
        costField = new JLabel("0.0  €    ");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon img=new ImageIcon("carWash.gif");
        this.setIconImage(img.getImage());
        this.setTitle("Επιλέξτε υπηρεσία");
        if(FirstWinClient.lang==1){
            this.setTitle("Choose service");
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 768);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(new Color(153,255,255));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel nameLabel = new JLabel("Κατάλογος υπηρεσιών");
        if(FirstWinClient.lang==1){
            nameLabel.setText("List of services");
        }
        nameLabel.setFont(new Font("SansSerif", Font.ITALIC, 40));
        gbc.insets = new Insets(50, 50, 50, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nameLabel, gbc);

        JRadioButton ayto = new JRadioButton("Αυτοκίνητο");
        if(FirstWinClient.lang==1){
            ayto.setText("  Car  ");
        }
        ayto.setFont(new Font("SansSerif", Font.ITALIC, 20));
        ayto.setOpaque(false);
        JRadioButton truck = new JRadioButton("Φορτηγό");
        if(FirstWinClient.lang==1){
            truck.setText("  Truck  ");
        }
        truck.setFont(new Font("SansSerif", Font.ITALIC, 20));
        truck.setOpaque(false);
        JRadioButton bike = new JRadioButton("Μηχανή");
        if(FirstWinClient.lang==1){
            bike.setText("  Bike  ");
        }
        bike.setFont(new Font("SansSerif", Font.ITALIC, 20));
        bike.setOpaque(false);
        ayto.addItemListener(new ListenerForVehicle());
        truck.addItemListener(new ListenerForVehicle());
        bike.addItemListener(new ListenerForVehicle());
        vehicle.add(ayto);
        vehicle.add(truck);
        vehicle.add(bike);
        JPanel firstPanel = new JPanel(new GridLayout(3, 1));
        firstPanel.setBorder(BorderFactory.createTitledBorder("Όχημα"));
        if(FirstWinClient.lang==1){
            firstPanel.setBorder(BorderFactory.createTitledBorder("Vehicle"));
        }
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
        if(FirstWinClient.lang==1){
            secondPanel.setBorder(BorderFactory.createTitledBorder("Sevices"));
        }
        for (int i = 0; i < AvailableServices.getListServices().size(); i++) {
            JCheckBox chB = new JCheckBox(AvailableServices.getListServices().get(i).getName());
            chB.setFont(new Font("SansSerif", Font.BOLD, 20));
            chB.setText(servSetText(chB.getText(), MAX1));
            chB.addActionListener(new ListenerForListServices());
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

        JPanel thirdPanel = new JPanel(new FlowLayout());
        thirdPanel.setOpaque(false);
        if(FirstWinClient.lang==0){
            thirdPanel.setBorder(BorderFactory.createTitledBorder("Κόστος : "));
        }
        else if(FirstWinClient.lang==1){
            thirdPanel.setBorder(BorderFactory.createTitledBorder("Cost : "));
        }
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        costField.setFont(font1);
        thirdPanel.add(SecondWinClient.costField);
        thirdPanel.setOpaque(false);
        gbc.insets = new Insets(50, 50, 50, 0);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(thirdPanel, gbc);

        okButton.setEnabled(false);
        okButton.setFont(new Font("SansSerif", Font.ITALIC, 30));
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SummaryInfoSend confirmation =new SummaryInfoSend();
                confirmation.setVisible(true);
            }
        });
        gbc.insets = new Insets(50, 50, 50, 0);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        add(okButton, gbc);

        JButton returnButton = new JButton("Επιστροφή");
         if(FirstWinClient.lang==1){
            returnButton.setText("Return");
        }
        returnButton.setFont(new Font("SansSerif", Font.ITALIC, 30));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehicle.clearSelection();
                costField.setText("0.0  €");
                okButton.setEnabled(false);
                for (int i = 0; i < servicesArrayBox.size(); i++) {
                    servicesArrayBox.get(i).setSelected(false);
                    servicesArrayBox.get(i).setEnabled(false);
                }
                FirstWinClient.setTextfield("");
                CarWashClient.getWin2().setVisible(false);
                CarWashClient.getWin1().setVisible(true);
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

    public static void setCostField(String costField) {
        SecondWinClient.costField.setText(costField);
    }

    public static int getFlagVihicle() {
        return flagVihicle;
    }

    public static void setFlagVihicle(int flagVihicle) {
        SecondWinClient.flagVihicle = flagVihicle;
    }

    public static ArrayList<JCheckBox> getServicesArrayBox() {
        return servicesArrayBox;
    }

    public AvailableServices getServices() {
        return services;
    }

    public static JLabel getCostField() {
        return costField;
    }

    public static JButton getOkButton() {
        return okButton;
    }

    public static ButtonGroup getVihicle() {
        return vehicle;
    }

   
}
