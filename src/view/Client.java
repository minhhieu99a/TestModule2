package view;

import controller.PhonebookManager;
import model.Phonebook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Client {
    private static ArrayList<Phonebook> phonebookArrayListClient = PhonebookManager.phonebookArrayList;


    public static void main(String[] args) {
        int choice = -1;
        Scanner inputChoice = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Hiển thị thông tin danh bạ");
            System.out.println("2. Thêm mới vào danh bạ");
            System.out.println("3. Sửa thông tin theo số điện thoại ");
            System.out.println("4. Xóa thông tin trong danh bạ ");
            System.out.println("5. Tìm kiếm thông tin trong danh bạ");
            System.out.println("0. Exit!");
            System.out.println("Nhập lựa chọn: ");
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    PhonebookManager.displayPhonebook();
                    break;
                case 2:
                    PhonebookManager.addNewPhonebook();
                    break;
                case 3:
                   PhonebookManager.editPhoneByNumber();
                    break;
                case 4:
                    PhonebookManager.deletePhoneBookByNumber();
                    break;
                case 0:
                    System.exit(0);
                default:
            }
        }
    }

    public static Phonebook creatNewPhonebook() {

        Scanner inputPhoneNumbers = new Scanner(System.in);
        System.out.println("Nhập số điện thoại của người cần thêm vào danh bạ: ");
        int phoneNumbers = inputPhoneNumbers.nextInt();

        Scanner inputGroup = new Scanner(System.in);
        System.out.println("Nhập nhóm của người cần thêm vào danh bạ: ");
        String group = inputGroup.nextLine();

        Scanner inputFullname = new Scanner(System.in);
        System.out.println("Nhập họ tên của người cần thêm vào danh bạ: ");
        String fullname = inputFullname.nextLine();

        Scanner inputGender = new Scanner(System.in);
        System.out.println("Nhập giới tính của người cần thêm vào danh bạ: ");
        String gender = inputGender.nextLine();

        Scanner inputAddress = new Scanner(System.in);
        System.out.println("Nhập điạ chỉ của người cần thêm vào danh bạ: ");
        String address = inputAddress.nextLine();

        Scanner inputDayofBirth = new Scanner(System.in);
        System.out.println("Nhập ngày sinh của người cần thêm vào danh bạ: ");
        int dayofbirth = inputDayofBirth.nextInt();

        Scanner inputMonthofBirth = new Scanner(System.in);
        System.out.println("Nhập tháng sinh của người cần thêm vào danh bạ: ");
        int monthofbirth = inputMonthofBirth.nextInt();

        Scanner inputYearofBirth = new Scanner(System.in);
        System.out.println("Nhập năm sinh của người cần thêm vào danh bạ: ");
        int yearofbirth = inputYearofBirth.nextInt();

        Scanner inputEmail = new Scanner(System.in);
        System.out.println("Nhập Email của người cần thêm vào danh bạ:");
        String email = inputEmail.nextLine();

        Phonebook newPhonebook = new Phonebook(phoneNumbers, group, fullname, gender, address, LocalDate.of(yearofbirth, monthofbirth, dayofbirth), email);
        return newPhonebook;
    }

    public static int getPhoneBookByPhonenumbers() {
        Scanner inputPhoneNumber = new Scanner(System.in);
        System.out.println("Nhập số điện thoại mà bạn muốn thao tác : ");
        int phoneNumber = inputPhoneNumber.nextInt();
        for (int i = 0; i < phonebookArrayListClient.size(); i++) {
            if (phonebookArrayListClient.get(i).getPhonenumbers() == phoneNumber) {
                return i;
            } else {
                System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            }
        }
        return getPhoneBookByPhonenumbers();
    }

    public static ArrayList<Phonebook> editPhonebook() {
        int index = getPhoneBookByPhonenumbers();


        Scanner inputGroup = new Scanner(System.in);
        System.out.println("Nhập lại nhóm mà bạn muốn sửa : ");
        String editGroup = inputGroup.nextLine();

        phonebookArrayListClient.get(index).setGroups(editGroup);

        Scanner inputFullname = new Scanner(System.in);
        System.out.println("Nhập lại họ tên mà bạn muốn sửa: ");
        String editFullname = inputFullname.nextLine();

        phonebookArrayListClient.get(index).setFullnames(editFullname);

        Scanner inputGender = new Scanner(System.in);
        System.out.println("Nhập lại giới tính bạn muốn sửa: ");
        String editGender = inputGender.nextLine();

        phonebookArrayListClient.get(index).setGender(editGender);

        Scanner inputAddress = new Scanner(System.in);
        System.out.println("Nhập lại địa chỉ mà bạn muốn sửa: ");
        String editAddress = inputAddress.nextLine();

        phonebookArrayListClient.get(index).setAddress(editAddress);

        Scanner inputDayofBirth = new Scanner(System.in);
        System.out.println("Nhập ngày sinh mà bạn muốn sửa: ");
        int editdayofbirth = inputDayofBirth.nextInt();

        Scanner inputMonthofBirth = new Scanner(System.in);
        System.out.println("Nhập tháng sinh mà bạn muốn sửa: ");
        int editmonthofbirth = inputMonthofBirth.nextInt();

        Scanner inputYearofBirth = new Scanner(System.in);
        System.out.println("Nhập năm sinh mà bạn muốn sửa: ");
        int edityearofbirth = inputYearofBirth.nextInt();

        phonebookArrayListClient.get(index).setDateofbirth(LocalDate.of(edityearofbirth, editmonthofbirth, editdayofbirth));

        Scanner inputEmail = new Scanner(System.in);
        System.out.println("Nhập lại email nhân viên Full Time bạn muốn sửa: ");
        String editEmail = inputEmail.nextLine();

        phonebookArrayListClient.get(index).setEmail(editEmail);
        return phonebookArrayListClient;
    }

    public static ArrayList<Phonebook> deletePhoneBook() {
        int index = getPhoneBookByPhonenumbers();
        Scanner inputChoice = new Scanner(System.in);
        System.out.println("Nhập Y nếu bạn chắc chắn muốn xóa.");
        String choice = inputChoice.nextLine();
        if (Objects.equals(choice, "y")) {
            phonebookArrayListClient.remove(index);
            System.out.println("Đã xóa thành công.");
        }
        return phonebookArrayListClient;
    }
}

