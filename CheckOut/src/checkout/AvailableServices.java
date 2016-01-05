package checkout;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anestis
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Anestis
 */
public class AvailableServices {

    /**
     * ArrayList containing all the Services.
     */
    private static ArrayList<Services> listServices;
    /**
     * Constructor of the Available Services offered to the client
     */
    public AvailableServices() throws IOException {
        
        
        listServices = new ArrayList<>();
        Initialization();
    }

    /**
     * Initializes the ArrayList listServices with the services offered.
     * <p>
     * The services are stored in a file named AvailableServices.txt and from there 
     * they are buffered to the listServices ArrayList.
     * </p>
     */
    private void Initialization() throws IOException {
        String name,name2, input, id;
        int i = 0;
        double[] cost = new double[3];
        ArrayList<Integer> cd = new ArrayList<>(10);
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream("AvailableServices.txt"));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "The file not found.", "Error", JOptionPane.OK_OPTION);
        }
        try {
            while (inputStream.hasNext()) {
                //Diavazei to onoma
                name = inputStream.next();
                while (!name.endsWith("\\")) {
                    name = name.concat(" " + inputStream.next());
                }
                name = name.substring(0, name.length() - 1);               
                name2 = inputStream.next();              
                while (!name2.endsWith("\\")) {
                        name2 = name2.concat(" " + inputStream.next());
                }
                name2 = name2.substring(0, name2.length() - 1);
                  //Diavazei to id
                id = inputStream.next();
                input = inputStream.next();
                //Diavazei to code
                input = inputStream.next();
                while (!input.endsWith("\\")) {
                    cd.add(Integer.parseInt(input));
                    input = inputStream.next();
                }
                //Diavazei to cost
                for (int j = 0; j < 3; j++) {
                    cost[j] = Double.parseDouble(inputStream.next());
                }
                int id1 = Integer.parseInt(id);
                //Ta eisagei sto arrayList
                listServices.add(new Services());
                listServices.get(i).setCode(cd);
                listServices.get(i).setId(id1);
                listServices.get(i).setCost(cost);
                listServices.get(i).setName(name);
                listServices.get(i).setName2(name2);
                cd.clear();
                i++;
            }

        } catch (NumberFormatException g) {
            JOptionPane.showMessageDialog(null, "Wrong input file.", "Error!", JOptionPane.OK_OPTION);
            System.exit(0);
        }
        
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * Creates new services before the are stored in the listServices ArrayList.
     */
    public class Services {

        private ArrayList<Integer> code;
        private String name;
        private String name2;
        private int id;
        private double[] cost;

        /**
         * Constructor of the services.
         */
        public Services() {
            cost = new double[3];
            code = new ArrayList<>(10);
        }

        /**
         * Gets the code of the service.
         * @return code
         */
        public ArrayList<Integer> getCode() {
            return code;
        }

        /**
         * Sets the code of the service.
         * @param code 
         */
        public void setCode(ArrayList<Integer> code) {
            this.code = (ArrayList) code.clone();
        }

        /**
         * Sets the name of the service.
         * @param name 
         */
        public void setName(String name) {
            this.name = name;
        }
        public void setName2(String name2) {
            this.name2 = name2;
        }
        public void setId(int id) {
            this.id = id;
        }
        /**
         * Sets the cost of the service
         * @param cost 
         */
        public void setCost(double[] cost) {
            this.cost = cost.clone();
        }

        /**
         * Returns the name of the service.
         * @return name
         */
        public String getName() {
            return name;
        }
        
        public String getName2() {
            return name2;
        }
        
        public int getId() {
            return id;
        }

        /**
         * Returns the cost of the service.
         * @return cost
         */
        public double[] getCost() {
            return cost;
        }
    }

    /**
     * Return an ArraList with the supplied services.
     * @return  listServices
     */
    public static ArrayList<Services> getListServices() {
        return listServices;
    }

}

