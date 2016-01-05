package carwashclient;

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
            if (source.getText().equals("Μηχανή") ||source.getText().equals("  Bike  ")) {
                SecondWinClient.setFlagVihicle(2);
                SecondWinClient.setCostField("0.0  €    ");//se periptosi pou allaksei epilogi pio meta
                for (int i = 0; i < SecondWinClient.getServicesArrayBox().size(); i++) {
                    SecondWinClient.getServicesArrayBox().get(i).setEnabled(false);
                    SecondWinClient.getServicesArrayBox().get(i).setSelected(false);
                    if (AvailableServices.getListServices().get(i).getCost()[2] != 0) {
                        SecondWinClient.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "     " + AvailableServices.getListServices().get(i).getCost()[2] + "  €");
                        SecondWinClient.getServicesArrayBox().get(i).setEnabled(true);
                    }
                    else{
                        SecondWinClient.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "                 ");
                    }
                }
            } else if (source.getText().equals("Φορτηγό") || source.getText().equals("  Truck  ")) {
                SecondWinClient.setFlagVihicle(1);
                SecondWinClient.setCostField("0.0  €    ");
                for (int i = 0; i < SecondWinClient.getServicesArrayBox().size(); i++) {
                    SecondWinClient.getServicesArrayBox().get(i).setEnabled(false);
                    SecondWinClient.getServicesArrayBox().get(i).setSelected(false);
                    if (AvailableServices.getListServices().get(i).getCost()[1] != 0) {
                        SecondWinClient.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "     " + AvailableServices.getListServices().get(i).getCost()[1] + "  €");
                        SecondWinClient.getServicesArrayBox().get(i).setEnabled(true);
                    }
                    else{
                       SecondWinClient.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "                 ");
                    }
                }
            } else if (source.getText().equals("Αυτοκίνητο") || source.getText().equals("  Car  ")) {
                SecondWinClient.setFlagVihicle(0);
                SecondWinClient.setCostField("0.0  €    ");
                for (int i = 0; i < SecondWinClient.getServicesArrayBox().size(); i++) {
                    SecondWinClient.getServicesArrayBox().get(i).setEnabled(false);
                    SecondWinClient.getServicesArrayBox().get(i).setSelected(false);
                    if (AvailableServices.getListServices().get(i).getCost()[0] != 0) {
                        SecondWinClient.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "     " + AvailableServices.getListServices().get(i).getCost()[0] + "  €");
                        SecondWinClient.getServicesArrayBox().get(i).setEnabled(true);
                    }
                    else{
                        SecondWinClient.getServicesArrayBox().get(i).setText(AvailableServices.getListServices().get(i).getName() + "                 ");
                    }
                }
            }
            SecondWinClient.getOkButton().setEnabled(false);
        }
    }
}
