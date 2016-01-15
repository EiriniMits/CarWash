/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkout;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anestis, Eirini
 */
public class ServerInput {

    private ArrayList<String> inputData;
    private static ArrayList<String> file;
    public ServerInput() throws IOException {
        ServerSocket serverSocket = new ServerSocket(7896);
          //  System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            Socket clientSocket = serverSocket.accept();
           // System.out.println("Just connected to " + clientSocket.getRemoteSocketAddress());
            Scanner clientIn = new Scanner(clientSocket.getInputStream());
            PrintWriter clientOut = new PrintWriter(clientSocket.getOutputStream(), true);
            DataInputStream in= new DataInputStream(clientSocket.getInputStream());
            String bool = in.readUTF();
        if(bool.equals("0")){ // pernei thn apodi3h enos pelath 
        try {
            inputData = new ArrayList<>(8);
            do {
                String message = clientIn.nextLine();
                inputData.add(message);
                clientOut.println(message);
            } while (clientIn.hasNextLine());
            addCostInList();
            clientOut.close();
            clientIn.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        }
        else{ //stelnei tis uparxouses uphresies ston client
            file = new ArrayList<>();
        readText();
        try {
                for (String file1 : file) {
                    clientOut.println(file1);
                }
            clientIn.close();
            clientOut.close();
            clientSocket.close();
            serverSocket.close();       
	} catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        }
    }

    public static void readText() throws FileNotFoundException, IOException{
     
             Scanner scan = new Scanner(new File("AvailableServices.txt"));
     
        try {
            while (scan.hasNext()) {
                String line =scan.nextLine();
                file.add(line);
            }
        } catch (NumberFormatException g) {
            JOptionPane.showMessageDialog(null, "Wrong input file.", "Error!", JOptionPane.OK_OPTION);
            System.exit(0);
        }
    }
    public void addCostInList() {
        String vehicleType;
        if (Integer.parseInt(inputData.get(1)) == 0) {
            vehicleType = "Αυτοκίνητο";
        } else if (Integer.parseInt(inputData.get(1)) == 1) {
            vehicleType = "Φορτηγό";
        } else {
            vehicleType = "Μηχανή";
        }

        String vehicleNumber = inputData.get(0);

        ArrayList<Integer> servArray = new ArrayList<>();
        for (int i = 2; i < inputData.size(); i++) {
            servArray.add(Integer.parseInt(inputData.get(i)));
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String time = dateFormat.format(date);

        int cost = 0;
        for (Integer servArray1 : servArray) {
            cost += AvailableServices.getListServices().get(servArray1).getCost()[Integer.parseInt(inputData.get(1))];
        }


        Costumer cos = new Costumer(vehicleType, vehicleNumber, servArray, cost, time);
        CheckOutWin.getArrayCos().add(cos);
        //Grafei ton pinakka se arxeio
        ManagmentFile.refreshNowFile(CheckOutWin.getArrayCos());

        DefaultTableModel model = (DefaultTableModel) CheckOutWin.getCarTable().getModel();
        model.addRow(new Object[]{vehicleNumber, vehicleType, cost + "", time});

        //biblio eisodou
        ManagmentFile.writeToFile(cos,0);
        inputData.clear();
    }
}
