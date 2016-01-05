package checkout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anestis
 */
public class CheckOutWin extends JFrame {

    private JTextField textField;
    private static ArrayList<Costumer> ArrayCos = new ArrayList<>();
    private static JTable carTable;
    private static DefaultTableModel model;
    private JButton paymentButton;
    private JButton olderPayment;
    private JButton nowPayment;
    private JButton showServices;
    private JButton settings;
    private JMenuBar jmb;
    private JMenu jmFile;
    private JMenuItem jmiSettings;

    /**
     * Creates the Check out interface and all its components.
     */
    public CheckOutWin() {
        this.setTitle("CarWash Check Out.");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new checkExit());
        this.setSize(850, 500);
        jmb = new JMenuBar();

        jmFile = new JMenu("Ρυθμίσεις");
        ImageIcon icon = new ImageIcon("settings.png");
        jmFile.setIcon(icon);
        jmiSettings = new JMenuItem("Υπηρεσίες");   
        jmFile.add(jmiSettings);       
        jmb.add(jmFile);
        jmiSettings.addActionListener(new paymentActionListener());
        this.setJMenuBar(jmb);
        this.setVisible(true);
        //Fortonei apo to arxeio tous torinous Pelates
        ArrayCos=ManagmentFile.readFromFile(1);
        //Εδώ κάνω τα κελιά not editable
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
       
