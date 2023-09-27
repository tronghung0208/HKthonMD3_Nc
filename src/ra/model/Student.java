package ra.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Student {
    //1.Attribute
    private int studentID;
    private String name;
    private LocalDate birthDay;
    private boolean gender = false;

    private String address;

    private String phone;

    //2.Contructor
    public Student() {
    }


    public Student(int studentID, String name, LocalDate birthDay, boolean gender, String address, String phone) {
        this.studentID = studentID;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    //3. Methods
    //3.1 get-set

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //3.2 method
    public void inputData(Scanner sc,Student[] students,int currentIndex) {

        // Student name
        boolean isExistName = true;
        do {
            System.out.println("Nhập vào tên học sinh");
            String inputName = sc.nextLine();
            if (!inputName.trim().isEmpty()) {
                this.name = inputName;
                isExistName = false;
            } else {
                System.out.println("Tên học viên không được để trống, vui lòng nhập lại");
            }

        } while (isExistName);
         // Ngày sinh
        System.out.println("Nhập vào ngày sinh");
        this.birthDay = LocalDate.parse(sc.nextLine());
        // Địa chỉ
        boolean isExistAddress = true;
        do {
            System.out.println("Nhập vào địa chỉ");
            String inputAddress = sc.nextLine();
            if (!inputAddress.trim().isEmpty()) {
                this.address = inputAddress;
                isExistAddress = false;
            } else {
                System.out.println("Địa chỉ không được để trống, vui lòng nhập lại");
            }

        } while (isExistAddress);

        // Giới tính
        System.out.println("Nhập vào giới tính");
        boolean check =true;
        while (check){
            String sex =sc.nextLine();
            if (sex.equals("Nam")){
                this.gender=true;
                check=false;
            }else if (sex.equals("Nữ")) {
                this.gender=false;
                check=false;


            }else {
                System.out.println("Nhập lại giới tính");
            }

        }
        boolean isExistPhone = true;
        do {
            System.out.println("Nhập vào số điện thoại");
            String inputPhone = sc.nextLine();
            if (!inputPhone.trim().isEmpty()) {

                if (inputPhone.matches("^0[0-9]{9,10}$")){
                    boolean checkPhone=false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (students[i]!=null&&students[i].getPhone().equals(inputPhone)){
                            checkPhone=true;
                            break;
                        }
                    }

                    if (!checkPhone){
                        this.phone = inputPhone;
                        isExistPhone = false;
                    }else {
                        System.out.println("Số điện thoại đã có người sử dụng, mời nhập lại");
                    }

                }else {
                    System.out.println("Số điện thoại phải bắt đầu bằng số 0, có 10 hoặc 11 số");
                }

            } else {
                System.out.println("Tên học viên không được để trống, vui lòng nhập lại");
            }

        } while (isExistPhone);

    }

    public void displayDataStudent() {
        System.out.printf("Mã họ sinh: %d, Tên học sinh: %s,Ngày sinh: %s, Địa chỉ: %s, Giới tính: %s, Số điện thoại: %s \n",
                this.studentID, this.name, this.birthDay,this.address, this.gender ? "Nam" : "Nữ", this.phone);
    }


}
