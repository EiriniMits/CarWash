package carwashclient;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

/**
 * This is a windows that opens and show to the customer what services he has chosen. Its only for confirmational reasons.
 * @author Anestis
 */
public class SummaryInfoSend extends JFrame{

    public SummaryInfoSend() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        ImageIcon img=new ImageIcon("carWash.gif");
        this.setIconImage(img.getImage());
        this.getContentPane().setBackground(new Color(153,255,255));
        this.setTitle("Επιβεβαίωση");
        if(FirstWinClient.lang==1){
        this.setTitle("Summary");
        }
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1280, 820);
        this.setLayout(new GridLayout(5,2));
           
        
        JLabel vehicleType =new JLabel("Τύπος οχήματος :   ");
        if(FirstWinClient.lang==1){
            vehicleType.setText("Type of vehicle");
        }
        vehicleType.setFont(new Font("Sanserif",Font.BOLD,20));
        add(vehicleType);
        
        JLabel vehicleTypeInfo =new JLabel("");
        if(SecondWinClient.getFlagVihicle()==0){
            if(FirstWinClient.lang==0){
            vehicleTypeInfo.setText("Αυτοκίνητο");
            }
            else if(FirstWinClient.lang==1){
                vehicleTypeInfo.setText("Car");
            }
        }
        else if(SecondWinClient.getFlagVihicle()==1){
            if(FirstWinClient.lang==0){
            vehicleTypeInfo.setText("Φορτηγό");
            }
            else if(FirstWinClient.lang==1){
                vehicleTypeInfo.setText("Truck");
            }
        }
        else{
            if(FirstWinClient.lang==0){
            vehicleTypeInfo.setText("Μηχανή");
            }
            else if(FirstWinClient.lang==1){
                vehicleTypeInfo.setText("Bike");
            }
        }
        vehicleTypeInfo.setFont(new Font("Sanserif",Font.ITALIC,20));
        add(vehicleTypeInfo);
        
        JLabel numberOfVehicle =new JLabel("Αριθμός κυκλοφορίας οχήματος :   ");
        if(FirstWinClient.lang==1){
            numberOfVehicle.setText("Number of Vehicle");
        }
        
        numberOfVehicle.setFont(new Font("Sanserif",Font.BOLD,20));
        add(numberOfVehicle);
        
        JLabel numberOfVehicleInfo =new JLabel(FirstWinClient.getTextfield());
        numberOfVehicleInfo.setFont(new Font("Sanserif",Font.BOLD,20));
        add(numberOfVehicleInfo);
        
        
        JLabel servOfVehicle =new JLabel("Επιλεγμένες υπηρεσίες :   ");
        if(FirstWinClient.lang==1){
            servOfVehicle.setText("List of selected services");
        }
        servOfVehicle.setFont(new Font("Sanserif",Font.BOLD,20));
        add(servOfVehicle);
        
        String servOfVehicleInfo="";
        for(int i=0;i<SecondWinClient.getServicesArrayBox().size();i++){
            if(SecondWinClient.getServicesArrayBox().get(i).isSelected()){
                servOfVehicleInfo+="•  "+SecondWinClient.getServicesArrayBox().get(i).getText()+"\n";
            }
        }
        JTextArea servOfVehicleInfoPanel =new JTextArea(servOfVehicleInfo);
        servOfVehicleInfoPanel.setEditable(false);
        servOfVehicleInfoPanel.setBackground(this.getContentPane().getBackground());
        servOfVehicleInfoPanel.setFont(new Font("Sanserif",Font.BOLD,20));
        add(servOfVehicleInfoPanel);
 
        
        JLabel costOfVehicle =new JLabel("Συνολικό κόστος οχήματος :   ");
        if(FirstWinClient.lang==1){
            costOfVehicle.setText("Total Cost");
        }
        costOfVehicle.setFont(new Font("Sanserif",Font.BOLD,20));
        add(costOfVehicle);
        
        JLabel costOfVehicleInfo =new JLabel(SecondWinClient.getCostField().getText());
        costOfVehicleInfo.setFont(new Font("Sanserif",Font.BOLD,20));
        add(costOfVehicleInfo);
        
        JButton returnBut=new JButton("Επιστροφή");
        if(FirstWinClient.lang==1){
            returnBut.setText("Return");
        }
        returnBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SummaryInfoSend.this.dispose();
            }
        });
        returnBut.setPreferredSize(new Dimension(150,50));
        JPanel b =new JPanel(new FlowLayout());
        
        b.add(returnBut);
        b.setBackground(new Color(153,255,255));
        add(b);
        
        JButton okBut=new JButton("Συνέχεια");
        if(FirstWinClient.lang==1){
            okBut.setText("ok");
        }
        okBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> infSen = new ArrayList<>(8);
                infSen.add(FirstWinClient.getTextfield());
                infSen.add(SecondWinClient.getFlagVihicle() + "");
                for (int i = 0; i < SecondWinClient.getServicesArrayBox().size(); i++) {
                    if (SecondWinClient.getServicesArrayBox().get(i).isSelected()) {
                        infSen.add(i + "");
                    }
                }
                InfoSend newSend = new InfoSend(infSen,0);
                SecondWinClient.getVihicle().clearSelection();
                SecondWinClient.getCostField().setText("0.0  €");
                SecondWinClient.getOkButton().setEnabled(false);
                for (int i = 0; i < SecondWinClient.getServicesArrayBox().size(); i++) {
                    SecondWinClient.getServicesArrayBox().get(i).setSelected(false);
                    SecondWinClient.getServicesArrayBox().get(i).setEnabled(false);
                }
                FirstWinClient.setTextfield("");
                CarWashClient.getWin2().setVisible(false);
                CarWashClient.getWin1().setVisible(true);
                SummaryInfoSend.this.dispose();
            }
        });
        okBut.setPreferredSize(new Dimension(150,50));
        JPanel a =new JPanel(new FlowLayout());
        a.add(okBut);
        a.setBackground(new Color(153,255,255));
        add(a);
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
}
