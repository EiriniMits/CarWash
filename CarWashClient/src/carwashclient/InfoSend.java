package carwashclient;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sends the info to the main server which is the check out application or takes the list of the available services of the server.
 * @author Anestis, Eirini
 */
public class InfoSend {
private ArrayList<String> inputData;
    public InfoSend(ArrayList<String> infSen,int bool) {
        if(bool==0){// o pelaths stelnei thn aposei3h sto server
            try {
                try ( //Prepei na ginei allagh gia to LAN
                        Socket echoSocket = new Socket("localhost", 7896); PrintWriter serverOut = new PrintWriter(echoSocket.getOutputStream(), true)) {
                    OutputStream outToServer = echoSocket.getOutputStream();
                    DataOutputStream out = new DataOutputStream(outToServer);
                    try (Scanner serverIn = new Scanner(echoSocket.getInputStream())) {
                        out.writeUTF("0");
                        for (String infSen1 : infSen) {
                            serverOut.println(infSen1);
                        }
                    }
                }
            } catch (UnknownHostException e) {
                ErrorMessage error = new ErrorMessage(this,"Δεν είναι δυνατή η σύνδεση με το διακομιστή ελέγξτε τη σύνδεση σας στο δίκτυο.","Σφάλμα κατά τη σύνδεση");
                error.setVisible(true);
            } catch (IOException e) {
                ErrorMessage error = new ErrorMessage(this,"Δεν είναι δυνατή η σύνδεση με το διακομιστή ελέγξτε τη σύνδεση σας στο δίκτυο.","Σφάλμα κατά τη σύνδεση");
                error.setVisible(true);
            }
        }
        else{ //o pelaths pernei tis uparxouses uphresies apo ton server
            try {
                try (Socket echoSocket = new Socket("localhost", 7896); PrintWriter serverOut = new PrintWriter(echoSocket.getOutputStream(), true)) {
                    OutputStream outToServer = echoSocket.getOutputStream();
                    DataOutputStream out = new DataOutputStream(outToServer);
                    try (Scanner serverIn = new Scanner(echoSocket.getInputStream())) {
                        out.writeUTF("1");
                        inputData = new ArrayList<>();
                        for(int j=1; j<100;j++){
                            String message = serverIn.nextLine();
                            if(message.equals("End")) break;
                            inputData.add(message);
                            serverOut.println(message);
                        } 
                    }
                }
            } catch (UnknownHostException e) {
                ErrorMessage error = new ErrorMessage(this,"Δεν είναι δυνατή η σύνδεση με το διακομιστή ελέγξτε τη σύνδεση σας στο δίκτυο.","Σφάλμα κατά τη σύνδεση");
                error.setVisible(true);
            } catch (IOException e) {
                ErrorMessage error = new ErrorMessage(this,"Δεν είναι δυνατή η σύνδεση με το διακομιστή ελέγξτε τη σύνδεση σας στο δίκτυο.","Σφάλμα κατά τη σύνδεση");
                error.setVisible(true);
            }
            try{

                                        BufferedWriter out = new BufferedWriter(new FileWriter("AvailableServices.txt"));
                                       for(int i=0;i<inputData.size();i++){

                                            try {
                                                    out.write(inputData.get(i));
                                                    out.newLine();


                                            } catch (IOException ex) {
                                                System.out.println("Δεν ανοιγει το αρχειο");
                                            }
                                        }
                              out.close();
                              } catch (IOException e) {
                                       System.out.println("Δεν ανοιγει το αρχειο");
                        }
            }
    }
}
