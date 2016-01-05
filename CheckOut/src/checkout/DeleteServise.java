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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Eirini
 */
public class DeleteServise extends JFrame{
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList2;
    private javax.swing.JPanel Panel1;
    private javax.swing.JFrame frame2;
    private javax.swing.JFrame frame1;
    private javax.swing.JFrame f;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    
    public DeleteServise(){
                frame2 = new JFrame();
                frame2.setTitle("Διαγραφή Υπηρεσίας");
                final String[] strings = new String[20];
                for (int i = 0; i < AvailableServices.getListServices().size(); i++) {
                                strings[i] = AvailableServices.getListServices().get(i).getName();}
                frame2.setSize(500,800);
                frame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                Panel1 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jList2 = new JList(strings);
                jButton2 = new javax.swing.JButton();            
                frame2.setResizable(false);
                Panel1.setBackground(new java.awt.Color(255, 255, 255));
                jLabel2.setText("Eπέλεξε την υπηρεσία που θέλεις να διαγράψεις");
                jList2.setSelectionInterval(0, 0);
                jList2.setModel(new javax.swing.AbstractListModel() {                        
                    public int getSize() { return strings.length; }
                    public Object getElementAt(int i) { return strings[i]; }
                });
                jScrollPane2.setViewportView(jList2);

                jButton2.setText("ΟΚ");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        if(!jList2.isSelectionEmpty()){
                            String s = (String) jList2.getSelectedValue();
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog (null, "Θέλεις σίγουρα να διαγράψεις την υπηρεσία\n'"+s+"';","Warning",dialogButton);

                            if(dialogResult == JOptionPane.YES_OPTION){
                                    Scanner scan = null;
                                    int p=0;int id=300;
                                    try {
                                        scan = new Scanner(new File("AvailableServices.txt"));
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(AddServise.class.getName()).log(Level.SEVERE, null, ex);
                                    }    
                                    try {                      
                                        while (scan.hasNext()) {
                                            String line =scan.nextLine();
                                            if(AvailableServices.getListServices().get(p).getName().equals(s)){
                                                        id =AvailableServices.getListServices().get(p).getId(); 
                                                        break;
                                        }
                                            p++;

                                        }
                                    } catch (NumberFormatException g) {
                                        JOptionPane.showMessageDialog(null, "Wrong input file.", "Error!", JOptionPane.OK_OPTION);
                                        System.exit(0);
                                    }
                                    remove(s,id); 
                             
                                    frame2.dispose();
                            }
                            else if(dialogResult == JOptionPane.NO_OPTION){
                                frame2.dispose();
                            }
                       }
                        else{
                            f=new JFrame();
                            JOptionPane.showMessageDialog(f,"Δεν έχεις επιλέξει υπηρεσία!","Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(Panel1);
                Panel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                                 jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(109, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton2)
                        .addContainerGap(13, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                frame2.add(Panel1);
                frame2.pack();
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
        
    }
    public void remove(String s,int id) {
        File filee = new File("test.txt");
                            FileWriter fStreamm;
                            try{
                                FileInputStream fis = new FileInputStream("AvailableServices.txt");
                                BufferedReader in = new BufferedReader(new InputStreamReader(fis));
                                BufferedWriter out = new BufferedWriter(new FileWriter(filee));
                                String line; 

                               int i =0;
                                while ((line = in.readLine()) != null) {
                                    try {
                                        if (AvailableServices.getListServices().get(i).getName().equals(s)){                                           
                                            i++;
                                              
                                        }                     
                                        else{
                                        String name = AvailableServices.getListServices().get(i).getName();
                                        String name2 = AvailableServices.getListServices().get(i).getName2();
                                        int idd;
                                        if(AvailableServices.getListServices().get(i).getId()>(id)){
                                                idd = AvailableServices.getListServices().get(i).getId() - 1;                            
                                        }    
                                        else{
                                            idd=AvailableServices.getListServices().get(i).getId();
                                        }
                                        double cost1 = AvailableServices.getListServices().get(i).getCost()[0];
                                        double cost2 = AvailableServices.getListServices().get(i).getCost()[1];
                                        double cost3 = AvailableServices.getListServices().get(i).getCost()[2];
                                        out.write(name+"\\ "+name2+"\\ "+idd+" \\ ");
                                        for (int j = 0; j < AvailableServices.getListServices().get(i).getCode().size(); j++){
                                            if(AvailableServices.getListServices().get(i).getCode().get(j).equals(id)){                
                                                continue;
                                            }if((AvailableServices.getListServices().get(i).getCode().get(j))>id){
                                                int newid1 = AvailableServices.getListServices().get(i).getCode().get(j) - 1;
                                                out.write(newid1+" ");
                                            }
                                            else{
                                            out.write(AvailableServices.getListServices().get(i).getCode().get(j)+" ");
                                            }
                                        }
                                        out.write("\\ "+" "+cost1 +" "+cost2 +" "+ cost3);
                                        out.newLine();
                                        i++;
                                        }           
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
                            JOptionPane.showMessageDialog(f,"H υπηρεσία '"+s+"' διαγράφηκε με επιτυχία");
    }
    
}
