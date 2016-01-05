/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author Harris
 */
public class ListenerForListServices implements ActionListener  {
  
    @Override
    public void actionPerformed(ActionEvent e) {
        Set<Integer> orion = new HashSet<>();
        String name = e.getActionCommand();
        double cost = 0;
        if (ShowAvailableServices.getFlagVihicle() == 2) {
            ShowAvailableServices.getServicesArrayBox().get(0).setEnabled(true);
            ShowAvailableServices.getServicesArrayBox().get(3).setEnabled(true);
            if (ShowAvailableServices.getServicesArrayBox().get(0).isSelected()) {
                ShowAvailableServices.getServicesArrayBox().get(3).setEnabled(false);
            } else if (ShowAvailableServices.getServicesArrayBox().get(3).isSelected()) {
                ShowAvailableServices.getServicesArrayBox().get(0).setEnabled(false);
            }
        } else {
            for (int i = 0; i < ShowAvailableServices.getServicesArrayBox().size(); i++) {
                if (ShowAvailableServices.getServicesArrayBox().get(i).isSelected()) {
                    for (int j = 0; j < AvailableServices.getListServices().get(i).getCode().size(); j++) {//stin proti thesi einai o typos tou oximatos
                        orion.add(AvailableServices.getListServices().get(i).getCode().get(j));//save sto hash set osa apenergopoiountai synolika
                    }
                }
                ShowAvailableServices.getServicesArrayBox().get(i).setEnabled(true);
            }
            Iterator<Integer> itOrion = orion.iterator();
            while (itOrion.hasNext()) {
                ShowAvailableServices.getServicesArrayBox().get(itOrion.next()).setEnabled(false);
            }
        }
        
        
    }
        
        
        

    
}
