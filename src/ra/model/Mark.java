package ra.model;

import java.util.Scanner;

public class Mark {
    private int markId;
    private Student student;
    private Subject subject;
    private double point;

    public Mark() {
    }

    public Mark(int markId, Student student, Subject subject, double point) {
        this.markId = markId;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    // Các phương thức Getter và Setter

    public static void inputDataMark(Scanner sc, Student[] students, Subject[] subjects) {
        System.out.println("Nhập ID học sinh:");
        int studentId = sc.nextInt();
        Student student = findStudentById(studentId, students);

        if (student == null) {
            System.out.println("Học sinh không tồn tại. Vui lòng thêm học sinh trước.");
            return;
        }



        System.out.println("Nhập điểm:");
        double point = sc.nextDouble();

        // Thêm điểm vào danh sách điểm hoặc thực hiện các hành động khác cần thiết.
        // marks.add(mark);
        System.out.println("Điểm đã được nhập.");
    }

    // Phương thức trợ giúp để tìm học sinh theo ID
    private static Student findStudentById(int studentId, Student[] students) {
        for (Student student : students) {
            if (student != null && student.getStudentID() == studentId) {
                return student;
            }
        }
        return null;
    }




}