package ra.model;

import java.time.LocalDate;
import java.util.Scanner;

public class Exam_Advance {
    //***************STUDENT****************
    static Student[] students = new Student[100];
    static int currentIndex = 0;
    static int studentID;
    static String name;
    static String phone;
    static boolean gender;
    static String address;
    static LocalDate birthDay;

    //**********Phần SUBJECT************
    static  Subject[] subjects=new Subject[100];
    static String subjectId;
    static String subjectName;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("----------MUSIC-MANAGEMENT-----------");

            System.out.println("1.Quản lí học sinh");
            System.out.println("2.Quản lí môn học");
            System.out.println("3.Quản lí điểm thi");
            System.out.println("4.Thoát");
            System.out.println("Hãy nhập lựa chọn của bạn");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    boolean exist1=true;
                    do {
                        System.out.println("----------STUDENT-MANAGEMENT-----------");

                        System.out.println("1.Hiển thị danh sách tất cả học sinh");
                        System.out.println("2.Thêm học sinh mới");
                        System.out.println("3.Sửa thông tin học sinh");
                        System.out.println("4.Xóa học sinh");
                        System.out.println("5.Thoát");
                        System.out.println("Hãy nhập lựa chọn của bạn trong student");
                        int  choice1 = Integer.parseInt(sc.nextLine());

                        switch (choice1) {
                            case 1:
                                showStudent();
                                break;
                            case 2:
                                addStudent(sc);
                                break;
                            case 3:
                                updateStudent(sc);
                                break;
                            case 4:
                                deleteStudent();
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại");
                        }
                    } while (exist1);
                    break;
                case 2:
                    boolean exist2=true;
                    do {
                        System.out.println("----------SUBJECT-MANAGEMENT-----------");

                        System.out.println("1.Thêm mới môn học");
                        System.out.println("2.Hiển thị tất cả thông tin môn học");
                        System.out.println("3.Thay đổi thông tin môn học");
                        System.out.println("4.Xóa học sinh");
                        System.out.println("5.Thoát");
                        System.out.println("Hãy nhập lựa chọn của bạn trong subject");
                        int  choice2 = Integer.parseInt(sc.nextLine());

                        switch (choice2) {
                            case 1:
                                addSubject(sc);
                                break;
                            case 2:
                                showSubject();
                                break;
                            case 3:
                                updateSubject(sc);
                                break;
                            case 4:
                                deleteSubject();
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại");
                        }
                    } while (exist2);
                    break;
                case 3:

                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại");
            }
        } while (true);
    }

//------------------------------------------------------PHẦN QUẢN LÍ HỌC SINH-------------------------------------------------------
    public static void showStudent() {
        for (Student student : students
        ) {
            if (student != null) {
                student.displayDataStudent();
            } else {
                break;
            }
        }
    }


    // THÊM MỚI SINH VIÊN
    public static void addStudent(Scanner sc) {

        System.out.println("Nhập số lượng học sinh muốn thêm");
        int n = Integer.parseInt(sc.nextLine());
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                Student student = new Student();
                student.inputData(sc, students, i);
                students[i] = student;
                students[i].setStudentID(currentIndex + 1);
                currentIndex++;
            }
        } else {
            System.out.println("Số lượng học sinh phải lớn hơn 0");
        }
    }

    // Hàm tìm ra vị trí student
    public static int indexStudentUpdate(Student[] students, int studentID) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getStudentID() == studentID) {
                index = i;
                break;
            }
        }
        return index;
    }
   // Hàm sửa thông tin học sinh
    public static void updateStudent(Scanner sc){
        System.out.println("Nhập vào mã học sinh");
        int studentId=Integer.parseInt(sc.nextLine());
        int indexUpdate=indexStudentUpdate(students,studentId);

        if (indexUpdate >= 0) {
            // Học sinh tồn tại trong danh sách
            System.out.println("Nhập thông tin mới cho học sinh:");
            students[indexUpdate].inputData(sc, students, indexUpdate); // Gọi hàm để nhập thông tin mới
            System.out.println("Thông tin học sinh đã được cập nhật.");
        } else {
            System.out.println("Sinh viên bạn muốn sửa không có trong danh sách");
        }
    }

//     XÓA STUDENT
public static void deleteStudent() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Nhập mã sinh viên bạn muốn xóa");
    int deleteId = sc.nextInt();
    int indexDelete = indexStudentUpdate(students, deleteId);

    if (indexDelete == -1) {
        System.out.println("Mã sinh viên không hợp lệ");
    } else {
        // Di chuyển tất cả học sinh sau vị trí xóa lên một bậc
        for (int i = indexDelete; i < currentIndex - 1; i++) {
            students[i] = students[i + 1];
        }
        students[currentIndex - 1] = null;
        currentIndex--; // Giảm số lượng học sinh hiện tại

    }
}



    //--------------------------------------PHẦN QUẢN LÍ MÔN HỌC-------------------------------------------------------
    public static void showSubject() {
        for (Subject subject : subjects
        ) {
            if (subject != null) {
                subject.displayDataSubject();
            } else {
                break;
            }
        }
    }
    public static void addSubject(Scanner sc) {

        System.out.println("Nhập số lượng môn học muốn thêm");
        int n = Integer.parseInt(sc.nextLine());
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                Subject subject = new Subject();
                subject.inputDataSubject(sc, subjects, i);
                subjects[i] = subject;
            }
        } else {
            System.out.println("Số lượng học sinh phải lớn hơn 0");
        }
    }
    // Hàm tìm ra vị trí môn học
    public static int indexSubUpdate(Subject[] subjects, String subjectId) {
        int index = -1;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null && subjects[i].getSubjectId().equals(subjectId)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static void updateSubject(Scanner sc){
        System.out.println("Nhập vào mã môn học");
        String subjectId=sc.nextLine();
        int indexUpdate=indexSubUpdate(subjects,subjectId);

        if (indexUpdate >= 0) {
            // môn học tồn tại trong danh sách
            System.out.println("Nhập thông tin mới cho môn học:");
            subjects[indexUpdate].inputDataSubject(sc, subjects, indexUpdate); // Gọi hàm để nhập thông tin mới
            System.out.println("Thông tin môn học đã được cập nhật.");
        } else {
            System.out.println("Môn học bạn muốn sửa không có trong danh sách");
        }
    }
    //     XÓA MÔN HỌC
    public static void deleteSubject() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã môn học bạn muốn xóa");
        String deleteId = sc.nextLine();
        int indexDelete = indexSubUpdate(subjects, deleteId);

        if (indexDelete == -1) {
            System.out.println("Mã môn học không có trong danh sách");
        } else {
            for (int i = 0; i < currentIndex-1; i++) {
                subjects[i]=subjects[i+1];
            }
            subjects[indexDelete] = null;
        }
    }

}
