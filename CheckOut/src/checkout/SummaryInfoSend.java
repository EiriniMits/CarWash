/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Anestis Giorgos
 */
public class SummaryInfoSend extends JFrame {

    private static int row;
    
/**
 * Constructor of the SummaryInfoSend class.
 * <p>
 * Creates a new window where the user can see the summary of the services supplied to 
 * the current customer that wants to pay. Also there are given two choices Ακύρωση(cancel) or Επιβεβαίωση(confirm).<br>
 * If Ακύρωση(cancel) is selected we return to the previous window. Else if Επιβεβαίωση(confirm) is selected we assume 
 * that the client has payed and is removed from the current customers and added to the old customers.
 * </p>
 * @param parent
 * @param row The number of the row selected to pay.
 */
    
    public SummaryInfoSend(Object parent, int row) {
        this.row = row;
        this.setTitle("Summary");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        //this.setResizable(false);
        this.setLayout(new GridLayout(5, 2));


        JLabel vihicleType = new JLabel("Τύπος οχήματος :   ");
        vihicleType.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(vihicleType);

        JLabel vihicleTypeInfo = new JLabel("");
        switch (CheckOutWin.getArrayCos().get(row).getVehicleType()) {
            case "Αυτοκίνητο":
                vihicleTypeInfo.setText("Αυτοκίνητο");
                break;
            case "Τζίπ":
                vihicleTypeInfo.setText("Τζίπ");
                break;
            default:
                vihicleTypeInfo.setText("Μηχανή");
                break;
        }
        vihicleTypeInfo.setFont(new Font("Sanserif", Font.ITALIC, 20));
        add(vihicleTypeInfo);



        JLabel numberOfVehicle = new JLabel("Αριθμός κυκλοφορίας οχήματος :   ");
        numberOfVehicle.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(numberOfVehicle);

        JLabel numberOfVehicleInfo = new JLabel(CheckOutWin.getArrayCos().get(row).getVehicleNumber());
        numberOfVehicleInfo.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(numberOfVehicleInfo);


        JLabel servOfVehicle = new JLabel("Επιλεγμένες υπηρεσίες οχήματος :   ");
        servOfVehicle.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(servOfVehicle);

        String servOfVehicleInfo = "";
        for (int i = 0; i < CheckOutWin.getArrayCos().get(row).getServArray().size(); i++) {

            servOfVehicleInfo += "•  " + AvailableServices.getListServices().get(CheckOutWin.getArrayCos().get(row).getServArray().get(i)).getName() + "\n";

        }
        JTextArea servOfVehicleInfoPanel = new JTextArea(servOfVehicleInfo);
        servOfVehicleInfoPanel.setEditable(false);
        servOfVehicleInfoPanel.setBackground(this.getContentPane().getBackground());
        servOfVehicleInfoPanel.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(servOfVehicleInfoPanel);


        JLabel costOfVehicle = new JLabel("Συνολικό κόστος οχήματος :   ");
        costOfVehicle.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(costOfVehicle);

        JLabel costOfVehicleInfo = new JLabel(CheckOutWin.getArrayCos().get(row).getCost() + "");
        costOfVehicleInfo.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(costOfVehicleInfo);

        JButton returnBut = new JButton("Ακύρωση");
        returnBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SummaryInfoSend.this.dispose();
            }
        });
        returnBut.setPreferredSize(new Dimension(150, 50));
        JPanel b = new JPanel(new FlowLayout());
        b.add(returnBut);
        add(b);

        JButton okBut = new JButton("Επιβεβαίωση");
        okBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                String time = dateFormat.format(date);
                ManagmentFile.refreshFile(CheckOutWin.getArrayCos().get(SummaryInfoSend.getRow()), time,0);
                CheckOutWin.getArrayCos().remove(SummaryInfoSend.getRow());
                CheckOutWin.getModel().removeRow(SummaryInfoSend.getRow());
                ManagmentFile.refreshNowFile(CheckOutWin.getArrayCos());
                SummaryInfoSend.this.dispose();
            }
        });
        okBut.setPreferredSize(new Dimension(150, 50));
        JPanel a = new JPanel(new FlowLayout());
        a.add(okBut);
        add(a);

    }

    /**
     * Returns the row of the current costumer selected by the user to be payed. 
     * @return row
     */
    public static int getRow() {
        return row;
    }
}
