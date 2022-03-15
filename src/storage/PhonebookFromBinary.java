package storage;

import model.Phonebook;

import java.io.*;
import java.util.ArrayList;

public class PhonebookFromBinary implements IPhonebookData {
        @Override
        public ArrayList<Phonebook> readFile() {
            File file= new File("ListPhoneBook.hieu");
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object result = ois.readObject();
                ArrayList<Phonebook> phonebookList=(ArrayList<Phonebook>) result;
                ois.close();
                fis.close();
                return  phonebookList;
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }

        @Override
        public void writeFile(ArrayList<Phonebook> arrayList) throws IOException {
            ObjectOutputStream oos = null;
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream("ListPhoneBook.hieu");
                oos = new ObjectOutputStream(fos);
                oos.writeObject(arrayList);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fos.close();
                oos.close();
            }
        }
}
