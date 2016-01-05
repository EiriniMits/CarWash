package carwashclient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Anestis
 */
public class AvailableServices {

    private static ArrayList<Services> listServices;

    public AvailableServices() {
       
        listServices = new ArrayList<>();
        Initialization();
    }

    private void Initialization() {
        String name = null, input;
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
                if(FirstWinClient.lang==0){
                    //Diavazei to onoma
                    name = inputStream.next();
                    while (!name.endsWith("\\")) {
                        name = name.concat(" " + inputStream.next());
                    }
                    name = name.substring(0, name.length() - 1);
                    input = inputStream.next();
                    while (!input.endsWith("\\")) {
                        input = inputStream.next();
                    }
                }
                if(FirstWinClient.lang==1){
                    input = inputStream.next();
                    while (!input.endsWith("\\")) {
                        input = inputStream.next();
                    }//Diavazei to onoma
                    name = inputStream.next();
                    while (!name.endsWith("\\")) {
                        name = name.concat(" " + inputStream.next());
                    }
                    name = name.substring(0, name.length() - 1);
                }
                String id = inputStream.next();
                id = inputStream.next();
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
                //Ta eisagei sto arrayList
                listServices.add(new Services());
                listServices.get(i).setCode(cd);
                listServices.get(i).setCost(cost);
                listServices.get(i).setName(name);
                cd.clear();
                i++;
            }
        } catch (NumberFormatException g) {
            JOptionPane.showMessageDialog(null, "Wrong input file.", "Error!", JOptionPane.OK_OPTION);
            System.exit(0);
        }
    }
    
    public class Services {

        private ArrayList<Integer> code;
        private String name;
        private double[] cost;

        public Services() {
            cost = new double[3];
            code = new ArrayList<>(10);
        }

        public ArrayList<Integer> getCode() {
            return code;
        }

        public void setCode(ArrayList<Integer> code) {
            this.code = (ArrayList) code.clone();
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCost(double[] cost) {
            this.cost = cost.clone();
        }

        public String getName() {
            return name;
        }

        public double[] getCost() {
            return cost;
        }
    }

    public static ArrayList<Services> getListServices() {
        return listServices;
    }
}
