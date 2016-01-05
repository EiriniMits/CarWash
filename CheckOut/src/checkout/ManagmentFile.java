/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Anestis
 */
public class ManagmentFile {

    private static final String INPUT_FILE_NAME = "PaymentsFile.dat";
    private static final String INPUT_FILE_NAME_2 = "NowCos.dat";

    public ManagmentFile() {
    }

    /**
     * Saves a new costumer to the files.
     * <p>
     * If the file id = 0 the file where the costumer will be saved is PaymentsFile.dat (old costumers).
     * Else the file where the costumer will be saved is NowCos.dat (current costumers/have not payed yet).
     * </p>
     * @param newCostumer The new costumer that will be added to the file.
     * @param file The id of the file where the costumer will be added.
     */
    public static void writeToFile(Costumer newCostumer,int file) {
        String fname;
        if (file==0){
            fname=INPUT_FILE_NAME;
        }else{
            fname=INPUT_FILE_NAME_2;
        }
        ArrayList<Costumer> allCostumer = new ArrayList<>();
        File b = new File(fname);
        try {
            if (b.exists()) {
                allCostumer = readFromFile(file);
            }
            File a = new File(fname);
            a.delete();
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fname));
            allCostumer.add(newCostumer);
            outputStream.writeObject(allCostumer);
            outputStream.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Δημιουργήθηκε πρόβλημα κατά την εγγραφή του αρχείου.", "Σφάλμα!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Read the costumers from the file and stores them in an ArrayList.
     * <p>
     * If the file id = 0 the file from where the costumers will be read is PaymentsFile.dat (old costumers).
     * Else the file from where the costumers will be read is NowCos.dat (current costumers/have not payed yet).
     * </p>
     * @param file The id of the file that will be used.
     * @return allCostumer
     */
    public static ArrayList<Costumer> readFromFile(int file) {
        String fname;
        if (file==0){
            fname=INPUT_FILE_NAME;
        }else{
            fname=INPUT_FILE_NAME_2;
        }
        ArrayList<Costumer> allCostumer = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fname));
            allCostumer = (ArrayList<Costumer>) inputStream.readObject();
            inputStream.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Δημιουργήθηκε πρόβλημα κατά την ανάγνωση του αρχείου.", "Σφάλμα!", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Δημιουργήθηκε πρόβλημα κατά την ανάγνωση του αρχείου.", "Σφάλμα!", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Δημιουργήθηκε πρόβλημα κατά την ανάγνωση του αρχείου.", "Σφάλμα!", JOptionPane.ERROR_MESSAGE);
        }
        return allCostumer;
    }

    /**
     * Updates the content of the costumer file.
     * <p>If the file id = 0 the file where that will be refreshed is PaymentsFile.dat (old costumers).
     * Else the file that will be refreshed is NowCos.dat (current costumers/have not payed yet).</p>
     * 
     * @param forPayCostumer The costumer that is about to pay.
     * @param time The current time that is the time of payment.
     * @param file The id of the file that will be refreshed.
     */
    public static void refreshFile(Costumer forPayCostumer, String time,int file) {
        String fname;
        if (file==0){
            fname=INPUT_FILE_NAME;
        }else{
            fname=INPUT_FILE_NAME_2;
        }
        ArrayList<Costumer> array = readFromFile(file);
        File a = new File(fname);
        a.delete();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getTimeInsert().equals(forPayCostumer.getTimeInsert())) {
                array.get(i).setTimeOut(time);
            }
            writeToFile(array.get(i),file);
        }
    }
    
    /**
     * Updates the content of the NowCos.dat file.
     * @param arrayCos ArrayList of the current costumers(that has not payed yet).
     */
    public static void refreshNowFile(ArrayList<Costumer> arrayCos){
        try {
            File a = new File(INPUT_FILE_NAME_2);
            if(a.exists()){
                a.delete();
            }
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(INPUT_FILE_NAME_2));
            outputStream.writeObject(arrayCos);
            outputStream.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Δημιουργήθηκε πρόβλημα κατά την εγγραφή του αρχείου.", "Σφάλμα!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
