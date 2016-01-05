/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkout;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JRadioButton;

/**
 *
 * @author Anestis
 */
public class ListenerForVehicle implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == e.SELECTED) { //αν επελέγη νέα περιοχή
            JRadioButton source = (JRadioButton) (e.getSource());
            if (source.getText().equals("Μηχανή")) {
              ShowAvailableServices.setFlagVihicle(2);
                for (int i = 0; i < ShowAvailableServices.getServicesArrayBox().size(); i++) {
                    ShowAvailableServices.getServicesArrayBox().get(i).setEnabled(false);
                    ShowAvailableServices.getServicesArrayBox().get(i).setSelected(false);
                    if (AvailableServices.getListServices().get(i).getCost()[2] != 0) {
                        ShowAvailableServices.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "     " + AvailableServices.getListServices().get(i).getCost()[2] + "  €");
                        ShowAvailableServices.getServicesArrayBox().get(i).setEnabled(true);
                    }
                    else{
                        ShowAvailableServices.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "                 ");
                    }
                }
            } else if (source.getText().equals("Φορτηγό")) {
                ShowAvailableServices.setFlagVihicle(1);
                for (int i = 0; i < ShowAvailableServices.getServicesArrayBox().size(); i++) {
                    ShowAvailableServices.getServicesArrayBox().get(i).setEnabled(false);
                    ShowAvailableServices.getServicesArrayBox().get(i).setSelected(false);
                    if (AvailableServices.getListServices().get(i).getCost()[1] != 0) {
                        ShowAvailableServices.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "     " + AvailableServices.getListServices().get(i).getCost()[1] + "  €");
                        ShowAvailableServices.getServicesArrayBox().get(i).setEnabled(true);
                    }
                    else{
                        ShowAvailableServices.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "                 ");
                    }
                }
            } else if (source.getText().equals("Αυτοκίνητο")) {
               ShowAvailableServices.setFlagVihicle(0);
                for (int i = 0; i < ShowAvailableServices.getServicesArrayBox().size(); i++) {
                    ShowAvailableServices.getServicesArrayBox().get(i).setEnabled(false);
                    ShowAvailableServices.getServicesArrayBox().get(i).setSelected(false);
                    if (AvailableServices.getListServices().get(i).getCost()[0] != 0) {
                        ShowAvailableServices.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "     " + AvailableServices.getListServices().get(i).getCost()[0] + "  €");
                        ShowAvailableServices.getServicesArrayBox().get(i).setEnabled(true);
                    }
                    else{
                        ShowAvailableServices.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "                 ");
                    }
                }
            }
           
        }
    }
}
