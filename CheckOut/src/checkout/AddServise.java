/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Eirini
 */
public class AddServise extends javax.swing.JFrame{
    private javax.swing.JFrame frame2;
    private javax.swing.JFrame f;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private static int id;
    private static double cost1=0;
    private static double cost2=0;
    private static double cost3=0;
    private static String name;
    private static String name2;
    private static String line;
    private static ArrayList<String> selectedServises;
    private static ArrayList<Integer> ids;
    
    public AddServise(){
        selectedServises = new ArrayList<>();
        ids = new ArrayList<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        final String[] strings = new String[20];
                for (int i = 0; i < AvailableServices.getListServices().size(); i++) {
                                strings[i] = AvailableServices.getListServices().get(i).getName();}
        frame2 = new JFrame();
        frame2.setTitle("Προσθήκη Υπηρεσίας");
        frame2.setSize(500,800);
        frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame2.setResizable(false);
        
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("'Ονομα στα Ελληνικά");

        jLabel3.setText("'Ονομα στα Αγγλικά");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
            }
        });
        jCheckBox1.setText("Αυτοκίνητο");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3.setEnabled(true);
                jLabel6.setEnabled(true);
            }
        });
        jCheckBox2.setText("Φορτηγό");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               jTextField5.setEnabled(true);
               jLabel7.setEnabled(true);
            }
        });

        jCheckBox3.setText("Μηχανή");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               jTextField4.setEnabled(true);
               jLabel5.setEnabled(true);
            }
        });
        
        jTextField3.setEnabled(false);
        
       jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        jTextField4.setEnabled(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
            }
        });

        jTextField5.setEnabled(false);
        jTextField5.setFocusTraversalPolicyProvider(true);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
            }
        });

        jLabel4.setText("Επέλεξε όχημα και πληκτρολόγησε τις αντίστοιχες τιμές");

        jLabel5.setText("Τιμή€:");
        jLabel5.setEnabled(false);

        jLabel6.setText("Τιμή€:");
        jLabel6.setEnabled(false);

        jLabel7.setText("Τιμή€:");
        jLabel7.setEnabled(false);

        jButton1.setText("ΟΚ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 name = jTextField1.getText();
                 name2 = jTextField2.getText();
                 if(!"".equals(name)){
                     if(!"".equals(name2)){
                     if(!(!jCheckBox1.isSelected() && !jCheckBox2.isSelected() && !jCheckBox3.isSelected())){
                            cost1=0;
                            cost2=0;
                            cost3=0;
                            int error=0;
                           if(jCheckBox1.isSelected()){
                               String cost = jTextField3.getText();
                                try{
                                        cost1 = Double.parseDouble(cost);
                                }catch(NumberFormatException g){
                                          error = 1;                                       
                                }
                            }
                            if(jCheckBox2.isSelected()){                  
                               String cost = jTextField5.getText();                              
                               try{
                                        cost3 = Double.parseDouble(cost);
                                }catch(NumberFormatException g){
                                          error = 1;                                        
                                }
                            }
                            if(jCheckBox3.isSelected()){                  
                               String cost = jTextField4.getText();
                               try{
                                        cost2 = Double.parseDouble(cost);
                                }catch(NumberFormatException g){
                                          error = 1;                              
                                }
                            }
                            if(error==0){
                            int[] selectedIx = jList2.getSelectedIndices();
                            int p=0;
                            if(selectedIx.length!=0){
                             for (int i = 0; i < selectedIx.length; i++) {
                                 Object sel = jList2.getModel().getElementAt(selectedIx[i]);
                                 String ap = sel.toString();
                                 selectedServises.add(ap);
                             }
                             int size = selectedIx.length,j=0;
                             for (int i = 0; i < 30; i++) {         
                                       if(AvailableServices.getListServices().get(i).getName().equals(selectedServises.get(j))){
                                                    ids.add(AvailableServices.getListServices().get(i).getId());
                                                    j++;
                                       }

                                       if(j==size){break;}
                             }
                             Scanner scan = null;
                                try {
                                    scan = new Scanner(new File("AvailableServices.txt"));
                                } catch (FileNotFoundException ex) {
                                    Logger.getLogger(AddServise.class.getName()).log(Level.SEVERE, null, ex);
                                }    
                                try {                      
                                    while (scan.hasNext()) {
                                        String line =scan.nextLine();
                                        p++;

                                    }
                                } catch (NumberFormatException g) {
                                    JOptionPane.showMessageDialog(null, "Wrong input file.", "Error!", JOptionPane.OK_OPTION);
                                    System.exit(0);
                                }
                             id = p;
                             line = name+"\\ "+name2+"\\ "+id+" \\ ";
                             for (Integer id1 : ids) {
                                 line = line.concat(id1 +" ");
                             }
                             line = line.concat("\\ "+cost1+" "+cost3+" "+cost2);
                          }
                          else{
                              id = p;
                              line = name+"\\ "+name2+"\\ "+id+" \\ ";
                              line = line.concat("\\ "+cost1+" "+cost3+" "+cost2);
                          }

                          add(line,id,ids);
                          f=new JFrame();
                           JOptionPane.showMessageDialog(f,"H υπηρεσία '" +name+ "' προστέθηκε με επιτυχία");
                                                  
                           frame2.dispose();
                            }
                            else{
                                     f=new JFrame();
                                     JOptionPane.showMessageDialog(f,"Το πεδίο 'Τιμή' δέχεται μόνο ακέραιους ή δεκαδικούς αριθμούς!","Error", JOptionPane.ERROR_MESSAGE);
                                 }
                             }
                    else{
                              f=new JFrame();
                              JOptionPane.showMessageDialog(f,"Δεν έχεις επιλέξει όχημα!","Error", JOptionPane.ERROR_MESSAGE);
                          }
                      }
                     else{
                              f=new JFrame();
                              JOptionPane.showMessageDialog(f,"Κενό το πεδίο ''Ονομα στα Αγγλικά'!","Error", JOptionPane.ERROR_MESSAGE);
                          }
                      }
                 else{
                     f=new JFrame();
                            JOptionPane.showMessageDialog(f,"Κενό το πεδίο ''Ονομα στα Ελληνικά'!","Error", JOptionPane.ERROR_MESSAGE);
                        }
            }
        });

        jLabel1.setText("Επέλεξε τη/τις υπηρεσίες με παρόμοιο περιεχόμενο που επιθυμείς να εμφανίζονται ");

        jLabel8.setText("μπλοκαρισμένες στο χρήση ");

        jList2.setModel(new javax.swing.AbstractListModel() {
          
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList2.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if(super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }
                else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jCheckBox1)
                            .addGap(52, 52, 52)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(58, 58, 58)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator1)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox2)
                                .addComponent(jCheckBox3))
                            .addGap(71, 71, 71)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addComponent(jSeparator2)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frame2.add(jPanel2);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }
    
    public void add(String s,int id,ArrayList<Integer> ids) {
        File filee = new File("test.txt");
                            FileWriter fStreamm;
                            try{
                                FileInputStream fis = new FileInputStream("AvailableServices.txt");
                                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                                BufferedWriter out = new BufferedWriter(new FileWriter(filee));
                                String line; 
                                int k =0;
                                /*if(!ids.isEmpty()){
                                /*for ( int i = 0; i < ShowAvailableServices.getServicesArrayBox().size(); i++) {
                                                for (Integer id1 : ids) {                                                      
                                                    if(AvailableServices.getListServices().get(i).getId()==id1){                                    
                                                        AvailableServices.getListServices().get(i).getCode().add(id);
                                                        break;
                                                    }
                                                }
                                            }
                                }*/
                                while ((line = in.readLine()) != null) {
                                    try {
                                        if(!ids.isEmpty()){  
                                        for (Integer id1 : ids) {                                                      
                                                    if(AvailableServices.getListServices().get(k).getId()==id1){                                    
                                                        AvailableServices.getListServices().get(k).getCode().add(id);
                                                        break;
                                                    }
                                                } 
                                        }
                                        if(ids.isEmpty()){
                                        out.write(line);
                                        out.newLine();
                                        }
                                        else{                          
                                            String name = AvailableServices.getListServices().get(k).getName();
                                            String name2 = AvailableServices.getListServices().get(k).getName2();
                                            int idd=AvailableServices.getListServices().get(k).getId();
                                            double cost1 = AvailableServices.getListServices().get(k).getCost()[0];
                                            double cost2 = AvailableServices.getListServices().get(k).getCost()[1];
                                            double cost3 = AvailableServices.getListServices().get(k).getCost()[2];
                                            out.write(name+"\\ "+name2+"\\ "+idd+" \\ ");
                                            for (int j = 0; j < AvailableServices.getListServices().get(k).getCode().size(); j++){
                                                out.write(AvailableServices.getListServices().get(k).getCode().get(j)+" ");
                                            }
                                            out.write("\\ "+" "+cost1 +" "+cost2 +" "+ cost3);
                                            out.newLine();
                                            k++;
                                        }
                                                   
                                    } catch (IOException ex) {
                                            System.out.println("Δεν δημιουργειται το αρχειο");
                                    }
                                        
                                }
                                out.write(s);
                                out.newLine();
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
                            
                            
    }
    

}