        textField = new JTextField();
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtersearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtersearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            private void filtersearch() {
                String filter = textField.getText();
                if (!olderPayment.isEnabled()) {
                    ArrayList<Costumer> oldCos = ManagmentFile.readFromFile(0);
                    model.setRowCount(0);
                    for (int i = 0; i < oldCos.size(); i++) {
                        String str = (String) oldCos.get(i).getVehicleNumber();
                        if (str.contains(filter)) {
                            model.addRow(new Object[]{oldCos.get(i).getVehicleNumber(), oldCos.get(i).getVehicleType(), oldCos.get(i).getCost() + "", oldCos.get(i).getTimeInsert(), oldCos.get(i).getTimeOut()});
                        }
                    }
                } else if (!nowPayment.isEnabled()) {
                    model.setRowCount(0);
                    for (int i = 0; i < ArrayCos.size(); i++) {
                        String str = (String) ArrayCos.get(i).getVehicleNumber();
                        if (str.contains(filter)) {
                            model.addRow(new Object[]{ArrayCos.get(i).getVehicleNumber(), ArrayCos.get(i).getVehicleType(), ArrayCos.get(i).getCost() + "", ArrayCos.get(i).getTimeInsert(), ArrayCos.get(i).getTimeOut()});
                        }
                    }
                }
            }
        });
        textField.setPreferredSize(new Dimension(200, 25));
        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.add(textField);
        add(northPanel, BorderLayout.NORTH);

        model.setColumnIdentifiers(new Object[]{"Αριθμός κυκλοφορίας", "Τύπος οχήματος", "Κόστος", "Ώρα εισαγωγής", "Ώρα πληρωμής"});
        carTable = new JTable(model);
        carTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (ArrayCos.isEmpty()) {
                        return;
                    }
                    int row = carTable.getSelectedRow();
                    SummaryInfoSend sumWin = new SummaryInfoSend(this, row);
                    sumWin.setVisible(true);
                }
            }
        });
        carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane firstScrollPane = new JScrollPane(carTable);
        firstScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        firstScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        firstScrollPane.setPreferredSize(new Dimension(150, 400));
        this.add(firstScrollPane, BorderLayout.CENTER);
        
        JPanel p1 = new JPanel(new GridLayout(4, 1));
        
        paymentButton = new JButton("Πληρωμή");
        paymentButton.addActionListener(new paymentActionListener());
        p1.add(paymentButton);
        olderPayment = new JButton("Παλαιότεροι πελάτες");
        olderPayment.addActionListener(new paymentActionListener());
        p1.add(olderPayment);
        
        showServices = new JButton("Προβολή Υπηρεσιών");
        showServices.addActionListener(new paymentActionListener());
        showServices.setEnabled(false);
        p1.add(showServices);
        
        
        nowPayment = new JButton("Τωρινοί πελάτες");
        nowPayment.addActionListener(new paymentActionListener());
        p1.add(nowPayment);
        add(p1, BorderLayout.EAST);
        
       
    }
    
    /**
     * Reads from the PaymentsFile.dat file the old costumers data 
     * and stores them in an ArrayList named oldCos.
     * @return oldCos
     */
    public static ArrayList<Costumer> getCos(){
        ArrayList<Costumer> oldCos = ManagmentFile.readFromFile(0);
        return oldCos;
    }
    
    /**
     * Returns an ArrayList containing all the constumers that has not payed yet.  
     * @return ArrayCos 
     */

    public static ArrayList<Costumer> getArrayCos() {
        return ArrayCos;
    }

    /**
     * Retruns the DefaultTableModel used by the carTable JTable.
     * @return model
     */
    public static DefaultTableModel getModel() {
        return model;
    }

    /**
     * Returns the JTable used by the application.
     * @return carTable
     */
    public static JTable getCarTable() {
        return carTable;
    }

    /**
     * Contains the Action Listener of each choice made by the user.
     * <ul>
     * <li>Πληρωμή </li>
     * <li>Παλαιότεροι πελάτες</li>
     * <li>Προβολή Υπηρεσιών</li>
     * <li>Τωρινοί πελάτες</li>
     * </ul>
     */
    private class paymentActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Πληρωμή":
                    int row = carTable.getSelectedRow();
                    if (ArrayCos.isEmpty() || row==-1) {
                        return;
                    }
                    SummaryInfoSend sumWin = new SummaryInfoSend(this, row);
                    sumWin.setVisible(true);
                    break;
                case "Παλαιότεροι πελάτες":
                    ArrayList<Costumer> oldCos = ManagmentFile.readFromFile(0);
                    model.setRowCount(0);
                    for (int i = 0; i < oldCos.size(); i++) {
                        model.addRow(new Object[]{oldCos.get(i).getVehicleNumber(), oldCos.get(i).getVehicleType(), oldCos.get(i).getCost() + "", oldCos.get(i).getTimeInsert(), oldCos.get(i).getTimeOut()});
                    }
                    paymentButton.setEnabled(false);
                    olderPayment.setEnabled(false);
                    showServices.setEnabled(true);
                    nowPayment.setEnabled(true);
                    break;
                case "Προβολή Υπηρεσιών":
                    ArrayList<Costumer> oldCos2 = ManagmentFile.readFromFile(0);
                    int row2 = carTable.getSelectedRow();
                    if (oldCos2.isEmpty() || row2==-1) {
                        return;
                    }
                    ShowServices show = new ShowServices(this, row2);
                    show.setVisible(true);
                    break;
                case "Τωρινοί πελάτες":
                    model.setRowCount(0);
                    for (int i = 0; i < ArrayCos.size(); i++) {
                        model.addRow(new Object[]{ArrayCos.get(i).getVehicleNumber(), ArrayCos.get(i).getVehicleType(), ArrayCos.get(i).getCost() + "", ArrayCos.get(i).getTimeInsert(), ArrayCos.get(i).getTimeOut()});
                    }
                    paymentButton.setEnabled(true);
                    nowPayment.setEnabled(false);
                    showServices.setEnabled(false);
                    olderPayment.setEnabled(true);
                    break;
                default:
            {
                try {
                    AvailableServices a1=new AvailableServices();
                } catch (IOException ex) {
                    Logger.getLogger(CheckOutWin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    ShowAvailableServices services;
            try {
                services = new ShowAvailableServices();
                services.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(CheckOutWin.class.getName()).log(Level.SEVERE, null, ex);
            }
                    //services.setVisible(true);
                    break;
            }
        }
    }

    /**
     * Checks if all the clients has payed before the program is closed.
     * If not a warning message appears.
     */
    private class checkExit extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            if (ArrayCos.isEmpty()) {
                new CheckOnExit().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Αδύνατος τερματισμός προγράμματος.");
            }
        }
    }
}