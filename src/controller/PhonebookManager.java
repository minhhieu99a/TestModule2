package controller;

import model.Phonebook;
import storage.IPhonebookData;
import storage.PhonebookFromBinary;
import view.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static view.Client.*;

public class PhonebookManager {
    private static IPhonebookData phonebookData = new PhonebookFromBinary();
    public static ArrayList<Phonebook> phonebookArrayList = phonebookData.readFile();


    public static void displayPhonebook() {
        for (Phonebook e : phonebookArrayList
        ) {
            System.out.println(e);
        }
    }
    public static void addNewPhonebook() {
        Phonebook newPhoneBook = creatNewPhonebook();
        phonebookArrayList.add(newPhoneBook);
        try {
            phonebookData.writeFile(phonebookArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editPhoneByNumber(){
        phonebookArrayList= Client.editPhonebook();
        try {
            phonebookData.writeFile(phonebookArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
public static void deletePhoneBookByNumber(){
        phonebookArrayList=Client.deletePhoneBook();
    try {
        phonebookData.writeFile(phonebookArrayList);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
