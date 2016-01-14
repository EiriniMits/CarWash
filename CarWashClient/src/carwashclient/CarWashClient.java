package carwashclient;

public class CarWashClient {

    /**
     * @param args the command line arguments
     */
    private static final FirstWinClient win1 = new FirstWinClient(); //these are just to have access to them from other points in the programm
    private static SecondWinClient win2 = new SecondWinClient();

    /**
     * The programm main
     * @param args 
     */
    public static void main(String[] args) {
        win1.setVisible(true);
        win2.setVisible(false);
    
        
    }
 

    /**
     * Getters for the windows
     * @return 
     */
    public static FirstWinClient getWin1() {
        return win1;
    }
    
    public static SecondWinClient getWin2() {
        return win2;
    }
    public static void Redraw(){
        win2.dispose();
        win2=new SecondWinClient();
    }
}
