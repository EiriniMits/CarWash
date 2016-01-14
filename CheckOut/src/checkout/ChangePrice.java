
package checkout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Eirini
 */
public class ChangePrice extends javax.swing.JFrame{
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JFrame f;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JFrame frame2;
    private static double cost1;
    private static double cost2;
    private static double cost3;
    private int[] cost;
    
    public ChangePrice(){
        cost = new int[3];
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        final String[] strings = new String[20];
                for (int i = 0; i < AvailableServices.getListServices().size(); i++) {
                                strings[i] = AvailableServices.getListServices().get(i).getName();}
        frame2 = new JFrame();
        frame2.setTitle("Τροποποίηση Tιμών");
        frame2.setSize(500,800);
        frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame2.setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jList1.setSelectionInterval(0, 0);
        jList1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jCheckBox1.setEnabled(false);
        jCheckBox2.setEnabled(false);
        jCheckBox3.setEnabled(false);
        MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            jCheckBox1.setEnabled(true);
            jCheckBox2.setEnabled(true);
            jCheckBox3.setEnabled(true);
        }
        };
        jList1.addMouseListener(mouseListener);
        jList1.setSelectionBackground(new java.awt.Color(0, 102, 204));
        jScrollPane1.setViewportView(jList1);
        jTextField1.setEnabled(false);
        jLabel1.setEnabled(false);
        jTextField2.setEnabled(false);
        jLabel2.setEnabled(false);
        jTextField3.setEnabled(false);
        jLabel3.setEnabled(false);
        jCheckBox1.setText("Αυτοκίνητο");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               jTextField1.setEnabled(true);
               jLabel1.setEnabled(true);
            }
        });
        
        jCheckBox2.setText("Φορτηγό");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2.setEnabled(true);
               jLabel2.setEnabled(true);
            }
        });

        jCheckBox3.setText("Μηχανή");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3.setEnabled(true);
                jLabel3.setEnabled(true);
            }
        });

        jLabel1.setText("Νέα Τιμή€:");

        jLabel2.setText("Νέα Τιμή€:");

        jLabel3.setText("Νέα Τιμή€:");

        jLabel4.setText("Eπέλεξε την υπηρεσία στην οποία θέλεις να αλλάξεις τιμή. 'Επειτα επέλεξε ");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        jLabel5.setText("τα οχήματα που επιθυμείς και εισήγαγε την νέα τιμή.");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton1.setText("ΟΚ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(!jList1.isSelectionEmpty()){
                    if(!(!jCheckBox1.isSelected() && !jCheckBox2.isSelected() && !jCheckBox3.isSelected())){
                        String s = (String) jList1.getSelectedValue();
                        cost1=0;
                         cost2=0;
                         cost3=0;
                         int error=0;
                        if(jCheckBox1.isSelected()){
                             String cost = jTextField1.getText();
                             try{
                                        cost1 = Double.parseDouble(cost);
                                }catch(NumberFormatException g){
                                          error = 1;                                       
                                }
                         }
                         if(jCheckBox2.isSelected()){                  
                            String cost = jTextField2.getText();
                            try{
                                        cost2 = Double.parseDouble(cost);
                                }catch(NumberFormatException g){
                                          error = 1;                                        
                                }

                         }
                         if(jCheckBox3.isSelected()){                  
                            String cost = jTextField3.getText();
                            try{
                                        cost3 = Double.parseDouble(cost);
                                }catch(NumberFormatException g){
                                          error = 1;                              
                                }
                         }
                         if(error==0){
                         change(s,cost1,cost2,cost3);
                         frame2.dispose();
                         }
                         else{
                             f=new JFrame();
                                     JOptionPane.showMessageDialog(f,"Το πεδίο 'Νέα Τιμή' δέχεται μόνο ακέραιους ή δεκαδικούς αριθμούς!","Error", JOptionPane.ERROR_MESSAGE);
                         }
                    }
                    else{
                            f=new JFrame();
                            JOptionPane.showMessageDialog(f,"Δεν έχεις επιλέξει όχημα!","Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                else{
                            f=new JFrame();
                            JOptionPane.showMessageDialog(f,"Δεν έχεις επιλέξει υπηρεσία!","Error", JOptionPane.ERROR_MESSAGE);
                        }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(19, 19, 19)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jCheckBox2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox3)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        frame2.add(jPanel1);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);

    }
    public void change(String s,double cost1,double cost2,double cost3) {
        File filee = new File("test.txt");
                            FileWriter fStreamm;
                            try{
                                FileInputStream fis = new FileInputStream("AvailableServices.txt");
                                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                                BufferedWriter out = new BufferedWriter(new FileWriter(filee));
                                String line; 
                                int k =0;                            
                                while ((line = in.readLine()) != null) {
                                    try {
                                                                                                                                            
                                            String name = AvailableServices.getListServices().get(k).getName();
                                            String name2 = AvailableServices.getListServices().get(k).getName2();
                                            int idd=AvailableServices.getListServices().get(k).getId();
                                            out.write(name+"\\ "+name2+"\\ "+idd+" \\ ");
                                            for (int j = 0; j < AvailableServices.getListServices().get(k).getCode().size(); j++){
                                                out.write(AvailableServices.getListServices().get(k).getCode().get(j)+" ");
                                            }
                                                if(AvailableServices.getListServices().get(k).getName().equals(s)){
                                                    if(cost1!=0){
                                                        out.write("\\ "+cost1+" ");
                                                       }
                                                       else{
                                                          out.write("\\ "+" "+AvailableServices.getListServices().get(k).getCost()[0]+" ");
                                                       }
                                                    if(cost2!=0){
                                                        out.write(cost2+" ");
                                                       }
                                                       else{
                                                          out.write(AvailableServices.getListServices().get(k).getCost()[1]+" ");
                                                       }
                                                     if(cost3!=0){
                                                        out.write(cost3+" ");
                                                       }
                                                       else{
                                                          out.write(AvailableServices.getListServices().get(k).getCost()[2]+" ");
                                                       }
                                                }
                                                else{
                                                    out.write("\\ "+" "+AvailableServices.getListServices().get(k).getCost()[0]+" "+AvailableServices.getListServices().get(k).getCost()[1]+" "+AvailableServices.getListServices().get(k).getCost()[2]);
                                                }

                                            out.newLine();
                                            k++;                                  
                                                   
                                    } catch (IOException ex) {
                                            System.out.println("Δεν δημιουργειται το αρχειο");
                                    }
                                        
                                }
                                in.close();
                               out.close();
                            } catch (IOException e) {
                                 System.out.println("Δεν ανοιγει το αρχειο");
                            }
                            try{
                                    FileInputStream fis = new FileInputStream(filee);
                                    BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                                    BufferedWriter out = new BufferedWriter(new FileWriter("AvailableServices.txt"));
                                    String line;
                                    while ((line = in.readLine()) != null) {

                                        try {
                                                out.write(line);
                                                out.newLine();


                                        } catch (IOException ex) {
                                            System.out.println("Δεν ανοιγει το αρχειο");
                                        }
                                    }



                          in.close();
                          out.close();
                          filee.deleteOnExit();
                    } catch (IOException e) {
                                   System.out.println("Δεν ανοιγει το αρχειο");
                    }
                        f=new JFrame();
                            JOptionPane.showMessageDialog(f,"Οι τιμές της υπηρεσίας '"+s+"' τροποποιήθηκαν επιτυχώς");    
    }
}
