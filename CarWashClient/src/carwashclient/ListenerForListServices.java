package carwashclient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author Harris
 */
public class ListenerForListServices implements ActionListener {
 
    @Override
    public void actionPerformed(ActionEvent e) {
        Set<Integer> orion = new HashSet<>();
        String name = e.getActionCommand();
        double cost = 0;
        if (SecondWinClient.getFlagVihicle() == 2) {
            SecondWinClient.getServicesArrayBox().get(0).setEnabled(true);
            SecondWinClient.getServicesArrayBox().get(3).setEnabled(true);
            if (SecondWinClient.getServicesArrayBox().get(0).isSelected()) {
                SecondWinClient.getServicesArrayBox().get(3).setEnabled(false);
            } else if (SecondWinClient.getServicesArrayBox().get(3).isSelected()) {
                SecondWinClient.getServicesArrayBox().get(0).setEnabled(false);
            }
        } else {
            for (int i = 0; i < SecondWinClient.getServicesArrayBox().size(); i++) {
                if (SecondWinClient.getServicesArrayBox().get(i).isSelected()) {
                    for (int j = 0; j < AvailableServices.getListServices().get(i).getCode().size(); j++) {//stin proti thesi einai o typos tou oximatos
                        orion.add(AvailableServices.getListServices().get(i).getCode().get(j));//save sto hash set osa apenergopoiountai synolika
                    }
                }
                SecondWinClient.getServicesArrayBox().get(i).setEnabled(true);
            }
            Iterator<Integer> itOrion = orion.iterator();
            while (itOrion.hasNext()) {
                SecondWinClient.getServicesArrayBox().get(itOrion.next()).setEnabled(false);
            }
        }
       for (int i = 0; i < SecondWinClient.getServicesArrayBox().size(); i++) {
            if (SecondWinClient.getServicesArrayBox().get(i).isSelected()) {
                cost += AvailableServices.getListServices().get(i).getCost()[SecondWinClient.getFlagVihicle()];
            }
        }
        if (cost != 0) {
            SecondWinClient.getOkButton().setEnabled(true);
        } else {
            SecondWinClient.getOkButton().setEnabled(false);
        }
        if (cost > 99) {
            SecondWinClient.setCostField(cost + "  €");
        } else if (cost > 9) {
            SecondWinClient.setCostField(cost + "    €");
        } else {
            SecondWinClient.setCostField(cost + "      €");
        }
    }
}
