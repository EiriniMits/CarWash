package checkout;

import java.io.IOException;

/**
 *
 * @author Anestis
 */
public class CheckOut {

    /**
     * Starts the Check out application used by the user of the system 
     * @param args 
     */
    public static void main(String[] args) throws IOException {
        AvailableServices a1=new AvailableServices();
        CheckOutWin win1 = new CheckOutWin();
        win1.setVisible(true);
       
        while (true) {       
           ServerInput a = new ServerInput();

        }
    }
}
