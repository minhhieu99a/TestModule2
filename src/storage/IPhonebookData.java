package storage;

import model.Phonebook;

import java.io.IOException;
import java.util.ArrayList;

public interface IPhonebookData {
    ArrayList<Phonebook> readFile();
    void writeFile(ArrayList<Phonebook> arrayList) throws IOException;
}
