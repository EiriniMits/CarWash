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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Giorgos
 * 
 */
public class ShowServices extends JFrame{
    private static int row;

    
    /**
    * Constructor of the ShowServices class.
    * <p>
    * Creates a new window where the user can see the summary of the services supplied to 
    * the old customer selected. The button ΕΠΙΣΤΡΟΦΗ(return) return to the previous window.
    * </p>
    * @param parent
    * @param row The number of the row selected to be previewed.
    */
    public ShowServices(Object parent, int row) {
        this.row = row;
        this.setTitle("Υπηρεσίες");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 850);
        this.setLayout(new GridLayout(5, 2));


        JLabel vihicleType = new JLabel("Τύπος οχήματος :   ");
        vihicleType.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(vihicleType);

        JLabel vihicleTypeInfo = new JLabel("");
        switch (CheckOutWin.getCos().get(row).getVehicleType()) {
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

        JLabel numberOfVehicleInfo = new JLabel(CheckOutWin.getCos().get(row).getVehicleNumber());
        numberOfVehicleInfo.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(numberOfVehicleInfo);


        JLabel servOfVehicle = new JLabel("Επιλεγμένες υπηρεσίες οχήματος :   ");
        servOfVehicle.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(servOfVehicle);

        String servOfVehicleInfo = "";
        for (int i = 0; i < CheckOutWin.getCos().get(row).getServArray().size(); i++) {

            servOfVehicleInfo += "•  " + AvailableServices.getListServices().get(CheckOutWin.getCos().get(row).getServArray().get(i)).getName() + "\n";

        }
        JTextArea servOfVehicleInfoPanel = new JTextArea(servOfVehicleInfo);
        servOfVehicleInfoPanel.setEditable(false);
        servOfVehicleInfoPanel.setBackground(this.getContentPane().getBackground());
        servOfVehicleInfoPanel.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(servOfVehicleInfoPanel);


        JLabel costOfVehicle = new JLabel("Συνολικό κόστος οχήματος :   ");
        costOfVehicle.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(costOfVehicle);

        JLabel costOfVehicleInfo = new JLabel(CheckOutWin.getCos().get(row).getCost() + "");
        costOfVehicleInfo.setFont(new Font("Sanserif", Font.BOLD, 20));
        add(costOfVehicleInfo);

        JButton okBut = new JButton("ΕΠΙΣΤΡΟΦΗ");
        okBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowServices.this.dispose();
            }
        });
        okBut.setPreferredSize(new Dimension(150, 50));
        JPanel a = new JPanel(new FlowLayout());
        a.add(okBut);
        add(a);

    }

    /**
     * Returns the row of the costumer selected by the user to be displayed. 
     * @return row
     */
    public static int getRow() {
        return row;
    }
}