package carwashclient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class has all the listeners for all the buttons in the virtual keyboard which is created in the FirstWinClient
 * @author Anestis
 */
public class ClickListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int error1=0;
        if (e.getActionCommand().equals("BackSpace")) {
            if (FirstWinClient.getTextfield().length() > 0) {
                FirstWinClient.setTextfield(FirstWinClient.getTextfield().substring(0, FirstWinClient.getTextfield().length() - 1));
            }
        } else if (e.getActionCommand().equals("Space")) {
            FirstWinClient.setTextfield(FirstWinClient.getTextfield() + " ");
        } else if (e.getActionCommand().equals("Enter")) {
            ArrayList<String> blank = new ArrayList<>(8);
            try {
                if (FirstWinClient.getTextfield().trim().length()<3){
                    error1=1;
                    throw new Exception();
                }
                InfoSend newSend = new InfoSend(blank,1);
                CarWashClient.getWin1().setVisible(false);                
                System.out.println(error1);
                CarWashClient.Redraw();
                CarWashClient.getWin2().setVisible(true);
            } catch (Exception d) {
                if(error1==1){
                ErrorMessage error =new ErrorMessage(this,"Μη έγκυρος αριθμός κυκλοφορίας","Σφάλμα εισόδου");
                error.setVisible(true);}
            }
        } else {
            FirstWinClient.setTextfield(FirstWinClient.getTextfield() + e.getActionCommand());
        }
    }
}
